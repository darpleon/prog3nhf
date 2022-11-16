package functional_ramming;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    private JLabel hlabel;
    private JLabel wlabel;

    GameFrame() {
        this.setTitle("Functional Ramming");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hlabel = new JLabel();
        wlabel = new JLabel();
        this.add(hlabel,BorderLayout.WEST);
        this.add(wlabel,BorderLayout.EAST);

        this.pack();
        this.setVisible(true);
    }

    public void writeSize() {

        Rectangle r = this.getBounds();
        String h = Integer.toString(r.height);
        String w = Integer.toString(r.width);
        hlabel.setText(h);
        wlabel.setText(w);
        //this.repaint();
    }

}
