package edu.sp5.jvx330.cafe.category.item.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import edu.sp5.jvx330.cafe.config.ItemConfig;
import edu.sp5.jvx330.cafe.menu.dao.ItemDao;

@SpringJUnitConfig(classes = {ItemConfig.class})
public class ItemJdbcDaoTest {

	@Autowired
	private ItemDao dao;
	
	@Test
	public void findItemByItemNameTest() {
		assertTrue(dao.findItemByItemName("아메리카노").getItemName().equals("아메리카노"));
		
	}
}
