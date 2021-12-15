package edu.sp5.jvx330.cafe.manager.business;

import edu.sp5.jvx330.cafe.manager.domain.Manager;

public interface ManagerService {

	public Manager loginManager(String managerName, String passwd);
}
