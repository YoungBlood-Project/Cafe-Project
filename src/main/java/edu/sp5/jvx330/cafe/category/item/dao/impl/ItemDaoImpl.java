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
	 * 1. �����޴�
	 */
	// 1-1. �޴� �߰�
	@Override
	public void addMenu(Item item) {
		String sql = "INSERT INTO Item(categoryId, itemName, itemPrice)"
				+ " VALUES(?,?,?)";
		// System.out.println(menu);
		jdbcTemplate.update(sql, item.getCategory().getCategoryId(),
				item.getItemName(), item.getItemPrice());
	}

	// 1-2. �޴� ����
	// �޴� �̸� ����
	@Override
	public Item setMenuName(Item item, String itemName) {
		String sql = "UPDATE Menu SET menuName = ? WHERE menuName = ?";

		jdbcTemplate.update(sql, itemName, item.getItemName());

		// return���� void�� ���� Menu�� ���� ��������� ������ menuName�� argument�� �޴� �� �� �������� �Ŷ�� �Ǵ�
		item.setItemName(itemName);
		return item;
	}

	// �޴� ���� ����
	@Override
	public Item setMenuSales(Item item, Integer menuPrice) {
		String sql = "UPDATE Menu SET menuPrice = ? WHERE menuName = ?";

		jdbcTemplate.update(sql, menuPrice, item.getMenuName());

		item.setMenuPrice(menuPrice);
		return item;
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

		Item item = jdbcTemplate.queryForObject(sql, new ItemRowMapper(), menuName);
		return item.getMid();
	}

	// 2-2. ī�װ��� �޴� ��ȸ
	@Override
	public List<Item> findMidByCategory(String category) {
		String sql = "SELECT mid, category, menuName, menuPrice" + " FROM Menu WHERE category = ?";

		return jdbcTemplate.query(sql, new ItemRowMapper(), category);
	}

	// 2-3. �޴� �̸����� �޴� ��ȸ
	@Override
	public Item findMenuByMenuName(String menuName) {
		String sql = "SELECT mid, category, menuName, menuPrice" + " FROM Menu WHERE menuName = ?";

		return jdbcTemplate.queryForObject(sql, new ItemRowMapper(), menuName);
	}

	// 2-4. ��ü �޴� ��ȸ
	@Override
	public List<Item> findAllMenus() {
		String sql = "SELECT mid, category, menuName, menuPrice FROM Menu";
		return jdbcTemplate.query(sql, new ItemRowMapper());
	}

}
