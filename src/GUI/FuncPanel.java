package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class FuncPanel {
    private JScrollPane[] funcScrollPanel ={new JScrollPane(),new JScrollPane(),new JScrollPane(),new JScrollPane(),};
    private Table table=new Table();

    public JScrollPane[] getfuncPanel() {
        return funcScrollPanel;
    }

    public Table getTable(){
        return table;
    }

    public void selectFuncPanel(){

    }

    public void chartShowPanel(String tableColor){
            table .setTable(tableColor);
            funcScrollPanel[1].setViewportView(table.getTable());
    }

    public void chartChosePanel(){

    }

    public void updateFuncPanel(){

    }
}


class Table{

    private JTable table =new JTable(40,10);
    private DefaultTableModel tableModel=new DefaultTableModel();

    public JTable getTable(){
        return table;
    }

    public void setTable(String tableColor){
        ColorDefined color=new ColorDefined();
        table.setRowHeight(25);
        Font f=new Font("Fonts/Go Mono for Powerline.ttf",Font.PLAIN,15);
        table.setBackground(color.getColor(tableColor));
        table.setFont(f);
    }

    public void delete(){

    }

    public void show(){

    }

    public void updata(){

    }
}
