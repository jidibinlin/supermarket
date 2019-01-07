package GUI;

import javax.swing.*;
import javax.swing.border.Border;
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
        ColorDefined color=new ColorDefined();
        mainframe.setBackground(color.getColor("blue"));
        ControlPanel control=new ControlPanel();
        control.tabAdd();
        mainframe.add(control.getControlPanel(), BorderLayout.NORTH);
        mainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//防止worning窗口关闭主窗口
        CardPanel cardMother=new CardPanel();
        cardMother.setCardPanel();
        this.switchadd(cardMother.getLayout(),control.getTab(),cardMother.getCardPanel(),cardMother.getCardPanel_funcPanel());

        mainframe.add(cardMother.getCardPanel(),BorderLayout.CENTER);
        mainframe.setVisible(true);
        closeWindow();
    }


    void switchadd(CardLayout carlayout,JButton[] tab,JPanel CardPanel,JPanel[] CardPanel_funcPanel){
        for(int i=0;i<5;i++){
            tab[i].addMouseListener(new TabSwitch(carlayout,tab[i],CardPanel,CardPanel_funcPanel[i]));
        }
    }

    private void closeWindow() {
        mainframe.addWindowListener(new CloseWindowSpecial());
    }
}
