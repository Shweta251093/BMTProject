package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.Menu;
import com.nttdata.pune.training.bookmytable.repository.MenuDAO;
import com.nttdata.pune.training.bookmytable.util.MenuAttributesRowMapper;
import com.nttdata.pune.training.bookmytable.util.MenuDisplayRowMapper;
import com.nttdata.pune.training.bookmytable.util.MenuRowMapper;

@Repository
public class MenuDAOImpl implements MenuDAO {
	@Autowired
	private JdbcTemplate dbTemplate;

	@Override
	public int insert(Menu menu,String hotel_id) {
		// Insert query to insert new menu
		System.out.println("Before Query");
		
		System.out.println("Hotel Id:" +hotel_id);
		dbTemplate
				.update("insert into menu(hotel_id,menu_id,food_name,rate,veg,category) values(?,?,?,?,?,?)",
						new Object[] {hotel_id, menu.getMenu_id(),
								menu.getFood_name(), menu.getRate(),
								menu.getVeg(), menu.getCategory() });
		System.out.println("Insert Successfull");
		return 0;
	}

	/*@Override
	public int updateMenu(Menu menu) {
		// Update query to Update menu rate
		System.out.println("Before Update Query");

		dbTemplate.update(
				"update menu SET rate=? WHERE hotel_id=? and menu_id=?",
				new Object[] { menu.getRate(), menu.getHotel_id(),
						menu.getMenu_id() });
		System.out.println("Update Successfull");
		return 0;
	}*/

	@Override
	public List<Menu> displayAllMenuToValidate() {
		// TODO Auto-generated method stub
        //display menu table
		List<Menu> listOfMenuData = dbTemplate
				.query("select menu_id,hotel_id,food_name,rate,veg,category from menu ",
						new MenuRowMapper());

		return listOfMenuData;

	}

	@Override
	public List<Menu> displayAllMenu(String hotel_id) {
		// TODO Auto-generated method stub
         //display menu_id,hotel_id,food_name,rate,veg,category of selected hotel
		System.out.println(hotel_id);
		List<Menu> listOfMenu = dbTemplate
				.query("select menu_id,hotel_id,food_name,rate,veg,category from menu where hotel_id=?",
						new Object[] { hotel_id }, new MenuRowMapper());

		return listOfMenu;

	}

	/*@Override
	public int deleteMenu(String hotelId, String menuId) {
		// Delete query to delete existing menu
		System.out.println("Before Delete Query");
		int del = dbTemplate.update(
				"delete from menu where hotel_id=? and menu_id=?",
				new Object[] { (hotelId), (menuId) });
		System.out.println("Delete Successfull");
		return del;
	}*/

	@Override
	public List<Menu> displayMenu(String hotel_id) {
		// TODO Auto-generated method stub
	
		List<Menu> listOfMenu = dbTemplate
				.query("select menu_id,food_name,rate,veg,category from menu where hotel_id=?",new Object[]{hotel_id},
						new MenuDisplayRowMapper());

		return listOfMenu;
	}

	@Override
	public int updateNewMenu(String hotel_id, String menu_id, String rate) {
		
		dbTemplate.update("update menu SET rate=? WHERE hotel_id=? and menu_id=?", new Object[]{rate,hotel_id,menu_id});
		return 0;
		}
		// TODO Auto-generated method stub

	@Override
	public List<Menu> displayAllMenu() {
		// TODO Auto-generated method stub
		 //display menu table
		List<Menu> listOfMenu = dbTemplate
				.query("select menu_id,hotel_id,food_name,rate,veg,category from menu ",
						new MenuRowMapper());

		return listOfMenu;
		
	}

	/*@Override
	public List<Menu> getMenuData(Menu menu, String menuId, String foodName) {
		System.out.println("before Menu query");
		List<Menu> menuData = dbTemplate.query("select menu_id,food_name from menu where menu_id=? and food_name=?",new Object[]{menuId, foodName } , new MenuAttributesRowMapper());
		System.out.println("After menu query");
		// TODO Auto-generated method stub
		return menuData;
	}*/

	@Override
	public List<Menu> getMenuData(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getMenuData(String hotel_id,String menuId, String foodName) {
		// TODO Auto-generated method stub
		System.out.println("before Menu query");
		System.out.println("Menu Id:"+menuId+"Food Name:"+foodName);
		List<Menu> menuData = dbTemplate.query("select menu_id,food_name from menu where hotel_id=? and (menu_id=? or food_name=?)",new Object[]{hotel_id,menuId, foodName } , new MenuAttributesRowMapper());
		System.out.println("After menu query");
		
		return menuData;
		
	}

	@Override
	public int updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return 0;
	}
		
		
	}


