package edu.sp5.jvx330.cafe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import edu.sp5.jvx330.cafe.command.OrderItemsCommand;

@Controller("main.index")
public class IndexController {
	@GetMapping("main/index")
	public String indexForm() {
		return "main/index";
	}
	
	@PostMapping("main/index")
	public String index(@ModelAttribute List<OrderItemsCommand> orderItems_list) {
		//�ŷ����� �ҷ�����...? AJAX �Ƚᵵ ������
		return "main/index";
	}
}
