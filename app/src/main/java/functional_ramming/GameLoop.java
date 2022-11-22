package functional_ramming;

import java.awt.Toolkit;

public class GameLoop {
    private static final double UPS = 60.0;
    private static final double FPS = 60.0;

    private Arena a;
    private ArenaPanel ap;
    private boolean running;

    public GameLoop(Arena arena, ArenaPanel arenaPanel) {
        a = arena;
        ap = arenaPanel;
        running = false;
    }

    public void run() {

        long lastTime = System.nanoTime();
        final double uPeriod = 1000000000 / UPS;
        final double fPeriod = 1000000000 / FPS;
        double uProgress = 0, fProgress = 0;

        running = true;
        
        while (running) {
            
            long currentTime = System.nanoTime();
            uProgress += (currentTime - lastTime) / uPeriod;
            fProgress += (currentTime - lastTime) / fPeriod;
            lastTime = currentTime;

            if (uProgress >= 1) {
                a.update();
                ap.repaint();
                Toolkit.getDefaultToolkit().sync();
                uProgress--;
            }
        }

    }

}
