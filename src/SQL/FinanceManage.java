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
//    public void (){
//        try {
//            stmt = connect.getConnection().createStatement();
//            stmt.executeUpdate(  );
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            connect.release(stmt);
//        }
//    }
//    select 模板
//    public void (){
//        try {
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


    //销量管理

    //销量统计
    public Vector[] selesVolumeCollect() {
        try {
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
                System.out.println("proNum " + rs.getString("proNum") + "proName " + rs.getString("proName") + "counts: " + rs.getString("counts"));
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
    public void selesVolumeOrderDesc() {
        try {
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery("select Product.proNum,proName,counts " +
                    " from Product," +
                    " (select Shopping.proNum,sum(number) counts" +
                    " from Shopping" +
                    " group by proNum) AS PRO " +
                    " where PRO.proNum=Product.proNum" +
                    " order by counts Desc;");
            rs.last();
            rowCount=rs.getRow()-1;
            rs.first();
            String[][] resultArray=new String[rowCount][3];
            i=0;
            System.out.println("Product.proNum\t" + "proName\t\t\t" + "counts\t");
            while (rs.next()) {
                System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
    }
                //升序
    public void selesVolumeOrderAsc() {
        try {
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery("select Product.proNum,proName,counts " +
                    "from Product," +
                    "(select Shopping.proNum,sum(number) counts" +
                    "from Shopping" +
                    "group by proNum) AS PRO " +
                    "where PRO.proNum=Product.proNum" +
                    "order by counts Desc;");
            rs.last();
            rowCount=rs.getRow()-1;
            rs.first();
            String[][] resultArray=new String[rowCount][3];
            i=0;
            System.out.println("Product.proNum\t" + "proName\t\t\t" + "counts\t");
            while (rs.next()) {
                System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
    }

        //订单录入
    public void billInsert() {
        try {
            stmt = connect.getConnection().createStatement();
            stmt.executeUpdate("insert Shopping(billNum,proNum,number,price,shopDate) " +
                    "values('S01','p1','2','10','2018-12-15')," +
                    "('S02','p3','1','3','2018-12-15')," +
                    "('S03','p5','3','6','2018-12-15')," +
                    "('S04','p2','5','20','2018-12-15');");
            rs.last();
            rowCount=rs.getRow()-1;
            rs.first();
            String[][] resultArray=new String[rowCount][3];
            i=0;
            System.out.println("Product.proNum\t" + "proName\t\t\t" + "counts\t");
            while (rs.next()) {
                System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt);
        }
    }

        //指定日期查询----降序
    public void apponited_date_cheack_Desc() {
        try {
            seResult = sql.select("Shopping.proNum,sum(number) counts", "Shopping", "shopDate='2018-12-15'", " group by proNum", "");
            result = sql.select("Product.proNum,proName,counts", "Product,", seResult, "AS PRO", "PRO.proNum=Product.proNum", "", " order by counts Desc");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            System.out.println("Product.proNum\t" + "proName\t\t\t" + "counts\t");
            while (rs.next()) {
                System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
    }
        //指定日期查询----升序
    public void apponited_date_check_Asc() {
        try {
            seResult = sql.select("Shopping.proNum,sum(number) counts", "Shopping", "shopDate='2018-12-15'", " group by proNum", "");
            result = sql.select("Product.proNum,proName,counts", "Product,", seResult, "AS PRO", "PRO.proNum=Product.proNum", "", " order by counts Asc;");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            System.out.println("Product.proNum\t" + "proName\t\t\t" + "counts\t");
            while (rs.next()) {
                System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
    }

        //指定商品销量统计（比较）
            //升序
    public void apppnited_product_compare_Asc() {
        try {
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping ", " group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,counts ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and Product.proNum in ('P1','P2') ", "  ", " order by counts ASC;");
           // System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            System.out.println("Product.proNum\t" + "proName\t\t\t" + "counts\t");
            while (rs.next()) {
                System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
    }
            //降序
    public void apponited_product_compare_Desc() {
        try {
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping ", " group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,counts ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and Product.proNum in ('P1','P2') ", "  ", " order by counts DESC;");
            //System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            System.out.println("Product.proNum\t" + "proName\t\t\t" + "counts\t");
            while (rs.next()) {
                System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
    }

        //指定商品销量统计
    public void apponited_product_sell_Asc() {
        try {
            seResult = sql.select(" Shopping.proNum,sum(number) counts ", " Shopping "," group by proNum ", "  ");
            result = sql.select(" Product.proNum,proName,counts ", " Product, ", seResult, " AS PRO ", " PRO.proNum=Product.proNum and PRO.proNum ", "  ", " order by counts ASC;");
           // System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            System.out.println("Product.proNum\t" + "proName\t\t\t" + "counts\t");
            while (rs.next()) {
                System.out.println(rs.getString("Product.proNum") + "\t\t\t\t" + rs.getString("proName") + "\t" + rs.getString("counts") + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
    }

        //不同品牌的同类产品销量比较.
    public void compare_with_same_kind(){
        try {
            seResult=sql.select(" Shopping.proNum,sum(number) counts "," Shopping "," group by proNum ","  ");
            result=sql.select(" Product.proNum,proName,counts,Manu.manuName,Manu.manuLoc,Manu.manuTel "," Product,Manu, ",seResult,"  AS PRO "," PRO.proNum=Product.proNum and Product.manuNum=Manu.manuNum and Product.proName like '%矿泉水'  ","  ","  ");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println("Product.proNum"+"proName"+"counts"+"Manu.manuName"+"Manu.manuLoc"+"Manu.manuTel");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+rs.getString("proName")+rs.getString("counts")+rs.getString("Manu.manuName")+rs.getString("Manu.manuLoc")+rs.getString("Manu.manuTel"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }

    //盈利管理
        //全局
    public void whole_profit_manage (){
        try {
            seResult=sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum "," Shopping,Purchase "," Shopping.proNum=Purchase.proNum "," group by proNum; ","  ");
            result=sql.select(" Product.proNum,proName,profitSum "," Product, ",seResult," AS PRO "," PRO.proNum=Product.proNum ","  "," order by profitSum; ");
            //System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println("Product.proNum"+"proName"+"profitSum");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+rs.getString("proName")+rs.getString("profitSum"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
        //指定日期段或当日
    public void apponited_profit_manage (){
        try {
            seResult=sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum "," Shopping,Purchase "," Shopping.proNum=Purchase.proNum and shopDate<='2018-12-15' and shopDate>'2018-12-13' "," group by proNum","  ");
            result=sql.select(" Product.proNum,proName,profitSum "," Product, ",seResult," AS PRO "," PRO.proNum=Product.proNum ","  "," order by profitSum; ");
            //System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println("Product.proNum"+"proName"+"profitSum");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+rs.getString("proName")+rs.getString("profitSum"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
        //指定商品盈利
    public void apponited_product_profit(){
        try {
            seResult=sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum "," Shopping,Purchase "," Shopping.proNum=Purchase.proNum "," group by proNum","  ");
            result=sql.select(" Product.proNum,proName,profitSum "," Product, ",seResult," AS PRO "," PRO.proNum=Product.proNum and Product.proNum='P6' ","  "," order by profitSum; ");
            //System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println("Product.proNum"+"proName"+"profitSum");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+rs.getString("proName")+rs.getString("profitSum"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
        //比较商品盈利
    public void compare_product_profit(){
        try {
            seResult=sql.select(" Shopping.proNum,sum(Shopping.number*price-Purchase.Cargoprice*Shopping.number) profitSum "," Shopping,Purchase "," Shopping.proNum=Purchase.proNum "," group by proNum","  ");
            result=sql.select(" Product.proNum,proName,profitSum "," Product, ",seResult," AS PRO "," PRO.proNum=Product.proNum and Product.proName like '%矿泉水' ","  "," order by profitSum; ");
            //System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println("Product.proNum"+"proName"+"profitSum");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+rs.getString("proName")+rs.getString("profitSum"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
        //查询当前盈亏
    public void select_profit_fornow (){
            try {
            seResult=sql.select(" Purchase.manuNum,sum(Shopping.price*Shopping.number-Purchase.Cargoprice * Purchase.number) profitSUM "," Purchase,Shopping "," Purchase.proNum=Shopping.proNum "," group by manuNum ","  ");
            result=sql.select(" Manu.manuNum,Manu.manuName,profitSUM "," Manu, ",seResult," AS PRO "," Manu.manuNum=PRO.manuNum; ","  ","  ");
            //System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println("Manu.manuNum"+"Manu.manuName"+"profitSUM");
            while(rs.next()){
                System.out.println(rs.getString("Manu.manuNum")+rs.getString("Manu.manuName")+rs.getString("profitSUM"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
//供货商管理
    //供货商信息查询
        //仅本表内查询
            //查询指定商家的信息
    public void manu_info_select(){
        try {
            seResult=sql.select(" * "," Manu "," manuName='康帅傅';","  ","  ");
            //result=sql.select(" * "," Manu ","","  "," manuName='康帅傅'; ","  ","  ");
           // System.out.println(seResult);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(seResult);
            System.out.println("manuNum"+"manuName"+"manuLoc"+"manuTel");
            while(rs.next()){
                System.out.println(rs.getString("manuNum")+rs.getString("manuName")+rs.getString("manuLoc")+rs.getString("manuTel"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
        //链表查询
            //查询商品的供应商
    public void select_manu_of_product(){
        try {
            seResult=sql.select(" Product.proNum,Product.proName,Manu.manuName,Manu.manuLoc,Manu.manuTel "," Manu,Product ","  Manu.manuNum=Product.manuNum; ","  ","  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            //System.out.println(seResult);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(seResult);
            System.out.println("Product.proNum"+"Product.proName"+"Manu.manuName"+"Manu.manuLoc"+"Manu.manuTel");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+rs.getString("Product.proName")+rs.getString("Manu.manuName")+rs.getString("Manu.manuLoc")+rs.getString("Manu.manuTel"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
            //查询指定商品的供应商
    public void select_manu_of_apponited_product(){
        try {
            seResult=sql.select(" Product.proNum,Product.proName,Manu.manuName,Manu.manuLoc,Manu.manuTel "," Manu,Product ","  Manu.manuNum=Product.manuNum and Product.proName='恰宝矿泉水'; ","  ","  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            //System.out.println(seResult);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(seResult);
            System.out.println("Product.proNum"+"Product.proName"+"Manu.manuName"+"Manu.manuLoc"+"Manu.manuTel");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+rs.getString("Product.proName")+rs.getString("Manu.manuName")+rs.getString("Manu.manuLoc")+rs.getString("Manu.manuTel"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
            //查询指定供货商的所有商品
    public void select_all_product_from_apponited_manu(){
        try {
            seResult=sql.select(" Product.proNum,Product.proName,manuName "," Product,Manu "," Product.manuNum=Manu.manuNum and Product.manuNum='M03'; ","  ","  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
           // System.out.println(seResult);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(seResult);
            System.out.println("Product.proNum"+"Product.proName"+"manuName");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+rs.getString("Product.proName")+rs.getString("manuName"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
            //查询与所有供货商的交易总额
    public void all_manu_profit() {
        try {
            seResult=sql.select(" manuNum,sum(Cargoprice * number) purSUM "," Purchase "," group by manuNum ","  ");
            result=sql.select(" Manu.manuNum,Manu.manuName,purSUM "," Manu, ",seResult," AS PRO "," Manu.manuNum=PRO.manuNum; ","  ","  ");
            //System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println("Manu.manuNum"+"Manu.manuName"+"");
            while(rs.next()){
                System.out.println(rs.getString("Manu.manuNum")+rs.getString("Manu.manuName")+rs.getString("purSUM"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
            //查询指定商品的产地
    public void select_product_loc(){
        try {
            seResult=sql.select(" Product.proName,Product.proNum,Manu.manuName,Manu.manuLoc "," Product,Manu "," Product.manuNum=Manu.manuNum; ","  ","  ");
            //result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            System.out.println(seResult);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(seResult);
            System.out.println("Product.proName"+"Product.proNum"+"Manu.manuName"+"Manu.manuLoc");
            while(rs.next()){
                System.out.println(rs.getString("Product.proName")+rs.getString("Product.proNum")+rs.getString("Manu.manuName")+rs.getString("Manu.manuLoc"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
//select 模板
//    public void (){
//        try {
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
//    public void (){
//        try {
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