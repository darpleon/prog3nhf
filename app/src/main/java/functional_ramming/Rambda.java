package functional_ramming;

public class Rambda extends Creature {
    private static final double ANGLE_DELTA = 7;
    private static final double SIZE = 30;

    private final Game game;
    private Vector turnDelta;
    private Function function;

    private double health;
    private TurnDir turnDir;

    public Rambda(Game game, Vector spawnPos, Function function) {
        super(spawnPos, 0, SIZE);
        this.game = game;
        double angleDeltaRad = Math.toRadians(ANGLE_DELTA);
        this.turnDelta = new Vector(Math.cos(angleDeltaRad), Math.sin(angleDeltaRad));
        this.turnDir = TurnDir.NONE;
        this.function = function;
        this.health = 100.0;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public void setTurnDir(TurnDir td) {
        turnDir = td;
    }

    public int getHealth() {
        return (int) health;
    }

    @Override
    public void step() {
        this.speed = this.function.getCurrentValue();

        if (turnDir != TurnDir.NONE) {
            double newX = 1;
            double newY = 0;
            if (turnDir == TurnDir.LEFT) {
                newX = dir.dotProduct(turnDelta);
                newY = dir.dotProduct(turnDelta.flip().swap());
            } else if (turnDir == TurnDir.RIGHT) {
                newX = dir.dotProduct(turnDelta.flip());
                newY = dir.dotProduct(turnDelta.swap());
            }
            dir = new Vector(newX, newY);
        }

        super.step();
    }

    public void hit() {
        this.health -= 100.0 * Math.pow(2.0, - this.speed / 5.0);
        //this.health -= 100;
        if (this.health <= 0) {
            this.health = 0;
            this.alive = false;
            game.gameLost();
        }
    }

}
