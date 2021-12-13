package edu.sp5.jvx330.cafe.common.config;

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
@EnableTransactionManagement //Ʈ����� ����� ��
public class DataSourceConfig {
	
	@Bean
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		ds.setUrl("jdbc:derby://localhost:1527/cafe");
		ds.setUsername("cafe");
		ds.setPassword("cafe");
		
		//Ŀ�ؼ� pool�� ���õ� ȯ�� ����
		ds.setInitialSize(2);//�ʱ⿡ Ŀ�ؼ��� 2�� ������
		ds.setMaxActive(10);//����� Ŀ�ؼ��� �ִ� 10������ ������ (�ƹ��͵� ���� ������ ����Ʈ 100)
		ds.setMaxIdle(10);//Active�� Idle�� ������� �ϳ�? Idle: ������
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
