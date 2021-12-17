package edu.sp5.jvx330.cafe.menu.controller;

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

@Controller("setItemsController")
public class SetItemsController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@Autowired
	private ItemSerivceImpl itemServiceImpl;

	@GetMapping("/menu/setItems")
	public ModelAndView setItemsGet() {
		ModelAndView mav = new ModelAndView();

		Map<Category, List<Item>> ciMap = new HashMap<Category, List<Item>>();
		List<Category> category_list = categoryServiceImpl.findAllCategorys();
		for (Category category : category_list) {
			if (!category.getCategoryName().equals("deletedMenu")) {
				ciMap.put(category, itemServiceImpl.findItemsByCategory(category));
			}
		}

		mav.addObject("ciMap", ciMap);
		mav.setViewName("menu/set_items");

		return mav;
	}

	@PostMapping("/menu/setItems")
	public ModelAndView setItemsPost(String itemName, String newItemName) {
		ModelAndView mav = new ModelAndView();

		Item item = itemServiceImpl.findItemByItemName(itemName);
		itemServiceImpl.setItemName(item, newItemName);

		mav.setViewName("menu/search_items");
		return mav;
	}
}
