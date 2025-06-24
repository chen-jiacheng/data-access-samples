package com.chenjiacheng.data.access.samples.start.ds;

import com.chenjiacheng.data.access.samples.start.ds.route.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        //1. 指定数据源
        //2. 指定注解
        return DataSourceContextHolder.getDataSourceType();
    }
}