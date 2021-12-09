package edu.sp5.jvx330.cafe.customer.mileage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.DataSourceConfig;
import edu.sp5.jvx330.cafe.customer.mileage.business.impl.TotalMileageServiceImpl;
import edu.sp5.jvx330.cafe.customer.mileage.dao.impl.TotalMileageDaoImpl;

@Configuration
@Import(DataSourceConfig.class)
public class TotalMileageConfig extends DataSourceConfig {
	@Bean
	public TotalMileageDaoImpl totalMileageDaoImpl() {
		return new TotalMileageDaoImpl();
	}
	
	@Bean
	public TotalMileageServiceImpl totalMileageServiceImpl() {
		return new TotalMileageServiceImpl();
	}
}
