package functional_ramming;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private Game game;

    private JLabel healthLabel;

    public MenuPanel(Game game) {
        this.setLayout(new GridLayout(4, 1));
        this.game = game;

        JPanel healthPanel = new JPanel();
        healthPanel.add(new JLabel("Remaining Aliveness Measure: "));
        this.healthLabel = new JLabel("100");
        this.healthLabel.setForeground(Color.RED);
        this.healthLabel.setFont(new Font("Serif", Font.BOLD, 30));
        healthPanel.add(this.healthLabel);

        this.add(healthPanel);
        this.add(new JLabel("lol"));
        this.add(new JButton("lmao"));
        this.add(new JLabel("ésmégegy"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.healthLabel.setText(Integer.toString(this.game.getRambdaHealth()));
    }
}
