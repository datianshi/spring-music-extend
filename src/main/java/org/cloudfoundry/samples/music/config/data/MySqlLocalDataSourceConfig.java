package org.cloudfoundry.samples.music.config.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("mysql-local")
public class MySqlLocalDataSourceConfig extends AbstractLocalDataSourceConfig {

    @Value("${database.host}")
    private String host;

    @Value("${database.name}")
    private String name;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        String jdbcUrl = "jdbc:mysql://" + host + "/" + name;
        return createDataSource(jdbcUrl, "com.mysql.jdbc.Driver", username, password);
    }

}
