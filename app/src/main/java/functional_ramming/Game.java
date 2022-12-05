package functional_ramming;

import java.util.*;

public class Game implements Iterable<Chaser> {
    public static final int ARENA_WIDTH = 1200;
    public static final int ARENA_HEIGHT = 900;
    public static final Vector RAMBDA_SPAWN_POS = new Vector(ARENA_WIDTH / 2, ARENA_HEIGHT / 2);

    private GameLoop gameLoop;

    private Rambda rambda;

    private FunctionCollection functionCollection;
    private List<Level> levels;

    private Function function;
    private Level level;
    // private List<Chaser> chasers;

    private int killTally;

    private boolean running;
    private boolean started;

    public Game(FunctionCollection functionCollection, List<Level> levels) {
        this.functionCollection = functionCollection;
        this.levels = levels;

        this.rambda = new Rambda(this, new Vector(500, 300), this.function);

        for (Level l : levels) {
            l.setTarget(this.rambda);
        }

        this.function = functionCollection.get(0);
        this.level = this.levels.get(0);
        this.rambda.setFunction(this.function);

        // this.chasers = new ArrayList<Chaser>();
        this.running = false;
        this.started = false;
        this.killTally = 0;
    }

    public Iterator<Chaser> iterator() {
        return level.iterator();
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

    // public void addChaser(Chaser chaser) {
    //     chasers.add(chaser);
    // }

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
            level.step();
        }
    }

    public void incrementTally() {
        killTally += 1;
        if (this.killTally == this.level.chaserCount()) {
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
        this.level.reset();
        this.running = false;
        this.started = false;
        System.out.println(this.rambda.getPos());
    }

    public void start() {
        this.running = true;
        this.started = true;
    }

    public void toggleRun() {
        if (!this.running) {
            this.running = true;
        }
        else {
            this.running = false;
        }
    }

    public void setGameLoop(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

}
