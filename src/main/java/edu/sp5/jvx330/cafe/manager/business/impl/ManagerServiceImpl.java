package edu.sp5.jvx330.cafe.manager.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import edu.sp5.jvx330.cafe.manager.business.ManagerService;
import edu.sp5.jvx330.cafe.manager.dao.ManagerDao;
import edu.sp5.jvx330.cafe.manager.domain.Manager;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;

public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	@Override
	public Manager loginManager(String managerName, String passwd) {
		Manager manager = new Manager(managerName, passwd);
		try {
			manager = managerDao.loginManager(manager);
			return manager;
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}

}
