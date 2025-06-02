package com.chenjiacheng.data.access.samples.start;

import com.chenjiacheng.data.access.samples.BaseSpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * Created by chenjiacheng on 2025/6/1 23:13
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class DataAccessSamplesApplicationTest extends BaseSpringBootTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void contextLoader() {
        Assertions.assertNotNull(ctx, "Application context should not be null");
    }
}