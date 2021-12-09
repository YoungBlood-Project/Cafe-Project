package edu.sp5.jvx330.cafe.category.item.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.DataSourceConfig;
import edu.sp5.jvx330.cafe.item.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.item.dao.impl.ItemDaoImpl;

@Configuration
@Import(DataSourceConfig.class)
public class ItemConfig extends DataSourceConfig {
	@Bean
	public ItemDaoImpl itemDaoImpl() {
		return new ItemDaoImpl();
	}
	
	@Bean
	public ItemSerivceImpl menuServiceImpl() {
		return new ItemSerivceImpl();
	}
}
