package edu.sp5.jvx330.cafe.sales.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuSalesHistoryCommand {
	private String categoryName;
	private String itemName;
	private Long totalNumOfNum;
	private Integer totalPrice;
	
	public MenuSalesHistoryCommand() {
		
	}
	
	public MenuSalesHistoryCommand(String categoryName, String itemName, Long totalNumOfNum, Integer totalPrice) {
		super();
		this.categoryName = categoryName;
		this.itemName = itemName;
		this.totalNumOfNum = totalNumOfNum;
		this.totalPrice = totalPrice;
	}
}
