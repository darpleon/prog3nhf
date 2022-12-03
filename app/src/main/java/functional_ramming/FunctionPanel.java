package functional_ramming;

import java.awt.*;
import javax.swing.*;

public class FunctionPanel extends JPanel {
    private static final int TOP_PADDING = 20;
    private static final int BOTTOM_PADDING = 10;

    private Function function;

    public FunctionPanel(Function function) {
        this.function = function;
        this.setPreferredSize(new Dimension(Function.DATA_COUNT, Function.DATA_COUNT));
        //this.setMaximumSize(new Dimension(360, 360));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        setBackground(Color.LIGHT_GRAY);
        super.paintComponent(graphics2d);

        int bottomY = Function.DATA_COUNT - FunctionPanel.BOTTOM_PADDING;
        int lastVal = Function.DATA_COUNT - 1;

        graphics2d.setColor(Color.BLACK);
        graphics2d.drawLine(0, bottomY, lastVal, bottomY);
        graphics2d.drawLine(function.getCurrentIndex(), 0, function.getCurrentIndex(), lastVal);

        int height = Function.DATA_COUNT - TOP_PADDING - BOTTOM_PADDING;

        graphics2d.setColor(Color.RED);
        
        for (int i = 0; i < Function.DATA_COUNT; i++) {
            double scalingFactor = height / this.function.getMaxValue();
            int yCoord = bottomY - (int) (scalingFactor * this.function.getValueAtIndex(i));
            graphics2d.setStroke(new BasicStroke(3));
            graphics2d.drawLine(i, yCoord, i, yCoord);
        }
    }
}
