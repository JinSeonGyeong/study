package kiosk.user;

import java.util.Scanner;

public interface LoginService {
	void addUser(Scanner sc);
	
	void getUser(Scanner sc);
	
	void getByTel(Scanner sc);
	
	void getList();

	void editUser(Scanner sc);
	
	void delUser(Scanner sc);
	
	int login(Scanner sc);
}
