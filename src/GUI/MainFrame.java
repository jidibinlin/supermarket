package GUI;

import SQL.*;

import javax.swing.*;
import java.awt.*;

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

        FuncPanel[] funcPanel = {new FuncPanel(), new FuncPanel(), new FuncPanel(), new FuncPanel(), new FuncPanel(), new FuncPanel()};//6张卡片

        funcPanel[0].selectFuncPanel(productFuncButtonadd(funcPanel[0].getTable()), productFuncButtonadd(funcPanel[0].getTable()).length);

        funcPanel[1].selectFuncPanel(employeeFuncButtonadd(funcPanel[1].getTable()), employeeFuncButtonadd(funcPanel[1].getTable()).length);

        funcPanel[2].selectFuncPanel(storeManaeFuncButtonadd(funcPanel[2].getTable()), storeManaeFuncButtonadd(funcPanel[2].getTable()).length);

        funcPanel[3].selectFuncPanel(financeFuncButtonadd(funcPanel[3].getTable()), financeFuncButtonadd(funcPanel[3].getTable()).length);//财务管理功能按钮

        funcPanel[4].selectFuncPanel(guestInfoButtonadd(funcPanel[4].getTable()), guestInfoButtonadd(funcPanel[4].getTable()).length);

        funcPanel[5].selectFuncPanel(basicChartButtonadd(funcPanel[5].getTable()),basicChartButtonadd(funcPanel[5].getTable()).length);
        funcPanel[5].updateFuncPanel(updateFuncButtonadd(funcPanel[5].getTable()));


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
        for (int i = 0; i < 6; i++) {
            tab[i].addMouseListener(new TabSwitch(carlayout, tab[i], CardPanel, CardPanel_funcPanel[i]));
        }
    }

    private void funcchildadd(CardPanel cardMother, FuncPanel[] funcPanel) {
        for (int i = 0; i < 6; i++) {
            if(i!=5)
                Layout.funcLayout(cardMother.getCardPanel_funcPanel()[i], funcPanel[i].getfuncPanel());
            else
                Layout.funcLayout2(cardMother.getCardPanel_funcPanel()[i],funcPanel[i].getfuncPanel());
        }
    }

    private JButton[] basicChartButtonadd(Table table) {
        JButton[] basicChartFunc = {
                new FuncButton().createSelectButtonBasicChart(new ColorDefined().getColor("pink"),"部门表", "Department", new BasicTableSelect(), table),
                new FuncButton().createSelectButtonBasicChart(new ColorDefined().getColor("pink"),"部门领导表", "Director", new BasicTableSelect(), table),
                new FuncButton().createSelectButtonBasicChart(new ColorDefined().getColor("pink"),"职工表", "Employee", new BasicTableSelect(), table),
                new FuncButton().createSelectButtonBasicChart(new ColorDefined().getColor("pink"),"客户表", "Guest", new BasicTableSelect(), table),
                new FuncButton().createSelectButtonBasicChart(new ColorDefined().getColor("pink"),"工种表", "JobKind", new BasicTableSelect(), table),
                new FuncButton().createSelectButtonBasicChart(new ColorDefined().getColor("pink"),"厂家表", "Manu", new BasicTableSelect(), table),
                new FuncButton().createSelectButtonBasicChart(new ColorDefined().getColor("pink"),"商品表", "Product", new BasicTableSelect(), table),
                new FuncButton().createSelectButtonBasicChart(new ColorDefined().getColor("pink"),"进货表", "Purchase", new BasicTableSelect(), table),
                new FuncButton().createSelectButtonBasicChart(new ColorDefined().getColor("pink"),"购物表", "Shopping", new BasicTableSelect(), table),
                new FuncButton().createSelectButtonBasicChart(new ColorDefined().getColor("pink"),"VIP", "VIP", new BasicTableSelect(), table),
        };
        return basicChartFunc;
    }

    private JButton[] updateFuncButtonadd(Table table) {
        JButton[] updateUpdate = {
                new FuncButton().createUpdateButton(new Color(174,221,129),"插入", table),
                new FuncButton().createUpdateButton(new Color(174,221,129),"更新", table),
                new FuncButton().createUpdateButton(new Color(174,221,129),"删除", table),
                new FuncButton().createUpdateButton(new Color(247,68,97),"提交", table)
        };
        TableEvent tableEvent = new TableEvent(table, updateUpdate[0], updateUpdate[1], updateUpdate[2], updateUpdate[3]);
        tableEvent.execute();
        return updateUpdate;
    }


    private JButton[] productFuncButtonadd(Table table) {
        JButton[] selectFunc = {
                new FuncButton().createSelectButton(new ColorDefined().getColor("blue"),"按类查询商品", "selectApponitedProductInfo", new ProductManage(), null, table, "商品类", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("blue"),"价格-商品匹配", "selectApponitedPriceProduct", new ProductManage(), null, table, "指定价格", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("blue"),"供应商全局查询", "selectManuOfProduct", new ProductManage(), null, table, new String(), new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("blue"),"商品-供应商匹配", "selectManuOfApponitedProduct", new ProductManage(), null, table, "商品名", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("blue"),"商品-产地匹配", "selectProductLoc", new ProductManage(), null, table, new String(), new String()),
        };
        return selectFunc;
    }


    private JButton[] employeeFuncButtonadd(Table table) {
        JButton[] selectFunc = {
                new FuncButton().createSelectButton(new ColorDefined().getColor("grey"),"工种查询", "jobKindQuery", new EmployeeManage(), null, table, "工种", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("grey"),"薪水-职位匹配", "appointedSalaryCheck", new EmployeeManage(), null, table, "薪水", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("grey"),"员工工种薪水查询", "appointedEmNameCheck", new EmployeeManage(), null, table, "员工姓名", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("grey"),"性别-部门匹配", "appointedSexCheckDpartment", new EmployeeManage(), null, table, "员工性别", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("grey"),"员工信息查询", "selectEmployeeInfoByName", new EmployeeManage(), null, table, "员工姓名", new String()),
        };
        return selectFunc;
    }


    private JButton[] storeManaeFuncButtonadd(Table table) {
        JButton[] selectFunc = {
                new FuncButton().createSelectButton(new ColorDefined().getColor("brown"),"供货商信息", "manuInfoSelectByName", new StoreManage(), null, table, "供货商名", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("brown"),"所有商品库存量", "AllProductsRemain", new StoreManage(), null, table, "", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("brown"),"指定商品库存量", "AppointedProductsRemain", new StoreManage(), null, table, "商品名", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("brown"),"指定商品类库存", "ConutsAppointedType", new StoreManage(), null, table, "商品类", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("brown"),"供货商产品查询", "selectAllProductFromApponitedManu", new StoreManage(), null, table, "供货商名", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("brown"),"某商品厂家信息", "selectSameKindManu", new StoreManage(), null, table, "商品名（模糊查询）", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("brown"),"指定库存量以上商品", "AppointedRemainProduct", new StoreManage(), null, table, "库存量", new String()),
        };
        return selectFunc;
    }


    private JButton[] financeFuncButtonadd(Table table) {

        JButton[] selecFunc = {
                new FuncButton().createSelectButton(new ColorDefined().getColor("green"),"销量统计", "selesVolumeOrder", new FinanceManage(), new FinanceManage(), table, new String(), new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("green"),"某日销量", "apponitedDateCheck", new FinanceManage(), new FinanceManage(), table, "日期", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("green"),"销量比较", "apponitedProductCompare", new FinanceManage(), new FinanceManage(), table, "产品名1", "产品名2"),
                new FuncButton().createSelectButton(new ColorDefined().getColor("green"),"同类产品销量", "compareWithSameKind", new FinanceManage(), null, table, "类型", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("green"),"整体盈利", "wholeProfitManage", new FinanceManage(), null, table, new String(), new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("green"),"日期段盈利", "apponitedProfitManage", new FinanceManage(), null, table, "起始日期", "截止日期"),
                new FuncButton().createSelectButton(new ColorDefined().getColor("green"),"指定商品盈利", "apponitedProductProfit", new FinanceManage(), null, table, "商品名", new String()),
        };
        return selecFunc;
    }


    private JButton[] guestInfoButtonadd(Table table) {
        JButton[] selectFunc = {
                new FuncButton().createSelectButton(new ColorDefined().getColor("orange"),"等级—客户匹配", "selectGuestByViplevel", new GuestInfoManage(), null, table, "vip等级", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("orange"),"积分-客户匹配", "selectGuestByAppointedScore", new GuestInfoManage(), null, table, "积分分数", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("orange"),"客户码-积分匹配", "checkScoreByGuestNum", new GuestInfoManage(), null, table, "客户码", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("orange"),"客户名-积分匹配", "checkScoreByGuestName", new GuestInfoManage(), null, table, "客户名", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("orange"),"vip查询", "connectGuestWithVIP", new GuestInfoManage(), null, table, new String(), new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("orange"),"客户-金钱比匹配", "checkMoneyRateByName", new GuestInfoManage(), null, table, "客户姓名", new String()),
                new FuncButton().createSelectButton(new ColorDefined().getColor("orange"),"等级-兑换比匹配", "checkMoneyRateAppointedLevel", new GuestInfoManage(), null, table, "vip等级", new String()),
        };
        return selectFunc;
    }


    private void showScrollPanelFunc(FuncPanel[] funcPanel) {
        String[] color = {"blue", "grey", "brown", "green", "orange","pink"};
        for (int i = 0; i < 6; i++) {
            funcPanel[i].chartShowPanel(color[i]);
        }
    }
}
