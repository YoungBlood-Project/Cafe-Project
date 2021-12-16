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
		mav.setViewName("/main/addItems");
		
		return mav;
	}
	
//	@PostMapping("/menu/addItems")
//	public ModelAndView addItemsPost() {
//		
//		ModelAndView mav = new ModelAndView();
//		
//		
//		
//		
//	}
}
