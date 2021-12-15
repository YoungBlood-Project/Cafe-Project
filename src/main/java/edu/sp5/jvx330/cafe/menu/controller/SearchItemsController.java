package edu.sp5.jvx330.cafe.menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.manager.domain.Manager;
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
	
	@GetMapping("/menu/searchItems")
	public ModelAndView SearchItemsGet(HttpServletRequest request, HttpSession session) {	
		Manager auth_manager = (Manager)session.getAttribute("manager");
		ModelAndView mav = new ModelAndView();
		
		//�����ڷα��� Ȯ��
		if(auth_manager == null) {
			session.setAttribute("requestPath", request.getServletPath());
			mav.setViewName("/manager/loginManager");
			return mav;
		}
		
		Map<Category, List<Item>> categoryItemMap = new HashMap<Category, List<Item>>();
		List<Category> category_list = categoryServiceImpl.findAllCategorys();
		for (Category category : category_list) {
			categoryItemMap.put(category, itemServiceImpl.findItemsByCategory(category));
		}
		
		mav.addObject("categoryItemMap", categoryItemMap);
		mav.setViewName("/menu/search_items");
		
		return mav;
	}
}
