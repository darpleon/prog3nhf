package functional_ramming;

import java.awt.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

public class ArenaPanel extends JPanel {
    // private final double aspectRatio;
    private static final Color RAMBDA_BODY_COLOR = Color.YELLOW;
    private static final Color CHASER_BODY_COLOR = Color.BLUE;

    private final Game game;
    private final CreatureView rambdaView;
    private List<CreatureView> chaserViews;

    public ArenaPanel(Game game) {
        this.setPreferredSize(new Dimension(1200, 900));
        this.setMaximumSize(new Dimension(1200, 900));

        this.game = game;
        this.rambdaView = new CreatureView(this.game.getRambda(), RAMBDA_BODY_COLOR);
        this.chaserViews = new ArrayList<CreatureView>();

        for (Chaser c: game) {
            chaserViews.add(new CreatureView(c, CHASER_BODY_COLOR));
        }

        // aspectRatio = Arena.WIDTH / Arena.HEIGHT;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        setBackground(Color.GRAY);
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        // g.setColor(Color.RED);
        // g.fillOval(100, 100, 100, 100);

        for (CreatureView v : this.chaserViews) {
            v.draw(g);
        }
        rambdaView.draw(g);
    }

    public void drawCreature(Creature c, Graphics2D g) {
        int x = (int) c.getPos().getX();
        int y = (int) c.getPos().getY();
        int s = (int) c.getSize();

        g.setColor(Color.YELLOW);
        g.fillOval(x - s, y - s, 2 * s, 2 * s);

    }
}
