package edu.sp5.jvx330.cafe.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;

@Controller("searchItemsController")
public class SearchItemsController {
	@Autowired
	private ItemSerivceImpl itemServiceImpl;
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@GetMapping("/main/menu/searchItems")
	public ModelAndView SearchItemsForm() {
		
		ModelAndView mav = new ModelAndView();
	
		Map<Category, List<Item>> categoryItemMap = new HashMap<Category, List<Item>>();
		
		List<Category> category_list = categoryServiceImpl.findAllCategorys();
		
		for (Category category : category_list) {
			categoryItemMap.put(category, itemServiceImpl.findItemsByCategory(category));
		}
		
		mav.addObject("categoryItemMap", categoryItemMap);
		
		mav.addObject("searchItems_link", "searchItems");
		mav.setViewName("main/menu/searchItems");
		
		System.out.println("GET");
		return mav;
	}
	
	@PostMapping("/main/menu/searchItems")
	public String SearchItemsPost() {
		
		System.out.println("POST");
		return "/main/menu/search_items";
	}
}
