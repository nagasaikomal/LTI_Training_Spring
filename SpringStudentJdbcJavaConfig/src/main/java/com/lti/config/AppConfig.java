package com.lti.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.lti")
public class AppConfig {
	@Autowired
	private DataSource dataSource;
	@Bean
	public JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
/*		jdbcTemplate.setDataSource(getDataSouce());*/
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
	
	@Bean
	public DataSource getDataSouce(){
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@Localhost:1521:XE");
			dataSource.setUsername("hr");
			dataSource.setPassword("hr");
			return dataSource;
	}
}

