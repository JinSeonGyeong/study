package kiosk.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kiosk.db.DBConn;

public class DaoImpl implements Dao {
	private DBConn db;
	public DaoImpl(){
		db = DBConn.getInstance();
	}
	
	@Override
	public void insert(Review r) {
		// TODO Auto-generated method stub
		String sql = "insert into Review values(seq_review.nextval, ?,?,?);";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getTitle());
			pstmt.setString(3, r.getSantance());
			pstmt.executeUpdate();
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
	}

	@Override
	public ArrayList<Review> selectByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from Review where user_id = ?;";
		ArrayList<Review> list = new ArrayList<Review>();
		Connection conn = db.getConnect();
		ResultSet rs = null;
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Review(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
	public Review selectByNum(int num) {
		// TODO Auto-generated method stub
		String sql = "select review_id, user_id, review_title from Review where review_id = ?;";
		Connection conn = db.getConnect();
		ResultSet rs = null;
		Review r = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				r = new Review(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
		return r;
	}

	@Override
	public ArrayList<Review> selectAllList() {
		// TODO Auto-generated method stub
		String sql = "select * from Review;";
		ArrayList<Review> list = new ArrayList<Review>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int num = rs.getInt(1);
				String name = rs.getString(2);
				String title = rs.getString(3);
				Review r = new Review(num, name, title, "");
				list.add(r);
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
	public void update(Review r) {
		// TODO Auto-generated method stub
		String sql = "update Review set review_title = ?, review_santance = ? where review_id = ?;";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getTitle());
			pstmt.setString(2, r.getSantance());
			pstmt.setInt(3, r.getNum());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		String sql = "delete from Review where review_id = ?;";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
