package functional_ramming;

import java.util.*;

public class Arena implements Iterable<Chaser> {
    public static final double WIDTH = 1200;
    public static final double HEIGHT = 900;

    private Function function;
    private Rambda rambda;
    private List<Chaser> chasers;

    public Iterator<Chaser> iterator() {
        return chasers.iterator();
    }

    public Arena() {
        chasers = new ArrayList<Chaser>();
    }

    public void setRambda(Rambda rambda) {
        this.rambda = rambda;
    }

    public Rambda getRambda() {
        return this.rambda;
    }

    public void addChaser(Chaser chaser) {
        chasers.add(chaser);
    }

    public void setFunction(Function function) {
        this.function = function;
        this.rambda.setFunction(function);
    }

    public void update() {
        rambda.step();
        for (Chaser c: chasers) {
            c.step();
        }
        function.step();
    }

}
