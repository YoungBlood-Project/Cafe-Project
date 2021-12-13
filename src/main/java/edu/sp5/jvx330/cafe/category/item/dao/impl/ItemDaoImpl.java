package edu.sp5.jvx330.cafe.category.item.dao.impl;

import java.net.CookieManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.sp5.jvx330.cafe.category.domain.Category;
import edu.sp5.jvx330.cafe.category.item.dao.ItemDao;
import edu.sp5.jvx330.cafe.category.item.dao.ItemRowMapper;
import edu.sp5.jvx330.cafe.category.item.domain.Item;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 1. 관리메뉴
	 */
	// 1-1. 메뉴 추가
	@Override
	public void addItem(Item item) {
		//이미지 경로 있는 경우
		if(item.getItemUrl()!=null) {
			String sql = "INSERT INTO Item(categoryId, itemName, itemPrice, itemUrl)"
					+ " VALUES(?,?,?,?)";
			// System.out.println(menu);
			jdbcTemplate.update(sql, item.getCategory().getCategoryId(),
					item.getItemName(), item.getItemPrice(), item.getItemUrl());
		}
		//이미지 경로 없는 경우
		else { 
			String sql = "INSERT INTO Item(categoryId, itemName, itemPrice)"
					+ " VALUES(?,?,?)";
			// System.out.println(menu);
			jdbcTemplate.update(sql, item.getCategory().getCategoryId(),
					item.getItemName(), item.getItemPrice());
		}

	}

	// 1-2. 메뉴 수정
	// 메뉴 이름 수정
	@Override
	public Item setItemName(Item item, String itemName) {
		String sql = "UPDATE Item SET itemName = ? WHERE itemName = ?";

		jdbcTemplate.update(sql, itemName, item.getItemName());

		// return값을 void로 할지 Menu로 할지 고민했지만 변경할 menuName을 argument로 받는 게 더 직관적일 거라고 판단
		item.setItemName(itemName);
		return item;
	}

	// 메뉴 가격 수정
	@Override
	public Item setItemPrice(Item item, Integer itemPrice) {
		String sql = "UPDATE Item SET itemPrice = ? WHERE itemName = ?";

		jdbcTemplate.update(sql, itemPrice, item.getItemName());

		item.setItemPrice(itemPrice);
		return item;
	}

	// 1-3 메뉴 삭제
	@Override
	public void deleteItem(String itemName) {
		String sql = "DELETE FROM Item WHERE itemName = ?";

		jdbcTemplate.update(sql, itemName);
	}

	/**
	 * 2. 메뉴 조회
	 */
	// 2-1. 메뉴 id 조회
	// SalesHistoryServiceImpl에서 사용
	@Override
	public Long findItemIdByItemName(String itemName) {
		// 메뉴 이름은 중복되지 않는다는 가정
		String sql = "SELECT itemId, categoryId, itemName, itemPrice, itemUrl, regDate" 
				+ " FROM Item WHERE itemName = ?";

		Item item = jdbcTemplate.queryForObject(sql, new ItemRowMapper(), itemName);
		return item.getItemId();
	}

	// 2-2. 카테고리별 메뉴 조회
	@Override
	public List<Item> findItemsByCategory(Category category) {
		String sql = "SELECT itemId, categoryId, itemName, itemPrice, itemUrl, regDate" 
				+ " FROM Item WHERE categoryId = ?";

		return jdbcTemplate.query(sql, new ItemRowMapper(), category.getCategoryId());
	}

	// 2-3. 메뉴 이름으로 메뉴 조회
	@Override
	public Item findItemByItemName(String itemName) {
		String sql ="SELECT itemId, categoryId, itemName, itemPrice, itemUrl, regDate" 
				+ " FROM Item WHERE itemName = ?";

		return jdbcTemplate.queryForObject(sql, new ItemRowMapper(), itemName);
	}

	// 2-4. 전체 메뉴 조회
	@Override
	public List<Item> findAllItems() {
		String sql = "SELECT itemId, categoryId, itemName, itemPrice, itemUrl, regDate FROM Item";
	
		return jdbcTemplate.query(sql, new ItemRowMapper());
	}

}
