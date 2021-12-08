package edu.sp5.jvx330.cafe.command;

//주문내역 AJAX 데이터 받을 곳
public class OrderListCommand {
	private String menuName;
	private Integer numOfNum;
	private Integer paidPrice;
	
	public OrderListCommand() {
		
	}
	
	public OrderListCommand(String menuName, Integer numOfNum, Integer paidPrice) {
		super();
		this.menuName = menuName;
		this.numOfNum = numOfNum;
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

	public Integer getPaidPrice() {
		return paidPrice;
	}

	public void setPaidPrice(Integer paidPrice) {
		this.paidPrice = paidPrice;
	}

	@Override
	public String toString() {
		return "OrderList [menuName=" + menuName + ", numOfNum=" + numOfNum + ", paidPrice=" + paidPrice + "]";
	}
}
