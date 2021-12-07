package edu.sp5.jvx330.cafe.customer.domain;

public class Customer {
	private Long cid;
	private String name;
	private String phone;
	
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

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", phone=" + phone + "]";
	}
}
