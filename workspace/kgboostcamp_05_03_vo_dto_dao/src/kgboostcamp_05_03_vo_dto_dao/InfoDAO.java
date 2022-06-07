package kgboostcamp_05_03_vo_dto_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class InfoDAO extends DAO<InfoVO>{
	@Override
	public ArrayList<InfoVO> selectAll() {
		ArrayList<InfoVO> result = new ArrayList<>();
		String sql = "SELECT * FROM info ORDER BY \"NUMBER\" ASC";
		PreparedStatement pst;
		try {
			pst = JdbcSingleton.getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				result.add(new InfoVO(
						rs.getLong(1),
						rs.getString(2),
						LocalDate.parse(rs.getDate(3).toString()),
						rs.getString(4)
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean insert(InfoVO ivo) {
		String sql = "INSERT INTO info VALUES(info_number_auto_increase.NEXTVAL, ?, ?, ?)";
		PreparedStatement pst;
		boolean result = false;
		try {
			pst = JdbcSingleton.getConnection().prepareStatement(sql);
			pst.setString(1, ivo.getName());
			pst.setObject(2, ivo.getBirth());
			pst.setString(3, ivo.getBloodType());
			pst.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// 테스트용이므로 number를 통해 삭제하도록 구현
	@Override
	int delete(InfoVO ivo) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM info WHERE \"NUMBER\" = ?";
		PreparedStatement pst;
		int result = 0;
		try {
			pst = JdbcSingleton.getConnection().prepareStatement(sql);
			pst.setLong(1, ivo.getNumber());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public InfoVO selectByNumber(long num) {
		InfoVO result = null;
		String sql = "SELECT * FROM info WHERE \"NUMBER\" = ?";
		PreparedStatement pst;
		try {
			pst = JdbcSingleton.getConnection().prepareStatement(sql);
			pst.setLong(1, num);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				result = new InfoVO(rs.getLong(1),
						rs.getString(2),
						LocalDate.parse(rs.getDate(3).toString()),
						rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		InfoDAO test = new InfoDAO();
		ArrayList<InfoVO> ilis = new ArrayList<InfoVO>();
		System.out.println(test.insert(new InfoVO("TEST", LocalDate.parse("1999-09-09"), "AB")));
		ilis = test.selectAll();
		for(InfoVO v : ilis) {
			System.out.println(v.toString());
		}
	}
}