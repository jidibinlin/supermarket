package GUI;

import javax.jws.Oneway;
import javax.swing.*;
import SQL.*;

import java.awt.*;
import java.math.*;

import java.util.Random;
import java.util.Vector;

public class FuncButton {
    private JButton selectFunc =null;
    private JButton updataFunc =null;

    public JButton getSelectFunc() {
        return selectFunc;
    }

    public JButton getUpdataFunc() {
        return updataFunc;
    }

    public JButton createSelectButton(String label,String funcName,Object select1,Object select2, Table table){
        ColorDefined color=new ColorDefined();
        Random r=new Random();
        selectFunc=new JButton(label);
        selectFunc.setBackground(color.getSefunCol()[r.nextInt(14)]);
        selectFunc.addMouseListener(new MouseListenSqlSelect(funcName,select1,select2,table));
        Font f=new Font("Go Mono for Powerline.ttf",Font.PLAIN,20);
        selectFunc.setPreferredSize(new Dimension(300,50));
        return selectFunc;
    }
}
