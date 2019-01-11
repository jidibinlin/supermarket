package SQL;

import JDBC.connect;
import java.sql.*;
import java.util.Vector;

public class EmployeeManage {
    Statement stmt = null;
    ResultSet rs = null;
    String seResult;
    String result;
    String update_result;
    SQLwords sql = new SQLwords();
    int rowCount, columCount;
    int i, j;
    Vector data = new Vector();
    Vector title = new Vector();
    Vector[] resu = {data, title};
    Vector[] sql_result;

    public Vector[] sql_result(String sqlName,String par1,String par2) {

        switch (sqlName) {
            case "jobKindQuery":sql_result=job_kind_query();break;

        }
        return sql_result;
    }
    public String update_result(String sqlName,String par1,String par2) {
        switch (sqlName) {

        }
        return update_result;
    }

    //工种查询（通过工种号查询该工种下员工所属部门）
    private Vector[] job_kind_query()

    {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" JobKind.jobNum,JobName,emNum,name,Department.depNum,depName ", " Employee,Department,JobKind ", " JobKind.jobNum=Employee.jobNum" +
                    "and Department.depNum=Employee.depNum " +
                    "and JobKind.jobNum='E01'; ", "  ", "  ");
            //result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("JobKind.jobNum");
            title.add("JobName");
            title.add("emNum");
            title.add("name");
            title.add("Department.depNum");
            title.add("depName");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("JobKind.jobNum"));
                row.add(rs.getString("JobName"));
                row.add(rs.getString("emNum"));
                row.add(rs.getString("name"));
                row.add(rs.getString("Department.depNum"));
                row.add(rs.getString("depName"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }


//    private Vector[] ()
//
//    {
//        try {
//            data.removeAllElements();
//            title.removeAllElements();
//            seResult = sql.select("  ", "  ", "  ", "  ", "  ");
//            result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
//            stmt = connect.getConnection().createStatement();
//            rs = stmt.executeQuery(result);
//            title.add("");
//            title.add("");
//            title.add("");
//            while (rs.next()) {
//                Vector row = new Vector();
//                row.add(rs.getString(""));
//                row.add(rs.getString(""));
//                row.add(rs.getString(""));
//                data.add(row);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            connect.release(stmt, rs);
//        }
//        return resu;
//
//    }
//


}



