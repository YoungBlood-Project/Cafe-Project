package edu.sp5.jvx330.cafe.sales.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	
	@PostMapping("/sales/daySalesTotalPrice")
	public ModelAndView daySalesTotalPost(String year, String month, String date) throws ParseException {
		
		ModelAndView mav = new ModelAndView();
		
		String dayString = year+"년 "+month+"월 "+date+"일";
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date dateSales = sf.parse(dayString);
	
		List<SalesHistory> salesHistory_list = salesHistoryServiceImpl.findSalesHistoryByOrderDate(dateSales);
		
		MenuSalesHistoryCommand salesHistoryCommand = new MenuSalesHistoryCommand();
		
		
		// command.setCategoryName();
		// command.setMenuName();
		// command.setOrderNum();
		// command.setPaidPrice();
		
		mav.addObject("salesHistory_list", salesHistory_list);
		mav.setViewName("sales/day_salesTotalPrice");
		return mav;
	}
}
