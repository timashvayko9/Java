import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {
    public void  paintGrad(Graphics g1){
        Graphics2D g2d = (Graphics2D) g1;

        GradientPaint gradient = new GradientPaint(150,150,Color.BLUE,230,230,Color.CYAN);

        g2d.setPaint(gradient);
        g2d.fillOval(150,150,100,100);
    }
}
