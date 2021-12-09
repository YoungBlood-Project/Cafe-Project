package edu.sp5.jvx330.cafe.item.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.DataSourceConfig;
import edu.sp5.jvx330.cafe.item.business.impl.MenuSerivceImpl;
import edu.sp5.jvx330.cafe.item.dao.impl.ItemDaoImpl;

@Configuration
@Import(DataSourceConfig.class)
public class MenuConfig extends DataSourceConfig {
	@Bean
	public ItemDaoImpl itemDaoImpl() {
		return new ItemDaoImpl();
	}
	
	@Bean
	public MenuSerivceImpl menuServiceImpl() {
		return new MenuSerivceImpl();
	}
}
