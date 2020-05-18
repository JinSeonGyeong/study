package kiosk.user;

import java.util.Scanner;

import kiosk.main.Menu;
import kiosk.order.OrderMenu;
import kiosk.review.ReviewMenu;

public class LoginMenu {
	private LoginService s;
	private ReviewMenu r;
	private OrderMenu o;
	private SelectMenu sm;
	private Menu Menu;
	
	public LoginMenu() {
		this.s = new LoginServiceImpl();
		this.r = new ReviewMenu();
		this.o = new OrderMenu();
		this.sm = new SelectMenu();
		this.Menu = new Menu();
	}
	public void run(Scanner sc) {
		boolean flag = true;
		int menu;
		int user = s.login(sc); // 1이면 일반유저 2면 관리자 그외는 로그인실패로 다시 초기화면으로
		switch(user) {
			case 1:
				String str = "1. 주문 / 2. 후기작성 / 3. 회원정보 수정 / 4. 로그아웃";
				while(flag) {
					System.out.println(str);
					menu = sc.nextInt();
					switch (menu) {
					case 1:
						o.run(sc);
						break;
					case 2:
						r.run(sc);
						break;
					case 3:
						sm.run(sc);
						break;
					case 4:
						Menu.run();
						break;
					}
				}
				break;
			case 2:
				Menu.run();
				break;
			default :
				break;
		}
	}
	
	public void register(Scanner sc) {
		s.addUser(sc);
	}
	
	public void search(Scanner sc) {
		s.getUser(sc);
		s.getByTel(sc);
		
	}
}
