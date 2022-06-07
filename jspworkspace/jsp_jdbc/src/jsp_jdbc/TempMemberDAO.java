package jsp_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class TempMemberDAO {
	private ConnectionPool pool = null;
	
	public TempMemberDAO() {
		try {
			pool = ConnectionPool.getInstance();
		}catch(Exception e) {
			System.out.println("Connection load failed!");
			e.printStackTrace();
		}
	}
	public Vector<TempMemberVO> getMemberList(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Vector<TempMemberVO> memList = new Vector<>();
		try {
			conn = pool.getConnection();
			String sql = "SELECT * FROM TEMPMEMBER";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				TempMemberVO tmp = new TempMemberVO();
				tmp.setId(rs.getNString("id"));
				tmp.setPassword(rs.getString("password"));
				tmp.setName(rs.getString("name"));
				tmp.setMem_num1(rs.getString("mem_num1"));
				tmp.setMem_num2(rs.getString("mem_num2"));
				tmp.setE_mail(rs.getString("e_mail"));
				tmp.setPhone(rs.getString("phone"));
				tmp.setZipcode(rs.getString("zipcode"));
				tmp.setAddress(rs.getString("address"));
				tmp.setJob(rs.getString("job"));
				memList.add(tmp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(psmt != null) try {rs.close();}catch(Exception e) {}
			if(conn != null) try {pool.releaseConnection(conn);}catch(Exception e) {}
		}
		
		return memList;
	}
}