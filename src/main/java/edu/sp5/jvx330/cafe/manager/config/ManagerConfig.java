package edu.sp5.jvx330.cafe.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.sp5.jvx330.cafe.DataSourceConfig;
import edu.sp5.jvx330.cafe.customer.dao.impl.CustomerDaoImpl;

@Configuration
@Import(DataSourceConfig.class)
public class ManagerConfig {

}
