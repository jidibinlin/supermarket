package SQL;

import java.sql.*;
import java.util.Vector;

import JDBC.connect;

public class StoreManage {
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
            case "manuInfoSelect":
                sql_result = manu_info_select(par1);
                break;
            case "selectAllProductFromApponitedManu":
                sql_result = select_all_product_from_apponited_manu(par1);
                break;
            case "selectSameKindManu":
                sql_result = select_samekind_manu(par1);
                break;
        }
        return sql_result;
    }

    //供货商信息查询
    private Vector[] manu_info_select(String manuName) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Manu ", " manuName='"+manuName+"';", "  ", "  ");
            //result=sql.select(" * "," Manu ","","  "," manuName='康帅傅'; ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
            title.add("manuNum");
            title.add("manuName");
            title.add("manuLoc");
            title.add("manuTel");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("manuNum"));
                row.add(rs.getString("manuName"));
                row.add(rs.getString("manuLoc"));
                row.add(rs.getString("manuTel"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }
    //查询指定供货商的所有商品
    private Vector[] select_all_product_from_apponited_manu(String manuName) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Product.proNum,Product.proName,manuName ", " Product,Manu ", " Product.manuNum=Manu.manuNum and Product.manuName='"+manuName+"'; ", "  ", "  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
            title.add("proNum");
            title.add("proName");
            title.add("manuName");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("manuName"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }
    //查询有供应同类商品的不同厂家
    private Vector[] select_samekind_manu(String proName_Like) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Product.proNum,Product.proName,Manu.manuName,Manu.manuLoc,Manu.manuTel ", " Manu,Product ", " Manu.manuNum=Product.manuNum and Product.proName like '"+proName_Like+"'; ", "  ", "  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("manuName");
            title.add("manuLoc");
            title.add("manuTel");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("manuName"));
                row.add(rs.getString("manuLoc"));
                row.add(rs.getString("manuTel"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

}
