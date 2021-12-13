package edu.sp5.jvx330.cafe.membership.domain;

public class Mileage {
	private Long mId;
	private Customer customer;
	private Integer mTotal;
	
	public Mileage() {
		
	}
	
	public Mileage(Integer mileageTotal) {
		super();
		this.mTotal = mileageTotal;
	}
	
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

	@Override
	public String toString() {
		return "TotalMileage [mId=" + mId + ", customer=" + customer + ", mTotal=" + mTotal + "]";
	}
}
