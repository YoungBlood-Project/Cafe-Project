package edu.sp5.jvx330.cafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.dao.impl.ItemDaoImpl;

@Configuration
@Import(DataSourceConfig.class)
public class ItemConfig extends DataSourceConfig {
	@Bean
	public ItemDaoImpl itemDaoImpl() {
		return new ItemDaoImpl();
	}
	
	@Bean
	public ItemSerivceImpl itemServiceImpl() {
		return new ItemSerivceImpl();
	}
}
