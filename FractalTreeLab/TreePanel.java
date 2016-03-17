import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
import java.util.Random;
public class TreePanel extends JPanel
{
    private final int PANEL_WIDTH = 700;
    private final int PANEL_HEIGHT = 600;
    double x_init = 350;
    double y_init = 450;
    double length_init = 100;
    double bAngle = 20;
    double angle_init = 90;
    double lengthFrac = .8;
    double minLength = 2;
    Random rand = new Random();
    public TreePanel()
    {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
    }
    
    public void drawFractal(Graphics2D g2, double x, double y, double length, double angle)
    {
        if (length < minLength)
            return;
        else
        {
            //dif angles left v right
            
            double x2 = x - Math.cos(Math.toRadians(angle+bAngle))*length;
            double y2 = y - Math.sin(Math.toRadians(angle+bAngle))*length;
            double x3 = x - Math.cos(Math.toRadians(angle-bAngle))*length;
            double y3 = y - Math.sin(Math.toRadians(angle-bAngle))*length;
            Line2D.Double line = new Line2D.Double(x,y,x2,y2);
            Line2D.Double line2 = new Line2D.Double(x,y,x3,y3);
            g2.setColor(colorChooser(length));
            g2.draw(line);
            g2.draw(line2);
            drawFractal(g2,x2,y2,length*lengthFrac,angle+bAngle);
            drawFractal(g2,x3,y3,length*lengthFrac,angle-bAngle);
            
        }
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(colorChooser(length_init));
        g2.draw(new Line2D.Double(x_init,y_init,x_init,y_init+length_init));
        drawFractal(g2,x_init,y_init,length_init*lengthFrac,angle_init);
    }
    
    public Color colorChooser(double length)
    {
        int color = rand.nextInt(5);
        if (length<=5)
            return Color.RED;
        else if (length<=10)
            return Color.ORANGE;
        else if (length<=30)
            return Color.YELLOW;
        else if (length<=60)
            return Color.GREEN;
        else if (length>60)
            return Color.BLUE;
        return Color.BLACK;
    }
}