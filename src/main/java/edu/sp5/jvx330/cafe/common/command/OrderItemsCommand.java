package edu.sp5.jvx330.cafe.common.command;

import java.util.List;

//�ֹ����� ������ ���� ��
public class OrderItemsCommand {
	private String menuName;//�޴� �̸�
	private Integer numOfNum;//�޴� ����
	private Integer paidPrice;//���� ���� ����
	
	private List<OrderItemsCommand> orderItemsList; 
	
	public OrderItemsCommand() {
		
	}

	public OrderItemsCommand(String menuName, Integer numOfNum, Integer paidPrice) {
		super();
		this.menuName = menuName;
		this.numOfNum = numOfNum;
		this.paidPrice = paidPrice;
	}

	public List<OrderItemsCommand> getOrderItemsList() {
		return orderItemsList;
	}

	public void setOrderItemsList(List<OrderItemsCommand> orderItemsList) {
		this.orderItemsList = orderItemsList;
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

	public Integer getPaidPrice() {
		return paidPrice;
	}

	public void setPaidPrice(Integer paidPrice) {
		this.paidPrice = paidPrice;
	}

	@Override
	public String toString() {
		return "OrderItemsCommand [menuName=" + menuName + ", numOfNum=" + numOfNum + ", paidPrice=" + paidPrice
				+ ", orderItemsList=" + orderItemsList + "]";
	}
}
