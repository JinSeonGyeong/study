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
		System.out.print("제목: ");
		r.setTitle(sc.next());
		System.out.println("================================");
		r.setSantance(sc.next());
		dao.insert(r);
	}

	@Override
	public void getReview(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("글의 번호를 검색하세요: ");
		int num = sc.nextInt();
		Review r = dao.selectByNum(num);
		if (r == null) {
			System.out.println("찾을 수 없습니다.");
		} else {
			System.out.println(r);
			System.out.println("================================");
			System.out.println(r.getSantance());

		}
	}

	@Override
	public void getByName(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("사용자를 검색하세요: ");
		String name = sc.next();
		ArrayList<Review> list = dao.selectByName(name);
		if (list.isEmpty()) {
			System.out.println("찾을 수 없습니다.");
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
		System.out.print("수정 할 글 번호를 입력하세요: ");
		r.setNum(sc.nextInt());
		System.out.print("제목을 수정하세요: ");
		r.setTitle(sc.next());
		System.out.print("내용을 수정하세요: ");
		r.setSantance(sc.next());
		dao.update(r);
	}

	@Override
	public void delReview(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("삭제 할 글 번호를 입력하세요: ");
		int num = sc.nextInt();
		dao.delete(num);
	}

}
