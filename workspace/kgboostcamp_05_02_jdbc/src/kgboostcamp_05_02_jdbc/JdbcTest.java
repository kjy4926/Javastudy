package kgboostcamp_05_02_jdbc;
import java.sql.*;

public class JdbcTest {
	public static void main(String[] args) {
		Connection conn;
		try {
			conn = JdbcSingleton.getConnection();
			String sql = "SELECT * FROM info";
			PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			rs.last();
			int rowCount = rs.getRow();
			System.out.println(rowCount);
			rs.beforeFirst();
			while(rs.next()) {
				int data_id = rs.getInt("number"); // column name을 통해 가져오기
				String data_name = rs.getString(2); // column idx를 통해 가져오기.
				String data_birth = rs.getString(3);
				String data_blood = rs.getNString(4);
				System.out.printf("%2d %s %s %s\n", data_id, data_name, data_birth, data_blood);
			}
			conn.close();
			pst.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}