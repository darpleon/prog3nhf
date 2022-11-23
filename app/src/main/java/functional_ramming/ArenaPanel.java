package functional_ramming;

import java.awt.*;
import javax.swing.*;

public class ArenaPanel extends JPanel {

    private final Arena a;
    private final double aspectRatio;

    public ArenaPanel(Arena arena) {
        a = arena;
        aspectRatio = a.WIDTH / a.HEIGHT;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        setBackground(Color.GRAY);
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.RED);
        g.fillOval(100, 100, 100, 100);

        drawCreature(a.getRambda(), g);
        for (Chaser c: a) {
            drawCreature(c, g);
        }
    }

    public void drawCreature(Creature c, Graphics2D g) {
        int x = (int) c.getPos().getX();
        int y = (int) c.getPos().getY();
        int s = (int) c.getSize();

        g.setColor(Color.YELLOW);
        g.fillOval(x - s, y - s, 2 * s, 2 * s);
        
    }
}
