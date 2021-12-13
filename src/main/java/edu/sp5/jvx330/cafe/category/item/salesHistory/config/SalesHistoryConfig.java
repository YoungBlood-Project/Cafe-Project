package edu.sp5.jvx330.cafe.category.item.salesHistory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.category.item.salesHistory.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.category.item.salesHistory.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.common.config.DataSourceConfig;

@Configuration
@Import(DataSourceConfig.class)
public class SalesHistoryConfig extends DataSourceConfig {
	@Bean
	public SalesHistoryDaoImpl salesHistoryDaoImpl() {
		return new SalesHistoryDaoImpl();
	}
	
	@Bean
	public SalesHistoryServiceImpl salesHistoryServiceImpl() {
		return new SalesHistoryServiceImpl();
	}
}
