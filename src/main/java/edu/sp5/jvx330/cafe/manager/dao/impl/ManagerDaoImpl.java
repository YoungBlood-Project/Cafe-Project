package edu.sp5.jvx330.cafe.manager.dao.impl;

import edu.sp5.jvx330.cafe.manager.dao.ManagerDao;
import edu.sp5.jvx330.cafe.manager.domain.Manager;

public class ManagerDaoImpl implements ManagerDao {
	
	//1. 매니저 로그
	public Manager managerLogin(Manager manager) {
		String sql = "SELECT managerId, managerName, passwd FROM Manager"
				+ " WHERE managerName = ?, passwd = ?";
		
		return null;
	}
}
