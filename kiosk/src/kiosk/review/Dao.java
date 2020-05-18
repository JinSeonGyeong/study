package kiosk.review;

import java.util.ArrayList;

public interface Dao {
	void insert(Review r);
	
	ArrayList<Review> selectByName(String name);
	
	Review selectByNum(int num);
	
	ArrayList<Review> selectAllList();
	
	void update(Review r);
	
	void delete(int num);
}
