package memberone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO instance = null;
	private static DataSource ds = null;
	static{
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/myOracle");
		} catch(Exception e) {
			System.err.println("Connection 실패");
		}
	}
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public boolean idCheck(String id) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM MEMBER WHERE id = ?";
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(!rs.next()) result = false;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {rs.close();} catch (SQLException e1) {}
			}
			if(psmt != null) {
				try {psmt.close();} catch (SQLException e2) {}
			}
			if(conn != null) {
				try {conn.close();} catch(SQLException e3) {}
			}
		}
		return result;
	}
	public boolean memberInsert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		boolean flag = false;
		
		try {
			String sql ="INSERT INTO MEMBER VALUES(?, ?, ?, ?)";
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getEmail());
			psmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			int count = psmt.executeUpdate();
			if(count>0) flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null)try {rs.close();}catch(SQLException e1) {}
			if(psmt != null)try {psmt.close();}catch(SQLException e2) {}
			if(conn != null)try {conn.close();}catch(SQLException e3) {}
		}
		return flag;
	}
	
	public int loginCheck(String id, String pass) {
		int check = -1;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT PASS from MEMBER WHERE ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				String dbPass = rs.getNString("pass");
				if(pass.equals(dbPass)) check = 1;
				else check = 0;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null)try {rs.close();}catch(SQLException e1) {}
			if(psmt != null)try {psmt.close();}catch(SQLException e2) {}
			if(conn != null)try {conn.close();}catch(SQLException e3) {}
		}
		return check;
	}
	public MemberDTO getMember(String id) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE ID = ?");
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()){
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getTimestamp("regdate"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null)try {rs.close();}catch(SQLException e1) {}
			if(psmt != null)try {psmt.close();}catch(SQLException e2) {}
			if(conn != null)try {conn.close();}catch(SQLException e3) {}
		}
		return dto;
	}
	public void memberUpdate(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("UPDATE MEMBER SET PASS = ?, EMAIL = ? WHERE ID = ?");
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getEmail());
			psmt.setString(3, dto.getId());
			psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(psmt != null)try {psmt.close();}catch(SQLException e2) {}
			if(conn != null)try {conn.close();}catch(SQLException e3) {}
		}
	}
	public int deleteMember(String id, String pass) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String dbPass = "";
		int result = -1;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT PASS FROM MEMBER WHERE ID = ?");
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dbPass = rs.getString("pass");
				// 비밀번호 일치
				if(dbPass.equals(pass)) {
					psmt.close();
					psmt = conn.prepareStatement("DELETE FROM MEMBER WHERE ID = ?");
					psmt.setString(1, id);
					result = psmt.executeUpdate();
				}else {
					result = 0;
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null)try {rs.close();}catch(SQLException e1) {}
			if(psmt != null)try {psmt.close();}catch(SQLException e2) {}
			if(conn != null)try {conn.close();}catch(SQLException e3) {}
		}
		return result;
	}
}
