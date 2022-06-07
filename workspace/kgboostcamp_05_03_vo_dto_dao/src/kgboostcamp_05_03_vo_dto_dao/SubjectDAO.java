package kgboostcamp_05_03_vo_dto_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDAO extends DAO<SubjectVO> {

	@Override
	ArrayList<SubjectVO> selectAll() {
		ArrayList<SubjectVO> result = new ArrayList<>();
		String sql = "SELECT * FROM subject ORDER BY \"SUB_CODE\" ASC";
		PreparedStatement pst;
		try {
			pst = JdbcSingleton.getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				result.add(new SubjectVO(
						rs.getLong(1),
						rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	boolean insert(SubjectVO svo) {
		String sql = "INSERT INTO subject VALUES(subject_number_auto_increase.NEXTVAL, ?)";
		PreparedStatement pst;
		boolean result = false;
		try {
			pst = JdbcSingleton.getConnection().prepareStatement(sql);
			pst.setString(1, svo.getSubName());
			pst.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// 테스트 용으로써 이름을 통해 삭제
	@Override
	int delete(SubjectVO svo) {
		String sql = "DELETE FROM subject WHERE \"NAME\" = ?";
		PreparedStatement pst;
		int result = 0;
		try {
			pst = JdbcSingleton.getConnection().prepareStatement(sql);
			pst.setString(1, svo.getSubName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		SubjectDAO test = new SubjectDAO();
		ArrayList<SubjectVO> lis = test.selectAll();
		for(SubjectVO v : lis) {
			System.out.println(v.toString());
		}
	}
}