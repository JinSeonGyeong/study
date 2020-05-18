package kiosk.review;

import java.util.Scanner;

import kiosk.user.LoginMenu;


public class ReviewMenu {
	private ReviewService s;
	
	public ReviewMenu() {
		this.s = new ReviewServiceImp();
	}
	public void run(Scanner sc){
		boolean flag = true;
		int menu;
		String str = "1.글 쓰기 / 2.글 목록 / 3.사용자 검색 / 4.뒤로가기";
		while(flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				s.addReview(sc);
				break;
			case 2:
				s.getList();
				break;
			case 3:
				s.getByName(sc);
				break;
			case 4:
				flag = false;
				break;
			}
		}
	}
}
