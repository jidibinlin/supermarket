package SQL;

import JDBC.connect;
import java.sql.*;
import java.util.Vector;

public class GuestInfoManage {
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

    public Vector[] select_result(String sqlName,String par1,String par2) {

        switch (sqlName) {
            case "selectGuestByViplevel":sql_result=select_guest_by_viplevel(par1);break;
//            case "":sql_result=();break;
//            case "":sql_result=();break;
//            case "":sql_result=();break;
//            case "":sql_result=();break;
        }
        return sql_result;
    }
    public String update_result(String sqlName,String par1,String par2) {
        switch (sqlName) {
            case "changeVip":update_result=change_vip(par1,par2);break;
            case "changeGuest":update_result=change_guest(par1,par2);break;
        }
        return update_result;
    }


//客户信息修改
    //VIP表修改

    private String change_vip(String updateTarget,String updateConditions) {
        int reInt;
        String resultString = null;
        try {
            result = sql.update(" VIP ", " "+updateTarget+" ", " "+updateConditions+" ");
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

    //客户表修改
    private String change_guest(String updateTarget,String updateConditions) {
        int reInt;
        String resultString = null;
        try {
            result = sql.update(" Guest ", " "+updateTarget+" ", " "+updateConditions+" ");
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


    //按VIP等级查询客户
        private Vector[] select_guest_by_viplevel(String viplevel)

    {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Guest ", " Viplevel='"+viplevel+"' ;", "  ", "  ");
           // result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
            title.add("guestNum");
            title.add("guestName");
            title.add("guestTel");
            title.add("guestSex");
            title.add("Viplevel");
            title.add("score");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("guestNum"));
                row.add(rs.getString("guestName"));
                row.add(rs.getString("guestTel"));
                row.add(rs.getString("guestSex"));
                row.add(rs.getString("Viplevel"));
                row.add(rs.getString("score"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }

    //积分查询
    //指定查询
    //通过客户码查询积分
        private Vector[] check_score_by_guestnum()

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

