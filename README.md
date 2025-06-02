# Data Access Samples

> 数据库相关框架集成


##  1. 依赖
1. org.springframework.boot::spring-boot-dependencies::2.7.13
2. org.springframework.boot::spring-boot-starter-web
3. org.springframework.boot::spring-boot-starter-jdbc
4. lombok::lombok
5. mysql:mysql-connector-java
6. mybatis::mybatis-spring-boot-starter
7. mybatis::mybatis
8. slf4j::slf4j-api
9. log4j::log4j-slf4j-impl

##  2. 数据库配置
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
  mybatis:
    mapper-locations: classpath:mapper/*.xml
    type-aliases-package: com.example.demo.model
```
##  3. 数据库表
```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

##  4. 实体类
```java

package com.example.demo.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User() {
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
```
