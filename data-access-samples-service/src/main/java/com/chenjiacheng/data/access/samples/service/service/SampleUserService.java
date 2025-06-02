package com.chenjiacheng.data.access.samples.service.service;

import com.chenjiacheng.data.access.samples.dao.model.SampleUser;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * 创建于 2025/6/1 22:31
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public interface SampleUserService {

    /**
     * 插入新用户并返回自增ID
     *
     * @param user 要插入的用户
     * @return 自增ID
     */
    int insertUser(SampleUser user);

    /**
     * 根据ID查询用户
     *
     * @param userId 用户ID
     * @return 如果找到则返回用户的Optional
     */
    Optional<SampleUser> findById(Long userId);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 如果找到则返回用户的Optional
     */
    Optional<SampleUser> findByUsername(String username);

    /**
     * 根据邮箱查询用户
     *
     * @param email 邮箱
     * @return 如果找到则返回用户的Optional
     */
    Optional<SampleUser> findByEmail(String email);

    /**
     * 更新用户信息
     *
     * @param user 包含更新信息的用户
     * @return 受影响的行数
     */
    int updateUser(SampleUser user);

    /**
     * 更新用户的最后登录时间
     *
     * @param userId 用户ID
     * @param lastLogin 最后登录时间
     * @return 受影响的行数
     */
    int updateLastLogin(Long userId, LocalDateTime lastLogin);

    /**
     * 根据用户类型查询用户列表
     *
     * @param userType 用户类型
     * @return 匹配用户类型的用户列表
     */
    List<SampleUser> findByUserType(SampleUser.UserType userType);

    /**
     * 逻辑删除用户（设置is_active=false）
     *
     * @param userId 要停用的用户ID
     * @return 受影响的行数
     */
    int deactivateUser(Long userId);

    /**
     * 统计活跃用户数量
     *
     * @return 活跃用户数量
     */
    int countActiveUsers();

    /**
     * 查询所有用户（通过XML映射）
     *
     * @return 所有用户的列表
     */
    List<SampleUser> findAllUsers();

    /**
     * 根据ID删除用户
     *
     * @param userId 要删除的用户ID
     * @return 受影响的行数
     */
    int deleteUser(Long userId);

}