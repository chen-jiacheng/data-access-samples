package com.chenjiacheng.data.access.samples.dao.performance;

import com.chenjiacheng.data.access.samples.BaseSpringBootTest;
import com.chenjiacheng.data.access.samples.dao.mapper.SampleUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by chenjiacheng on 2025/6/1 23:33
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
public class SampleUserMapperPerformanceTest extends BaseSpringBootTest {

    @Resource
    private SampleUserMapper sampleUserMapper;


    @Test
    public void insertTest(){
        int cpuCount = Runtime.getRuntime().availableProcessors();
        log.info("CPU Count: {}", cpuCount);
        // 创建一个线程池，线程数为 CPU 核心数的两倍
        int threadCount = cpuCount * 2;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorService.execute(new SampleUserMapperPerformanceTask(sampleUserMapper));
        }
        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("end");
    }

}
