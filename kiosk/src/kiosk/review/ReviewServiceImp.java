package kiosk.review;

import java.util.ArrayList;
import java.util.Scanner;



public class ReviewServiceImp implements ReviewService {
	private Dao dao;

	public ReviewServiceImp() {
		dao = new DaoImpl();
	}

	@Override
	public void addReview(Scanner sc) {
		// TODO Auto-generated method stub
		Review r = new Review();
		System.out.print("����: ");
		r.setTitle(sc.next());
		System.out.println("================================");
		r.setSantance(sc.next());
		dao.insert(r);
	}

	@Override
	public void getReview(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("���� ��ȣ�� �˻��ϼ���: ");
		int num = sc.nextInt();
		Review r = dao.selectByNum(num);
		if (r == null) {
			System.out.println("ã�� �� �����ϴ�.");
		} else {
			System.out.println(r);
			System.out.println("================================");
			System.out.println(r.getSantance());

		}
	}

	@Override
	public void getByName(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("����ڸ� �˻��ϼ���: ");
		String name = sc.next();
		ArrayList<Review> list = dao.selectByName(name);
		if (list.isEmpty()) {
			System.out.println("ã�� �� �����ϴ�.");
		} else {
			for (Review r : list) {
				System.out.println(r);
			}
		}
	}

	@Override
	public void getList() {
		// TODO Auto-generated method stub
		ArrayList<Review> list = dao.selectAllList();
		for (Review r : list) {
			System.out.println(r);
		}
	}

	@Override
	public void editReview(Scanner sc) {
		// TODO Auto-generated method stub
		Review r = new Review();
		System.out.print("���� �� �� ��ȣ�� �Է��ϼ���: ");
		r.setNum(sc.nextInt());
		System.out.print("������ �����ϼ���: ");
		r.setTitle(sc.next());
		System.out.print("������ �����ϼ���: ");
		r.setSantance(sc.next());
		dao.update(r);
	}

	@Override
	public void delReview(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("���� �� �� ��ȣ�� �Է��ϼ���: ");
		int num = sc.nextInt();
		dao.delete(num);
	}

}
