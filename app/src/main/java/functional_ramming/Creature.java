package functional_ramming;

public class Creature {
    //private Arena a;

    protected Vector pos;
    protected Vector dir;
    protected double speed;
    protected double size;

    public Creature() {

    }

    public Creature(Vector p, Vector d, double sp, double sz) {
        pos = p;
        dir = d;
        speed = sp;
        size = sz;
    }

    public Vector getPos() {
        return pos;
    }

    public double getSize() {
        return size;
    }

    public void step() {
        Vector step = dir.scale(speed);
        Vector newPos = pos.add(step);
        if (newPos.getX() + size > Arena.WIDTH || newPos.getX() - size < 0) {
            dir.setX(-dir.getX());
        }
        if (newPos.getY() + size > Arena.HEIGHT || newPos.getY() - size < 0) {
            dir.setY(-dir.getY());
        }
        step = dir.scale(speed);
        pos = pos.add(step);
    }
}
