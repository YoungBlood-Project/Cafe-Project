package edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.dao.impl.SalesTotalPriceDaoImpl;
import edu.sp5.jvx330.cafe.common.config.DataSourceConfig;

@Configuration
@Import(DataSourceConfig.class)
public class SalesTotalPriceConfig {
	@Bean
	public SalesTotalPriceDaoImpl salesTotalPriceDaoImpl() {
		return new SalesTotalPriceDaoImpl();
	}
	
	@Bean
	public SalesTotalPriceServiceImpl salesTotalPriceServiceImpl() {
		return new SalesTotalPriceServiceImpl();
	}
}
