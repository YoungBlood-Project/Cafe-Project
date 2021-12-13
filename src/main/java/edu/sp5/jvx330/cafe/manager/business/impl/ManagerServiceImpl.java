package edu.sp5.jvx330.cafe.manager.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.manager.business.ManagerService;
import edu.sp5.jvx330.cafe.manager.dao.ManagerDao;
import edu.sp5.jvx330.cafe.manager.domain.Manager;

public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	@Override
	public Manager managerLogin(String managerName, String passwd) {
		Manager manager = new Manager(managerName, passwd);
		manager = managerDao.managerLogin(manager);
		if ( manager != null) {
			return manager;
		}
		return null;
	}

}
