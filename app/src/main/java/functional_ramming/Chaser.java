package functional_ramming;

import java.util.*;

public class Chaser extends Creature {
    private Rambda target;
    private List<Creature> toAvoid;

    public Chaser(Vector pos, double speed, double size, Rambda target, List<Creature> toAvoid) {
        super(pos, speed, size);
        this.target = target;
        this.toAvoid = toAvoid;
    }

    @Override
    public void step() {
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
}
