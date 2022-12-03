package functional_ramming;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    private Game game;

    private ArenaPanel arenaPanel;
	private FunctionPanel functionPanel;
    private MenuPanel menuPanel;

    public GameFrame(Game game) {
        this.setTitle("Functional Ramming");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.game = game;
        this.arenaPanel = new ArenaPanel(this.game);
        this.functionPanel = new FunctionPanel(this.game.getFunction());
        this.menuPanel = new MenuPanel(game);

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());
        sidePanel.add(this.menuPanel, BorderLayout.CENTER);
        sidePanel.add(this.functionPanel, BorderLayout.SOUTH);

        this.add(this.arenaPanel, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new RambdaController(game.getRambda()));

        this.setVisible(true);
        this.pack();
    }

	public ArenaPanel getArenaPanel() {
		return arenaPanel;
	}

	public FunctionPanel getFunctionPanel() {
		return functionPanel;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

}
