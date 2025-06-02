package com.chenjiacheng.data.access.samples.dao.performance;

import com.chenjiacheng.data.access.samples.dao.mapper.SampleUserMapper;

import java.util.concurrent.Callable;

/**
 * Created by chenjiacheng on 2025/6/1 23:32
 *
 * @author chenjiacheng
 * @since 1.0.0
 */

public class SampleUserMapperPerformanceTask implements Callable<Long> {

    private final SampleUserMapper sampleUserMapper;
    private final Long userId;

    public SampleUserMapperPerformanceTask(SampleUserMapper sampleUserMapper, Long userId) {
        this.sampleUserMapper = sampleUserMapper;
        this.userId = userId;
    }

    @Override
    public Long call() throws Exception {
        long startTime = System.currentTimeMillis();
        sampleUserMapper.findById(userId);
        return System.currentTimeMillis() - startTime;
    }


}
