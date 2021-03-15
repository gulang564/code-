package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//DataSourceAutoConfiguration  自动配置，默认使用但数据源，如果需要配置多数据源的情况，则剔除掉自动配置

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MongodbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class,args);
    }
}
