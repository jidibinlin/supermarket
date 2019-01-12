package GUI;

import java.awt.*;

public class ColorDefined {
    private Color blue = new Color(147, 224, 225);
    private Color grey = new Color(225, 233, 220);
    private Color brown = new Color(224, 160, 158);
    private Color green = new Color(179, 197, 135);
    private Color orange = new Color(243, 244, 246);


    private Color[] sefunCol={
            new Color(255,150,128),
            new Color(225,238,210),
            new Color(229,187,129),
            new Color(85,170,173),
            new Color(230,179,61),
            new Color(107,194,53),
            new Color(174,221,129),
            new Color(247,68,97),
            new Color(173,195,192),
            new Color(219,207,202),
            new Color(166,137,202),
            new Color(114,111,128)
    };

    public Color[] getSefunCol(){
        return sefunCol;
    }


    public Color getColor(String chose) {
        switch (chose) {
            case "blue":
                return this.blue;
            case "grey":
                return this.grey;
            case "brown":
                return this.brown;
            case "green":
                return this.green;
            case "orange":
                return this.orange;
        }
        return this.blue;
    }
}
