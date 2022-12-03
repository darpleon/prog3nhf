package functional_ramming;

import java.awt.*;
import javax.swing.*;

public class FunctionPanel extends JPanel {
    private Function function;

    public FunctionPanel(Function function) {
        this.function = function;
        this.setPreferredSize(new Dimension(360, 360));
        //this.setMaximumSize(new Dimension(360, 360));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        setBackground(Color.LIGHT_GRAY);
        super.paintComponent(graphics2d);

        graphics2d.setColor(Color.BLACK);
        graphics2d.drawLine(0, 350, 359, 350);
        graphics2d.drawLine(function.getCurrentIndex(), 0, function.getCurrentIndex(), 359);

        graphics2d.setColor(Color.RED);
        
        for (int i = 0; i < Function.DATA_COUNT; i++) {
            double scalingFactor = 330 / this.function.getMaxValue();
            int yCoord = 350 - (int) (scalingFactor * this.function.getValueAtIndex(i));
            graphics2d.setStroke(new BasicStroke(3));
            graphics2d.drawLine(i, yCoord, i, yCoord);
        }
    }
}
