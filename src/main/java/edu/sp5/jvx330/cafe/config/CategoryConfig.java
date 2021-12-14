package edu.sp5.jvx330.cafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.dao.impl.CategoryDaoImpl;

@Configuration
@Import(DataSourceConfig.class)
public class CategoryConfig extends DataSourceConfig {
	@Bean
	public CategoryServiceImpl categoryServiceImpl() {
		return new CategoryServiceImpl();
	}
		
	@Bean
	public CategoryDaoImpl categoryDaoImpl() {
		return new CategoryDaoImpl();
	}
}
