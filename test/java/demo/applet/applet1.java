package demo.applet;
import java.applet.*;
import java.awt.*;
/**
 * Created by simpletour_java on 2015/7/1.
 */
public class applet1 extends Applet{
    int squareSize = 50;

    public void init(){
        String squareSizeParam = getParameter("squareSize");
        parseSquareSize(squareSizeParam);
        String colorParam = getParameter("color");
        Color fg = parseColor(colorParam);
        setBackground(Color.black);
        setForeground(fg);
    }
    private void parseSquareSize(String param){
        if(param == null) return;
        try{
            squareSize = Integer.parseInt(param);
        }catch(Exception e){

        }
    }
    private Color parseColor(String param){
        return null;
    }
    public void paint(Graphics g){
        g.drawString("Hello World",25,50);
    }

}
