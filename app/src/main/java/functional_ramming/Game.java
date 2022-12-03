package functional_ramming;

import java.util.*;

public class Game implements Iterable<Chaser> {
    public static final double WIDTH = 1200;
    public static final double HEIGHT = 900;

    private Function function;
    private Rambda rambda;
    private List<Chaser> chasers;

    private boolean running;

    public Iterator<Chaser> iterator() {
        return chasers.iterator();
    }

    public Game() {
        this.chasers = new ArrayList<Chaser>();
        this.running = true;
    }

    public boolean isRunning() {
        return this.running;
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

    public Function getFunction() {
        return this.function;
    }

    public void setFunction(Function function) {
        this.function = function;
        this.rambda.setFunction(function);
    }

    public void update() {
        rambda.step();
        for (Chaser c : chasers) {
            c.step();
        }
        function.step();
    }

    public void gameWon() {

    }

    public void gameLost() {
        this.running = false;
    }

}
