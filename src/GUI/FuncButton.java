package GUI;

import SQL.BasicTableSelect;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FuncButton {
    private JButton selectFunc = null;
    private JButton updataFunc = null;
    private JButton[] colorEnhance=null;
    public JButton getSelectFunc() {
        return selectFunc;
    }

    public JButton getUpdataFunc() {
        return updataFunc;
    }

    public void setColorEnhance(JButton[] colorEnhance) {
        this.colorEnhance = colorEnhance;
    }

    public JButton[] getColorEnhance(){
        return colorEnhance;
    }

    public JButton createSelectButton(Color color, String label, String funcName, Object select1, Object select2, Table table, String attr1, String attr2) {
        Random r = new Random();
        selectFunc = new JButton(label);
        selectFunc.setBackground(color);
        selectFunc.addMouseListener(new MouseListenSqlSelect(funcName, select1, select2, table, attr1, attr2));
        Font f = new Font("Go Mono for Powerline.ttf", Font.PLAIN, 23);
        selectFunc.setFont(f);
        selectFunc.setSize(50, 25);
        return selectFunc;
    }


    public JButton createSelectButtonBasicChart(Color color,String label, String funcName, BasicTableSelect select, Table table) {
        Random r = new Random();
        selectFunc = new JButton(label);
        selectFunc.setBackground(color);
        selectFunc.addMouseListener(new MouseListenSqlSelectBaseChart(funcName, select, table));
        Font f = new Font("Go Mono for Powerline.ttf", Font.PLAIN, 23);
        selectFunc.setFont(f);
        selectFunc.setSize(50, 25);
        return selectFunc;
    }


    public JButton createUpdateButton(Color color,String label, Table table) {
        updataFunc = new JButton(label);
        updataFunc.setBackground(color);
        Font f = new Font("Go Mono for Powerline.ttf", Font.PLAIN, 20);
        updataFunc.setFont(f);
        updataFunc.setSize(25, 25);
        return updataFunc;
    }
}
