package com.organization;

import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
public class OrganizationProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationProjectApplication.class, args);
    }

    @Bean
    public static PlaceholderConfigurerSupport propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
