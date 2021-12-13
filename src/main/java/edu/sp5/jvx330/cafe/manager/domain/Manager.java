package edu.sp5.jvx330.cafe.manager.domain;

public class Manager {
	
	private Integer managerId;
	private String name;
	private String passwd;
	
	
	public Manager(String name, String passwd) {
		super();
		this.name = name;
		this.passwd = passwd;
	}
	
	
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", name=" + name + ", passwd=" + passwd + "]";
	}
	
}
