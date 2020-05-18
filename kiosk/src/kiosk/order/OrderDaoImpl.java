package kiosk.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kiosk.db.DBConn;
import kiosk.restaurant.Food;

public class OrderDaoImpl implements Dao{
	private DBConn db;
	ArrayList<Order> order;
	ArrayList<Food> food;
	public OrderDaoImpl() {
		db = DBConn.getInstance();
	}
	public void listinsert(Food f) {
		String sql = "insert into orderlist values(seq_orderlist.nextval, ?, ?, ?)";

		Connection conn = db.getConnect();
		int num = order.get(order.size()-1).getOrderNum();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, f.getNum());
			pstmt.setInt(3,f.getAmount());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void insert(Order o) {
		// TODO Auto-generated method stub
		String sql = "insert into ord values(seq_order.nextval, to_date(?), ?, ?, ?)";

		Connection conn = db.getConnect();
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, o.getDate());
			pstmt.setInt(2, o.getTotalPrice());
			pstmt.setString(3, o.getId());
			pstmt.setInt(4, o.getPayment() ? 1 : 0);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Order> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from ord order by num";
		ArrayList<Order> list = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt(1);
				String date = rs.getString(2);
				int price = rs.getInt(3);
				String id = rs.getString(4);
				int t = rs.getInt(5);
				Boolean pay;
				if (t == 1) pay = true;
				else pay = false;
				
				Order o = new Order(num, price,  id, date, pay);
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public void update(Order m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Food foodSelect(int num) {
		// TODO Auto-generated method stub
		
		String sql = "select * from food  where num = ?";
		Food f = null;
		ResultSet rs = null;
		Connection conn = db.getConnect();
		System.out.println(conn);
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fnum = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				
				 f = new Food(fnum, name, price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return f;
	}

	@Override
	public ArrayList<Food> foodSelectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from food order  by num";
		ArrayList<Food> list = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		System.out.println(conn);
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				
				Food f = new Food(num, name, price);
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
