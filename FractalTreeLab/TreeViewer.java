import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TreeViewer 
{
    private final int WIDTH = 720;
    private final int HEIGHT = 620;

    private JLabel titleLabel;
    private TreePanel drawing;
    private JFrame frame;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }

    public TreeViewer()
    {
        titleLabel = new JLabel ("Fractal Tree");
        titleLabel.setForeground (Color.black);
        
        drawing = new TreePanel();
        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(drawing);
        frame.setVisible(true);
    }
}