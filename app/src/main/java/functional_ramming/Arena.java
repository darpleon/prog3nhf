package functional_ramming;

import java.util.*;

public class Arena implements Iterable<Creature> {
    private final List<Creature> creatures;
    private static final double width = 400;
    private static final double height = 300;

    public Iterator<Creature> iterator() {
        return creatures.iterator();
    }

    public Arena() {
        creatures = new ArrayList<Creature>();
    }

    public void addCreature(Creature c) {
        creatures.add(c);
    }

    public void update() {
        for (Creature c: creatures) {
            c.step();
        }
    }

}
