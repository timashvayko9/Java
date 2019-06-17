import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui1 implements ActionListener {
   JFrame frame;
   JLabel label;

    public static void main(String[] args) {
        gui1 gui = new gui1();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change label");
        labelButton.addActionListener(this::actionPerformed1);

        JButton colorButton = new JButton("Change circle");
        colorButton.addActionListener(this::actionPerformed);
        label = new JLabel("I'm a label");
        MeDrawPanel drawPanel = new MeDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.WEST,label);
        frame.setSize(400,400);
        frame.setVisible(true);

    }

        public void actionPerformed1(ActionEvent event){
            label.setText("OUCH");
        }

        public void actionPerformed(ActionEvent event){
            frame.repaint();
        }


}
