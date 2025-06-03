package com.chenjiacheng.data.access.samples.dao.performance;

import com.chenjiacheng.data.access.samples.dao.mapper.SampleUserMapper;
import com.chenjiacheng.data.access.samples.dao.model.SampleUser;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * Created by chenjiacheng on 2025/6/1 23:32
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j

public class SampleUserMapperPerformanceTask implements Runnable {

    private final SampleUserMapper sampleUserMapper;

    public SampleUserMapperPerformanceTask(SampleUserMapper sampleUserMapper) {
        this.sampleUserMapper = sampleUserMapper;
    }

    @Override
    public void run() {
        try {
            while (true){
                SampleUser sampleUser = new SampleUser();
                sampleUser.setUsername("user_" + UUID.randomUUID().toString().substring(0, 8));
                sampleUser.setPasswordHash(UUID.randomUUID().toString());
                sampleUser.setDisplayName("User " + UUID.randomUUID().toString().substring(0, 5));
                sampleUser.setEmail("user" + UUID.randomUUID().toString() + "@example.com");
                sampleUser.setUserType(SampleUser.UserType.NORMAL);
                sampleUser.setCreatedAt(LocalDateTime.now());
                sampleUser.setLastLogin(LocalDateTime.now());
                sampleUser.setIsActive(true);
                log.info("Inserting user: {}", sampleUser);
                int row = sampleUserMapper.insertUser(sampleUser);
                if(1 != row){
                    throw new RuntimeException("insert user failed, row: " + sampleUser);
                }
            }
        }catch (Exception e){
            log.error("error: ",e);
        }
    }
}
