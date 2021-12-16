package edu.sp5.jvx330.cafe.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;

@Controller("setItemsController")
public class SetItemsController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private ItemSerivceImpl itemServiceImpl;
	
	
	@GetMapping("/menu/setItems")
	public ModelAndView setItemsGet() {
		ModelAndView mav = new ModelAndView();
		
		// select - option�� ���� �ֱ� ���� category List ����
		List<Category> category_list = categoryServiceImpl.findAllCategorys();
		
		mav.addObject("category_list", category_list);
		mav.setViewName("menu/set_items");
		
		return mav;
	}
	
	@PostMapping("/menu/setItems")
	public ModelAndView setItemsPost(String categoryName, String itemName, Integer itemPrice) {
		ModelAndView mav = new ModelAndView();
		
		Category category = categoryServiceImpl.findCategoryByCategoryName(categoryName);
		
		Item item = new Item();
		itemServiceImpl.setItemName(item, itemName);
		itemServiceImpl.setItemPrice(item, itemPrice);
		
		// ���� Ȯ�� Ŭ������ �� ������ üũ�ڽ��Ǿ� ������ �����Ǵ� ���
		
		mav.setViewName("menu/search_items");
		return mav;
	}
}
