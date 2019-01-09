package GUI;

import SQL.FinanceManage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import SQL.*;

public class Event {


}

class MouseListen extends MouseAdapter {//鼠标事件监听总类

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
            System.out.println("left button pressed once");
        }

        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {

            System.out.println("left button pressed twice");
        }


        if (e.getButton() == MouseEvent.BUTTON2) {
            System.out.println("right button pressed");
        }
    }
}

class MouseListenSqlSelect extends MouseAdapter {
    private Vector[] sqlfunc = null;
    private Vector[] sqlfunc2 = null;
    private Object select1=null;
    private Object select2=null;
    private String funcName=null;
    private Table table = null;

    MouseListenSqlSelect(String funcName, Object select1, Object select2, Table table) {
        this.select1=select1;
        this.select2=select2;

        this.funcName=funcName;
        this.table = table;
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
            whichtype();
            table.tableDataShow(sqlfunc);
        }

        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
        }

        if (e.getButton() == MouseEvent.BUTTON3 && sqlfunc2 != null) {
            whichtype();
            table.tableDataShow(sqlfunc2);
        }
    }


    private void whichtype(){
        if (select1 instanceof FinanceManage && select2 == null) {
            this.sqlfunc =((FinanceManage) select1).select_result(funcName);
        } else if (select1 instanceof FinanceManage && select2 != null) {
            this.sqlfunc =((FinanceManage) select1).select_result(funcName+"_Asc");
            this.sqlfunc2 = ((FinanceManage)select2).select_result(funcName+"_Desc");
        }


//        if(select1 instanceof EmployeeManage && select2==null){
//            sqlfunc =((EmployeeManage) select1).select_result(funcName);
//        }
//        else if(select1 instanceof EmployeeManage && select2!=null){
//            sqlfunc =((EmployeeManage) select1).select_result(funcName+"_Asc");
//            sqlfunc2 = ((EmployeeManage)select2).select_result(funcName+"_Desc");
//        }
//
//
//
//        if(select1 instanceof GuestInfoManage && select2==null){
//            sqlfunc =((GuestInfoManage) select1).select_result(funcName);
//        }
//
//        else if(select1 instanceof GuestInfoManage && select2!=null){
//            sqlfunc =((GuestInfoManage) select1).select_result(funcName+"_Asc");
//            sqlfunc2 = ((GuestInfoManage)select2).select_result(funcName+"_Desc");
//        }
//
//
//        if(select1 instanceof ProductManage && select2==null){
//            sqlfunc =((ProductManage) select1).select_result(funcName);
//        }
//
//        else if(select1 instanceof ProductManage && select2!=null){
//            sqlfunc =((ProductManage) select1).select_result(funcName+"_Asc");
//            sqlfunc2 = ((ProductManage)select2).select_result(funcName+"_Desc");
//        }
//
//
//        if(select1 instanceof StoreManage && select2==null){
//            sqlfunc =((StoreManage) select1).select_result(funcName);
//        }
//
//        else if(select1 instanceof StoreManage && select2!=null){
//            sqlfunc =((StoreManage) select1).select_result(funcName+"_Asc");
//            sqlfunc2 = ((StoreManage)select2).select_result(funcName+"_Desc");
//        }
    }
}