package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    Color[] bgColor = {new Color(147, 224, 255), new Color(151, 151, 151),
            new Color(91, 74, 66), new Color(179, 197, 135),
            new Color(220, 87, 18)};//色彩数组
    JButton[] tab = {new JButton("商户信息管理"), new JButton("库存管理"),
            new JButton("商品管理"), new JButton("财务管理"),
            new JButton("员工管理"),};//选项卡
    JPanel control = new JPanel();//选项卡容器
    JFrame mainframe = new JFrame("mainframe");//用于承载功能模块的frame
    JPanel[] pan = new JPanel[6];//功能模块
    CardLayout carlayout = null;//卡片布局管理
    String[] panName = {"guestManage", "storeManage", "proManage", "moneyManage", "empManage"};//卡片名称

    public void mainInterface() {
        mainframe.setSize(1300, 1000);//设置界面大小
        mainframe.setLocation(300, 100);
        mainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//防止worning窗口关闭主窗口
        FunctionModel func_card=new FunctionModel();
        func_card.add(pan, bgColor, panName);

        carlayout = Layout.mainInterfaceLayout(mainframe, pan, panName);
        for(int i=1;i<6;i++){
            Layout.funcLayout(pan[i],FunctionModel.addfunchild());
        }
        TabSwitch top = new TabSwitch();
        for (int i = 0; i < 5; i++)
            tab[i].addMouseListener(new TabSwitch(carlayout, tab[i], pan[0]));
        top.tabAdd(carlayout, control, panName, bgColor, tab);

        mainframe.setVisible(true);
        control.setVisible(true);

        mainframe.add(control, BorderLayout.NORTH);
        CloseWindowSpecial ls = new CloseWindowSpecial();//主界面窗体关闭
        mainframe.addWindowListener(ls);
    }

}

class CloseWindowSpecial extends WindowAdapter {//主窗口时间监听

    public void windowClosing(WindowEvent e) {
        JFrame fratran = (JFrame) e.getComponent();
        NoticeCloseSureDialog.CloseSure(fratran);
    }
}

class MouseListen extends MouseAdapter {//鼠标事件监听总类

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
            System.out.println("left button pressed once");
        }

        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {

            System.out.println("left button pressed twice");
        }


        if (e.getButton() == MouseEvent.BUTTON2) {
            System.out.printf("right button pressed");
        }
    }
}

class NoticeCloseSureDialog {//worning 对话框

    static void CloseSure(JFrame fratran) {
        JDialog closeSureDia = new JDialog(fratran, true);
        closeSureDia.setTitle("warning");
        closeSureDia.setLocationRelativeTo(fratran);
        closeSureDia.setSize(300, 200);
        JButton Exit = new JButton("Exit");
        Exit.setBackground(Color.red);
        JButton back = new JButton("back");
        back.setBackground(Color.green);
        JLabel message = new JLabel();
        message.setText("you really want to exit?");
        Layout.NoticeLayout(closeSureDia, Exit, back, message);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeSureDia.dispose();
                fratran.dispose();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeSureDia.dispose();
            }
        });
        closeSureDia.setVisible(true);
    }
}

