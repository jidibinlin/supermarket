package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import SQL.*;

public class login {
    JTextField userNameInput = new JTextField();//用户名输入框
    JPasswordField passwordInput = new JPasswordField();
    JFrame loginUI = new JFrame();
    JButton sure = new JButton("登陆");
    JButton exit = new JButton("退出");
    String password = null;

    public void logInUi() {
        loginUI.setSize(250, 200);
        loginUI.setLocation(500, 300);
        JLabel userNameLabel = new JLabel("username");
        JLabel passwdLabel = new JLabel("passwd");
        userNameInput.setColumns(13);
        passwordInput.setColumns(13);
        Layout.loginLayout(loginUI, userNameLabel, userNameInput, passwdLabel, passwordInput, sure, exit);
        loginUI.setVisible(true);
        sure.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {

                    password=new login_sql().Login(userNameInput.getText());

                    if (passwordInput.getPassword().equals(password)) {
                        loginUI.dispose();
                        GUI g = new GUI();//important
                        g.integrate();//important
                    } else {
                        JDialog fail = new JDialog(loginUI, true);
                        JLabel notice = new JLabel("密码或用户名错误");
                        notice.setSize(new Dimension(40,20));
                        fail.setLocationRelativeTo(loginUI);
                        fail.setLayout(new FlowLayout());
                        fail.add(notice);
                        fail.setSize(150,100);
                        fail.setVisible(true);
                    }
                }
            }
        });


        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    loginUI.dispose();
                    System.exit(0);
                }
            }
        });
    }
}
