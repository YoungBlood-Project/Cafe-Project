package edu.sp5.jvx330.cafe.sales.domain;

import java.util.Date;

public class SalesTotalPrice {

	private Long stpId;

	private Long orderNum;
	private Integer totalPrice;
	private Integer reducePrice;

	private Date orderDate;

	public SalesTotalPrice() {

	}

	public SalesTotalPrice(Long orderNum, Integer totalPrice, Integer reducePrice) {
		super();
		this.orderNum = orderNum;
		this.totalPrice = totalPrice;
		this.reducePrice = reducePrice;
	}


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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "SalesTotalPrice [stpId=" + stpId + ", orderNum=" + orderNum + ", totalPrice=" + totalPrice
				+ ", reducePrice=" + reducePrice + ", orderDate=" + orderDate + "]";
	}

}