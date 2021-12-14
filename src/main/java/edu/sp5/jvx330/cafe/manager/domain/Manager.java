package edu.sp5.jvx330.cafe.manager.domain;

public class Manager {
	
	private Long managerId;
	private String managerName;
	private String passwd;
	
	
	public Manager(String managerName, String passwd) {
		super();
		this.managerName = managerName;
		this.passwd = passwd;
	}
	
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", passwd=" + passwd + "]";
	}
	
}
