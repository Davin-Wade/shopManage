package shopping.Utils;

import java.sql.*;
import java.util.ArrayList;

public class DBUtils {
    private static String URL = DBConfig.getValue("url");
    private static String USERNAME = DBConfig.getValue("username");
    private static String PASSWORD = DBConfig.getValue("password");
    private static String DRIVER = DBConfig.getValue("driver");

    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getClose(Connection conn, Statement stmt, ResultSet rs){
        try {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();

            ArrayList lsit = new ArrayList<>();
            lsit.add(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int executeUpdate(String sql, ArrayList list){
        PreparedStatement pstmt = null;
        Connection conn = null;

        try {
            conn = getConn();
            pstmt = conn.prepareStatement(sql);
            if(list.size() > 0){
                for(int i = 0;i < list.size();i++){
                    pstmt.setObject(i+1,list.get(i));
                }
            }
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
