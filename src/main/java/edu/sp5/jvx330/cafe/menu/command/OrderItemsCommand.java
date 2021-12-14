package edu.sp5.jvx330.cafe.menu.command;

import java.util.List;

//주문내역 데이터 받을 곳
public class OrderItemsCommand {
	private String menuName;//메뉴 이름
	private Integer numOfNum;//메뉴 개수
	private Integer menuPrice;//메뉴 단가
	private Integer paidPrice;//지불 가격 저장
	
	public OrderItemsCommand() {
		
	}
	
	public OrderItemsCommand(String menuName, Integer numOfNum, Integer menuPrice, Integer paidPrice) {
		super();
		this.menuName = menuName;
		this.numOfNum = numOfNum;
		this.menuPrice = menuPrice;
		this.paidPrice = paidPrice;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getNumOfNum() {
		return numOfNum;
	}

	public void setNumOfNum(Integer numOfNum) {
		this.numOfNum = numOfNum;
	}

	public Integer getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(Integer menuPrice) {
		this.menuPrice = menuPrice;
	}

	public Integer getPaidPrice() {
		return paidPrice;
	}

	public void setPaidPrice(Integer paidPrice) {
		this.paidPrice = paidPrice;
	}

	@Override
	public String toString() {
		return "OrderItemsCommand [menuName=" + menuName + ", numOfNum=" + numOfNum + ", menuPrice=" + menuPrice
				+ ", paidPrice=" + paidPrice + "]";
	}
}
