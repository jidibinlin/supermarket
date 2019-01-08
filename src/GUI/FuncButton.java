package GUI;

import javax.swing.*;
import SQL.*;

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

    public JButton createSelectButton(String label, Vector[] resu,Vector[] resu2,Table table){
        selectFunc=new JButton(label);
        selectFunc.addMouseListener(new MouseListenSqlSelect(resu,resu2,table));
        return selectFunc;
    }
}
