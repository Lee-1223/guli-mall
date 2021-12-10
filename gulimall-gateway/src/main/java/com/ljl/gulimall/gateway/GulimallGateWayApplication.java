package com.ljl.gulimall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)  // 网关不需要数据库的连接依赖
@EnableDiscoveryClient
public class GulimallGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallGateWayApplication.class, args);
    }
}
