package functional_ramming;

import java.util.*;

public class Arena implements Iterable<Creature> {
    public static final double WIDTH = 800;
    public static final double HEIGHT = 600;

    private final List<Creature> creatures;

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
