package functional_ramming;

public class Creature {
    // private Arena a;
    protected final double size;

    protected boolean alive;

    protected Vector pos;
    protected Vector dir;
    protected double speed;

    public Creature(Vector spawnPos, double speed, double size) {
        this.pos = spawnPos;
        this.dir = new Vector(1, 0);
        this.speed = speed;
        this.size = size;

        this.alive = true;
    }

    public Vector getPos() {
        return this.pos;
    }

    public double getSize() {
        return this.size;
    }

    public Vector getDir() {
        return this.dir;
    }
    public boolean isAlive() {
        return this.alive;
    }

    public void step() {
        Vector step = this.dir.scale(speed);
        Vector newPos = this.pos.add(step);

        if (newPos.getX() + this.size > Game.ARENA_WIDTH || newPos.getX() - this.size < 0) {
            this.dir.setX(-this.dir.getX());
        }
        if (newPos.getY() + this.size > Game.ARENA_HEIGHT || newPos.getY() - this.size < 0) {
            this.dir.setY(-this.dir.getY());
        }
        step = this.dir.scale(speed);
        this.pos = this.pos.add(step);
    }
}
