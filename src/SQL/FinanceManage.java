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
            case "apponitedProductCompare_Asc":
                sql_result=apppnited_product_compare_Asc(par1,par2);
                break;
            case "apponitedProductCompare_Desc":
                sql_result=apponited_product_compare_Desc(par1,par2);
                break;
            case "compareWithSameKind":
                sql_result=compare_with_same_kind(par1);
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
                sql_result=compare_product_profit(par1);
                break;
            case "selectProfitFornow":
                sql_result=select_profit_fornow();
                break;
        }
        return sql_result;
    }

    //销量管理
    //销量统计
    //销量统计排行
    //全局
    //降序
    private Vector[] selesVolumeOrderDesc() {
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
    private Vector[] selesVolumeOrderAsc() {
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
    private Vector[] apponited_date_cheack_Desc(String apponitedDate) {
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
    private Vector[] apponited_date_check_Asc(String apponitedDate) {
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
    private Vector[] apppnited_product_compare_Asc(String proName1,String proName2) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping ", " group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,counts ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and Product.proName in ('"+proName1+"','"+proName2+"') ", "  ", " order by counts ASC;");
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
    private Vector[] apponited_product_compare_Desc(String proName1,String proName2) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping ", " group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,counts ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and Product.ProName in ('"+proName1+"','"+proName2+"') ", "  ", " order by counts Desc;");
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
    private Vector[] compare_with_same_kind(String proName_LIKE) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping ", " group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,counts,Manu.manuName,Manu.manuLoc,Manu.manuTel ", " Product,Manu, ", seResult, "  AS PRO ", " PRO.proNum=Product.proNum and Product.manuNum=Manu.manuNum and Product.proName like '%"+proName_LIKE+"%'  ", "  ", "  ");
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
    private Vector[] whole_profit_manage() {
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
    private Vector[] apponited_profit_manage(String startDate,String endDate) {
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
    private Vector[] apponited_product_profit(String proName) {
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
    private Vector[] compare_product_profit(String proName_Like) {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum ", " Shopping,Purchase ", " Shopping.proNum=Purchase.proNum ", " group by proNum", "  ");
            result = sql.select(" Product.proNum,proName,profitSum ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and Product.proName like '%"+proName_Like+"%' ", "  ", " order by profitSum; ");
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
    private Vector[] select_profit_fornow() {
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
    private Vector[] all_manu_profit() {
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


}