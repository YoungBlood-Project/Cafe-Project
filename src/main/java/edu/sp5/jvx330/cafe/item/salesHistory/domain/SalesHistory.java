package edu.sp5.jvx330.cafe.item.salesHistory.domain;

import java.util.Date;

import edu.sp5.jvx330.cafe.item.domain.Item;
import edu.sp5.jvx330.cafe.item.salesHistory.util.OrderNumGenerator;

public class SalesHistory {
	private Long sid;
	private Item item;
	private Long orderNum;
	private Integer numOfSales;
	private Integer paidPrice;
	private Date orderDate;
	
	//Bean���� ����Ϸ��� ����Ʈ ������ �־�� �Ѵ�?
	public SalesHistory() {

	}
	
	//DB�� ����� �� ���
	public SalesHistory(Item item, Integer numOfSales, Integer paidPrice) {
		super();
		this.item = item;
		this.numOfSales = numOfSales;
		this.paidPrice = paidPrice;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Item getMenu() {
		return item;
	}

	public void setMenu(Item item) {
		this.item = item;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getNumOfSales() {
		return numOfSales;
	}

	public void setNumOfSales(Integer numOfSales) {
		this.numOfSales = numOfSales;
	}

	public Integer getPaidPrice() {
		return paidPrice;
	}

	public void setPaidPrice(Integer paidPrice) {
		this.paidPrice = paidPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "SalesHistory [sid=" + sid + ", menu=" + item + ", orderNum=" + orderNum + ", numOfSales=" + numOfSales
				+ ", paidPrice=" + paidPrice + ", orderDate=" + orderDate + "]";
	}
}
