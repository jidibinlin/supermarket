package GUI;

import javax.swing.*;
import java.awt.*;

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

    static CardLayout mainInterfaceLayout(JPanel CardPanel, JPanel[] CardPael_funcPanel) {//主界面卡片布局管理
        CardLayout layout = new CardLayout();
        CardPanel.setLayout(layout);
        CardPanel.add("商品管理", CardPael_funcPanel[0]);
        CardPanel.add("员工管理", CardPael_funcPanel[1]);
        CardPanel.add("库存管理", CardPael_funcPanel[2]);
        CardPanel.add("财务管理", CardPael_funcPanel[3]);
        CardPanel.add("客户信息管理", CardPael_funcPanel[4]);
        return layout;
    }

    static JScrollPane[] funcLayout(JPanel gspve, JScrollPane[] funchild) {//功能模块布局管理
        GridBagLayout layout = new GridBagLayout();
        gspve.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 4;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 10, 10);
        layout.setConstraints(funchild[0], constraints);
        gspve.add(funchild[0]);

        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = 1;
        constraints.weightx = 4;
        constraints.weighty = 4;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 10, 0);
        layout.setConstraints(funchild[1], constraints);
        gspve.add(funchild[1]);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 0, 10);
        layout.setConstraints(funchild[2], constraints);
        gspve.add(funchild[2]);

        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = 1;
        constraints.weightx = 4;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 0, 0);
        layout.setConstraints(funchild[3], constraints);
        gspve.add(funchild[3]);
        return funchild;
    }

    static void selectFuncLayout() {

    }

    static void updateFuncLayout() {

    }

    static void chartselectFuncLayout() {

    }

    static void tableFuncLayout(JScrollPane chart, JTable table) {
        chart.setViewportView(table);
        table.setVisible(true);
    }
}