package functional_ramming;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class RambdaController implements KeyListener {
    private Rambda r;
    boolean leftPressed;
    boolean rightPressed;

    public RambdaController(Rambda rambda) {
        r = rambda;
        leftPressed = false;
        rightPressed = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                if (!rightPressed) r.setTurnDir(TurnDir.LEFT);
                else r.setTurnDir(TurnDir.NONE);
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                if (!leftPressed) r.setTurnDir(TurnDir.RIGHT);
                else r.setTurnDir(TurnDir.NONE);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                if (rightPressed) r.setTurnDir(TurnDir.RIGHT);
                else r.setTurnDir(TurnDir.NONE);
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                if (leftPressed) r.setTurnDir(TurnDir.LEFT);
                else r.setTurnDir(TurnDir.NONE);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
