package GUI;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabSwitch extends MouseAdapter{//选项卡切换

    CardLayout carLayout=null;
    JButton tab=null;
    JPanel pan=null;

    TabSwitch(){};
    TabSwitch(CardLayout carlayout,JButton tab,JPanel pan){
        this.carLayout=carlayout;
        this.tab=tab;
        this.pan=pan;
    }

    public void mousePressed(MouseEvent e) {//选项卡鼠标时间监听
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
            carLayout.show(pan,tab.getName());
        }

        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {

            System.out.println("left button pressed twice");
        }

        if (e.getButton() == MouseEvent.BUTTON2) {
            System.out.printf("right button pressed");
        }
    }
    public void tabAdd(CardLayout carlayout,JPanel control,String[] panName,Color[] bgColor,JButton tab[]) {//选项卡添加
        GridLayout layout = new GridLayout(1, 5);
        control.setLayout(layout);
        Font f = new Font("Fonts/Go Mono for Powerline.ttf", Font.BOLD, 20);//选项卡自体设置
        for (int i = 0; i < 5; i++) {
            control.add(tab[i]);
            tab[i].setVisible(true);
            tab[i].setFont(f);
        }

        for (int i = 0; i < 5; i++) {
            //tab[i] = new JButton();
            tab[i].setBackground(bgColor[i]);//选项卡背景设置
            tab[i].setName(panName[i]);
        }
    }

}
