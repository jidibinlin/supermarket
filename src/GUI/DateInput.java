package GUI;

import javax.swing.*;
import java.util.ArrayList;

public class DateInput{
    private String[] attribete=null;
    private ArrayList tips=new ArrayList();
    private JDialog input=new JDialog(GUI.mainframe.getMainframe(),true);
    private ArrayList inputField=new ArrayList();
    public JButton sure=new JButton("确定");
    public JButton back=new JButton("返回");
    public String[] getAttribete() {
        return attribete;
    }

    public JDialog getInput(){
        return input;
    }
    public DateInput(String [] attribete){
        this.attribete=attribete;
    }

    public ArrayList getInputField(){
        return inputField;
    }


    public void getDateUI(){

        input.setLocation(300,400);
        input.setLocationRelativeTo(GUI.mainframe.getMainframe());
        for(int i=0;i<attribete.length;i++){
            tips.add(new JLabel(attribete[i]));
            inputField.add(new JTextField(30));
        }
        Layout.getDateUIlayout(sure,back,attribete,tips,inputField,input);
    }
}