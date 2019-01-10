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
            case "selectApponitedProductInfo":
                sql_result = select_apponited_product_info();
                break;
            case "manuInfoSelect":
                sql_result = manu_info_select();
                break;
            case "selectApponitedPriceProduct":
                select_apponited_price_product();
                break;
            case "selectManuOfProduct":
                sql_result = select_manu_of_product();
                break;
            case "selectManuOfApponitedProduct":
                sql_result = select_manu_of_apponited_product();
                break;
            case "selectAllProductFromApponitedManu":
                sql_result = select_all_product_from_apponited_manu();
                break;
            case "selectProductLoc":
                sql_result = select_product_loc();
                break;
            case "selectSameKindManu":
                sql_result = select_samekind_manu();
                break;
        }
        return sql_result;
    }

    public String update_result(String sqlName) {
        switch (sqlName) {
            case "updateProductInfo":
                update_result = update_product_info();
                break;
            case "updateManuInfo":
                update_result = update_manu_info();
                break;

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

    public Vector[] manu_info_select() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Manu ", " manuName='康帅傅';", "  ", "  ");
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

    //链表查询
    //查询商品的供应商
    public Vector[] select_manu_of_product() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Product.proNum,Product.proName,Manu.manuName,Manu.manuLoc,Manu.manuTel ", " Manu,Product ", "  Manu.manuNum=Product.manuNum; ", "  ", "  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
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

    //查询指定商品的供应商
    public Vector[] select_manu_of_apponited_product() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Product.proNum,Product.proName,Manu.manuName,Manu.manuLoc,Manu.manuTel ", " Manu,Product ", "  Manu.manuNum=Product.manuNum and Product.proName='恰宝矿泉水'; ", "  ", "  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
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

    //查询指定供货商的所有商品
    public Vector[] select_all_product_from_apponited_manu() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Product.proNum,Product.proName,manuName ", " Product,Manu ", " Product.manuNum=Manu.manuNum and Product.manuNum='M03'; ", "  ", "  ");
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

    //查询指定商品的产地
    public Vector[] select_product_loc() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Product.proName,Product.proNum,Manu.manuName,Manu.manuLoc ", " Product,Manu ", " Product.manuNum=Manu.manuNum; ", "  ", "  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            //System.out.println(seResult);
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(seResult);
            title.add("proName");
            title.add("proNum");
            title.add("manuName");
            title.add("manuLoc");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proName"));
                row.add(rs.getString("proNum"));
                row.add(rs.getString("manuName"));
                row.add(rs.getString("manuLoc"));
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
    public Vector[] select_samekind_manu() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Product.proNum,Product.proName,Manu.manuName,Manu.manuLoc,Manu.manuTel ", " Manu,Product ", " Manu.manuNum=Product.manuNum and Product.proName like '%矿泉水'; ", "  ", "  ");
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

    //供货商信息修改
    private String update_manu_info() {
        int reInt;
        String resultString = null;
        try {
            result = sql.update(" Manu ", " ManuTel='17774809112' ", "manuNum='M05'");
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

    //商品信息修改
    private String update_product_info() {
        int reInt;
        String resultString = null;
        try {
            result = sql.update(" Product ", " proName='心怡抽纸' ", "proNum='P6'");
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
}

