package GUI;

import javax.swing.*;

public class MainFrame {
    private JFrame mainframe = new JFrame("Supmarket Manager System");

    private JPanel control = null;

    public JFrame getMainframe() {
        return mainframe;
    }

    void setFrameSize() {
        mainframe.setSize(1300, 1000);//设置界面大小
        mainframe.setLocation(300, 100);
        mainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//防止worning窗口关闭主窗口
        mainframe.setVisible(true);
        closeWindow();
    }

    private void closeWindow() {
        mainframe.addWindowListener(new CloseWindowSpecial());
    }

}
