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
            case "checkScoreByGuestNum":sql_result=check_score_by_guestnum(par1);break;
            case "checkScoreByGuestName":sql_result=check_score_by_guestname(par1);break;
            case "selectGuestByAppointedScore":sql_result=select_guest_by_appointed_score(par1);break;
            case "connectGuestWithVIP":sql_result=connect_Guest_with_VIP();break;
            case "checkMoneyRateByName":sql_result=check_moneyRate_BY_name(par1);break;
            case "checkMoneyRateAppointedLevel":sql_result=check_moneyRate_appointed_level(par1);break;
        }
        return sql_result;
    }
    //按VIP等级查询客户
        private Vector[] select_guest_by_viplevel(String viplevel) {
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
    //全局查询
    //查询积分大于某一分数的客户
        private Vector[] select_guest_by_appointed_score(String score) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" guestNum,guestName,score ", " Guest ", " score>'"+score+"'; ", "  ", "  ");
           // result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
            title.add("guestNum");
            title.add("guestName");
            title.add("score");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("guestNum"));
                row.add(rs.getString("guestName"));
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
    //指定查询
    //通过客户码查询积分
        private Vector[] check_score_by_guestnum(String guestNum) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" guestNum,guestName,score ", " Guest ", " guestNum='"+guestNum+"' ", " ; ", "  ");
            //result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
            title.add("guestNum");
            title.add("guestName");
            title.add("score");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("guestNum"));
                row.add(rs.getString("guestName"));
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
    //通过客户名查询积分
    private Vector[] check_score_by_guestname(String guestName) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" guestNum,guestName,score ", " Guest ", " guestName='" + guestName + "' ", "  ", "  ");
            //result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
            title.add("guestNum");
            title.add("guestName");
            title.add("score");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("guestNum"));
                row.add(rs.getString("guestName"));
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
    //VIP查询
    //链表客户表于vip表
        private Vector[] connect_Guest_with_VIP() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" guestNum,guestName,Guest.VipLevel,VIP.moneyRate,VIP.transRate ", " Guest,VIP ", " Guest.VipLevel=VIP.Viplevel; ", "  ", "  ");
            //result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
            title.add("guestNum");
            title.add("guestName");
            title.add("Guest.VipLevel");
            title.add("VIP.moneyRate");
            title.add("VIP.transRate");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("guestNum"));
                row.add(rs.getString("guestName"));
                row.add(rs.getString("Guest.VipLevel"));
                row.add(rs.getString("VIP.moneyRate"));
                row.add(rs.getString("VIP.transRate"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }
//vip指定查询
    //按客户名查询积分金钱比例
        private Vector[] check_moneyRate_BY_name(String guestname) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" VIP.Viplevel,VIP.moneyRate ", " Guest,VIP ", " guestName='"+guestname+"' and Guest.VipLevel=VIP.Viplevel; ", "  ", "  ");
            //result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
            title.add("VIP.Viplevel");
            title.add("VIP.moneyRate");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("VIP.Viplevel"));
                row.add(rs.getString("VIP.moneyRate"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }
        //查询指定等级的vip积分兑换比例
        private Vector[] check_moneyRate_appointed_level(String viplevel) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Guest.Viplevel,VIP.transRate ", " Guest,VIP ", " Guest.Viplevel='"+viplevel+"' and Guest.VipLevel=VIP.Viplevel; ", "  ", "  ");
            //result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
            title.add("Guest.Viplevel");
            title.add("VIP.transRate");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("Guest.Viplevel"));
                row.add(rs.getString("VIP.transRate"));
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

