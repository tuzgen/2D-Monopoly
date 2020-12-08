package gui.menus;

import gui.menus.popups.PausePopup;
import javafx.stage.Stage;

public class GameMenuController {
	Stage context;

	public void setStage(Stage context) {
		this.context = context;
	}

	public void pauseGame() {
		new PausePopup().display(context);
	}
}