package kgboostcamp_05_02_jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSingleton {
	private static JdbcSingleton instance = new JdbcSingleton();
	private static String url;
	private static String id;
	private static String pwd;
	
	private JdbcSingleton() {
		try(BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\kim\\Desktop\\Javastudy\\db_account.txt"));) {
			url = br.readLine();
			id = br.readLine();
			pwd = br.readLine();
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static JdbcSingleton getInstance() {
		return instance;
	}
	
	public synchronized static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, id, pwd);
		return conn;
	}
}
