package edu.sp5.jvx330.cafe.mileage.domain;

import java.util.Date;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public class Mileage {
	private Long mileageId;
	private	Customer customer;
	private Long orderNum;
	private Integer mBalance;
	private Date regDate;
	
	public Mileage() {
		
	}
	
	//DB에서 등록할 때 사용
	public Mileage(Customer customer, Long orderNum, Integer mBalance) {
		super();
		this.customer = customer;
		this.orderNum = orderNum;
		this.mBalance = mBalance;
	}
	public Long getMileageId() {
		return mileageId;
	}
	public void setMileageId(Long mileageId) {
		this.mileageId = mileageId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getMBalance() {
		return mBalance;
	}
	public void setMBalance(Integer mbalance) {
		this.mBalance = mbalance;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "Mileage [mileageId=" + mileageId + ", customer=" + customer + ", mBalance=" + mBalance + ", regDate="
				+ regDate + "]";
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
}
