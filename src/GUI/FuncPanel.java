package GUI;

import SQL.FinanceManage;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class FuncPanel {
    private JScrollPane[] funcScrollPanel = {new JScrollPane(), new JScrollPane(), new JScrollPane(), new JScrollPane()};
    private Table table = new Table();

    public JScrollPane[] getfuncPanel() {
        return funcScrollPanel;
    }

    public Table getTable() {
        return table;
    }

    public void selectFuncPanel() {
        funcScrollPanel[0].setViewportView(new FuncButton().createSelectButton("select",new FinanceManage().selesVolumeCollect(),new FinanceManage().all_manu_profit(),table));

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
