package edu.sp5.jvx330.cafe.customer.mileage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.common.config.DataSourceConfig;
import edu.sp5.jvx330.cafe.customer.mileage.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.customer.mileage.dao.impl.MileageDaoImpl;

@Configuration
@Import(DataSourceConfig.class)
public class MileageConfig extends DataSourceConfig {
	@Bean
	public MileageDaoImpl mileageDaoImpl() {
		return new MileageDaoImpl();
	}
	
	@Bean
	public MileageServiceImpl mileageServiceImpl() {
		return new MileageServiceImpl();
	}
}
