package com.organization.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackages = "com.organization.project.repository",
        entityManagerFactoryRef = "projectEntityManager",
        transactionManagerRef = "projectTransactionManager")
public class ProjectHibernateConfig {

    @Bean("projectDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.project.datasource")
    public DataSourceProperties projectDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("projectDataSource")
    @ConfigurationProperties(prefix = "spring.project.datasource.configuration")
    public DataSource projectDataSource(@Qualifier("projectDataSourceProperties") DataSourceProperties properties) {
        System.out.println(properties);
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean("projectEntityManager")
    public LocalContainerEntityManagerFactoryBean projectEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("projectDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");

        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("com.organization.employee.entity")
                .persistenceUnit("ProjectResultDb")
                .build();
    }

    @Bean("projectTransactionManager")
    public PlatformTransactionManager projectTransactionManager(@Qualifier("projectEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
