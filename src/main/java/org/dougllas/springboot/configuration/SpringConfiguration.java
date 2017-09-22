package org.dougllas.springboot.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by DOUGLLAS SOUSA on 20/09/2017.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"org.dougllas"})
@EnableJpaRepositories(basePackages = {"org.dougllas.springboot.repository"})
@EnableAutoConfiguration
@EntityScan("org.dougllas.springboot.model")
public class SpringConfiguration {

    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.generateUniqueName(true);
        builder.setType(EmbeddedDatabaseType.DERBY);
        builder.addScript("db/create-db.sql");
        builder.addScript("db/insert-data.sql");
        EmbeddedDatabase db = builder.build();
        return db;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringConfiguration.class, args);
    }
}