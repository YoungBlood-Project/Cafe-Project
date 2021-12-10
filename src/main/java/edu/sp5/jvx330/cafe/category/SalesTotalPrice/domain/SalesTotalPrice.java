package edu.sp5.jvx330.cafe.category.SalesTotalPrice.domain;

import edu.sp5.jvx330.cafe.category.item.domain.Item;

public class SalesTotalPrice {

	private long stpId;
	private Item item;
	private int totalPrice;
	private int reducePrice;
	
	
	public long getStpId() {
		return stpId;
	}
	public void setStpId(long stpId) {
		this.stpId = stpId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
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
