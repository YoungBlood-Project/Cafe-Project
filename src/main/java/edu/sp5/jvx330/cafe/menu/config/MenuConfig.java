package edu.sp5.jvx330.cafe.menu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.DataSourceConfig;
import edu.sp5.jvx330.cafe.menu.business.impl.MenuSerivceImpl;
import edu.sp5.jvx330.cafe.menu.dao.impl.MenuDaoImpl;

@Configuration
@Import(DataSourceConfig.class)
public class MenuConfig extends DataSourceConfig {
	@Bean
	public MenuDaoImpl menuDaoImpl() {
		return new MenuDaoImpl();
	}
	
	@Bean
	public MenuSerivceImpl menuServiceImpl() {
		return new MenuSerivceImpl();
	}
}
