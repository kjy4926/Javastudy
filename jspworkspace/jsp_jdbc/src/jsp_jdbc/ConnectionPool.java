package jsp_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ArrayList<Connection> freed;
	private ArrayList<Connection> used;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "c##test";
	private String password = "test";
	private int initCons = 10;
	private int maxCons = 20;
	private int numCons = 0;
	private static ConnectionPool cp;
	
	public static ConnectionPool getInstance() {
		try {
			if(cp == null) {
				synchronized(ConnectionPool.class) {
					cp = new ConnectionPool();
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cp;
	}
	private ConnectionPool() throws SQLException{
		freed = new ArrayList<Connection>(initCons);
		used = new ArrayList<Connection>(initCons);
		while(numCons < initCons) {
			addConnection();
		}
	}
	private void addConnection() throws SQLException{
		freed.add(getNewConnection());
	}
	private Connection getNewConnection() throws SQLException{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, id, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("About to connect to " + conn);
		numCons++;
		return conn;
	}
	// 요청이 올 경우 freed에 있는 Connection을 used로 이동
	public synchronized Connection getConnection() throws SQLException{
		if(freed.isEmpty()) {
			while(numCons < maxCons) {
				addConnection();
			}
		}
		Connection _conn = freed.get(freed.size()-1);
		freed.remove(_conn);
		used.add(_conn);
		return _conn;
	}
	// 요청이 끝날 경우 used의 Connection을 freed로 이동
	public synchronized void releaseConnection(Connection _conn) throws SQLException{
		boolean flag = false;
		if(used.contains(_conn)) {
			used.remove(_conn);
			numCons--;
			flag = true;
		}
		else {
			throw new SQLException("ConnectionPool에 없습니다.");
		}
		try {
			if(flag) {freed.add(_conn); numCons++;}
			else {_conn.close();}
		} catch(SQLException e){
			try {_conn.close();}
			catch(SQLException e1) {e1.printStackTrace();}
		}
	}
	// 모든 Connection 삭제
	public void closeAll() {
		// 사용 중인 커넥션 삭제
		for(int i=0;i<used.size();i++) {
			Connection _conn = used.get(i);
			used.remove(i--);
			try {
				_conn.close();
			}catch(SQLException e) {
				try {_conn.close();}
				catch(SQLException e1) {e1.printStackTrace();}
			}
		}
		// 대기 중인 커넥션 삭제
		for(int i=0;i<used.size();i++) {
			Connection _conn = freed.get(i);
			freed.remove(i--);
			try {
				_conn.close();
			}catch(SQLException e) {
				try {_conn.close();}
				catch(SQLException e1) {e1.printStackTrace();}
			}
		}
	}
	public int getNumCons() {
		return numCons;
	}
}
