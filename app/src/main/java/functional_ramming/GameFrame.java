package functional_ramming;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    private JLabel hlabel;
    private JLabel wlabel;
    public Creature c;

    GameFrame() {
        this.setTitle("Functional Ramming");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hlabel = new JLabel();
        wlabel = new JLabel();
        this.add(hlabel,BorderLayout.WEST);
        this.add(wlabel,BorderLayout.EAST);

        Arena a = new Arena();
        
        Vector pos = new Vector(50, 250);
        Vector dir = new Vector(4.0 / 5.0, 3.0 / 5.0);
        double speed = 0.005;
        double size = 20;
        c = new Creature(pos, dir, speed, size);
        a.addCreature(c);

        ArenaPanel ap = new ArenaPanel(a);

        this.add(ap, BorderLayout.CENTER); 

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
