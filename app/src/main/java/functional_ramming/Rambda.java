package functional_ramming;

public class Rambda extends Creature {
    private static final double ANGLE_DELTA = 6;
    private static final double SIZE = 20;

    private TurnDir turnDir;
    private Vector turnDelta;
    private Function function;
    
    public Rambda(Vector spawnPos, Function function) {
        super(spawnPos, 0, SIZE);
        double angleDeltaRad = Math.toRadians(ANGLE_DELTA);
        this.turnDelta = new Vector(Math.cos(angleDeltaRad), Math.sin(angleDeltaRad));
        this.turnDir = TurnDir.NONE;
        this.function = function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
    
    public void setTurnDir(TurnDir td) {
        turnDir = td;
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
            }
            else if (turnDir == TurnDir.RIGHT) {
                newX = dir.dotProduct(turnDelta.flip());
                newY = dir.dotProduct(turnDelta.swap());
            }
            dir = new Vector(newX, newY);
        }

        super.step();
    }

}
