package edu.sp5.jvx330.cafe.category.item.salesTotalPrice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.dao.impl.SalesTotalPriceDaoImpl;
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