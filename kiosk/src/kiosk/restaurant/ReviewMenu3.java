package kiosk.restaurant;

import java.util.Scanner;

import kiosk.review.ReviewService;
import kiosk.review.ReviewServiceImp;

public class ReviewMenu3 {
	private ReviewService s;
	private StoreMenu sm;
	
	public ReviewMenu3() {
		this.s = new ReviewServiceImp();
		this.sm = new StoreMenu();
	}

	public void run(Scanner sc) {
		boolean flag = true;
		int menu;
		while (flag) {
			s.getList();
			menu = sc.nextInt();
			System.out.println("1. ��ȣ�� ���� / 2. �ڷΰ��� ");
			switch(menu){
				case 1:
					s.getReview(sc);
					break;
				case 2:
					sm.run(sc);			
			}
		}
	}
}
