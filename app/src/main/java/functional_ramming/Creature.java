package functional_ramming;

public class Creature {
    private Vector pos;
    private Vector dir;
    private double speed;
    private double size;

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
        if (newPos.getX() + size > 400 || newPos.getX() - size < 0) {
            dir.setX(-dir.getX());
        }
        if (newPos.getY() + size > 300 || newPos.getY() - size < 0) {
            dir.setY(-dir.getY());
        }
        step = dir.scale(speed);
        pos = pos.add(step);
    }
}
