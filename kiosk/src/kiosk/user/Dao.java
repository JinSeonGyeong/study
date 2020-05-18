package kiosk.user;

import java.util.ArrayList;

public interface Dao {
	void insert(User c);
	
	ArrayList<User> selectByID(String id);
	
	User selectByTel(String tel);
	
	ArrayList<User> selectAllList();
	
	void update(User c);
	
	void delete(String id);
}
