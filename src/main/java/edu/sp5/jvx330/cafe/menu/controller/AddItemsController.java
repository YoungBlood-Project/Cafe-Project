package edu.sp5.jvx330.cafe.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.util.Validator;

@Controller("addItemsContoller")
public class AddItemsController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private ItemSerivceImpl itemServiceImpl;
	
	@GetMapping("/menu/addItems")
	public ModelAndView addItemsGet() {
		ModelAndView mav = new ModelAndView();
		
		List<Category> category_list = categoryServiceImpl.findAllCategorys();

		mav.addObject("category_list", category_list);
		mav.setViewName("menu/add_items");
		
		return mav;
	}
	
	@Transactional
	@PostMapping("/menu/addItems")
	public ModelAndView addItemsPost(String categoryName, String itemName, Integer itemPrice) {
		
		ModelAndView mav = new ModelAndView();
		
		Category category = categoryServiceImpl.findCategoryByCategoryName(categoryName);
		
		//System.out.println("itemName : "+itemName);
		//System.out.println("itemPrice : "+itemPrice);
		
		//��ȿ�� �˻�
		if(Validator.isEmpty(itemName)||Validator.isEmpty(itemPrice)) {
			mav.addObject("errorMsgs", "������ ��� �Է����ֽʽÿ�.");
			
			List<Category> category_list = categoryServiceImpl.findAllCategorys();
			
			mav.addObject("category_list", category_list);
			mav.setViewName("menu/add_items");
			
			return mav;
		} else if((itemPrice%10) != 0) {
			mav.addObject("errorMsgs", "10�� ������ ������ �Է��� �� �����ϴ�.");
			
			List<Category> category_list = categoryServiceImpl.findAllCategorys();
			
			mav.addObject("category_list", category_list);
			mav.setViewName("menu/add_items");
			
			return mav;
		}
		
		Item item = new Item();
		item.setCategory(category);
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		
		itemServiceImpl.addItem(item);
		
		System.out.println("Post success.");
		
		//get���� �̵��ؾ� �ؼ� ��� ���� - ��
		mav.setViewName("redirect:/menu/searchItems");
		//mav.setViewName("menu/searchItems");
		
		return mav;
	}
}
