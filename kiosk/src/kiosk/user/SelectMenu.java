package kiosk.user;

import java.util.Scanner;

public class SelectMenu {
	private LoginService s;
	private LoginMenu lm;
	
	public SelectMenu() {
		this.s = new LoginServiceImpl();
		this.lm = new LoginMenu();
	}
	public void run(Scanner sc) {
		boolean flag = true;
		int menu;
		String str = "1. 연락처로 검색 / 2. 아이디로 검색 / 3. 뒤로가기";
		while(flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch(menu){
			case 1:
				s.getByTel(sc);
				break;
			case 2:
				s.getUser(sc);
				break;
			case 3:
				lm.run(sc);
				flag = false;
				break;
			}
		}
	}
}
