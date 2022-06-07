package data_board;

public class FileDAO {
	private static FileDAO instance = null;
	private FileDAO() {};
	
	public static FileDAO getInstance() {
		if(instance == null) {
			synchronized (FileDAO.class) {
				instance = new FileDAO();
			}
		}
		return instance;
	}
}
