package edu.sp5.jvx330.cafe.category.item.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.category.item.dao.ItemDao;
import edu.sp5.jvx330.cafe.category.item.domain.Item;


public class ItemDaoImpl implements ItemDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 1. 관리메뉴
	 */
	// 1-1. 메뉴 추가
	@Override
	public void addMenu(Item item) {
		String sql = "INSERT INTO Item(categoryId, itemName, itemPrice)"
				+ " VALUES(?,?,?)";
		// System.out.println(menu);
		jdbcTemplate.update(sql, item.getCategory().getCategoryId(),
				item.getItemName(), item.getItemPrice());
	}

	// 1-2. 메뉴 수정
	// 메뉴 이름 수정
	@Override
	public Item setMenuName(Item item, String itemName) {
		String sql = "UPDATE Menu SET menuName = ? WHERE menuName = ?";

		jdbcTemplate.update(sql, itemName, item.getItemName());

		// return값을 void로 할지 Menu로 할지 고민했지만 변경할 menuName을 argument로 받는 게 더 직관적일 거라고 판단
		item.setItemName(itemName);
		return item;
	}

	// 메뉴 가격 수정
	@Override
	public Item setMenuSales(Item item, Integer menuPrice) {
		String sql = "UPDATE Menu SET menuPrice = ? WHERE menuName = ?";

		jdbcTemplate.update(sql, menuPrice, item.getMenuName());

		item.setMenuPrice(menuPrice);
		return item;
	}

	// 1-3 메뉴 삭제
	@Override
	public void deleteMenu(String menuName) {
		String sql = "DELETE FROM Menu WHERE menuName = ?";

		jdbcTemplate.update(sql, menuName);
	}

	/**
	 * 2. 메뉴 조회
	 */
	// 2-1. 메뉴 id 조회
	// SalesHistoryServiceImpl에서 사용
	@Override
	public Long findMidByMenu(String menuName) {
		// 메뉴 이름은 중복되지 않는다는 가정
		String sql = "SELECT mid, category, menuName, menuPrice" + " FROM Menu WHERE menuName = ?";

		Item item = jdbcTemplate.queryForObject(sql, new ItemRowMapper(), menuName);
		return item.getMid();
	}

	// 2-2. 카테고리별 메뉴 조회
	@Override
	public List<Item> findMidByCategory(String category) {
		String sql = "SELECT mid, category, menuName, menuPrice" + " FROM Menu WHERE category = ?";

		return jdbcTemplate.query(sql, new ItemRowMapper(), category);
	}

	// 2-3. 메뉴 이름으로 메뉴 조회
	@Override
	public Item findMenuByMenuName(String menuName) {
		String sql = "SELECT mid, category, menuName, menuPrice" + " FROM Menu WHERE menuName = ?";

		return jdbcTemplate.queryForObject(sql, new ItemRowMapper(), menuName);
	}

	// 2-4. 전체 메뉴 조회
	@Override
	public List<Item> findAllMenus() {
		String sql = "SELECT mid, category, menuName, menuPrice FROM Menu";
		return jdbcTemplate.query(sql, new ItemRowMapper());
	}

}
