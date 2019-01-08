package SQL;

import JDBC.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import SQL.*;
//import SQLwords.java

public class FinanceManage {
    Statement stmt = null;
    ResultSet rs = null;
    String seResult;
    String result;
    SQLwords sql = new SQLwords();
    int rowCount,columCount;
    int i,j;
    Vector data=new Vector();
    Vector title=new Vector();
    Vector[] resu={data,title};
//    //insert update delete模板
//    public Vector[] (){
//        try {
//            stmt = connect.getConnection().createStatement();
//            stmt.executeUpdate(  );
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            connect.release(stmt);
//        }
//    }


    //销量管理

    //销量统计
    public Vector[] selesVolumeCollect() {
                try {
                    data.removeAllElements();
                    title.removeAllElements();
                    stmt = connect.getConnection().createStatement();
                    rs = stmt.executeQuery("select Product.proNum,proName,counts " +
                            "from Product," +
                            "(select Shopping.proNum,sum(number) counts " +
                            "from Shopping " +
                            "group by proNum) AS PRO " +
                            "where PRO.proNum=Product.proNum;");
                    title.add("proNum");
                    title.add("proName");
                    title.add("counts");
                    while (rs.next()) {
                        Vector row=new Vector();
                        //System.out.println("proNum " + rs.getString("proNum") + "proName " + rs.getString("proName") + "counts: " + rs.getString("counts"));
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
                    " from Shopping" +
                    " group by proNum) AS PRO " +
                    " where PRO.proNum=Product.proNum" +
                    " order by counts Desc;");
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row=new Vector();
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
                    "from Product," +
                    "(select Shopping.proNum,sum(number) counts" +
                    "from Shopping" +
                    "group by proNum) AS PRO " +
                    "where PRO.proNum=Product.proNum" +
                    "order by counts Desc;");
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row=new Vector();
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

        //订单录入
    public Vector[] billInsert() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            stmt = connect.getConnection().createStatement();
            stmt.executeUpdate("insert Shopping(billNum,proNum,number,price,shopDate) " +
                    "values('S01','p1','2','10','2018-12-15')," +
                    "('S02','p3','1','3','2018-12-15')," +
                    "('S03','p5','3','6','2018-12-15')," +
                    "('S04','p2','5','20','2018-12-15');");
            title.add("billNum");
            title.add("proNum");
            title.add("number");
            title.add("price");
            title.add("shopDate");
          while (rs.next()) {
              Vector row=new Vector();
               // System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
              row.add(rs.getString("billNum"));
              row.add(rs.getString("proNum"));
              row.add(rs.getString("number"));
              row.add(rs.getString("price"));
              row.add(rs.getString("shopDate"));
              data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt);
        }
        return resu;
    }

        //指定日期查询----降序
    public Vector[] apponited_date_cheack_Desc() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select("Shopping.proNum,sum(number) counts", "Shopping", "shopDate='2018-12-15'", " group by proNum", "");
            result = sql.select("Product.proNum,proName,counts", "Product,", seResult, "AS PRO", "PRO.proNum=Product.proNum", "", " order by counts Desc");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row=new Vector();
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
    public Vector[] apponited_date_check_Asc() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select("Shopping.proNum,sum(number) counts", "Shopping", "shopDate='2018-12-15'", " group by proNum", "");
            result = sql.select("Product.proNum,proName,counts", "Product,", seResult, "AS PRO", "PRO.proNum=Product.proNum", "", " order by counts Asc;");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row=new Vector();
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
                Vector row=new Vector();
                //System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);}
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
                Vector row=new Vector();
                //System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

        //指定商品销量统计
    public Vector[] apponited_product_sell_Asc() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping "," group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,counts ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and PRO.proNum ", "  ", " order by counts ASC;");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            while (rs.next()) {
                Vector row=new Vector();
                //System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;
    }

        //不同品牌的同类产品销量比较.
    public Vector[] compare_with_same_kind(){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" Shopping.proNum,sum(number) counts "," Shopping "," group by proNum ","  ");
            result=sql.select(" Product.proNum,proName,counts,Manu.manuName,Manu.manuLoc,Manu.manuTel "," Product,Manu, ",seResult,"  AS PRO "," PRO.proNum=Product.proNum and Product.manuNum=Manu.manuNum and Product.proName like '%矿泉水'  ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("counts");
            title.add("manuName");
            title.add("manuLoc");
            title.add("manuTel");
            while(rs.next()){
                Vector row=new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                row.add(rs.getString("manuName"));
                row.add(rs.getString("manuLoc"));
                row.add(rs.getString("manuTel"));
                data.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }

    //盈利管理
        //全局
    public Vector[] whole_profit_manage (){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum "," Shopping,Purchase "," Shopping.proNum=Purchase.proNum "," group by proNum; ","  ");
            result=sql.select(" Product.proNum,proName,profitSum "," Product, ",seResult," AS PRO "," PRO.proNum=Product.proNum ","  "," order by profitSum; ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("profitSum");
            while(rs.next()){
                Vector row=new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }
        //指定日期段或当日
    public Vector[] apponited_profit_manage (){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum "," Shopping,Purchase "," Shopping.proNum=Purchase.proNum and shopDate<='2018-12-15' and shopDate>'2018-12-13' "," group by proNum","  ");
            result=sql.select(" Product.proNum,proName,profitSum "," Product, ",seResult," AS PRO "," PRO.proNum=Product.proNum ","  "," order by profitSum; ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("profitSum");
            while(rs.next()){
                Vector row=new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }
        //指定商品盈利
    public Vector[] apponited_product_profit(){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum "," Shopping,Purchase "," Shopping.proNum=Purchase.proNum "," group by proNum","  ");
            result=sql.select(" Product.proNum,proName,profitSum "," Product, ",seResult," AS PRO "," PRO.proNum=Product.proNum and Product.proNum='P6' ","  "," order by profitSum; ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("profitSum");
            while(rs.next()){
                Vector row=new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);}
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }

        //比较商品盈利
    public Vector[] compare_product_profit(){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum "," Shopping,Purchase "," Shopping.proNum=Purchase.proNum "," group by proNum","  ");
            result=sql.select(" Product.proNum,proName,profitSum "," Product, ",seResult," AS PRO "," PRO.proNum=Product.proNum and Product.proName like '%矿泉水' ","  "," order by profitSum; ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("profitSum");
            while(rs.next()){
                Vector row=new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("counts"));
                data.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }
        //查询当前盈亏
    public Vector[] select_profit_fornow (){
            try {
                data.removeAllElements();
                title.removeAllElements();
            seResult=sql.select(" Purchase.manuNum,sum(Shopping.price*Shopping.number-Purchase.Cargoprice * Purchase.number) profitSUM "," Purchase,Shopping "," Purchase.proNum=Shopping.proNum "," group by manuNum ","  ");
            result=sql.select(" Manu.manuNum,Manu.manuName,profitSUM "," Manu, ",seResult," AS PRO "," Manu.manuNum=PRO.manuNum; ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            title.add("manuNum");
            title.add("manuName");
            title.add("profitSUM");
            while(rs.next()){
                Vector row=new Vector();
                row.add(rs.getString("manuNum"));
                row.add(rs.getString("manuName"));
                row.add(rs.getString("counts"));
                data.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }
//供货商管理
    //供货商信息查询
        //仅本表内查询
            //查询指定商家的信息
    public Vector[] manu_info_select(){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" * "," Manu "," manuName='康帅傅';","  ","  ");
            //result=sql.select(" * "," Manu ","","  "," manuName='康帅傅'; ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(seResult);
            title.add("manuNum");
            title.add("manuName");
            title.add("manuLoc");
            title.add("manuTel");
            while(rs.next()){
                Vector row=new Vector();
                row.add(rs.getString("manuNum"));
                row.add(rs.getString("manuName"));
                row.add(rs.getString("manuLoc"));
                row.add(rs.getString("manuTel"));
                data.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }
        //链表查询
            //查询商品的供应商
    public Vector[] select_manu_of_product(){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" Product.proNum,Product.proName,Manu.manuName,Manu.manuLoc,Manu.manuTel "," Manu,Product ","  Manu.manuNum=Product.manuNum; ","  ","  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(seResult);
            title.add("proNum");
            title.add("proName");
            title.add("manuName");
            title.add("manuLoc");
            title.add("manuTel");
            while(rs.next()){
                Vector row=new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("manuName"));
                row.add(rs.getString("manuLoc"));
                row.add(rs.getString("manuTel"));
                data.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }
            //查询指定商品的供应商
    public Vector[] select_manu_of_apponited_product(){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" Product.proNum,Product.proName,Manu.manuName,Manu.manuLoc,Manu.manuTel "," Manu,Product ","  Manu.manuNum=Product.manuNum and Product.proName='恰宝矿泉水'; ","  ","  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(seResult);
            title.add("proNum");
            title.add("proName");
            title.add("manuName");
            title.add("manuLoc");
            title.add("manuTel");
            while(rs.next()){
                Vector row=new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("manuName"));
                row.add(rs.getString("manuLoc"));
                row.add(rs.getString("manuTel"));
                data.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }
            //查询指定供货商的所有商品
    public Vector[] select_all_product_from_apponited_manu(){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" Product.proNum,Product.proName,manuName "," Product,Manu "," Product.manuNum=Manu.manuNum and Product.manuNum='M03'; ","  ","  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(seResult);
            title.add("proNum");
            title.add("proName");
            title.add("manuName");
            while(rs.next()){
                Vector row=new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("manuName"));
                data.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }
            //查询与所有供货商的交易总额
    public Vector[] all_manu_profit() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" manuNum,sum(Cargoprice * number) purSUM "," Purchase "," group by manuNum ","  ");
            result=sql.select(" Manu.manuNum,Manu.manuName,purSUM "," Manu, ",seResult," AS PRO "," Manu.manuNum=PRO.manuNum; ","  ","  ");
            //System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            //System.out.println("Manu.manuNum"+"Manu.manuName"+"");
            while(rs.next()){
                //System.out.println(rs.getString("Manu.manuNum")+rs.getString("Manu.manuName")+rs.getString("purSUM"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }
            //查询指定商品的产地
    public Vector[] select_product_loc(){
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult=sql.select(" Product.proName,Product.proNum,Manu.manuName,Manu.manuLoc "," Product,Manu "," Product.manuNum=Manu.manuNum; ","  ","  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            //System.out.println(seResult);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(seResult);
            //System.out.println("Product.proName"+"Product.proNum"+"Manu.manuName"+"Manu.manuLoc");
            while(rs.next()){
                //System.out.println(rs.getString("Product.proName")+rs.getString("Product.proNum")+rs.getString("Manu.manuName")+rs.getString("Manu.manuLoc"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
        return resu;
    }
//select 模板
//    public Vector[] (){
//        try {
//    data.removeAllElements();
//                    title.removeAllElements();
//            seResult=sql.select("  ","  ","  ","  ","  ");
//            result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
//            System.out.println(result);
//            stmt = connect.getConnection().createStatement();
//            rs=stmt.executeQuery(result);
//            System.out.println();
//            while(rs.next()){
//                System.out.println(rs.getString();
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            connect.release(stmt,rs);
//        }
//    }
//select 模板
//    public Vector[] (){
//        try {
//    data.removeAllElements();
//                    title.removeAllElements();
//            seResult=sql.select("  ","  ","  ","  ","  ");
//            result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
//            System.out.println(result);
//            stmt = connect.getConnection().createStatement();
//            rs=stmt.executeQuery(result);
//            System.out.println();
//            while(rs.next()){
//                System.out.println(rs.getString();
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            connect.release(stmt,rs);
//        }
//    }


}