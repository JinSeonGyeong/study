package kiosk.restaurant;

import java.util.Scanner;

public interface StoreService {
	void addFood(Scanner sc);
	
	void editFood(Scanner sc);

	void delFood(Scanner sc);
	
	void getAll();
	
	void daySales();
	
	void monthSales();
}
