package GUI;

import SQL.FinanceManage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class FuncPanel {
    private JScrollPane[] funcScrollPanel = {new JScrollPane(), new JScrollPane(), new JScrollPane(), new JScrollPane()};
    private Table table = new Table();
    private JPanel[] funcpanel={new JPanel(),new JPanel()};

    public JScrollPane[] getfuncPanel() {
        return funcScrollPanel;
    }

    public Table getTable() {
        return table;
    }

    public JPanel[] getFuncpanel() {
        return funcpanel;
    }

    public void selectFuncPanel(JButton [] selecFunc,int counts) {
        funcScrollPanel[0].setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        funcScrollPanel[0].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        funcpanel[0].setBackground(new ColorDefined().getColor("blue"));

        for(int i=0;i<selecFunc.length;i++) {
           funcScrollPanel[0].setViewportView(funcpanel[0]);
        }
        Layout.selectFuncLayout(funcpanel[0],counts);
        for(int i=0;i<counts;i++){
            funcpanel[0].add(selecFunc[i]);
        }
    }

    public void chartShowPanel(String tableColor) {
        table.setTable(tableColor);
        funcScrollPanel[1].setViewportView(table.getTable());
    }

    public void chartChosePanel() {

    }

    public void updateFuncPanel() {

    }
}


class Table {

    private JTable table = new JTable();
    private DefaultTableModel tableModel = new DefaultTableModel();
    public Vector[] Data = {new Vector(), new Vector()};

    public JTable getTable() {
        return table;
    }

    public void setTable(String tableColor) {
        ColorDefined color = new ColorDefined();
        table.setRowHeight(25);
        table.getTableHeader().setPreferredSize(new Dimension(0,25));
        Font f = new Font("Fonts/Go Mono for Powerline.ttf", Font.PLAIN, 15);
        table.setBackground(color.getColor(tableColor));
        table.setFont(f);
    }

    public void tableDataShow(Vector[] Data) {
        tableModel.setDataVector(Data[0], Data[1]);
        for(int i=0;i<30;i++) {
            tableModel.insertRow(Data[0].size(), new Vector());
        }
        table.setModel(tableModel);
        table.validate();
        table.updateUI();
    }

    public void delete() {

    }

    public void show() {

    }

    public void updata() {

    }
}
