package functional_ramming;

import java.awt.Toolkit;

public class GameLoop {
    private static final double UPS = 60.0;
    //private static final double FPS = 60.0;

    private Arena a;
    private ArenaPanel ap;
    private FunctionPanel functionPanel;
    private boolean running;

    public GameLoop(Arena arena, ArenaPanel arenaPanel, FunctionPanel functionPanel) {
        a = arena;
        ap = arenaPanel;
        this.functionPanel = functionPanel;
        running = false;
    }

    public void run() {

        long lastTime = System.nanoTime();
        final double uPeriod = 1000000000 / UPS;
        //final double fPeriod = 1000000000 / FPS;
        double uProgress = 0;
        //double fProgress = 0;

        running = true;
        
        while (running) {
            
            long currentTime = System.nanoTime();
            uProgress += (currentTime - lastTime) / uPeriod;
            //fProgress += (currentTime - lastTime) / fPeriod;
            lastTime = currentTime;

            if (uProgress >= 1) {
                a.update();
                ap.repaint();
                this.functionPanel.repaint();
                Toolkit.getDefaultToolkit().sync();
                uProgress--;
            }
        }

    }

    public void stop() {
        this.running = false;
    }

}
