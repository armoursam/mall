package com.sam.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置类
 */
@Configuration
@MapperScan("com.sam.mall.mbg.mapper")
public class MyBatisConfig {
}
