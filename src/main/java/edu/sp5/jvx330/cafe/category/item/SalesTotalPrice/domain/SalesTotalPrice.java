package edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.domain;

public class SalesTotalPrice {

	private long stpId;
	private long orderNum;
	private int totalPrice;
	private int reducePrice;
	public long getStpId() {
		return stpId;
	}
	public void setStpId(long stpId) {
		this.stpId = stpId;
	}
	public long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getReducePrice() {
		return reducePrice;
	}
	public void setReducePrice(int reducePrice) {
		this.reducePrice = reducePrice;
	}
		
	
}
