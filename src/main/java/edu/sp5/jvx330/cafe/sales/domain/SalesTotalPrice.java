package edu.sp5.jvx330.cafe.sales.domain;

import java.util.Date;

public class SalesTotalPrice {

	private Long stpId;

	private Long orderNum;
	private Integer totalPrice;
	private Integer reducedPrice;

	private Date orderDate;

	public SalesTotalPrice() {

	}

	public SalesTotalPrice(Long orderNum, Integer totalPrice, Integer reducedPrice) {
		super();
		this.orderNum = orderNum;
		this.totalPrice = totalPrice;
		this.reducedPrice = reducedPrice;
	}

	public Long getStpId() {
		return stpId;
	}

	public void setStpId(Long stpId) {
		this.stpId = stpId;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getReducedPrice() {
		return reducedPrice;
	}

	public void setReducedPrice(Integer reducedPrice) {
		this.reducedPrice = reducedPrice;
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
				+ ", reducedPrice=" + reducedPrice + ", orderDate=" + orderDate + "]";
	}
}