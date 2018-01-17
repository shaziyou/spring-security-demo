package com.shaziyou.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfigurer {

    @Bean
    @ConfigurationProperties("spring.datasource.c3p0")
    public ComboPooledDataSource dataSource() {
        return new ComboPooledDataSource();
    }

}
