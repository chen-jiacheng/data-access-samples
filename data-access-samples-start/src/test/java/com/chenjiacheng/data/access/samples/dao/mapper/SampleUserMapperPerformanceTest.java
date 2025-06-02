package com.chenjiacheng.data.access.samples.dao.mapper;

import com.chenjiacheng.data.access.samples.dao.model.SampleUser;
import com.chenjiacheng.data.access.samples.BaseSpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class SampleUserMapperPerformanceTest extends BaseSpringBootTest {

    @Autowired
    private SampleUserMapper sampleUserMapper;

    @Test
    @Transactional
    public void testInsertUserPerformance() {
        SampleUser user = createMockUser();
        long startTime = System.nanoTime();
        int rowsAffected = sampleUserMapper.insertUser(user);
        long endTime = System.nanoTime();
        assertEquals(1, rowsAffected, "Insert should affect 1 row");
        System.out.println("Execution time for insertUser: " + (endTime - startTime) + " ns");
    }

    @Test
    @Transactional
    public void testFindByIdPerformance() {
        SampleUser user = createMockUser();
        sampleUserMapper.insertUser(user);
        long startTime = System.nanoTime();
        Optional<SampleUser> result = sampleUserMapper.findById(user.getUserId());
        long endTime = System.nanoTime();
        assertTrue(result.isPresent(), "User should be found");
        System.out.println("Execution time for findById: " + (endTime - startTime) + " ns");
    }

    @Test
    @Transactional
    public void testFindByUsernamePerformance() {
        SampleUser user = createMockUser();
        sampleUserMapper.insertUser(user);
        long startTime = System.nanoTime();
        Optional<SampleUser> result = sampleUserMapper.findByUsername(user.getUsername());
        long endTime = System.nanoTime();
        assertTrue(result.isPresent(), "User should be found");
        System.out.println("Execution time for findByUsername: " + (endTime - startTime) + " ns");
    }

    @Test
    @Transactional
    public void testUpdateLastLoginPerformance() {
        SampleUser user = createMockUser();
        sampleUserMapper.insertUser(user);
        long startTime = System.nanoTime();
        int rowsAffected = sampleUserMapper.updateLastLogin(user.getUserId(), LocalDateTime.now());
        long endTime = System.nanoTime();
        assertEquals(1, rowsAffected, "Update should affect 1 row");
        System.out.println("Execution time for updateLastLogin: " + (endTime - startTime) + " ns");
    }

    @Test
    @Transactional
    public void testFindByUserTypePerformance() {
        SampleUser user = createMockUser();
        sampleUserMapper.insertUser(user);
        long startTime = System.nanoTime();
        List<SampleUser> users = sampleUserMapper.findByUserType(user.getUserType());
        long endTime = System.nanoTime();
        assertFalse(users.isEmpty(), "Users list should not be empty");
        System.out.println("Execution time for findByUserType: " + (endTime - startTime) + " ns");
    }

    @Test
    @Transactional
    public void testDeactivateUserPerformance() {
        SampleUser user = createMockUser();
        sampleUserMapper.insertUser(user);
        long startTime = System.nanoTime();
        int rowsAffected = sampleUserMapper.deactivateUser(user.getUserId());
        long endTime = System.nanoTime();
        assertEquals(1, rowsAffected, "Deactivate should affect 1 row");
        System.out.println("Execution time for deactivateUser: " + (endTime - startTime) + " ns");
    }

    @Test
    @Transactional
    public void testCountActiveUsersPerformance() {
        SampleUser user = createMockUser();
        sampleUserMapper.insertUser(user);
        long startTime = System.nanoTime();
        int count = sampleUserMapper.countActiveUsers();
        long endTime = System.nanoTime();
        assertTrue(count > 0, "Active users count should be greater than 0");
        System.out.println("Execution time for countActiveUsers: " + (endTime - startTime) + " ns");
    }

    @Test
    @Transactional
    public void testFindAllUsersPerformance() {
        SampleUser user = createMockUser();
        sampleUserMapper.insertUser(user);
        long startTime = System.nanoTime();
        List<SampleUser> users = sampleUserMapper.findAllUsers();
        long endTime = System.nanoTime();
        assertFalse(users.isEmpty(), "Users list should not be empty");
        System.out.println("Execution time for findAllUsers: " + (endTime - startTime) + " ns");
    }

    @Test
    @Transactional
    public void testDeleteUserPerformance() {
        SampleUser user = createMockUser();
        sampleUserMapper.insertUser(user);
        long startTime = System.nanoTime();
        int rowsAffected = sampleUserMapper.deleteUser(user.getUserId());
        long endTime = System.nanoTime();
        assertEquals(1, rowsAffected, "Delete should affect 1 row");
        System.out.println("Execution time for deleteUser: " + (endTime - startTime) + " ns");
    }

    private SampleUser createMockUser() {
        SampleUser user = new SampleUser();
        user.setUsername("test_user");
        user.setPasswordHash("hashed_password");
        user.setDisplayName("Test User");
        user.setEmail("test_user@example.com");
        user.setUserType(SampleUser.UserType.NORMAL);
        user.setCreatedAt(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setIsActive(true);
        return user;
    }
}