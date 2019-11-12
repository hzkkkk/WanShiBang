package Model;

import Entity.User;

import java.sql.*;

public class LoginModel {
    private static String DBUNAME = "root";
    private static String DBUPWD = "";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/json?useUnicode=true&characterEncoding=UTF-8";

    public static boolean login(User user){
        return false;
//        String loginAccount = user.getLoginAccount();
//        String loginPassword = user.getLoginPassword();
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        int count = 0;
//        try{
//            Class.forName(DRIVER);
//            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
//            pstmt = con.prepareStatement("select count(*)from userinfo where account=? and password=?");
//            pstmt.setString(1,loginAccount);
//            pstmt.setString(2,loginPassword);
//            rs = pstmt.executeQuery();
//            if (rs.next()){
//                count = rs.getInt(1);
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try{
//                if (rs!=null){
//                    rs.close();
//                }
//                if (pstmt!=null){
//                    pstmt.close();
//                }
//                if (con!=null){
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            if (count==1){
//                return true;
//            }else{
//                return false;
//            }
//        }
    }

    public static boolean register(User user){
        return true;
//        String loginAccount = user.getLoginAccount();
//        String loginPassword = user.getLoginPassword();
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        int count = 0;
//        try{
//            Class.forName(DRIVER);
//            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
//            pstmt = con.prepareStatement("insert into userinfo values (?,?)");
//            pstmt.setString(1,loginAccount);
//            pstmt.setString(2,loginPassword);
//            count = pstmt.executeUpdate();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try{
//                if (rs!=null){
//                    rs.close();
//                }
//                if (pstmt!=null){
//                    pstmt.close();
//                }
//                if (con!=null){
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            if (count==1){
//                return true;
//            }else{
//                return false;
//            }
//        }
    }
}