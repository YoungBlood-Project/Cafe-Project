package edu.sp5.jvx330.cafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.membership.business.impl.MileageHistoryServiceImpl;
import edu.sp5.jvx330.cafe.membership.dao.impl.MileageHistoryDaoImpl;

@Configuration
@Import(DataSourceConfig.class)
public class MileageHistoryConfig extends DataSourceConfig {

	@Bean
	public MileageHistoryDaoImpl mileageHistoryDaoImpl() {
		return new MileageHistoryDaoImpl();
	}
	
	@Bean 
	public MileageHistoryServiceImpl mileageHistoryServiceImpl() {
		return new MileageHistoryServiceImpl();
	}
}
