package kiosk.review;

import java.util.Scanner;

public interface ReviewService {
	void addReview(Scanner sc);
	
	void getReview(Scanner sc);
	
	void getByName(Scanner sc);
	
	void getList();

	void editReview(Scanner sc);
	
	void delReview(Scanner sc);
}
