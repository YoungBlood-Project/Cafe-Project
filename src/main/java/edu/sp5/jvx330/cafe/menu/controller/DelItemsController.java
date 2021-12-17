package edu.sp5.jvx330.cafe.menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@Controller
public class DelItemsController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@Autowired
	private ItemSerivceImpl itemServiceImpl;

	@GetMapping("/menu/delItems")
	public ModelAndView delItemsGet() {
		ModelAndView mav = new ModelAndView();

		Map<Category, List<Item>> ciMap = new HashMap<Category, List<Item>>();
		List<Category> category_list = categoryServiceImpl.findAllCategorys();
		for (Category category : category_list) {
			if (!category.getCategoryName().equals("deletedMenu")) {
				ciMap.put(category, itemServiceImpl.findItemsByCategory(category));
			}
		}

		mav.addObject("ciMap", ciMap);
		
		//System.out.println(ciMap);
		//System.out.println("setItemsController : "+ciMap.keySet());
		//System.out.println("setItemsController : "+ciMap.values());
		mav.setViewName("menu/del_items");

		return mav;
	}

	@Transactional
	@PostMapping("/menu/delItems")
	public ModelAndView delItemsPost(String itemName) {
		ModelAndView mav = new ModelAndView();

		//System.out.println("삭제할 아이템 이름 : "+itemName);

		
		Item item = itemServiceImpl.findItemByItemName(itemName);
		//System.out.println("삭제할 아이템 : "+item);
		itemServiceImpl.deleteItem(item);
		
		System.out.println("아이템 삭제 완료");

		//get으로 이동해야 해서 경로 변경 - 초
		mav.setViewName("redirect:/menu/searchItems");
		return mav;
	}

}
