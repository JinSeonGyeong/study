package kiosk.restaurant;

import java.util.ArrayList;
import java.util.Scanner;


public class StoreServiceImp implements StoreService {
private Dao dao;
	
	public StoreServiceImp(){
		dao = new DaoImp();
	}
	@Override
	public void addFood(Scanner sc) {
		// TODO Auto-generated method stub
		Food f = new Food();
		System.out.print("name : ");
		f.setName(sc.next());
		System.out.print("price : ");
		f.setPrice(sc.nextInt());
		dao.insert(f);
	}

	@Override
	public void editFood(Scanner sc) {
		// TODO Auto-generated method stub
		Food f = new Food();
		System.out.print("edit name : ");
		f.setName(sc.next());
		System.out.print("new price : ");
		f.setPrice(sc.nextInt());
		dao.update(f);
	}

	@Override
	public void delFood(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("delete name:");
		String name = sc.next();
		dao.delete(name);
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		ArrayList<Food> list = dao.selectAll();
		for(Food f:list){
			System.out.println(f);
		}
	}

	@Override
	public void daySales() {
		// TODO Auto-generated method stub

	}

	@Override
	public void monthSales() {
		// TODO Auto-generated method stub

	}

}
