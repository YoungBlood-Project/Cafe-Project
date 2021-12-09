package edu.sp5.jvx330.cafe.category.domain;

public class Category {
	private Long categoryId;
	private String categoryName;
	
	public Category() {
		
	}
	
	//DB에서 사용
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
