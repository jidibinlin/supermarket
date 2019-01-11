package SQL;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import JDBC.connect;

public class BasicTableSelect {
    Statement stmt = null;
    ResultSet rs = null;
    String seResult;
    String result;
    SQLwords sql = new SQLwords();
    Vector data = new Vector();
    Vector title = new Vector();
    Vector[] resu = {data, title};
    Vector[] sql_result;

    public Vector[] sql_result(String sqlName) {

        switch (sqlName) {
            case "Department":sql_result=Department();break;
            case "Director":sql_result=Director();break;
            case "Employee":sql_result=Employee();break;
            case "Guest":sql_result=Guest();break;
            case "JobKind":sql_result=JobKind();break;
            case "Manu":sql_result=Manu();break;
            case "Product":sql_result=Product();break;
            case "Puchase":sql_result=Puchase();break;
            case "Shopping":sql_result=Shopping();break;
            case "VIP":sql_result=VIP();break;
        }
        return sql_result;
    }

    //部门表
    private Vector[] Department() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Department ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("depNum");
            title.add("depName");
            title.add("depLeader");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("depNum"));
                row.add(rs.getString("depName"));
                row.add(rs.getString("depLeader"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }
    //导购员表
    private Vector[] Director() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Director");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("emNum");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("emNum"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }
    //员工表
    private Vector[] Employee() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Employee");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("emNum");
            title.add("name");
            title.add("sex");
            title.add("location");
            title.add("age");
            title.add("depNum");
            title.add("jobNum");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("emNum"));
                row.add(rs.getString("name"));
                row.add(rs.getString("sex"));
                row.add(rs.getString("location"));
                row.add(rs.getString("age"));
                row.add(rs.getString("depNum"));
                row.add(rs.getString("jobNum"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }
    //客户表
    private Vector[] Guest() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Guest ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("guestNum");
            title.add("guestName");
            title.add("guestTel");
            title.add("guestSex");
            title.add("Viplevel");
            title.add("score");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("guestNum"));
                row.add(rs.getString("guestName"));
                row.add(rs.getString("guestTel"));
                row.add(rs.getString("guestSex"));
                row.add(rs.getString("Viplevel"));
                row.add(rs.getString("score"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }
    //工种表
    private Vector[] JobKind() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " JobKind");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("jobNum");
            title.add("jobName");
            title.add("salary");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("jobNum"));
                row.add(rs.getString("jobName"));
                row.add(rs.getString("salary"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }
    //厂家表
    private Vector[] Manu() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Manu ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
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
    //商品表
    private Vector[] Product() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Product ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("proNum");
            title.add("proName");
            title.add("value");
            title.add("weight");
            title.add("manuNum");
            title.add("prodate");
            title.add("deadTime");
            title.add("proRemain");
            title.add("type");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("proNum"));
                row.add(rs.getString("proName"));
                row.add(rs.getString("value"));
                row.add(rs.getString("weight"));
                row.add(rs.getString("manuNum"));
                row.add(rs.getString("prodate"));
                row.add(rs.getString("deadTime"));
                row.add(rs.getString("proRemain"));
                row.add(rs.getString("type"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }
    //采购表
    private Vector[] Puchase() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Puchase");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("cbillNum");
            title.add("proNum");
            title.add("emNum");
            title.add("Cargoprice");
            title.add("number");
            title.add("manuNum");
            title.add("GargoDate");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("cbillNum"));
                row.add(rs.getString("proNum"));
                row.add(rs.getString("emNum"));
                row.add(rs.getString("Cargoprice"));
                row.add(rs.getString("number"));
                row.add(rs.getString("manuNum"));
                row.add(rs.getString("GargoDate"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.release(stmt, rs);
        }
        return resu;

    }
    //购物表
    private Vector[] Shopping() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " Shopping");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("billNum");
            title.add("proNum");
            title.add("number");
            title.add("price");
            title.add("shopDate");
            while (rs.next()) {
                Vector row = new Vector();
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
            connect.release(stmt, rs);
        }
        return resu;

    }
    //VIP
    private Vector[] VIP() {
        try {
            data.removeAllElements();
            title.removeAllElements();
            seResult = sql.select(" * ", " VIP ");
            stmt = connect.getConnection().createStatement();
            rs = stmt.executeQuery(result);
            title.add("Viplevel");
            title.add("transRate");
            title.add("moneyRate");
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("Viplevel"));
                row.add(rs.getString("transRate"));
                row.add(rs.getString("moneyRate"));
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
