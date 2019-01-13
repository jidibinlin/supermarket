import GUI.GUI;
import SQL.BasicTableSelect;
import SQL.FinanceManage;

public class Main {
    public static void main(String[] args) {
        GUI g = new GUI();
        String A;
        g.integrate();
        BasicTableSelect b= new BasicTableSelect();
        A=b.Update("Manu","manuName='超大宝'","manuNum='M04'");
        System.out.println(A);
    }
}

