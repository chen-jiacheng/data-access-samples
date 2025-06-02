# Data Access Samples

> 数据库相关框架集成


##  1. 依赖
1. org.springframework.boot::spring-boot-dependencies::2.7.13
2. org.springframework.boot::spring-boot-starter-web
3. org.springframework.boot::spring-boot-starter-jdbc
4. lombok::lombok
5. mysql:mysql-connector-java
6. mybatis::mybatis-spring-boot-starter
7. mybatis::mybatis
8. slf4j::slf4j-api
9. log4j::log4j-slf4j-impl

##  2. 数据库配置
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
  mybatis:
    mapper-locations: classpath:mapper/*.xml
    type-aliases-package: com.example.demo.model
```
https://blog.csdn.net/Agan__/article/details/148384501?spm=1011.2415.3001.5331