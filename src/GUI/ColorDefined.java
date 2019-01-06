package GUI;

import javax.swing.*;
import java.awt.*;

public class ColorDefined {
    private Color blue=new Color(147,224,225);
    private Color grey=new Color(151,151,151);
    private Color brown=new Color(91,74,66);
    private Color green=new Color(179,197,135);
    private Color orange=new Color(220,87,18);


    public Color getColor(String chose){
        switch(chose){
            case "blue": return this.blue;
            case "grey": return this.grey;
            case "brown": return this.brown;
            case "green": return this.green;
            case "orange":return this.orange;
        }
        return this.blue;
    }
}
