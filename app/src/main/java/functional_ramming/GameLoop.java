package functional_ramming;

import java.awt.Toolkit;

public class GameLoop {
    private static final double UPS = 60.0;
    // private static final double FPS = 60.0;

    private Game game;
    private ArenaPanel arenaPanel;
    private FunctionPanel functionPanel;
    private boolean running;

    public GameLoop(Game game, ArenaPanel arenaPanel, FunctionPanel functionPanel) {
        this.game = game;
        this.arenaPanel = arenaPanel;
        this.functionPanel = functionPanel;
        this.running = false;
    }

    public void run() {

        long lastTime = System.nanoTime();
        final double uPeriod = 1000000000 / UPS;
        // final double fPeriod = 1000000000 / FPS;
        double uProgress = 0;
        // double fProgress = 0;

        running = true;

        while (game.isRunning()) {

            long currentTime = System.nanoTime();
            uProgress += (currentTime - lastTime) / uPeriod;
            // fProgress += (currentTime - lastTime) / fPeriod;
            lastTime = currentTime;

            if (uProgress >= 1) {
                game.update();
                this.arenaPanel.repaint();
                this.functionPanel.repaint();
                Toolkit.getDefaultToolkit().sync();
                uProgress--;
            }
        }
        this.arenaPanel.repaint();
        this.arenaPanel.repaint();

    }

    public void stop() {
        this.running = false;
    }

}
