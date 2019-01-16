package SQL;

import JDBC.connect;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class login_sql {
    Statement stmt = null;
    ResultSet rs = null;
    String seResult;
    String result;
    String password;
    SQLwords sql = new SQLwords();
    Vector data = new Vector();
    Vector title = new Vector();
    Vector[] resu = {data, title};
    Vector[] sql_result;

    //LOGIN
    public String Login(String userid) {
        int reInt;
        String resultString = null;
        try {
            result = sql.login(userid);
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            resultString=rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt);
        }
        return resultString;
    }
}
