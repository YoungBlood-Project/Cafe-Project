package edu.sp5.jvx330.cafe.customer.mileageHistory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import edu.sp5.jvx330.cafe.DataSourceConfig;
import edu.sp5.jvx330.cafe.customer.mileageHistory.business.impl.MileageHistoryServiceImpl;
import edu.sp5.jvx330.cafe.customer.mileageHistory.dao.impl.MileageHistoryDaoImpl;

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
