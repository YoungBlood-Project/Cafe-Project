package edu.sp5.jvx330.cafe.category.item.domain;

import java.util.Date;

import edu.sp5.jvx330.cafe.category.domain.Category;

public class Item {
	private Long itemId;
	private Category category;
	private String itemName;
	private Integer itemPrice;
	private String itemUrl;
	private Date regDate;
	
	public Item() {
		
	}
	
	//DB에 등록할 때 사용
	public Item(Category category, String itemName, Integer itemPrice, String itemUrl) {
		super();
		this.category = category;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemUrl = itemUrl;
	}

	/**
	 * getter, setter
	 * @return
	 */
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", category=" + category + ", itemName=" + itemName + ", itemPrice="
				+ itemPrice + ", itemUrl=" + itemUrl + ", regDate=" + regDate + "]";
	}
}
