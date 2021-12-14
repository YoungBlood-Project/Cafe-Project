package edu.sp5.jvx330.cafe.menu.command;

import java.util.List;

//�ֹ����� ������ ���� ��
public class OrderItemsCommand {
	private String menuName;//�޴� �̸�
	private Integer numOfNum;//�޴� ����
	private Integer menuPrice;//�޴� �ܰ�
	private Integer paidPrice;//���� ���� ����
	
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
