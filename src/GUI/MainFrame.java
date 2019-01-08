package GUI;

import javax.swing.*;
import java.awt.*;
import SQL.*;

public class MainFrame {
    private JFrame mainframe = new JFrame("Supmarket Manager System");

    private JPanel control = null;

    public JFrame getMainframe() {
        return mainframe;
    }

    void setFrame() {
        mainframe.setSize(1300, 1000);//设置界面大小
        mainframe.setLocation(300, 100);
        ControlPanel control = new ControlPanel();//承载选项卡（tab）的控制面板
        control.tabAdd();//像控制面板中添加tab
        mainframe.add(control.getControlPanel(), BorderLayout.NORTH);//将控制面板添加到主界面的最上方
        mainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//防止worning窗口关闭主窗口
        FuncPanel[] funcPanel = {new FuncPanel(), new FuncPanel(), new FuncPanel(), new FuncPanel(), new FuncPanel(), new FuncPanel(),};//5张卡片
        CardPanel cardMother = new CardPanel();//添加承载卡片的Panel
        cardMother.setCardPanel();//设置卡片颜色和布局
        showScrollPanelFunc(funcPanel);//显示各个功能模块
        this.switchadd(cardMother.getLayout(), control.getTab(), cardMother.getCardPanel(), cardMother.getCardPanel_funcPanel());//选项卡切换功能
        funcchildadd(cardMother, funcPanel);
        mainframe.add(cardMother.getCardPanel(), BorderLayout.CENTER);//将cardMother添加到主界面的中央
        mainframe.setVisible(true);//主界面可见
        closeWindow();
    }

    private void closeWindow() {
        mainframe.addWindowListener(new CloseWindowSpecial());
    }//关闭窗口

    private void switchadd(CardLayout carlayout, JButton[] tab, JPanel CardPanel, JPanel[] CardPanel_funcPanel) {
        for (int i = 0; i < 5; i++) {
            tab[i].addMouseListener(new TabSwitch(carlayout, tab[i], CardPanel, CardPanel_funcPanel[i]));
        }
    }

    private void funcchildadd(CardPanel cardMother, FuncPanel[] funcPanel) {
        for (int i = 0; i < 5; i++) {
            Layout.funcLayout(cardMother.getCardPanel_funcPanel()[i], funcPanel[i].getfuncPanel());
        }
    }

    private void showScrollPanelFunc(FuncPanel[] funcPanel) {
        String[] color = {"blue", "grey", "brown", "green", "orange"};
        for (int i = 0; i < 5; i++) {
            funcPanel[i].chartShowPanel(color[i]);
            funcPanel[i].selectFuncPanel();
        }
    }
}
