package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUntil {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			String url ="jdbc:mysql://localhost:3307/data_bookstore";
			String userName = "root";
			String password= "0986341885dai";
			c = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return c;		
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
			c.close();
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public static void printInfo(Connection c) {
		if(c!=null) {
			try {
				java.sql.DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
