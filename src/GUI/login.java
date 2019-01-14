package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login {
    JTextField userNameInput = new JTextField();
    JTextField passwordInput = new JTextField();
    JFrame loginUI = new JFrame();
    JButton sure = new JButton("登陆");
    JButton exit = new JButton("退出");
    String username = null;
    String password = null;

    public login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void logInUi() {
        loginUI.setSize(250, 200);
        loginUI.setLocation(260, 100);
        JLabel userNameLabbel = new JLabel("username");
        JLabel passwdLabel = new JLabel("passwd");
        userNameInput.setColumns(13);
        passwordInput.setColumns(13);
        Layout.loginLayout(loginUI, userNameLabbel, userNameInput, passwdLabel, passwordInput, sure, exit);
        loginUI.setVisible(true);
        sure.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (userNameInput.getText().equals(username) && passwordInput.getText().equals(password)) {
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
