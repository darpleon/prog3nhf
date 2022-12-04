package functional_ramming;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class MenuPanel extends JPanel {
    private Game game;

    private JLabel healthLabel;
    private JComboBox<Function> functionBox;

    private FunctionPanel functionPanel;

    public MenuPanel(Game game, FunctionPanel functionPanel) {
        this.setPreferredSize(new Dimension(360, 900 - 360));
        this.setLayout(new GridLayout(4, 1));
        this.game = game;

        this.functionPanel = functionPanel;

        JPanel healthPanel = new JPanel();
        healthPanel.add(new JLabel("Remaining Aliveness Measure: "));
        this.healthLabel = new JLabel("100");
        this.healthLabel.setForeground(Color.RED);
        this.healthLabel.setFont(new Font("Serif", Font.BOLD, 30));
        healthPanel.add(this.healthLabel);

        this.add(healthPanel);

        functionBox = new JComboBox<Function>();
        for (Function f : game.getFunctionCollection()) {
            functionBox.addItem(f);
        }

        functionBox.addActionListener( e -> {
            JComboBox<Function> fBox = (JComboBox<Function>) e.getSource();
            Function newFunc = (Function) fBox.getSelectedItem();
            game.setFunction(newFunc);
            functionPanel.setFunction(newFunc);
        });

        JPanel fBoxPanel = new JPanel();
        fBoxPanel.add(new JLabel("Select function:"));
        fBoxPanel.add(functionBox);
        this.add(fBoxPanel);

        JButton resetButton =  new JButton("Reset");
        resetButton.addActionListener(a -> this.game.reset());
        JButton startButton = new JButton("Start");
        startButton.addActionListener(a -> this.game.start());

        JPanel controlPanel = new JPanel();
        controlPanel.add(resetButton);
        controlPanel.add(startButton);
        this.add(controlPanel);
        this.add(new JLabel("ésmégegy"));

    }

    @Override
    protected void paintComponent(Graphics g) {
        this.healthLabel.setText(Integer.toString(this.game.getRambdaHealth()));
    }
}
