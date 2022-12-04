package functional_ramming;

import java.util.*;

public class Chaser extends Creature {
    private Rambda target;
    private List<Creature> toAvoid;

    private final double spawnDelay;
    private double spawnTimer;

    public Chaser(Vector pos, double speed, double size, Rambda target, double waitTime) {
        super(pos, speed, size);
        this.spawnDelay = waitTime;
        this.spawnTimer = this.spawnDelay;
        this.target = target;
        this.alive = false;
        // this.toAvoid = toAvoid;
    }

    @Override
    public void step() {
        if (spawnTimer > 0) {
            spawnTimer -= 1 / 60.0;
            if (spawnTimer <= 0) {
                this.alive = true;
            }
        }

        if (!this.alive) {
            return;
        }

        this.dir = target.getPos().subtract(this.pos).normalize();

        super.step();

        if (this.pos.distance(this.target.getPos()) < this.size + this.target.getSize()) {
            this.target.hit();
            this.alive = false;
        }
    }

    public void reset() {
        this.alive = false;
        this.spawnTimer = spawnDelay;
        this.pos = this.spawnPos;
    }
}
