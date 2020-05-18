package kiosk.user;

import java.util.ArrayList;
import java.util.Scanner;


public class LoginServiceImpl implements LoginService {
	private Dao dao;

	public LoginServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addUser(Scanner sc) {
		// TODO Auto-generated method stub
		User c = new User();
		System.out.print("id: ");
		c.setId(sc.next());
		System.out.print("name: ");
		c.setName(sc.next());
		System.out.print("pw: ");
		c.setPassword(sc.next());
		System.out.print("tel: ");
		c.setTel(sc.next());
		dao.insert(c);
	}

	@Override
	public void getUser(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("ȸ�����̵�� �˻��ϼ���: ");
		String id = sc.next();
		ArrayList<User> list = dao.selectByID(id);
		if (list.isEmpty()) {
			System.out.println("ã�� �� �����ϴ�.");
		} else {
			for (User c : list) {
				System.out.println(c);
			}
		}
		
	}

	@Override
	public void getByTel(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("ȸ���� ��ȭ��ȣ�� �˻��ϼ���(###-####-####): ");
		String tel = sc.next();
		User c = dao.selectByTel(tel);
		if (c == null) {
			System.out.println("ã�� �� �����ϴ�.");
		} else {
			System.out.println(c);

		}
	}

	@Override
	public void editUser(Scanner sc) {
		// TODO Auto-generated method stub
		User u = new User();
		
		dao.update(u);
	}

	@Override
	public void delUser(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("���� �� ID�� �Է��ϼ���: ");
		String id = sc.next();
		dao.delete(id);
	}

	@Override
	public int login(Scanner sc) {
		// TODO Auto-generated method stub
		return 1;
	}


	@Override
	public void getList() {
		// TODO Auto-generated method stub
		ArrayList<User> list = dao.selectAllList();
		for (User r : list) {
			System.out.println(r);
		}
	}


}
