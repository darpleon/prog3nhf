package functional_ramming;

import java.awt.*;

public class CreatureView {
    private Creature creature;
    private Color color;

    public CreatureView(Creature creature, Color color) {
        this.creature = creature;
        this.color = color;
    }

    public void draw(Graphics2D g) {
        int x = (int) this.creature.getPos().getX();
        int y = (int) this.creature.getPos().getY();
        int s = (int) this.creature.getSize();

        g.setColor(color);

        if (creature.isAlive()) {
            g.fillOval(x - s, y - s, 2 * s, 2 * s);
            // g.drawRect(x -s, y -s, 2 * s, 2 * s);

            int nx = x + (int) (this.creature.getDir().getX() * s / 2.0);
            int ny = y + (int) (this.creature.getDir().getY() * s / 2.0);
            int ns = s / 3;

            g.setColor(Color.RED);
            g.fillOval(nx - ns, ny - ns, 2 * ns, 2 * ns);
        }
        else {
            g.drawOval(x - s, y - s, 2 * s, 2 * s);
        }
    }
}
