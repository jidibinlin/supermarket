package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

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

class MouseListenSqlSelect extends  MouseAdapter{
    private Vector[] sqlfunc=null;
    private Vector[] sqlfunc2=null;
    private Table table=null;
    MouseListenSqlSelect(Vector[] sqlfunc,Vector[] sqlfunc2,Table table){
        this.sqlfunc=sqlfunc;
        this.sqlfunc2=sqlfunc2;
        this.table=table;
    }
     public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
            table.tableDataShow(sqlfunc);
        }

        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
        }

        if (e.getButton() == MouseEvent.BUTTON3 && sqlfunc2 !=null) {
            System.out.println("right");
            table.tableDataShow(sqlfunc2);
        }
    }
}