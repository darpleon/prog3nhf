package functional_ramming;

import java.awt.*;

public class CreatureView {
    private Creature c;

    public CreatureView(Creature creature) {
        c = creature;
    }

    public void draw(Graphics2D g) {
        int x = (int) c.getPos().getX();
        int y = (int) c.getPos().getY();
        int s = (int) c.getSize();

        g.setColor(Color.YELLOW);
        g.fillOval(x - s, y - s, 2 * s, 2 * s);
    }
}
