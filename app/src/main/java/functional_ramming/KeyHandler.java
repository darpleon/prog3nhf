package functional_ramming;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyEventDispatcher {
    private Game game;
    private Rambda r;
    boolean leftPressed;
    boolean rightPressed;

    public KeyHandler(Game game) {
        this.game = game;
        r = this.game.getRambda();
        leftPressed = false;
        rightPressed = false;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        switch (e.getID()) {
            case KeyEvent.KEY_PRESSED:
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        leftPressed = true;
                        if (!rightPressed)
                            r.setTurnDir(TurnDir.LEFT);
                        else
                            r.setTurnDir(TurnDir.NONE);
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightPressed = true;
                        if (!leftPressed)
                            r.setTurnDir(TurnDir.RIGHT);
                        else
                            r.setTurnDir(TurnDir.NONE);
                        break;
                    case KeyEvent.VK_SPACE:
                        game.toggleRun();
                        break;

                }
                break;
            case KeyEvent.KEY_RELEASED:
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        leftPressed = false;
                        if (rightPressed)
                            r.setTurnDir(TurnDir.RIGHT);
                        else
                            r.setTurnDir(TurnDir.NONE);
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightPressed = false;
                        if (leftPressed)
                            r.setTurnDir(TurnDir.LEFT);
                        else
                            r.setTurnDir(TurnDir.NONE);
                        break;
                }
                break;
            default:
                break;
        }
        return false;
    }

}
