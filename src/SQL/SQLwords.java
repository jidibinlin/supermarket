package SQL;

public class SQLwords {
    String targets;//查询或修改的目标内容
    String tables;//被查询或修改的表
    String conditions;//查询或修改的条件
    String attributies;//元组属性
    String result;


    //select 方法
    public String select(String targets, String tables, String grReult, String orResult) {
        result = " select " + targets + " from " + tables  + grReult + orResult ;
        return result;
    }
    public String select(String targets, String tables,String conditions, String grReult, String orResult) {
        result = " select " + targets + " from " + tables + " where " + conditions + grReult + orResult;
        return result;
    }

    public String select(String targets, String tables, String lowerResult, String as, String conditions, String grReult, String orResult) {
        result = " select " + targets + " from " + tables +"("+ lowerResult +")"+ as + " where " + conditions + grReult + orResult ;
        return result;
    }

    //group方法
    public String group(String attributies) {
        result = " group by " + attributies;
        return result;
    }

    //order方法
    public String order(String attributies, String sortord) {
        result = " order by " + attributies + " " + sortord ;
        return result;
    }


    //update方法
    public String update(String tables, String targets, String conditions) {
        result = " update " + tables + " set " + targets + " where " + conditions+";" ;
        return result;
    }

    //delete方法
    public String delete(String tables, String conditions) {
        result = " delete " + " from " + tables + " where " + conditions+";" ;
        return result;
    }

    //insert方法
    public String insert(String tables, String attributies, String data) {
        result = " insert into " + tables + "(" + attributies + ") values " + data+";" ;
        return result;
    }

}
