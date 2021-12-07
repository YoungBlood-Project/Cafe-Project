package edu.sp5.jvx330.cafe.menu.domain;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public class Menu {
	private Long mid;
	private String menuName;
	private Integer menuPrice;
	private String category;
	
	public Menu() {
		
	}
	//DB에 등록할 때 사용
	public Menu(String menuName, Integer menuPrice, String category) {
		super();
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.category = category;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(Integer menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", menuName=" + menuName + ", menuPrice=" + menuPrice
				+ ", category=" + category + "]";
	}
}
