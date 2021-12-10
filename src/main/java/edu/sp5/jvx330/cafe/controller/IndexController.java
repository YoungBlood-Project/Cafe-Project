package edu.sp5.jvx330.cafe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.category.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.category.domain.Category;
import edu.sp5.jvx330.cafe.category.item.business.ItemService;
import edu.sp5.jvx330.cafe.category.item.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.category.item.domain.Item;
import edu.sp5.jvx330.cafe.command.OrderItemsCommand;

@Controller("main.index")
public class IndexController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private ItemSerivceImpl itemSerivceImpl;
	
	@GetMapping("main/index")
	public ModelAndView indexForm() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Category> category_list = categoryServiceImpl.findAllCategorys();
		List<Long> itemId_list; //itemId 받아오는 리스트
		for(Category category : category_list) {
			itemId_list.addAll(itemSerivceImpl.findItemIdByCategory(category));
		}
		
		List<Item>
		
		mav.addObject(itemId_list);
		mav.setViewName("main/index");
		
		return mav;
	}
	
	@PostMapping("main/index")
	public String index(@ModelAttribute List<OrderItemsCommand> orderItems_list) {
		
		return "main/index";
	}
}
