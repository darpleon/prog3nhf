package functional_ramming;

import java.util.*;

public class Game implements Iterable<Chaser> {
    public static final int ARENA_WIDTH = 1200;
    public static final int ARENA_HEIGHT = 900;
    public static final Vector RAMBDA_SPAWN_POS = new Vector(ARENA_WIDTH / 2, ARENA_HEIGHT / 2);

    private GameLoop gameLoop;

    private FunctionCollection functionCollection;

    private Function function;
    private Rambda rambda;
    private List<Chaser> chasers;

    private int killTally;

    private boolean running;
    private boolean started;

    public Game(FunctionCollection functionCollection) {
        this.functionCollection = functionCollection;
        this.function = functionCollection.get(0);
        this.rambda = new Rambda(this, new Vector(500, 300), this.function);
        this.chasers = new ArrayList<Chaser>();
        this.running = true;
        this.started = false;
        this.killTally = 0;
    }

    public Iterator<Chaser> iterator() {
        return chasers.iterator();
    }

    public FunctionCollection getFunctionCollection() {
        return this.functionCollection;
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

    public int getRambdaHealth() {
        return this.rambda.getHealth();
    }

    public void addChaser(Chaser chaser) {
        chasers.add(chaser);
    }

    public Function getFunction() {
        return this.function;
    }

    public void setFunction(Function function) {
        if (this.function != null)
            this.function.reset();
        this.function = function;
        this.rambda.setFunction(function);
    }

    public void update() {
        rambda.step();
        function.step();
        if (this.started) {
            for (Chaser c : chasers) {
                c.step();
            }
        }
    }

    public void incrementTally() {
        killTally += 1;
        if (killTally == chasers.size()) {
            this.running = false;
        }
    }

    public void gameLost() {
        this.running = false;
    }

    public void reset() {
        System.out.println(this.rambda.getPos());
        this.rambda.reset();
        this.function.reset();
        for (Chaser c : chasers) {
            c.reset();
        }
        this.running = true;
        this.started = false;
        System.out.println(this.rambda.getPos());
    }

    public void start() {
        this.started = true;
    }

    public void setGameLoop(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

}
