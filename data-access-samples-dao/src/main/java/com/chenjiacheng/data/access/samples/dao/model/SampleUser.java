package com.chenjiacheng.data.access.samples.dao.model;

import java.time.LocalDateTime;

public class SampleUser {
    private Long userId;
    private String username;
    private String passwordHash;
    private String displayName;
    private String email;
    private UserType userType;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
    private Boolean isActive;

    // 枚举类型
    public enum UserType {
        ADMIN, NORMAL, GUEST
    }

    // 无参构造函数
    public SampleUser() {}

    // 全参构造函数
    public SampleUser(Long userId, String username, String passwordHash, String displayName, 
                     String email, UserType userType, LocalDateTime createdAt, 
                     LocalDateTime lastLogin, Boolean isActive) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.displayName = displayName;
        this.email = email;
        this.userType = userType;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.isActive = isActive;
    }

    // Getter 和 Setter 方法
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // toString 方法
    @Override
    public String toString() {
        return "SampleUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                ", createdAt=" + createdAt +
                ", lastLogin=" + lastLogin +
                ", isActive=" + isActive +
                '}';
    }
}