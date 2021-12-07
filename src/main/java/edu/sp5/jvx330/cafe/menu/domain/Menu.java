package edu.sp5.jvx330.cafe.menu.domain;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public class Menu {
	private Long mid;
	private String category;
	private String menuName;
	private Integer menuPrice;
	
	public Menu() {
		
	}
	//DB에 등록할 때 사용
	public Menu(String category, String menuName, Integer menuPrice) {
		super();
		this.category = category;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", category=" + category + " , menuName=" + menuName + ", menuPrice=" + menuPrice
				+ "]";
	}
}
