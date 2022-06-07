package board;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
 
public class ConnUtil {
    private static DataSource ds;
    static {
        try{
            InitialContext init = new InitialContext();
            ds = (DataSource)init.lookup("java:comp/env/jdbc/myOracle");
        } catch(Exception e) {e.printStackTrace();}
    }
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
}