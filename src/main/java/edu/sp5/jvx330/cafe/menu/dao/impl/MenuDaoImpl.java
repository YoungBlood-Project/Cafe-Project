package edu.sp5.jvx330.cafe.menu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.menu.dao.MenuDao;
import edu.sp5.jvx330.cafe.menu.dao.MenuRowMapper;
import edu.sp5.jvx330.cafe.menu.domain.Menu;

public class MenuDaoImpl implements MenuDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 1. 관리메뉴
	 */
	// 1-1. 메뉴 추가
	@Override
	public void addMenu(Menu menu) {
		String sql = "INSERT INTO Menu(category, menuName, menuPrice)" + " VALUES(?,?,?)";
		// System.out.println(menu);
		jdbcTemplate.update(sql, menu.getCategory(), menu.getMenuName(), menu.getMenuPrice());
	}

	// 1-2. 메뉴 수정
	// 메뉴 이름 수정
	@Override
	public Menu setMenuName(Menu menu, String menuName) {
		String sql = "UPDATE Menu SET menuName = ? WHERE menuName = ?";

		jdbcTemplate.update(sql, menuName, menu.getMenuName());

		// return값을 void로 할지 Menu로 할지 고민했지만 변경할 menuName을 argument로 받는 게 더 직관적일 거라고 판단
		menu.setMenuName(menuName);
		return menu;
	}

	// 메뉴 가격 수정
	@Override
	public Menu setMenuSales(Menu menu, Integer menuPrice) {
		String sql = "UPDATE Menu SET menuPrice = ? WHERE menuName = ?";

		jdbcTemplate.update(sql, menuPrice, menu.getMenuName());

		menu.setMenuPrice(menuPrice);
		return menu;
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

		Menu menu = jdbcTemplate.queryForObject(sql, new MenuRowMapper(), menuName);
		return menu.getMid();
	}

	// 2-2. 카테고리별 메뉴 조회
	@Override
	public List<Menu> findMidByCategory(String category) {
		String sql = "SELECT mid, category, menuName, menuPrice" + " FROM Menu WHERE category = ?";

		return jdbcTemplate.query(sql, new MenuRowMapper(), category);
	}

	// 2-3. 메뉴 이름으로 메뉴 조회
	@Override
	public Menu findMenuByMenuName(String menuName) {
		String sql = "SELECT mid, category, menuName, menuPrice" + " FROM Menu WHERE menuName = ?";

		return jdbcTemplate.queryForObject(sql, new MenuRowMapper(), menuName);
	}

	// 2-4. 전체 메뉴 조회
	@Override
	public List<Menu> findAllMenus() {
		String sql = "SELECT mid, category, menuName, menuPrice FROM Menu";
		return jdbcTemplate.query(sql, new MenuRowMapper());
	}

}
