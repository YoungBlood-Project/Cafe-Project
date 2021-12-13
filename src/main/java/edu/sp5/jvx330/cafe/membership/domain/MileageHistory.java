package edu.sp5.jvx330.cafe.membership.domain;

import java.util.Date;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public class MileageHistory {
	private Long mhId;
	private	Customer customer;
	private Long orderNum;
	private Integer mBalance;
	private Date regDate;
	
	public MileageHistory() {
		
	}
	
	//DB에서 등록할 때 사용
	public MileageHistory(Customer customer, Long orderNum, Integer mBalance) {
		super();
		this.customer = customer;
		this.orderNum = orderNum;
		this.mBalance = mBalance;
	}
	public Long getMhId() {
		return mhId;
	}
	public void setMhId(Long mhId) {
		this.mhId = mhId;
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
		return "MileageHistory [mhId=" + mhId + ", customer=" + customer + ", mBalance=" + mBalance + ", regDate="
				+ regDate + "]";
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
}
