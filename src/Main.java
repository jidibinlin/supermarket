import GUI.*;
import SQL.*;
public class Main {
    public static void main(String[] args){
        GUI g= new GUI();
        g.integrate();
        FinanceManage f=new FinanceManage();
        f.selesVolumeCollect();
        f.select_profit_fornow();
    }
}

