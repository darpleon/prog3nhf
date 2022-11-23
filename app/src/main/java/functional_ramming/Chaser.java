package functional_ramming;

import java.util.*;

public class Chaser extends Creature {
    private Creature target;
    private List<Creature> toAvoid;

    public Chaser(Vector pos, double speed, double size, Creature target, List<Creature> toAvoid) {
        super(pos, new Vector(), speed, size);
        this.target = target;
        this.toAvoid = toAvoid;
    }

    @Override
    public void step() {
        this.dir = target.getPos().subtract(this.pos).normalize();

        super.step();
    }
}
