package edu.sp5.jvx330.cafe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.category.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.category.domain.Category;
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
		//ī�װ�, ������ ����Ʈ �� ���
		Map<Category, List<Item>> ciMap = new HashMap<Category, List<Item>>();
		//ī�װ� ��ü ��ȸ
		List<Category> category_list = categoryServiceImpl.findAllCategorys();
		for(Category category : category_list) {
			//ī�װ� ������ ������ ����Ʈ ciMap�� �߰�
			ciMap.put(category, itemSerivceImpl.findItemsByCategory(category));
		}
		
		System.out.println("<key ���>(index) : "+ciMap.keySet());
		System.out.println("<value ���>(index) : "+ciMap.values());
		
		//mav.addObject(ciMap);
	
		String test = "test";
		mav.addObject(test);
		mav.setViewName("main/index");
		
		return mav;
	}
	
	@PostMapping("main/index")
	public String index(@ModelAttribute List<OrderItemsCommand> orderItems_list) {
		
		return "main/index";
	}
}
