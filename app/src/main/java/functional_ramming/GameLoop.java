package functional_ramming;

import java.awt.Toolkit;

public class GameLoop {
    private static final double UPS = 60.0;

    private Game game;
    private GameFrame gameFrame;
    // private boolean running;

    public GameLoop(Game game, GameFrame gameFrame) {
        this.game = game;
        game.setGameLoop(this);
        this.gameFrame = gameFrame;

        // this.running = false;
    }

    public void run() { 

        long lastTime = System.nanoTime();
        double uPeriod = 1000000000 / UPS;

        double uProgress = 0;

        // running = true;

        while (game.isRunning()) {

            long currentTime = System.nanoTime();
            uProgress += (currentTime - lastTime) / uPeriod;
            lastTime = currentTime;

            if (uProgress >= 1) {
                game.update();
                gameFrame.repaint();
                Toolkit.getDefaultToolkit().sync();
                uProgress--;
            }
        }

    }

    // public void stop() {
    //     this.running = false;
    // }

}
