package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TabSwitch extends MouseAdapter {//选项卡切换

    CardLayout carLayout = null;
    JButton tab = null;
    JPanel CardPanel_funcPanel = null;
    JPanel CardPanel = null;

    TabSwitch() {
    }

    ;

    TabSwitch(CardLayout carlayout, JButton tab, JPanel CardPanel, JPanel CardPanel_funcPanel) {
        this.carLayout = carlayout;
        this.tab = tab;
        this.CardPanel_funcPanel = CardPanel_funcPanel;
        this.CardPanel = CardPanel;
    }

    public void mousePressed(MouseEvent e) {//选项卡鼠标事件监听
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
            carLayout.show(CardPanel, tab.getText());
        }

        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {

            System.out.println("left button pressed twice");
        }

        if (e.getButton() == MouseEvent.BUTTON2) {
            System.out.printf("right button pressed");
        }
    }


}
