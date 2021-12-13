package edu.sp5.jvx330.cafe.menu.dao.impl;

import java.net.CookieManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.menu.dao.ItemDao;
import edu.sp5.jvx330.cafe.menu.dao.ItemRowMapper;
import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;

public class ItemDaoImpl implements ItemDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 1. �����޴�
	 */
	// 1-1. �޴� �߰�
	@Override
	public void addItem(Item item) {
		//�̹��� ��� �ִ� ���
		if(item.getItemUrl()!=null) {
			String sql = "INSERT INTO Item(categoryId, itemName, itemPrice, itemUrl)"
					+ " VALUES(?,?,?,?)";
			// System.out.println(menu);
			jdbcTemplate.update(sql, item.getCategory().getCategoryId(),
					item.getItemName(), item.getItemPrice(), item.getItemUrl());
		}
		//�̹��� ��� ���� ���
		else { 
			String sql = "INSERT INTO Item(categoryId, itemName, itemPrice)"
					+ " VALUES(?,?,?)";
			// System.out.println(menu);
			jdbcTemplate.update(sql, item.getCategory().getCategoryId(),
					item.getItemName(), item.getItemPrice());
		}

	}

	// 1-2. �޴� ����
	// �޴� �̸� ����
	@Override
	public Item setItemName(Item item, String itemName) {
		String sql = "UPDATE Item SET itemName = ? WHERE itemName = ?";

		jdbcTemplate.update(sql, itemName, item.getItemName());

		// return���� void�� ���� Menu�� ���� ��������� ������ menuName�� argument�� �޴� �� �� �������� �Ŷ�� �Ǵ�
		item.setItemName(itemName);
		return item;
	}

	// �޴� ���� ����
	@Override
	public Item setItemPrice(Item item, Integer itemPrice) {
		String sql = "UPDATE Item SET itemPrice = ? WHERE itemName = ?";

		jdbcTemplate.update(sql, itemPrice, item.getItemName());

		item.setItemPrice(itemPrice);
		return item;
	}

	// 1-3 �޴� ����
	@Override
	public void deleteItem(String itemName) {
		String sql = "DELETE FROM Item WHERE itemName = ?";

		jdbcTemplate.update(sql, itemName);
	}

	/**
	 * 2. �޴� ��ȸ
	 */
	// 2-1. �޴� id ��ȸ
	// SalesHistoryServiceImpl���� ���
	@Override
	public Long findItemIdByItemName(String itemName) {
		// �޴� �̸��� �ߺ����� �ʴ´ٴ� ����
		String sql = "SELECT itemId, categoryId, itemName, itemPrice, itemUrl, regDate" 
				+ " FROM Item WHERE itemName = ?";

		Item item = jdbcTemplate.queryForObject(sql, new ItemRowMapper(), itemName);
		return item.getItemId();
	}

	// 2-2. ī�װ��� �޴� ��ȸ
	@Override
	public List<Item> findItemsByCategory(Category category) {
		String sql = "SELECT itemId, categoryId, itemName, itemPrice, itemUrl, regDate" 
				+ " FROM Item WHERE categoryId = ?";

		return jdbcTemplate.query(sql, new ItemRowMapper(), category.getCategoryId());
	}

	// 2-3. �޴� �̸����� �޴� ��ȸ
	@Override
	public Item findItemByItemName(String itemName) {
		String sql ="SELECT itemId, categoryId, itemName, itemPrice, itemUrl, regDate" 
				+ " FROM Item WHERE itemName = ?";

		return jdbcTemplate.queryForObject(sql, new ItemRowMapper(), itemName);
	}

	// 2-4. ��ü �޴� ��ȸ
	@Override
	public List<Item> findAllItems() {
		String sql = "SELECT itemId, categoryId, itemName, itemPrice, itemUrl, regDate FROM Item";
	
		return jdbcTemplate.query(sql, new ItemRowMapper());
	}

}
