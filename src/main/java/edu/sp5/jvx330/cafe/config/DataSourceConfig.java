package edu.sp5.jvx330.cafe.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "edu.sp5.jvx330.cafe")
@EnableTransactionManagement //트랜잭션 사용할 것
public class DataSourceConfig {
	
	@Bean
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		ds.setUrl("jdbc:derby://localhost:1527/cafe");
		ds.setUsername("cafe");
		ds.setPassword("cafe");
		
		//커넥션 pool과 관련된 환경 조절
		ds.setInitialSize(2);//초기에 커넥션을 2개 만들어라
		ds.setMaxActive(10);//연결된 커넥션을 최대 10개까지 만들어라 (아무것도 적지 않으면 디폴트 100)
		ds.setMaxIdle(10);//Active와 Idle를 맞춰줘야 하나? Idle: 게으른
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
}
