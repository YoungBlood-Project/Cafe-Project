package edu.sp5.jvx330.cafe.sales.command;

public class MenuSalesHistoryCommand {
	private String categoryName;
	private String itemName;
	private Long numOfNum;
	private Integer totalPrice;
	
	public MenuSalesHistoryCommand() {
		
	}
	
	public MenuSalesHistoryCommand(String categoryName, String itemName, Long numOfNum, Integer totalPrice) {
		super();
		this.categoryName = categoryName;
		this.itemName = itemName;
		this.numOfNum = numOfNum;
		this.totalPrice = totalPrice;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Long getNumOfNum() {
		return numOfNum;
	}
	public void setNumOfNum(Long orderNum) {
		numOfNum = orderNum;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "MenuSalesHistoryCommand [categoryName=" + categoryName + ", itemName=" + itemName + ", numOfNum="
				+ numOfNum + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
