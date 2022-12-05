package functional_ramming;

import java.util.*;

public class Level implements Iterable<Chaser> {
    private String name;
    private List<Chaser> chasers;

    public Level(String name) {
        this.name = name;
        this.chasers = new ArrayList<Chaser>();
    }

    public void add(Chaser chaser) {
        this.chasers.add(chaser);
    }

    public Chaser get(int idx) {
        return this.chasers.get(idx);
    }

    public int chaserCount() {
        return this.chasers.size();
    }

    public void setTarget(Rambda target) {
        for (Chaser c : chasers) {
            c.setTarget(target);
        }
    }

    public void reset() {
        for (Chaser c : chasers) {
            c.reset();
        }
    }

    public void step() {
        for (Chaser c : chasers) {
            c.step();
        }
    }

    @Override
    public Iterator<Chaser> iterator() {
        return this.chasers.iterator();
    }

    @Override
    public String toString() {
        return name;
    }
}
