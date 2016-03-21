import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
import java.util.Random;
public class TreePanel extends JPanel
{
    private final int PANEL_WIDTH = 1100;
    private final int PANEL_HEIGHT = 800;
    double x_init = 550;
    double y_init = 650;
    double length_init = 170;
    double bAngleRight = 40;
    double bAngleLeft = 10;
    double angle_init = 90;
    double lengthFrac = .8;
    double minLength = 5;
    Random rand = new Random();
    public TreePanel()
    {
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
    }
    
    public void drawFractal(Graphics2D g2, double x, double y, double length, double angle)
    {
        if (length < minLength)
            return;
        else
        {
            double x2 = x - Math.cos(Math.toRadians(angle+bAngleRight))*length;
            double y2 = y - Math.sin(Math.toRadians(angle+bAngleLeft))*length;
            double x3 = x - Math.cos(Math.toRadians(angle-bAngleRight))*length;
            double y3 = y - Math.sin(Math.toRadians(angle-bAngleLeft))*length;
            Line2D.Double line = new Line2D.Double(x,y,x2,y2);
            Line2D.Double line2 = new Line2D.Double(x,y,x3,y3);
            g2.setColor(branchCustomizer(length,g2));
            g2.draw(line);
            g2.draw(line2);
            drawFractal(g2,x2,y2,length*lengthFrac,angle+bAngleRight);
            drawFractal(g2,x3,y3,length*lengthFrac,angle-bAngleLeft);
        }
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(branchCustomizer(length_init,g2));
        g2.draw(new Line2D.Double(x_init,y_init,x_init,y_init+length_init));
        drawFractal(g2,x_init,y_init,length_init*lengthFrac,angle_init);
    }
    
    public Color branchCustomizer(double length,Graphics2D g2)
    {
        //width of branches gets smaller along with the length
        g2.setStroke(new BasicStroke((int)(length*.2)));
        if (length>=25)
            return Color.DARK_GRAY;
        else
            if (rand.nextInt(2)==1)
                return Color.GREEN;
            else
                return Color.BLUE;
    }
}