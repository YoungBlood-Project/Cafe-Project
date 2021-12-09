package edu.sp5.jvx330.cafe.customer.mileage.domain;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public class Mileage {
	private Long tmId;
	private Customer customer;
	private Integer mileageTotal;
	
	public Mileage() {
		
	}
	
	public Mileage(Integer mileageTotal) {
		super();
		this.mileageTotal = mileageTotal;
	}
	
	public Long getTmId() {
		return tmId;
	}
	public void setTmId(Long tmId) {
		this.tmId = tmId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getMileageTotal() {
		return mileageTotal;
	}
	public void setMileageTotal(Integer mileageTotal) {
		this.mileageTotal = mileageTotal;
	}

	@Override
	public String toString() {
		return "TotalMileage [tmId=" + tmId + ", customer=" + customer + ", mileageTotal=" + mileageTotal + "]";
	}
}
