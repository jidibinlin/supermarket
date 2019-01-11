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

    public Vector[] sql_result(String sqlName,String par1,String par2) {

        switch (sqlName) {
            case "selectApponitedProductInfo":
                sql_result = select_apponited_product_info(par1);
                break;
            case "manuInfoSelect":
                sql_result = manu_info_select(par1);
                break;
            case "selectApponitedPriceProduct":
                select_apponited_price_product(par1);
                break;
            case "selectManuOfProduct":
                sql_result = select_manu_of_product();
                break;
            case "selectManuOfApponitedProduct":
                sql_result = select_manu_of_apponited_product(par1);
                break;
            case "selectAllProductFromApponitedManu":
                sql_result = select_all_product_from_apponited_manu(par1);
                break;
            case "selectProductLoc":
                sql_result = select_product_loc();
                break;
            case "selectSameKindManu":
                sql_result = select_samekind_manu(par1);
                break;
        }
        return sql_result;
    }

    public String update_result(String sqlName,String par1,String par2) {
        switch (sqlName) {
            case "updateProductInfo":
                update_result = update_product_info(par1,par2);
                break;
            case "updateManuInfo":
                update_result = update_manu_info(par1,par2);
                break;

        }
        return update_result;
    }


    //查询指定类商品的商品名和商品号
    private Vector[] select_apponited_product_info(String proType){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" proName,proNum  ", " Product ", " type='"+proType+"'; ", "  ", "  ");
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
    private Vector[] select_apponited_price_product(String price) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" proNum,proName,proRemain ", " Product ", " value>="+price+"; ", "  ", "  ");
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
    //供货商信息查询
    public Vector[] manu_info_select(String manuName) {
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
    public Vector[] select_manu_of_apponited_product(String proName) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Product.proNum,Product.proName,Manu.manuName,Manu.manuLoc,Manu.manuTel ", " Manu,Product ", "  Manu.manuNum=Product.manuNum and Product.proName='"+proName+"'; ", "  ", "  ");
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
    public Vector[] select_all_product_from_apponited_manu(String manuName) {
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

    //查询商品的产地
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
    public Vector[] select_samekind_manu(String proName_Like) {
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

    //供货商信息修改
    private String update_manu_info(String updateTarget,String updateConditions) {
        int reInt;
        String resultString = null;
        try {
            result = sql.update(" Manu ", " "+updateTarget+" ", " "+updateConditions+" ");
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
    private String update_product_info(String updateTarget,String updateConditions) {
        int reInt;
        String resultString = null;
        try {
            result = sql.update(" Product ", " "+updateTarget+" ", " "+updateConditions+" ");
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

