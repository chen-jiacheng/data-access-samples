package com.chenjiacheng.data.access.samples.start.ds.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by chenjiacheng on 2025/6/24 11:28
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Configuration
public class DatasourceConfig {

    @Bean(name = "anhui")
    @ConfigurationProperties(prefix = "spring.datasource.anhui")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "henan")
    @ConfigurationProperties(prefix = "spring.datasource.henan")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

}
