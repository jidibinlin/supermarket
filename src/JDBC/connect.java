package JDBC;
import java.sql.*;
public class connect {
    public static Connection getConnection() throws SQLException,ClassNotFoundException{
        Connection conect=null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conect=DriverManager.getConnection("jdbc:mysql://47.106.241.153:3306/supmarket","root","QiBin`smysqlcount..66");
        return conect;
    }
    public static void release(Statement stmt,ResultSet rs){
        if(stmt != null){
            try{
                stmt.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            stmt = null;
        }

        if(rs != null){
            try{
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            rs = null;
        }
    }

    public static void release(ResultSet rs,Statement stmt, Connection conn){
        if(conn != null){
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            conn = null;
        }
        release(stmt,rs);
    }

    public static void release (Statement stmt){
        if (stmt != null){
            try{
                stmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            stmt=null;
        }
    }


}
