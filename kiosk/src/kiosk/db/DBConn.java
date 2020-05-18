package kiosk.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	private static DBConn db = new DBConn();
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private DBConn() {
		
	}
	public static DBConn getInstance() {
		return db;
	}
	
	public Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("connection");
		}
		catch(Exception e) {
			
		}
		return conn;
		
	}
}
