-- =============================================
-- data-access-samples 项目数据库初始化脚本 (MySQL 8.x 兼容版)
-- 修复了 UNSIGNED decimal 的弃用警告
-- =============================================

-- 1. 创建项目专属数据库
CREATE DATABASE IF NOT EXISTS `data_access_samples_db`
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_0900_ai_ci;

-- 2. 创建专用数据库用户
CREATE USER 'data_access_tester'@'localhost' IDENTIFIED BY 'DaT@2023!Secure';
CREATE USER 'data_access_tester'@'%' IDENTIFIED BY 'DaT@2023!Secure';

-- 3. 授予最小必要权限
GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE,
    CREATE TEMPORARY TABLES, LOCK TABLES
    ON `data_access_samples_db`.*
    TO 'data_access_tester'@'localhost';

GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE,
    CREATE TEMPORARY TABLES, LOCK TABLES
    ON `data_access_samples_db`.*
    TO 'data_access_tester'@'%';

-- 4. 刷新权限
FLUSH PRIVILEGES;

-- 5. 切换到项目数据库
USE `data_access_samples_db`;

-- 6. 创建核心测试表：用户表
CREATE TABLE IF NOT EXISTS `sample_users`
(
    `user_id`       BIGINT       NOT NULL AUTO_INCREMENT,
    `username`      VARCHAR(50)  NOT NULL COMMENT '登录账号',
    `password_hash` CHAR(64)     NOT NULL COMMENT 'SHA-256加密密码',
    `display_name`  VARCHAR(100) NOT NULL,
    `email`         VARCHAR(100) NOT NULL,
    `user_type`     ENUM ('ADMIN', 'NORMAL', 'GUEST') DEFAULT 'NORMAL',
    `created_at`    DATETIME(3)                       DEFAULT CURRENT_TIMESTAMP(3),
    `last_login`    DATETIME(3)  NULL,
    `is_active`     BOOLEAN                           DEFAULT TRUE,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `udx_username` (`username`),
    UNIQUE KEY `udx_email` (`email`),
    INDEX `idx_user_type` (`user_type`)
) ENGINE = InnoDB COMMENT ='用户主表-基础CRUD测试';

-- 7. 创建关联表：用户操作日志
CREATE TABLE IF NOT EXISTS `user_audit_log`
(
    `log_id`      BIGINT      NOT NULL AUTO_INCREMENT,
    `user_id`     BIGINT      NOT NULL,
    `action`      VARCHAR(20) NOT NULL COMMENT '操作类型: LOGIN, UPDATE, DELETE',
    `action_time` DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    `ip_address`  VARCHAR(45) DEFAULT NULL,
    `details`     JSON        DEFAULT NULL COMMENT '操作详情JSON',
    PRIMARY KEY (`log_id`),
    INDEX `idx_user_action` (`user_id`, `action`),
    CONSTRAINT `fk_log_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `sample_users` (`user_id`)
            ON DELETE CASCADE
) ENGINE = InnoDB COMMENT ='审计日志表-关联操作测试';

-- 8. 创建事务测试表：账户表（修复 UNSIGNED 警告）
CREATE TABLE IF NOT EXISTS `transaction_accounts`
(
    `account_id` VARCHAR(128) NOT NULL COMMENT '账户ID: acc_前缀+时间戳+随机数',
    `user_id`    BIGINT       NOT NULL,
    `balance`    DECIMAL(15, 2) DEFAULT 0.00 COMMENT '账户余额（必须非负）',
    `currency`   CHAR(3)        DEFAULT 'CNY',
    `created_at` DATETIME(3)    DEFAULT CURRENT_TIMESTAMP(3),
    `version`    INT UNSIGNED   DEFAULT 0 COMMENT '乐观锁版本',
    PRIMARY KEY (`account_id`),
    UNIQUE KEY `udx_user_currency` (`user_id`, `currency`),
    CONSTRAINT `fk_account_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `sample_users` (`user_id`)
            ON DELETE CASCADE,
    -- 添加 CHECK 约束替代 UNSIGNED
    CONSTRAINT `chk_balance_non_negative` CHECK (`balance` >= 0)
) ENGINE = InnoDB COMMENT ='账户表-事务测试';

-- 9. 插入初始化测试数据
INSERT INTO `sample_users`
    (username, password_hash, display_name, email, user_type)
VALUES ('test_admin', SHA2('AdminPass123!', 256), '管理员', 'admin@data-sample.com', 'ADMIN'),
       ('johndoe', SHA2('User@Pass1', 256), 'John Doe', 'john@data-sample.com', 'NORMAL'),
       ('test_user', SHA2('TempP@ss', 256), '测试用户', 'test@data-sample.com', 'GUEST');

-- 10. 插入账户数据（确保余额非负）
INSERT INTO `transaction_accounts`
    (account_id, user_id, balance, currency)
SELECT CONCAT('acc_', REPLACE(UUID(), '-', '')),
       user_id,
       ABS(ROUND(RAND() * 10000, 2)), -- 使用 ABS() 确保正数
       CASE WHEN RAND() > 0.5 THEN 'CNY' ELSE 'USD' END
FROM `sample_users`;