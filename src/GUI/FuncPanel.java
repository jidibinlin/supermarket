package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class FuncPanel {
    private JScrollPane[] funcScrollPanel ={new JScrollPane(),new JScrollPane(),new JScrollPane(),new JScrollPane(),};

    public JScrollPane[] getfuncPanel() {
        return funcScrollPanel;
    }

    public void selectFuncPanel(){

    }

    public void chartShowPanel(){
            Table table=new Table();
            funcScrollPanel[1].setViewportView(table.getTable());
    }

    public void chartChosePanel(){

    }

    public void updateFuncPanel(){

    }
}


class Table{

    private JTable table =new JTable();

    public JTable getTable(){
        return table;
    }
    public void setTable(){

    }
}
