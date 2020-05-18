package kiosk.order;

import java.util.Scanner;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : OrderMenu.java
//  @ Date : 2020-05-07
//  @ Author : 
//
//




public class OrderMenu {
	private OrderService oService;
	
	public OrderMenu() {
		this.oService = new OrderService();
	}
	
	public void run(Scanner scan) {
		int menu;
		boolean flag = true;
		oService.Order();
		while(flag) {
			System.out.println("----------------------------------------");
			System.out.println("1. 메뉴 추가");
			System.out.println("2. 메뉴 삭제");
			System.out.println("3. 메뉴 수정(수량)");
			System.out.println("4. 메뉴 목록");
			System.out.println("5. 결제");
			System.out.println("6. 취소");
			System.out.println("----------------------------------------");
			System.out.print("input : ");
			menu = scan.nextInt();
			
			switch(menu) {
				case 1: 
					int c = oService.itemAdd(scan);
					if(c == 1) {
						System.out.println("추가 성공");
					}
					else {
						System.out.println("추가 실패");
					}
					break;
				case 2:
					oService.itemSub(scan);
					break;
				case 3:
					oService.itemUpdate();
					break;
				case 4:
					oService.printList();
					break;
				case 5:
					oService.payment();
					oService.Order();
					flag = false;
					break;
				case 6:
					flag = false;
					break;
			}
		}
	}
}
