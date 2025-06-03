package com.chenjiacheng.data.access.samples.start.controller;

import com.chenjiacheng.data.access.samples.common.model.Result;
import com.chenjiacheng.data.access.samples.dao.model.SampleUser;
import com.chenjiacheng.data.access.samples.service.service.SampleUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * 用户控制器
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/api/users")
public class SampleUserController {

    @Autowired
    private SampleUserService sampleUserService;

    @PostMapping
    public Result<Integer> insertUser(@RequestBody SampleUser user) {
        int userId = sampleUserService.insertUser(user);
        return Result.success(userId);
    }

    @GetMapping("/{id}")
    public Result<SampleUser> findById(@PathVariable Long id) {
        Optional<SampleUser> user = sampleUserService.findById(id);
        return user.map(Result::success)
                .orElse(Result.failure(404, "用户未找到"));
    }

    @GetMapping("/username/{username}")
    public Result<SampleUser> findByUsername(@PathVariable String username) {
        log.info("SampleUserController.findByUsername:request:{}", username);
        long start = System.currentTimeMillis();

        Optional<SampleUser> user = sampleUserService.findByUsername(username);
        long end = System.currentTimeMillis();
        log.info("SampleUserController.findByUsername: {}ms result:{}", end-start,user);
        return user.map(Result::success)
                .orElse(Result.failure(404, "用户未找到"));
    }

    @GetMapping("/email/{email}")
    public Result<SampleUser> findByEmail(@PathVariable String email) {
        Optional<SampleUser> user = sampleUserService.findByEmail(email);
        return user.map(Result::success)
                .orElse(Result.failure(404, "用户未找到"));
    }

    @PutMapping
    public Result<Integer> updateUser(@RequestBody SampleUser user) {
        int rowsAffected = sampleUserService.updateUser(user);
        return Result.success(rowsAffected);
    }

    @PutMapping("/{id}/last-login")
    public Result<Integer> updateLastLogin(@PathVariable Long id, @RequestParam LocalDateTime lastLogin) {
        int rowsAffected = sampleUserService.updateLastLogin(id, lastLogin);
        return Result.success(rowsAffected);
    }

    @GetMapping("/type/{userType}")
    public Result<List<SampleUser>> findByUserType(@PathVariable SampleUser.UserType userType) {
        List<SampleUser> users = sampleUserService.findByUserType(userType);
        return Result.success(users);
    }

    @DeleteMapping("/{id}/deactivate")
    public Result<Integer> deactivateUser(@PathVariable Long id) {
        int rowsAffected = sampleUserService.deactivateUser(id);
        return Result.success(rowsAffected);
    }

    @GetMapping("/active/count")
    public Result<Integer> countActiveUsers() {
        int count = sampleUserService.countActiveUsers();
        return Result.success(count);
    }

    @GetMapping
    public Result<List<SampleUser>> findAllUsers() {
        List<SampleUser> users = sampleUserService.findAllUsers();
        return Result.success(users);
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteUser(@PathVariable Long id) {
        int rowsAffected = sampleUserService.deleteUser(id);
        return Result.success(rowsAffected);
    }
}