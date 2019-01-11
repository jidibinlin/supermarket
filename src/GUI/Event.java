package GUI;

import SQL.FinanceManage;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import SQL.*;

import javax.swing.*;

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

class MouseListeninput extends MouseAdapter {
    Boolean judge=false;
    Dialog di=null;
    MouseListeninput(Dialog di){
        this.di=di;
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
            judge=true;
            di.dispose();
        }
    }
}
class MouseListeninput2 extends MouseAdapter {
    Dialog di=null;
    MouseListeninput2(Dialog di){
        this.di=di;
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
            di.dispose();
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
    private String attr1=new String();
    private String attr2=new String();

    MouseListenSqlSelect(String funcName, Object select1, Object select2, Table table,String attr1,String attr2) {
        this.select1=select1;
        this.select2=select2;
        this.attr1=attr1;
        this.attr2=attr2;
        this.funcName=funcName;
        this.table = table;
    }

    public void mousePressed(MouseEvent e) {
        table.getTable().setEnabled(false);
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1 && attr1.isEmpty()) {
            whichtype(null,null);
            table.tableDataShow(sqlfunc);
        }else if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1 && !(attr1.isEmpty()) && attr2.isEmpty()){
            DateInput input=new DateInput(new String []{attr1,null});
            MouseListeninput mous=new MouseListeninput(input.getInput());
            MouseListeninput2 mous2=new MouseListeninput2(input.getInput());
            input.sure.addMouseListener(mous);
            input.back.addMouseListener(mous2);
            input.getDateUI();
            if(mous.judge){
                JTextField par1=(JTextField) input.getInputField().get(0);
                whichtype(par1.getText(),null);
                table.tableDataShow(sqlfunc);
            }

        }else if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1 && !(attr1.isEmpty()) && !(attr2.isEmpty())){
            DateInput input=new DateInput(new String []{attr1,attr2});
            MouseListeninput mous=new MouseListeninput(input.getInput());
            MouseListeninput2 mous2=new MouseListeninput2(input.getInput());
            input.sure.addMouseListener(mous);
            input.back.addMouseListener(mous2);
            input.getDateUI();
            if(mous.judge) {
                JTextField par1 = (JTextField) input.getInputField().get(0);
                JTextField par2 = (JTextField) input.getInputField().get(1);
                whichtype(par1.getText(), par2.getText());
                table.tableDataShow(sqlfunc);
            }
        }

        if (e.getButton() == MouseEvent.BUTTON3 && attr1.isEmpty()) {
            whichtype(null,null);
            table.tableDataShow(sqlfunc2);
        }else if(e.getButton() == MouseEvent.BUTTON3  && !(attr1.isEmpty()) && attr2.isEmpty()){
            DateInput input=new DateInput(new String[]{attr1,null});
            MouseListeninput mous=new MouseListeninput(input.getInput());
            MouseListeninput2 mous2=new MouseListeninput2(input.getInput());
            input.sure.addMouseListener(mous);
            input.back.addMouseListener(mous2);
            input.getDateUI();
            if(mous.judge) {
                JTextField par1 = (JTextField) input.getInputField().get(0);
                whichtype(par1.getText(), null);
                table.tableDataShow(sqlfunc2);
            }
        }else if(e.getButton() == MouseEvent.BUTTON3 && !(attr1.isEmpty()) && !(attr2.isEmpty())){
            DateInput input=new DateInput(new String[]{attr1,attr2});
            MouseListeninput mous=new MouseListeninput(input.getInput());
            MouseListeninput2 mous2=new MouseListeninput2(input.getInput());
            input.sure.addMouseListener(mous);
            input.back.addMouseListener(mous2);
            input.getDateUI();
            if (mous.judge) {
                JTextField par1 = (JTextField) input.getInputField().get(0);
                JTextField par2 = (JTextField) input.getInputField().get(1);
                whichtype(par1.getText(), par2.getText());
                table.tableDataShow(sqlfunc2);
            }
        }
    }


    private void whichtype(String par1,String par2){
        if (select1 instanceof FinanceManage && select2 == null) {
            this.sqlfunc =((FinanceManage) select1).select_result(funcName,par1,par2);
        } else if (select1 instanceof FinanceManage && select2 != null) {
            this.sqlfunc =((FinanceManage) select1).select_result(funcName+"_Asc",par1,par2);
            this.sqlfunc2 = ((FinanceManage)select2).select_result(funcName+"_Desc",par1,par2);
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
class CloseWindowSpecial extends WindowAdapter {//主窗口时间监听

    public void windowClosing(WindowEvent e) {
        JFrame fratran = (JFrame) e.getComponent();
        NoticeCloseSureDialog.CloseSure(fratran);
    }
}