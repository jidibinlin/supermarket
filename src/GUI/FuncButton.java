package GUI;

import SQL.BasicTableSelect;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FuncButton {
    private JButton selectFunc = null;
    private JButton updataFunc = null;

    public JButton getSelectFunc() {
        return selectFunc;
    }

    public JButton getUpdataFunc() {
        return updataFunc;
    }

    public JButton createSelectButton(String label, String funcName, Object select1, Object select2, Table table, String attr1, String attr2) {
        ColorDefined color = new ColorDefined();
        Random r = new Random();
        selectFunc = new JButton(label);
        selectFunc.setBackground(color.getSefunCol()[r.nextInt(11)]);
        selectFunc.addMouseListener(new MouseListenSqlSelect(funcName, select1, select2, table, attr1, attr2));
        Font f = new Font("Go Mono for Powerline.ttf", Font.PLAIN, 23);
        selectFunc.setFont(f);
        selectFunc.setSize(50, 25);
        return selectFunc;
    }


    public JButton createSelectButtonBasicChart(String label, String funcName, BasicTableSelect select, Table table) {
        ColorDefined color = new ColorDefined();
        Random r = new Random();
        selectFunc = new JButton(label);
        selectFunc.setBackground(color.getSefunCol()[r.nextInt(11)]);
        selectFunc.addMouseListener(new MouseListenSqlSelectBaseChart(funcName, select, table));
        Font f = new Font("Go Mono for Powerline.ttf", Font.PLAIN, 23);
        selectFunc.setFont(f);
        selectFunc.setSize(50, 25);
        return selectFunc;
    }


    public JButton createUpdateButton(String label, Table table) {
        ColorDefined color = new ColorDefined();
        Random r = new Random();
        updataFunc = new JButton(label);
        updataFunc.setBackground(color.getSefunCol()[r.nextInt(11)]);
        Font f = new Font("Go Mono for Powerline.ttf", Font.PLAIN, 20);
        updataFunc.setFont(f);
        updataFunc.setSize(25, 25);
        return updataFunc;
    }
}
