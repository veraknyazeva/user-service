package ru.netology.userservice.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@ConditionalOnProperty(name = "spring.liquibase.enabled", havingValue = "true")
public class LiquibaseRunner {

    @Value("${spring.datasource.hikari.schema:public}")
    private String schemaName;

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDefaultSchema(schemaName);
        liquibase.setChangeLog("classpath:db/liquibase/changelog.xml");
        liquibase.setDataSource(dataSource);
        var parametersMap = new HashMap<String, String>();
        parametersMap.put("SCHEMA", schemaName);
        liquibase.setChangeLogParameters(parametersMap);
        return liquibase;
    }
}
