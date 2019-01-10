package GUI;

import javax.swing.*;
import java.util.ArrayList;

public class DateInput{
    private String[] attribete=null;
    private JLabel[] tips={new JLabel(),new JLabel(),new JLabel()};
    private JDialog input=new JDialog(GUI.mainframe.getMainframe(),true);
    private JTextField[] inputField={new JTextField(10),new JTextField(10),new JTextField(10)};

    public String[] getAttribete() {
        return attribete;
    }

    public DateInput(String [] attribete){
        this.attribete=attribete;
    }

    public JTextField[] getInputField(){
        return inputField;
    }


    public void getDateUI(){
        JButton sure=new JButton("确定");
        JButton back=new JButton("返回");
        input.setLocation(300,400);
        input.setLocationRelativeTo(GUI.mainframe.getMainframe());
        for(int i=0;i<attribete.length;i++){
            tips[i].setText(attribete[i]);
        }
        Layout.getDateUIlayout(sure,back,attribete,tips,inputField,input);
        //sure.addMouseListener();
        //sure.addMouseListener();
    }
}