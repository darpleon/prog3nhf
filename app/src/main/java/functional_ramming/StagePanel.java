package functional_ramming;

import java.awt.*;

import javax.swing.*;

public class StagePanel extends JPanel {

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.RED);
        g.fillOval(100, 100, 100, 100);

    }
}
