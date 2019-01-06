package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NoticeCloseSureDialog {//worning 对话框

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
class CloseWindowSpecial extends WindowAdapter {//主窗口时间监听

    public void windowClosing(WindowEvent e) {
        JFrame fratran = (JFrame) e.getComponent();
        NoticeCloseSureDialog.CloseSure(fratran);
    }
}
