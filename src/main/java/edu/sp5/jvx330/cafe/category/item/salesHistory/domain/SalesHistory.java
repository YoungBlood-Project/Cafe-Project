package edu.sp5.jvx330.cafe.category.item.salesHistory.domain;

import java.util.Date;

import edu.sp5.jvx330.cafe.category.item.domain.Item;

public class SalesHistory {
	private Long shid;
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

	
}
