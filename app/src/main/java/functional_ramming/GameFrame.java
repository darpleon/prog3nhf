package functional_ramming;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(JPanel functionPanel) {
        this.setTitle("Functional Ramming");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setPreferredSize(new Dimension(1600, 900));
        this.setResizable(false);

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.add(new JPanel());
        sidePanel.add(functionPanel);

        this.add(sidePanel, BorderLayout.EAST);

    }

}
