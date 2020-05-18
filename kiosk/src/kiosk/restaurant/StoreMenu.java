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
		String str = "1.메뉴추가 2.메뉴수정 3.메뉴삭제 4.메뉴목록 5.하루 매출 6.한달 매출 7.후기글 목록 8.종료";
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
