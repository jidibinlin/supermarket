package GUI;

import javax.swing.*;
import java.awt.*;

public class CardPanel {
    private JPanel CardPanel = new JPanel();
    private JPanel[] CardPanel_funcPanel = {new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel()};
    private CardLayout layout = null;

    public JPanel getCardPanel() {
        return CardPanel;
    }

    public JPanel[] getCardPanel_funcPanel() {
        return CardPanel_funcPanel;
    }

    public CardLayout getLayout() {
        return this.layout;
    }

    public void setCardPanel() {
        ColorDefined color = new ColorDefined();
        CardPanel_funcPanel[0].setBackground(color.getColor("blue"));
        CardPanel_funcPanel[1].setBackground(color.getColor("grey"));
        CardPanel_funcPanel[2].setBackground(color.getColor("brown"));
        CardPanel_funcPanel[3].setBackground(color.getColor("green"));
        CardPanel_funcPanel[4].setBackground(color.getColor("orange"));
        layout = Layout.mainInterfaceLayout(CardPanel, CardPanel_funcPanel);//设置卡片布局
    }

}

class ControlPanel {
    private JPanel controlPanel = new JPanel();
    private JButton[] tab = {new JButton("商品管理"), new JButton("员工管理"), new JButton("库存管理"),
            new JButton("财务管理"), new JButton("客户信息管理")};

    public JPanel getControlPanel() {
        return this.controlPanel;
    }

    public JButton[] getTab() {
        return tab;
    }

    public void tabAdd() {//选项卡添加
        ColorDefined color = new ColorDefined();
        GridLayout layout = new GridLayout(1, 5);
        this.controlPanel.setLayout(layout);
        Font f = new Font("Fonts/Go Mono for Powerline.ttf", Font.BOLD, 20);//选项卡自体设置
        layout.setHgap(3);
        layout.setHgap(3);
        String[] Scolor = {"blue", "grey", "brown", "green", "orange"};
        for (int i = 0; i < 5; i++) {
            tab[i].setPreferredSize(new Dimension(100, 60));
            this.controlPanel.add(tab[i]);
            tab[i].setVisible(true);
            tab[i].setFont(f);
            tab[i].setBackground(color.getColor(Scolor[i]));//选项卡背景设置
        }

    }
}
