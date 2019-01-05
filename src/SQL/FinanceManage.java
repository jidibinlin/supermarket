package SQL;

import JDBC.connect;
import java.sql.*;

public class FinanceManage {
    Statement stmt=null;
    ResultSet rs=null;

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
                    "from Product,"+
                    "(select Shopping.proNum,sum(number) counts"+
                   "from Shopping"+
                    "group by proNum) AS PRO "+
            "where PRO.proNum=Product.proNum"+
            "order by counts Desc;");
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
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connect.release(stmt);
        }
    }



    //
}
