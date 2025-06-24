package com.chenjiacheng.data.access.samples.start.ds.route;

import com.chenjiacheng.data.access.samples.start.ds.route.DS;
import com.chenjiacheng.data.access.samples.start.ds.route.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class DataSourceAspect {

    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, DS ds) {
        String dataSourceKey = ds.value();
        DataSourceContextHolder.setDataSourceType(dataSourceKey);
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, DS ds) {
        DataSourceContextHolder.clearDataSourceType();
    }
}