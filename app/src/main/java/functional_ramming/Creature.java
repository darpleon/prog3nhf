package functional_ramming;

public class Creature {
    private Vector pos;
    private Vector dir;
    private double speed;
    private double size;

    public Creature(Vector p, Vector d, double sp, double sz, Vector b) {
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
        Vector newPos = pos.add(dir);
        if (newPos.getX() + size > 400) {
            dir.setX(-dir.getX());
            newPos = pos.add(dir);
        }
        if (newPos.getY() + size > 300) {
            dir.setY(-dir.getY());
            newPos = pos.add(dir);
        }
    }
}
