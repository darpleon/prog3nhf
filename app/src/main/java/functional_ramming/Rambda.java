package functional_ramming;

public class Rambda extends Creature {
    private TurnDir turnDir;
    private Vector turnDelta;
    
    public Rambda(Vector p, Vector d, double sz, double angleDelta/*, Function f*/) {
        super(p, d, 10, sz);
        double angleDeltaRad = Math.toRadians(angleDelta);
        turnDelta = new Vector(Math.cos(angleDeltaRad), Math.sin(angleDeltaRad));
        turnDir = TurnDir.NONE;
    }
    
    public void setTurnDir(TurnDir td) {
        turnDir = td;
    }

    public void step() {
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
