package kiosk.main;


import java.util.Scanner;

import kiosk.user.LoginMenu;


public class Menu {
	private LoginMenu loginMenu;
	private Scanner scan;
	
	public Menu() {
		this.scan = new Scanner(System.in);
		this.loginMenu = new LoginMenu();
	}
	public void run() {
		int menu;
		boolean flag = true;
		while(flag) {
			System.out.println("----------------------------------------");
			System.out.println("1. �α���");
			System.out.println("2. ȸ������");
			System.out.println("3. ȸ������ ã��");
			System.out.println("4. ����");
			System.out.println("----------------------------------------");
			System.out.print("input : ");
			menu = scan.nextInt();
			switch(menu) {
				case 1: 
					loginMenu.run(scan);
					break;
				case 2:
					loginMenu.register(scan);
					break;
				case 3:
					loginMenu.search(scan);
					break;
				case 4:
					flag = false;
					break;
			}
		}
	}
}
