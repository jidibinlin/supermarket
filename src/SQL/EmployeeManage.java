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
            case "jobKindQuery":sql_result=job_kind_query(par1);break;
            case "salaryCheck":sql_result=salaryCheck(par1);break;

        }
        return sql_result;
    }
    public String update_result(String sqlName,String par1,String par2) {
        switch (sqlName) {
            case "jobKindChange":jobKindChange(par1,par2);break;

        }
        return update_result;
    }

    //工种查询（通过工种号查询该工种下员工所属部门）
    private Vector[] job_kind_query(String jobNum)

    {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" JobKind.jobNum,JobName,emNum,name,Department.depNum,depName ", " Employee,Department,JobKind ", " JobKind.jobNum=Employee.jobNum" +
                    "and Department.depNum=Employee.depNum " +
                    "and JobKind.jobNum='"+jobNum+"'; ", "  ", "  ");
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

    //薪水管理
    //jobKind表修改
    private String jobKindChange (String updateTarget,String updateConditions) {
        int reInt;
        String resultString = null;
        try {
            result = sql.update(" JobKind ", " "+updateTarget+" ", " "+updateConditions+" ");
            stmt = connect.getConnection().createStatement();
            reInt = stmt.executeUpdate(result);
            if (reInt == 0) {
                resultString = "无任何元组被修改";
            } else {
                resultString = "有" + String.valueOf(reInt) + "条元组被修改";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt);
        }
        return resultString;
    }
    //薪水查询（查询指定薪水的职位）
    private Vector[] salaryCheck(String salary) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" JobKind.JobNum,JobName,salary ", " JobKind ", " salary='"+salary+"'; ", "  ", "  ");
            //result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("JobKind.JobNum");
            title.add("JobName");
            title.add("salary");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("JobKind.JobNum"));
                row.add(rs.getString("JobName"));
                row.add(rs.getString("salary"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }

    //查询指定员工的工种及薪水

    private Vector[] ()

    {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select("  ", "  ", "  ", "  ", "  ");
            result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("");
            title.add("");
            title.add("");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(""));
                row.add(rs.getString(""));
                row.add(rs.getString(""));
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

//    private String (String updateTarget,String updateConditions) {
//        int reInt;
//        String resultString = null;
//        try {
//            result = sql.update("  ", " "+updateTarget+" ", " "+updateConditions+" ");
//            stmt = connect.getConnection().createStatement();
//            reInt = stmt.executeUpdate(result);
//            if (reInt == 0) {
//                resultString = "无任何元组被修改";
//            } else {
//                resultString = "有" + String.valueOf(reInt) + "条元组被修改";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            connect.release(stmt);
//        }
//        return resultString;
//    }

}



