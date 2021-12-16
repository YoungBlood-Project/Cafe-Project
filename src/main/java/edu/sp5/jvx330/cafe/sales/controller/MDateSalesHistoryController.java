package edu.sp5.jvx330.cafe.sales.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import edu.sp5.jvx330.cafe.sales.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.sales.command.MenuSalesHistoryCommand;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;

@Controller
public class MDateSalesHistoryController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private ItemSerivceImpl itemServiceImpl;
	@Autowired
	private SalesHistoryServiceImpl salesHistoryServiceImpl;
	
	@GetMapping("/sales/mDateSalesHistory")
	public ModelAndView mDateSalesHistoryPost(String year, String month, String day) throws ParseException {
		
		ModelAndView mav = new ModelAndView();
		
		String dayString = year+"�� "+month+"�� "+day+"��";
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy�� MM�� dd��");
		Date dateSales = sf.parse(dayString);
	
		//List<MenuSalesHistoryCommand> msh_command_list = new ArrayList<MenuSalesHistoryCommand>();
		//List<SalesHistory> salesHistory_list = salesHistoryServiceImpl.findSalesHistoryByOrderDate(dateSales);
	
		//for (SalesHistory salesHistory : salesHistory_list) {
		//	Item item = itemServiceImpl.findItemByItemId(salesHistory.getItem().getItemId());
		//	Category category = categoryServiceImpl.findCategoryByCategoryId(item.getCategory().getCategoryId());
		//	msh_command_list.add(new MenuSalesHistoryCommand(category.getCategoryName(), item.getItemName(), ));	
		//}
		
		// ��� ī�װ� �ҷ�����
		Map<Category, List<Item>> ciMap = new HashMap<Category, List<Item>>();
		List<Category> category_list = categoryServiceImpl.findAllCategorys();
		for(Category category : category_list) {
			ciMap.put(category, itemServiceImpl.findItemsByCategory(category));
		}
		
		// ������ ���̵�� ��¥�� saleshistory�� �˻��ϴ� �޼ҵ�
		// List<salesHistory> salesHistory_list = findSHByItemIdAndOrderDate(Item id, dateSales);
		// Item id���� map�� �����
	
		mav.setViewName("sales/m_date_salesHistory");
		return mav;
	}
}
