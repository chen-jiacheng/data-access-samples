package com.chenjiacheng.data.access.samples.start;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by chenjiacheng on 2025/6/1 17:27
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@MapperScan(basePackages = "com.chenjiacheng.data.access.samples.dao.mapper")
@SpringBootApplication(scanBasePackages = "com.chenjiacheng.data.access.samples")
public class DataAccessSamplesApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataAccessSamplesApplication.class, args);
        log.info("Data Access Samples Application started successfully!");
    }
}