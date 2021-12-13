package edu.sp5.jvx330.cafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.membership.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.membership.dao.impl.MileageDaoImpl;

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
