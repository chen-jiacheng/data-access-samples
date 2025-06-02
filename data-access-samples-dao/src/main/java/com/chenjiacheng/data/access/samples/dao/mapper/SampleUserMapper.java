package com.chenjiacheng.data.access.samples.dao.mapper;

import com.chenjiacheng.data.access.samples.dao.model.SampleUser;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@Mapper
public interface SampleUserMapper {

    // 插入新用户并返回自增ID
    // @Insert("INSERT INTO sample_users (username, password_hash, display_name, email, user_type, created_at, last_login, is_active) " +
    //         "VALUES (#{username}, #{passwordHash}, #{displayName}, #{email}, #{userType}, #{createdAt}, #{lastLogin}, #{isActive})")
    // @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertUser(SampleUser user);

    // 根据ID查询用户
    @Select("SELECT * FROM sample_users WHERE user_id = #{userId}")
    Optional<SampleUser> findById(Long userId);

    // 根据用户名查询用户
    @Select("SELECT * FROM sample_users WHERE username = #{username}")
    Optional<SampleUser> findByUsername(String username);

    // 根据邮箱查询用户
    @Select("SELECT * FROM sample_users WHERE email = #{email}")
    Optional<SampleUser> findByEmail(String email);

    // 更新用户信息
    // @Update("UPDATE sample_users SET " +
    //         "display_name = #{displayName}, " +
    //         "email = #{email}, " +
    //         "user_type = #{userType}, " +
    //         "last_login = #{lastLogin}, " +
    //         "is_active = #{isActive} " +
    //         "WHERE user_id = #{userId}")
    int updateUser(SampleUser user);

    // 更新最后登录时间
    @Update("UPDATE sample_users SET last_login = #{lastLogin} WHERE user_id = #{userId}")
    int updateLastLogin(@Param("userId") Long userId, @Param("lastLogin") LocalDateTime lastLogin);

    // 根据用户类型查询用户列表
    @Select("SELECT * FROM sample_users WHERE user_type = #{userType}")
    List<SampleUser> findByUserType(@Param("userType") SampleUser.UserType userType);

    // 逻辑删除用户（设置is_active=false）
    @Update("UPDATE sample_users SET is_active = false WHERE user_id = #{userId}")
    int deactivateUser(Long userId);

    // 统计活跃用户数量
    @Select("SELECT COUNT(*) FROM sample_users WHERE is_active = true")
    int countActiveUsers();

    // XML映射方法
    List<SampleUser> findAllUsers();
    int deleteUser(Long userId);
}