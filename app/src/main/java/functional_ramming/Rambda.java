package functional_ramming;

public class Rambda extends Creature {
    private TurnDir turnDir;
    private Vector turnDelta;
    private Function function;
    
    public Rambda(Vector p, Vector d, double sz, double angleDelta , Function function) {
        super(p, d, 0, sz);
        double angleDeltaRad = Math.toRadians(angleDelta);
        turnDelta = new Vector(Math.cos(angleDeltaRad), Math.sin(angleDeltaRad));
        turnDir = TurnDir.NONE;
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
