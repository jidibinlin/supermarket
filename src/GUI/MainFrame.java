package GUI;

import javax.swing.*;
import java.awt.*;
import SQL.*;
import javafx.scene.control.Tab;

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
        control.tabAdd();//向控制面板中添加tab

        mainframe.add(control.getControlPanel(), BorderLayout.NORTH);//将控制面板添加到主界面的最上方
        mainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//防止worning窗口关闭主窗口

        FuncPanel[] funcPanel = {new FuncPanel(), new FuncPanel(), new FuncPanel(), new FuncPanel(), new FuncPanel(), new FuncPanel(),};//5张卡片

        //funcPanel[0].selectFuncPanel(productFuncButtonadd(funcPanel[0].getTable()),productFuncButtonadd(funcPanel[0].getTable()).length);
        //funcPanel[1].selectFuncPanel(employeeFuncButtonadd(funcPanel[1].getTable()),employeeFuncButtonadd(funcPanel[1].getTable()).length);
        //funcPanel[2].selectFuncPanel(storeManaeFuncButtonadd(funcPanel[2].getTable()),storeManaeFuncButtonadd(funcPanel[2].getTable()).length);
        funcPanel[3].selectFuncPanel(financeFuncButtonadd(funcPanel[3].getTable()),financeFuncButtonadd(funcPanel[3].getTable()).length);//财务管理功能按钮
        //funcPanel[4].selectFuncPanel(productFuncButtonadd(funcPanel[4].getTable()),productFuncButtonadd(funcPanel[4].getTable()).length);
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

    private JButton[] financeFuncButtonadd(Table table){

        JButton [] selecFunc={
                new FuncButton().createSelectButton("销量统计","selesVolumeOrder",new FinanceManage(),new FinanceManage(),table,new String(),new String()),
                new FuncButton().createSelectButton("某日销量","apponitedDateCheck",new FinanceManage(),new FinanceManage(),table,"日期",new String()),
                new FuncButton().createSelectButton("销量比较","apppnitedProductCompare",new FinanceManage(),new FinanceManage(),table,"产品名1","产品名2"),
                new FuncButton().createSelectButton("同类产品销量","compareWithSameKind",new FinanceManage(),null,table,"类型",new String()),
                new FuncButton().createSelectButton("整体盈利","wholeProfitManage",new FinanceManage(),null,table,new String(),new String()),
                new FuncButton().createSelectButton("日期段盈利","apponitedProfitManage",new FinanceManage(),null,table,"起始日期","截止日期"),
                new FuncButton().createSelectButton("指定商品盈利","apponitedProductProfit",new FinanceManage(),null,table,"商品名",new String()),
//                new FuncButton().createSelectButton("商品盈利","apponitedProductProfit",new FinanceManage(),null,table),
//                new FuncButton().createSelectButton("商品盈利比较","compareProductProfit",new FinanceManage(),null,table),
//                new FuncButton().createSelectButton("当前盈亏","selectProfitFornow",new FinanceManage(),null,table),
        };
        return selecFunc;
    }

    private JButton[] employeeFuncButtonadd(Table table){
        JButton [] selectFunc={

        };
        return selectFunc;
    }

    private JButton[] guestInfoFuncButtonadd(Table table){
        JButton [] selectFunc={

        };
        return selectFunc;
    }

    private JButton[] productFuncButtonadd(Table table){
        JButton [] selectFunc={

        };
        return selectFunc;
    }

    private JButton[] storeManaeFuncButtonadd(Table table){
        JButton[] selectFunc={

        };
        return selectFunc;
    }

    private void showScrollPanelFunc(FuncPanel[] funcPanel) {
        String[] color = {"blue", "grey", "brown", "green", "orange"};
        for (int i = 0; i < 5; i++) {
            funcPanel[i].chartShowPanel(color[i]);
        }
    }
}
