package functional_ramming;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private Game game;

    public MenuPanel(Game game) {
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setFocusable(false);
        this.game = game;
        this.setLayout(new GridLayout(4, 1));
        this.add(new JLabel("xd:"));
        this.add(new JLabel("lol"));
        this.add(new JButton("lmao"));
        this.add(new JLabel("ésmégegy"));
    }
}
