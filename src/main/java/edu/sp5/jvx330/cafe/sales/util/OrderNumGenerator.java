package edu.sp5.jvx330.cafe.sales.util;

import java.text.SimpleDateFormat;
import java.util.Date;

//test(�ʿ�)
public class OrderNumGenerator {
	
	private static OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
	private static long orderNum;
	
	
	private OrderNumGenerator() {
		orderNum  = startOrderNum();
	}

	/**
	 * 1. �ֹ� ��ȣ ī��Ʈ
	 */
	public static long countOrderNum() {
		orderNum++;
		return orderNum;
	};
	
	/**
	 * 2. ������ �ֹ� ��ȣ ����
	 */
	private static long startOrderNum() {
		//(1)������ ��¥
		Date todayDate = new Date();
		
		//(2)��¥���� ��ȯ
		SimpleDateFormat todayFormat = new SimpleDateFormat("yyyyMMdd");

		String stringToday = todayFormat.format(todayDate);
		
		return Long.parseLong(stringToday)*10000;
	}
	
	public static void main(String[] args) {
		System.out.println(OrderNumGenerator.countOrderNum());
		System.out.println(OrderNumGenerator.countOrderNum());
	}
	
	
}
