package edu.sp5.jvx330.cafe.membership.domain;

import java.util.Date;

public class Customer {
	private Long cid;
	private String name;
	private String phone;
	private Date regDate;
	
	public Customer() {
		
	}
	
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", phone=" + phone + ", regDate=" + regDate + "]";
	}	
}
