package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
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
            table.dateInput();
            funcScrollPanel[1].setViewportView(table.getTable());
    }

    public void chartChosePanel(){

    }

    public void updateFuncPanel(){

    }
}


class Table{

    private JTable table =new JTable();
    private DefaultTableModel tableModel=new DefaultTableModel();
    public Vector vDate=new Vector();
    public Vector vTitle=new Vector();

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

    public void dateInput(){
        String[][] Date={{"李清照","29","女"},{"李清照","29","女"},{"李清照","29","女"},{"李清照","29","女"}};
        String[] Title={"姓名","年龄","性别"};

        for(int i=0;i<Date.length;i++) {
            for (int j = 0; j < Title.length; j++) {
                vDate.add(Date[i][j]);
            }
        }
        for(int i=0;i<Title.length;i++){
            vTitle.add((String)Title[i]);
        }
        tableModel.setDataVector(vDate,vTitle);
        table.setModel(tableModel);
        table.validate();
        table.updateUI();
    }

    public void delete(){

    }

    public void show(){

    }

    public void updata(){

    }
}
