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

@Controller("addItemsContoller")
public class AddItemsController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private ItemSerivceImpl itemServiceImpl;
	
	@GetMapping("/menu/addItems")
	public ModelAndView addItemGet() {
		ModelAndView mav = new ModelAndView();
		
		List<Category> category_list = categoryServiceImpl.findAllCategorys();

		mav.addObject("category_list", category_list);
		mav.setViewName("/menu/add_items");
		
		return mav;
	}
	
	@PostMapping("/menu/addItems")
	public ModelAndView addItemsPost(String itemName, Integer itemPrice) {
		
		ModelAndView mav = new ModelAndView();
		
		Item item = new Item();
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		
		itemServiceImpl.addItem(item);
		
		System.out.println("Post success.");
		
		mav.addObject("itemName", item.getItemName());
		mav.addObject("itemPrice", item.getItemPrice());
		mav.setViewName("/menu/searchItems");
		
		return mav;
	}
}
