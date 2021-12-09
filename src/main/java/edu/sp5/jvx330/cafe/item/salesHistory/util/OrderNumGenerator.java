package edu.sp5.jvx330.cafe.item.salesHistory.util;

import java.text.SimpleDateFormat;
import java.util.Date;

//test(초원)
public class OrderNumGenerator {
	
	private static OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
	private static long orderNum;
	
	
	private OrderNumGenerator() {
		orderNum  = startOrderNum();
	}

	/**
	 * 1. 주문 번호 카운트
	 */
	public static long countOrderNum() {
		orderNum++;
		return orderNum;
	};
	
	/**
	 * 2. 오늘의 주문 번호 생성
	 */
	private static long startOrderNum() {
		//(1)오늘의 날짜
		Date todayDate = new Date();
		
		//(2)날짜형식 변환
		SimpleDateFormat todayFormat = new SimpleDateFormat("yyyyMMdd");

		String stringToday = todayFormat.format(todayDate);
		
		return Long.parseLong(stringToday)*10000;
	}
	
	public static void main(String[] args) {
		
		System.out.println(OrderNumGenerator.countOrderNum());
		System.out.println(OrderNumGenerator.countOrderNum());
		
		
	}
	
	
}
