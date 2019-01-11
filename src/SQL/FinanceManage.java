package SQL;

import GUI.DateInput;
import JDBC.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import GUI.NoticeCloseSureDialog;

import SQL.*;
//import SQLwords.java

public class FinanceManage {
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
            case "selesVolumeOrder_Desc":
                sql_result=selesVolumeOrderDesc();
                break;
            case "selesVolumeOrder_Asc":
                sql_result=selesVolumeOrderAsc();
                break;
            case "apponitedDateCheck_Desc":
                sql_result=apponited_date_cheack_Desc(par1);
                break;
            case "apponitedDateCheck_Asc":
                sql_result=apponited_date_check_Asc(par1);
                break;
            case "apppnitedProductCompare_Asc":
                sql_result=apppnited_product_compare_Asc();
                break;
            case "apponitedProductCompare_Desc":
                sql_result=apponited_product_compare_Desc();
                break;
            case "compareWithSameKind":
                sql_result=compare_with_same_kind();
                break;
            case "wholeProfitManage":
                sql_result=whole_profit_manage();
                break;
            case "apponitedProfitManage":
                sql_result=apponited_profit_manage(par1,par2);
                break;
            case "allManuProfit":
                sql_result=all_manu_profit();
                break;
            case "apponitedProductProfit":
                sql_result=apponited_product_profit(par1);
                break;
            case "compareProductProfit":
                sql_result=compare_product_profit();
                break;
            case "selectProfitFornow":
                sql_result=select_profit_fornow();
                break;
        }
        return sql_result;
    }

    public String update_result(String sqlName){
        switch(sqlName) {

            case "billInsert":
                update_result=billInsert();
                break;
        }
        return update_result;
    }

    //销量管理

    //销量统计
    //销量统计排行
    //全局
    //降序
    public Vector[] selesVolumeOrderDesc() {
        try {
           data.removeAllElements();
            title.removeAllElements();
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery("select Product.proNum,proName,counts " +
                    " from Product," +
                    " (select Shopping.proNum,sum(number) counts" +
                    " from Shopping " +
                    " group by proNum) AS PRO " +
                    " where PRO.proNum=Product.proNum" +
                    " order by counts Desc;");
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row = new Vector();
                //System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

    //升序
    public Vector[] selesVolumeOrderAsc() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery("select Product.proNum,proName,counts " +
                    " from Product," +
                    "  (select Shopping.proNum,sum(number) counts " +
                    " from Shopping " +
                    " group by proNum) AS PRO " +
                    " where PRO.proNum=Product.proNum" +
                    " order by counts Asc;");
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row = new Vector();
                //System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

    //指定日期查询----降序
    public Vector[] apponited_date_cheack_Desc(String apponitedDate) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping ", " shopDate='"+apponitedDate+"' ", " group by proNum", "");
            result = sql.select(" Product.proNum,proName,counts ", " Product, ", seResult, "AS PRO", " PRO.proNum=Product.proNum ", "", " order by counts Desc ;");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row = new Vector();
                // System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

    //指定日期查询----升序
    public Vector[] apponited_date_check_Asc(String apponitedDate) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select("Shopping.proNum,sum(number) counts", "Shopping", " shopDate='"+apponitedDate+"' ", " group by proNum", "");
            result = sql.select("Product.proNum,proName,counts", "Product,", seResult, "AS PRO", "PRO.proNum=Product.proNum", "", " order by counts Asc;");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row = new Vector();
                //System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

    //指定商品销量统计（比较）
    //升序
    public Vector[] apppnited_product_compare_Asc() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping ", " group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,counts ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and Product.proNum in ('P1','P2') ", "  ", " order by counts ASC;");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row = new Vector();
                //System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

    //降序
    public Vector[] apponited_product_compare_Desc() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping ", " group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,counts ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and Product.proNum in ('P1','P2') ", "  ", " order by counts DESC;");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row = new Vector();
                //System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

    //不同品牌的同类产品销量比较.
    public Vector[] compare_with_same_kind() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping ", " group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,counts,Manu.manuName,Manu.manuLoc,Manu.manuTel ", " Product,Manu, ", seResult, "  AS PRO ", " PRO.proNum=Product.proNum and Product.manuNum=Manu.manuNum and Product.proName like '%矿泉水'  ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            title.add("manuName");
            title.add("manuLoc");
            title.add("manuTel");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
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

    //盈利管理
    //全局
    public Vector[] whole_profit_manage() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum ", " Shopping,Purchase ", " Shopping.proNum=Purchase.proNum ", " group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,profitSum ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum ", "  ", " order by profitSum; ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("profitSum");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("profitSum"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

    //指定日期段或当日
    public Vector[] apponited_profit_manage(String startDate,String endDate) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum ", " Shopping,Purchase ", " Shopping.proNum=Purchase.proNum and shopDate<='"+endDate+"' and shopDate>='"+startDate+"' ", " group by proNum", "  ");
            result = sql.select(" Product.proNum,proName,profitSum ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum ", "  ", " order by profitSum; ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("profitSum");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("profitSum"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

    //查询指定商品盈利
    public Vector[] apponited_product_profit(String proName) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum ", " Shopping,Purchase ", " Shopping.proNum=Purchase.proNum ", " group by proNum", "  ");
            result = sql.select(" Product.proNum,proName,profitSum ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and Product.proName='"+proName+"' ", "  ", " order by profitSum; ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("profitSum");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("profitSum"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

    //比较商品盈利
    public Vector[] compare_product_profit() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum ", " Shopping,Purchase ", " Shopping.proNum=Purchase.proNum ", " group by proNum", "  ");
            result = sql.select(" Product.proNum,proName,profitSum ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and Product.proName like '%矿泉水' ", "  ", " order by profitSum; ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("profitSum");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("profitSum"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

    //查询当前盈亏
    public Vector[] select_profit_fornow() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Purchase.manuNum,sum(Shopping.price*Shopping.number-Purchase.Cargoprice * Purchase.number) profitSUM ", " Purchase,Shopping ", " Purchase.proNum=Shopping.proNum ", " group by manuNum ", "  ");
            result = sql.select(" Manu.manuNum,Manu.manuName,profitSUM ", " Manu, ", seResult, " AS PRO ", " Manu.manuNum=PRO.manuNum; ", "  ", "  ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("manuNum");
            title.add("manuName");
            title.add("profitSUM");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("manuNum"));
                row.add(rs.getString("manuName"));
                row.add(rs.getString("profitSUM"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }


    //查询与所有供货商的交易总额
    public Vector[] all_manu_profit() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" manuNum,sum(Cargoprice * number) purSUM ", " Purchase ", " group by manuNum ", "  ");
            result = sql.select(" Manu.manuNum,Manu.manuName,purSUM ", " Manu, ", seResult, " AS PRO ", " Manu.manuNum=PRO.manuNum; ", "  ", "  ");
            //System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("manuNum");
            title.add("manuName");
            title.add("purSUM");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("manuNum"));
                row.add(rs.getString("manuName"));
                row.add(rs.getString("purSUM"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }



    //订单录入
    public String billInsert() {
        int reInt;
        String resultString=null;
        try {
            result=sql.delete(" Manu "," manuNum='Mo1' ");
            stmt = connect.getConnection().createStatement();
            reInt=stmt.executeUpdate("insert Shopping(billNum,proNum,number,price,shopDate) " +
                    "values('S01','p1','2','10','2018-12-15')," +
                    "('S02','p3','1','3','2018-12-15')," +
                    "('S03','p5','3','6','2018-12-15')," +
                    "('S04','p2','5','20','2018-12-15');");
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