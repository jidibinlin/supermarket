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

    private void createSelectButton(String label, Vector[] resu,Table table){
        selectFunc=new JButton(label);
        selectFunc.addMouseListener(new MouseListenSqlSelect(resu,table));
    }
}
