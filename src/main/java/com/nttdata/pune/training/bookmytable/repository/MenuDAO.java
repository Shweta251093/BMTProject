package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.Menu;

public interface MenuDAO {
public int insert(Menu menu, String hotel_id);
List<Menu> displayAllMenu();
List<Menu> displayAllMenu(String hotel_id);

//int deleteMenu(String hotelId, String menuId);
int updateMenu(Menu menu);
public List<Menu> displayMenu(String hotel_id);
public int updateNewMenu(String hotel_id, String menu_id, String rate);
List<Menu> displayAllMenuToValidate();
public List<Menu> getMenuData(Menu menu);
//List<Menu> getMenuData(Menu menu, String menuId, String foodName);
//public List<Menu> getMenuData(String menuId, String foodName);
List<Menu> getMenuData(String hotel_id, String menuId, String foodName);


}
