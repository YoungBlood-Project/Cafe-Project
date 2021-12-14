package edu.sp5.jvx330.cafe.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.command.OrderItemsCommand;
import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

//@SessionAttributes(names = {"salesTotalPrice", "orderItemsCommand"}) //�ȵǸ� values�� �ٲٱ�
@SessionAttributes("orderContainer")
@Controller("controller.indexController")
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
	
		mav.addObject("ciMap", ciMap);
		mav.setViewName("main/index");
		
		return mav;
	}
	
	@PostMapping("main/index")
	public String index(@ModelAttribute("orderContainer") OrderContainer orderContainer) {
		System.out.println("index(post) �Ǹų��� : "+orderContainer);

		return "/membership/login_user";
	}
	/*public String index(@ModelAttribute OrderItemsCommand orderItemsCommand, 
			@ModelAttribute SalesTotalPrice salesTotalPrice) {
		System.out.println("index(post) �Ǹų��� : "+orderItemsCommand);
		System.out.println("stp : "+salesTotalPrice);

		return "/jvx330/membership/login_user";
	}*/
}