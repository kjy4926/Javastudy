package data_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MemberDAO {
	private static MemberDAO instance = null;
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		if(instance==null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}
	public boolean idCheck(String id) {
		boolean result = false;
		ResultSet rs = null;
		String sql = "SELECT id FROM member WHERE id = ?";
		try(Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql)){
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs != null) try {rs.close();} catch (SQLException e) {}
		}
		return result;
	}
	public boolean signUp(MemberDTO mdto) {
		boolean result = false;
		String sql = "INSERT INTO member VALUES(?, ?, ?, ?)";
		try(Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql)){
			psmt.setString(1, mdto.getId());
			psmt.setString(2, mdto.getPwd());
			psmt.setString(3, mdto.getEmail());
			psmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			int rowCount = psmt.executeUpdate();
			if(rowCount > 0) result=true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean login(String id, String pwd) {
		boolean result = false;
		if(idCheck(id)) {
			ResultSet rs = null;
			String sql = "SELECT pwd FROM member WHERE id = ?";
			try(Connection conn = DBCP.getConnection();
				PreparedStatement psmt = conn.prepareStatement(sql)){
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				if(rs.next()) {
					if(pwd.equals(rs.getString(1))) result = true;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
