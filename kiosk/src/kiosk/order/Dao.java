package kiosk.order;

import java.util.ArrayList;

import kiosk.restaurant.Food;

public interface Dao {
	void listinsert(Food f);
	
	void insert(Order o);
	
	ArrayList<Order> selectByName(String name);
	
	Order selectByNum(int num);
	
	ArrayList<Order> selectAll();
	
	void update(Order m);
	
	void delete(int num);
	
	Food foodSelect(int num);
	
	ArrayList<Food> foodSelectAll();
	
	
}
