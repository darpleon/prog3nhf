package functional_ramming;

public class Creature {
    //private Arena a;

    protected Vector pos;
    protected Vector dir;
    protected double speed;
    protected double size;

    public Creature() {

    }

    public Creature(Vector pos, Vector dir, double speed, double size) {
        this.pos = pos;
        this.dir = dir;
        this.speed = speed;
        this.size = size;
    }

    public Vector getPos() {
        return this.pos;
    }

    public double getSize() {
        return this.size;
    }

    public void step() {
        Vector step = this.dir.scale(speed);
        Vector newPos = this.pos.add(step);
        if (newPos.getX() + this.size > Arena.WIDTH || newPos.getX() - this.size < 0) {
            this.dir.setX(-this.dir.getX());
        }
        if (newPos.getY() + this.size > Arena.HEIGHT || newPos.getY() - this.size < 0) {
            this.dir.setY(-this.dir.getY());
        }
        step = this.dir.scale(speed);
        this.pos = this.pos.add(step);
    }
}
