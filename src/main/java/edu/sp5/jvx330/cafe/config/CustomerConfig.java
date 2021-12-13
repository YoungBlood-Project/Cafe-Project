package edu.sp5.jvx330.cafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.membership.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.membership.dao.impl.CustomerDaoImpl;

@Configuration
@Import(DataSourceConfig.class)
public class CustomerConfig extends DataSourceConfig{
	
	@Bean //�� Dao�� Bean���� �������� ����...? ���
	public CustomerDaoImpl customerDaoImpl() {
		return new CustomerDaoImpl();
	}
	
	@Bean
	public CustomerServiceImpl customerServiceImpl() {
		return new CustomerServiceImpl();
	}
}
