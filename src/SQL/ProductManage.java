package SQL;

import java.sql.*;
import java.util.Vector;

import JDBC.connect;

public class ProductManage {
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

    public Vector[] sql_result(String sqlName) {

        switch (sqlName) {
            case "select_apponited_product_info":
                select_apponited_product_info();
                break;
            case "select_apponited_price_product":
                select_apponited_price_product();
                break;
        }
        return sql_result;
    }
    private String update_result(String sqlName){
        switch(sqlName) {
            case "update_product_info":
                update_result=update_product_info(); break;
        }
        return update_result;
    }


    //查询指定类商品的商品名和商品号
    private Vector[] select_apponited_product_info() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" proName,proNum  ", " Product ", " type='饮品'; ", "  ", "  ");
            //result=sql.select("  "," , ",seResult,"  "," ; ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proName");
            title.add("proNum");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proName"));
                row.add(rs.getString("proNum"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }

    //查询特定价格以上的商品信息
    private Vector[] select_apponited_price_product() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" proNum,proName,proRemain ", " Product ", " value>=4; ", "  ", "  ");
            //result = sql.select("  ", " , ", seResult, "  ", " ; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("proRemain");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("proRemain"));
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
//private Vector[]()
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
//private Vector[]()
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
//private Vector[]()
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
//private Vector[]()
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
//
//}
//商品信息修改
private String update_product_info(){
    int reInt;
    String resultString=null;
    try {
        result=sql.update(" Product "," proName='心怡抽纸' ","proNum='P6'");
        stmt = connect.getConnection().createStatement();
        reInt=stmt.executeUpdate(result);
        if(reInt==0){
            resultString="无任何元组被修改";
        }else{
            resultString="有"+String.valueOf(reInt)+"条元组被修改";
        }
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        connect.release(stmt);
    }
    return resultString;
}
}

