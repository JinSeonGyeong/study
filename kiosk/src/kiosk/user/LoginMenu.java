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
		int user = s.login(sc); // 1�̸� �Ϲ����� 2�� ������ �׿ܴ� �α��ν��з� �ٽ� �ʱ�ȭ������
		switch(user) {
			case 1:
				String str = "1. �ֹ� / 2. �ı��ۼ� / 3. ȸ������ ���� / 4. �α׾ƿ�";
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
