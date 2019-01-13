package GUI;

import javax.swing.*;
import java.awt.*;
import SQL.*;
import com.sun.deploy.ui.FancyButton;
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

        funcPanel[0].selectFuncPanel(productFuncButtonadd(funcPanel[0].getTable()),productFuncButtonadd(funcPanel[0].getTable()).length);
        funcPanel[0].chartChosePanel(basicChartButtonadd(funcPanel[0].getTable()),basicChartButtonadd(funcPanel[0].getTable()).length);
        funcPanel[0].updateFuncPanel(updateFuncButtonadd(funcPanel[0].getTable()));
        funcPanel[1].selectFuncPanel(employeeFuncButtonadd(funcPanel[1].getTable()),employeeFuncButtonadd(funcPanel[1].getTable()).length);
        funcPanel[1].chartChosePanel(basicChartButtonadd(funcPanel[1].getTable()),basicChartButtonadd(funcPanel[1].getTable()).length);
        funcPanel[1].updateFuncPanel(updateFuncButtonadd(funcPanel[1].getTable()));
        funcPanel[2].selectFuncPanel(storeManaeFuncButtonadd(funcPanel[2].getTable()),storeManaeFuncButtonadd(funcPanel[2].getTable()).length);
        funcPanel[2].chartChosePanel(basicChartButtonadd(funcPanel[2].getTable()),basicChartButtonadd(funcPanel[2].getTable()).length);
        funcPanel[2].updateFuncPanel(updateFuncButtonadd(funcPanel[2].getTable()));
        funcPanel[3].selectFuncPanel(financeFuncButtonadd(funcPanel[3].getTable()),financeFuncButtonadd(funcPanel[3].getTable()).length);//财务管理功能按钮
        funcPanel[3].chartChosePanel(basicChartButtonadd(funcPanel[3].getTable()),basicChartButtonadd(funcPanel[3].getTable()).length);
        funcPanel[3].updateFuncPanel(updateFuncButtonadd(funcPanel[3].getTable()));
        funcPanel[4].selectFuncPanel(productFuncButtonadd(funcPanel[4].getTable()),productFuncButtonadd(funcPanel[4].getTable()).length);
        funcPanel[4].chartChosePanel(basicChartButtonadd(funcPanel[4].getTable()),basicChartButtonadd(funcPanel[4].getTable()).length);
        funcPanel[4].updateFuncPanel(updateFuncButtonadd(funcPanel[4].getTable()));
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

    private JButton[] basicChartButtonadd(Table table){
        JButton[] basicChartFunc={
                new FuncButton().createSelectButtonBasicChart("部门表","Department",new BasicTableSelect(),table),
                new FuncButton().createSelectButtonBasicChart("部门领导表","Director",new BasicTableSelect(),table),
                new FuncButton().createSelectButtonBasicChart("职工表","Employee",new BasicTableSelect(),table),
                new FuncButton().createSelectButtonBasicChart("客户表","Guest",new BasicTableSelect(),table),
                new FuncButton().createSelectButtonBasicChart("工种表","JobKind",new BasicTableSelect(),table),
                new FuncButton().createSelectButtonBasicChart("厂家表","Manu",new BasicTableSelect(),table),
                new FuncButton().createSelectButtonBasicChart("商品表","Product",new BasicTableSelect(),table),
                new FuncButton().createSelectButtonBasicChart("进货表","Purchase",new BasicTableSelect(),table),
                new FuncButton().createSelectButtonBasicChart("购物表","Shopping",new BasicTableSelect(),table),
                new FuncButton().createSelectButtonBasicChart("VIP","VIP",new BasicTableSelect(),table),
        };
        return basicChartFunc;
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

    private JButton[] updateFuncButtonadd(Table table){
        JButton [] updateUpdate={
                new FuncButton().createUpdateButton("插入",table),
                new FuncButton().createUpdateButton("更新",table),
                new FuncButton().createUpdateButton("删除",table),
                new FuncButton().createUpdateButton("提交",table)
        };
        return updateUpdate;
    }

    private JButton[] employeeFuncButtonadd(Table table) {
        JButton[] selectFunc = {
                new FuncButton().createSelectButton("工种查询", "jobKindQuery", new EmployeeManage(), null, table, "工种", new String()),
                new FuncButton().createSelectButton("查询指定薪水的职位", "appointedSalaryCheck", new EmployeeManage(), null, table, "职位", new String()),
                new FuncButton().createSelectButton("查询指定员工的工种及薪水", "appointedEmNameCheck", new EmployeeManage(), null, table, "员工编号", new String()),
                new FuncButton().createSelectButton("按性别查询部门信息", "appointedSexCheckDpartment", new EmployeeManage(), null, table, "员工性别", new String()),
                new FuncButton().createSelectButton("通过员工姓名查询员工相关信息", "selectEmployeeInfoByName", new EmployeeManage(), null, table, "员工姓名", new String()),
        };
        return selectFunc;
    }

    private JButton[] guestInfoManage(Table table){
        JButton [] selectFunc={
                new FuncButton().createSelectButton("按vip等级查询客户","selectGuestByViplevel",new GuestInfoManage(),null,table,"vip等级",new String()),
                new FuncButton().createSelectButton("查询积分大于某一分段的客户","checkScoreByGuestNum",new GuestInfoManage(),null,table,"积分分数",new String()),
                new FuncButton().createSelectButton("通过客户码查询积分","checkScoreByGuestName",new GuestInfoManage(),null,table,"客户码",new String()),
                new FuncButton().createSelectButton("通过客户名查询积分","selectGuestByAppointedScore",new GuestInfoManage(),null,table,"客户名",new String()),
                new FuncButton().createSelectButton("vip查询","connectGuestWithVIP",new GuestInfoManage(),null,table,new String(),new String()),
                new FuncButton().createSelectButton("按客户名查询积分金钱比例","checkMoneyRateByName",new GuestInfoManage(),null,table,"客户姓名",new String()),
                new FuncButton().createSelectButton("查询指定等级的vip积分兑换比例","checkMoneyRateAppointedLevel",new GuestInfoManage(),null,table,"vip等级",new String()),
        };
        return selectFunc;
    }

    private JButton[] productFuncButtonadd(Table table){
        JButton [] selectFunc={
                new FuncButton().createSelectButton("指定类商品的商品名和商品号","selectApponitedProductInfo",new ProductManage(),null,table,"商品",new String()),
                new FuncButton().createSelectButton("特定价格以上的商品信息","selectApponitedPriceProduct",new ProductManage(),null,table,"指定价格",new String()),
                new FuncButton().createSelectButton("全部商品的供应商","selectManuOfProduct",new ProductManage(),null,table,new String(),new String()),
                new FuncButton().createSelectButton("某个商品的供应商","selectManuOfApponitedProduct",new ProductManage(),null,table,"商品名",new String()),
                new FuncButton().createSelectButton("全部商品的产地","selectProductLoc",new ProductManage(),null,table,new String(),new String()),
        };
        return selectFunc;
    }

    private JButton[] storeManaeFuncButtonadd(Table table){
        JButton[] selectFunc={
                new FuncButton().createSelectButton("供货商信息","manuInfoSelect",new StoreManage(),null,table,new String(),new String()),
                new FuncButton().createSelectButton("查询指定供货商","selectAllProductFromApponitedManu",new StoreManage(),null,table,"供货商编号",new String()),
                new FuncButton().createSelectButton("查询商品供货信息","selectSameKindManu",new StoreManage(),null,table,"商品编号",new String()),
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
