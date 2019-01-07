package GUI;

import javax.swing.*;
import java.awt.*;

public class ColorDefined {
    private Color blue=new Color(147,224,225);
    private Color grey=new Color(225,233,220);
    private Color brown=new Color(224,160,158);
    private Color green=new Color(179,197,135);
    private Color orange=new Color(243,244,246);


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
