package com.chenjiacheng.data.access.samples.start.aop;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class DruidConfig {

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> registration = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        registration.addInitParameter("loginUsername", "admin");
        registration.addInitParameter("loginPassword", "admin");
        registration.addInitParameter("resetEnable", "false");
        return registration;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> filter = new FilterRegistrationBean<>(new WebStatFilter());
        filter.addUrlPatterns("/*");
        filter.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filter.addInitParameter("sessionStatEnable", "true");
        filter.addInitParameter("sessionStatMaxCount", "1000");
        return filter;
    }

    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        return new DruidStatInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean
    public JdkRegexpMethodPointcut druidStatPointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPatterns(
            "com.chenjiacheng.data.access.samples.service.service.*",
            "com.chenjiacheng.data.access.samples.start.controller.*",
            "com.chenjiacheng.data.access.samples.dao.*"
        );
        return pointcut;
    }

    @Bean
    public Advisor druidStatAdvisor() {
        return new DefaultPointcutAdvisor(druidStatPointcut(), druidStatInterceptor());
    }
}