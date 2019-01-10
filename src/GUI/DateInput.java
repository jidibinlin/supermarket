package GUI;

import javax.swing.*;
import java.util.ArrayList;

public class DateInput{
    private String[] attribete=null;
    private ArrayList tips=new ArrayList();
    private JDialog input=new JDialog(GUI.mainframe.getMainframe(),true);
    private ArrayList inputField=new ArrayList();

    public String[] getAttribete() {
        return attribete;
    }

    public DateInput(String [] attribete){
        this.attribete=attribete;
    }

    public ArrayList getInputField(){
        return inputField;
    }


    public void getDateUI(){
        JButton sure=new JButton("确定");
        JButton back=new JButton("返回");
        input.setLocation(300,400);
        input.setLocationRelativeTo(GUI.mainframe.getMainframe());
        for(int i=0;i<attribete.length;i++){
            tips.add(new JLabel(attribete[i]));
            inputField.add(new JTextField(13));
        }
        Layout.getDateUIlayout(sure,back,attribete,tips,inputField,input);
        //sure.addMouseListener();
        //sure.addMouseListener();
    }
}