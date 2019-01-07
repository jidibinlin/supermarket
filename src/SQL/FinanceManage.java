package SQL;

import JDBC.connect;
import java.sql.*;
import SQL.*;
//import SQLwords.java

public class FinanceManage {
    Statement stmt=null;
    ResultSet rs=null;
    String seResult;
    String result;
    SQLwords sql=new SQLwords();
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
//
//    //select模板
//    public void (){
//        try {
//            stmt = connect.getConnection().createStatement();
//            rs=stmt.executeQuery(  );
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            connect.release(stmt,rs);
//        }
//    }


    //销量管理

    //销量统计
    public void selesVolumeCollect(){
        try {
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(  "select Product.proNum,proName,counts "+
		                            "from Product,"+
			                                "(select Shopping.proNum,sum(number) counts "+
				                            "from Shopping "+
                                            "group by proNum) AS PRO "+
		                            "where PRO.proNum=Product.proNum;");
            while(rs.next()){
                System.out.println("proNum "+rs.getString("proNum")+"proName "+rs.getString("proName")+"counts: "+rs.getString("counts"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }

    //销量统计排行
       //全局
          //降序
    public void selesVolumeOrderDesc(){
        try {
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(  "select Product.proNum,proName,counts "+
                    " from Product,"+
                    " (select Shopping.proNum,sum(number) counts"+
                   " from Shopping"+
                    " group by proNum) AS PRO "+
                   " where PRO.proNum=Product.proNum"+
                    " order by counts Desc;");
            System.out.println("Product.proNum\t"+"proName\t\t\t"+"counts\t");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+"\t\t\t\t"+rs.getString("proName")+"\t"+rs.getString("counts")+"\t");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
    public void selesVolumeOrderAsc(){
        try {
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(  "select Product.proNum,proName,counts "+
                    "from Product,"+
                    "(select Shopping.proNum,sum(number) counts"+
                    "from Shopping"+
                    "group by proNum) AS PRO "+
                    "where PRO.proNum=Product.proNum"+
                    "order by counts Desc;");
            System.out.println("Product.proNum\t"+"proName\t\t\t"+"counts\t");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+"\t\t\t\t"+rs.getString("proName")+"\t"+rs.getString("counts")+"\t");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }

    //订单录入
    public void billInsert(){
        try {
            stmt = connect.getConnection().createStatement();
            stmt.executeUpdate("insert Shopping(billNum,proNum,number,price,shopDate) "+
                    "values('S01','p1','2','10','2018-12-15'),"+
                    "('S02','p3','1','3','2018-12-15'),"+
                    "('S03','p5','3','6','2018-12-15'),"+
                    "('S04','p2','5','20','2018-12-15');");
            System.out.println("Product.proNum\t"+"proName\t\t\t"+"counts\t");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+"\t\t\t\t"+rs.getString("proName")+"\t"+rs.getString("counts")+"\t");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt);
        }
    }


//    select Product.proNum,proName,counts
//    from Product,
//						(select Shopping.proNum,sum(number) counts
//    from Shopping
//    where shopDate='2018-12-15'
//    group by proNum) AS PRO
//    where PRO.proNum=Product.proNum
//    order by counts Desc;


    //指定日期查询----降序
    public void somedayCheack_Desc(){
        try {
            seResult=sql.select("Shopping.proNum,sum(number) counts","Shopping","shopDate='2018-12-15'"," group by proNum","");
            result=sql.select("Product.proNum,proName,counts","Product,",seResult,"AS PRO","PRO.proNum=Product.proNum",""," order by counts Desc");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println("Product.proNum\t"+"proName\t\t\t"+"counts\t");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+"\t\t\t\t"+rs.getString("proName")+"\t"+rs.getString("counts")+"\t");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }
    //指定日期查询----升序
    public void somedayCheack_Asc(){
        try {
            seResult=sql.select("Shopping.proNum,sum(number) counts","Shopping","shopDate='2018-12-15'"," group by proNum","");
            result=sql.select("Product.proNum,proName,counts","Product,",seResult,"AS PRO","PRO.proNum=Product.proNum",""," order by counts Asc");
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println("Product.proNum\t"+"proName\t\t\t"+"counts\t");
            while(rs.next()){
                System.out.println(rs.getString("Product.proNum")+"\t\t\t\t"+rs.getString("proName")+"\t"+rs.getString("counts")+"\t");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }

    //指定日期段查询
    public void somedaysCheck(){
        try {
            seResult=sql.select("  Shopping.proNum,sum(number) counts "," Shopping "," shopDate<='2018-12-15' and shopDate>='2018-12-13' "," group by proNum ","  ");
            result=sql.select(" Product.proNum,proName,counts "," Product, ",seResult," AS PRO  ","  PRO.proNum=Product.proNum  ","  "," order by counts Desc ");
            System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println();
            while(rs.next()){
                System.out.println(rs.getString();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }

    public void (){
        try {
            seResult=sql.select("  ","  ","  ","  ","  ");
            result=sql.select("  ","  ",seResult,"  ","  ","  ","  ");
            System.out.println(result);
            stmt = connect.getConnection().createStatement();
            rs=stmt.executeQuery(result);
            System.out.println();
            while(rs.next()){
                System.out.println(rs.getString();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt,rs);
        }
    }

    //
}
