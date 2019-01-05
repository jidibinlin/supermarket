package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Layout {//各个窗口的布局管理
    static void NoticeLayout(JDialog diaTran, JButton Exit, JButton back, JLabel message) {//worning 对话框布局管理
        GridBagLayout layout = new GridBagLayout();
        diaTran.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.RELATIVE;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        layout.setConstraints(Exit, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        layout.setConstraints(back, constraints);
        diaTran.add(Exit);
        diaTran.add(back);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        layout.setConstraints(message, constraints);
        diaTran.add(message);
    }

    static CardLayout mainInterfaceLayout(JFrame fratran, JPanel[] pan,String[] panName) {//主界面卡片布局管理
        CardLayout layout = new CardLayout();
        fratran.add(pan[0], BorderLayout.CENTER);
        pan[0].setLayout(layout);
        pan[0].add(panName[0],pan[1]);
        pan[0].add(panName[1],pan[2]);
        pan[0].add(panName[2],pan[3]);
        pan[0].add(panName[3],pan[4]);
        pan[0].add(panName[4],pan[5]);
        return layout;
    }

    static void funcLayout(JPanel gspve,JScrollPane[] funchild) {//功能模块布局管理
        GridBagLayout layout = new GridBagLayout();
        gspve.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx=1;
        constraints.weighty=4;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.insets=new Insets(0,0,2,2);
        layout.setConstraints(funchild[0],constraints);
        gspve.add(funchild[0]);

        constraints.gridwidth=GridBagConstraints.REMAINDER;
        constraints.gridheight=1;
        constraints.weightx=4;
        constraints.weighty=4;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.insets=new Insets(0,0,2,0);
        layout.setConstraints(funchild[1],constraints);
        gspve.add(funchild[1]);

        constraints.gridwidth=1;
        constraints.gridheight=1;
        constraints.weightx=1;
        constraints.weighty=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.insets=new Insets(0,0,0,2);
        layout.setConstraints(funchild[2],constraints);
        gspve.add(funchild[2]);

        constraints.gridwidth=GridBagConstraints.REMAINDER;
        constraints.gridheight=1;
        constraints.weightx=4;
        constraints.weighty=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.insets=new Insets(0,0,0,0);
        layout.setConstraints(funchild[3],constraints);
        gspve.add(funchild[3]);
    }
}