package com.organization.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages = "com.organization.employee.repository",
        entityManagerFactoryRef = "employeeEntityManager",
        transactionManagerRef = "employeeTransactionManager")
public class EmployeeHibernateConfig {

    @Primary
    @Bean("employeeDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.employee.datasource")
    public DataSourceProperties employeeDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean("employeeDataSource")
    @ConfigurationProperties(prefix = "spring.employee.datasource.configuration")
    public DataSource employeeDataSource(@Qualifier("employeeDataSourceProperties") DataSourceProperties properties) {
        System.out.println("Username: " + properties.getUsername());
        System.out.println("Password: " + properties.getPassword());
        System.out.println("Url: " + properties.getUrl());
        System.out.println("Driver: " + properties.getDriverClassName());
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean("employeeEntityManager")
    public LocalContainerEntityManagerFactoryBean employeeEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("employeeDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");

        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("com.organization.employee.entity")
                .persistenceUnit("EmployeeResultDb")
                .build();
    }

    @Primary
    @Bean("employeeTransactionManager")
    public PlatformTransactionManager employeeTransactionManager(@Qualifier("employeeEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
