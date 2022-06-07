package jsp_jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	private Connection conn = null;
	private DataSource ds = null;
	public DAO() {
		try {
			Context init = (Context) new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/myOracle");
			conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)try {conn.close();}catch(Exception e) {}
		}
	}
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
