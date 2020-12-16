package gui.menus;

import gui.menus.popups.PausePopup;
import javafx.stage.Stage;
import management.GameManager;

public class GameMenuController {
	private GameManager gameManager;
	private Stage context;

	public void setStage(Stage context) {
		this.context = context;
	}

	public void pauseGame() {
		new PausePopup().display(context);
	}
}