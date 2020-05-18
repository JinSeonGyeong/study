package kiosk.restaurant;

import java.util.Scanner;

import kiosk.review.ReviewService;
import kiosk.review.ReviewServiceImp;

public class StoreMenu {
	private StoreService s;
	private ReviewService rs;

	public StoreMenu() {
		this.s = new StoreServiceImp();
		this.rs = new ReviewServiceImp();
	}
	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		String str = "1.�޴��߰� 2.�޴����� 3.�޴����� 4.�޴���� 5.�Ϸ� ���� 6.�Ѵ� ���� 7.�ı�� ��� 8.����";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				s.addFood(sc);
				break;
			case 2:
				s.editFood(sc);
				break;
			case 3:
				s.delFood(sc);
				break;
			case 4:
				s.getAll();
				break;
			case 5:
				s.daySales();
				break;
			case 6:
				s.monthSales();
				break;
			case 7 :
				rs.getList();
				break;
			case 8:
				flag = false;
				break;
			}
		}
	}
}
