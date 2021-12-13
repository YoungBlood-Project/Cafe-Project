package edu.sp5.jvx330.cafe.membership.command;

import edu.sp5.jvx330.cafe.membership.domain.Customer;

public class MileageCommand {
	private Long mId;
	private Customer customer;
	private Integer mTotal;
	
	public Long getmId() {
		return mId;
	}
	public void setmId(Long mId) {
		this.mId = mId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getMTotal() {
		return mTotal;
	}
	public void setMTotal(Integer mTotal) {
		this.mTotal = mTotal;
	}
}
