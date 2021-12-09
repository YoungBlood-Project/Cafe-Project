package edu.sp5.jvx330.cafe.item.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.item.dao.MenuDao;
import edu.sp5.jvx330.cafe.item.dao.MenuRowMapper;
import edu.sp5.jvx330.cafe.item.domain.Menu;

public class MenuDaoImpl implements MenuDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 1. �����޴�
	 */
	// 1-1. �޴� �߰�
	@Override
	public void addMenu(Menu menu) {
		String sql = "INSERT INTO Menu(category, menuName, menuPrice)" + " VALUES(?,?,?)";
		// System.out.println(menu);
		jdbcTemplate.update(sql, menu.getCategory(), menu.getMenuName(), menu.getMenuPrice());
	}

	// 1-2. �޴� ����
	// �޴� �̸� ����
	@Override
	public Menu setMenuName(Menu menu, String menuName) {
		String sql = "UPDATE Menu SET menuName = ? WHERE menuName = ?";

		jdbcTemplate.update(sql, menuName, menu.getMenuName());

		// return���� void�� ���� Menu�� ���� ��������� ������ menuName�� argument�� �޴� �� �� �������� �Ŷ�� �Ǵ�
		menu.setMenuName(menuName);
		return menu;
	}

	// �޴� ���� ����
	@Override
	public Menu setMenuSales(Menu menu, Integer menuPrice) {
		String sql = "UPDATE Menu SET menuPrice = ? WHERE menuName = ?";

		jdbcTemplate.update(sql, menuPrice, menu.getMenuName());

		menu.setMenuPrice(menuPrice);
		return menu;
	}

	// 1-3 �޴� ����
	@Override
	public void deleteMenu(String menuName) {
		String sql = "DELETE FROM Menu WHERE menuName = ?";

		jdbcTemplate.update(sql, menuName);
	}

	/**
	 * 2. �޴� ��ȸ
	 */
	// 2-1. �޴� id ��ȸ
	// SalesHistoryServiceImpl���� ���
	@Override
	public Long findMidByMenu(String menuName) {
		// �޴� �̸��� �ߺ����� �ʴ´ٴ� ����
		String sql = "SELECT mid, category, menuName, menuPrice" + " FROM Menu WHERE menuName = ?";

		Menu menu = jdbcTemplate.queryForObject(sql, new MenuRowMapper(), menuName);
		return menu.getMid();
	}

	// 2-2. ī�װ��� �޴� ��ȸ
	@Override
	public List<Menu> findMidByCategory(String category) {
		String sql = "SELECT mid, category, menuName, menuPrice" + " FROM Menu WHERE category = ?";

		return jdbcTemplate.query(sql, new MenuRowMapper(), category);
	}

	// 2-3. �޴� �̸����� �޴� ��ȸ
	@Override
	public Menu findMenuByMenuName(String menuName) {
		String sql = "SELECT mid, category, menuName, menuPrice" + " FROM Menu WHERE menuName = ?";

		return jdbcTemplate.queryForObject(sql, new MenuRowMapper(), menuName);
	}

	// 2-4. ��ü �޴� ��ȸ
	@Override
	public List<Menu> findAllMenus() {
		String sql = "SELECT mid, category, menuName, menuPrice FROM Menu";
		return jdbcTemplate.query(sql, new MenuRowMapper());
	}

}
