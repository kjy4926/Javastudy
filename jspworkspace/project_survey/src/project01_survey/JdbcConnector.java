package project01_survey;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcConnector {
	private static DataSource ds = null;
	static{
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/myOracle");
		} catch(Exception e) {
			System.err.println("Connection 실패");
		}
	}
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}