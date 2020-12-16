package gui.menus.controller;

import gui.menus.popups.PausePopup;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import management.GameManager;

public class GameMenuController {
	@FXML
	Label infoPlayer1Name, infoPlayer2Name, infoPlayer3Name, infoPlayer4Name;

	private GameManager gameManager;
	private Stage context;

	@FXML
	void initialize() {
		// TODO gameManager = GameManager.getInstance();
		infoPlayer1Name = new Label(gameManager.getPlayerAt(0).getName());
		infoPlayer2Name = new Label(gameManager.getPlayerAt(1).getName());
		infoPlayer3Name = new Label(gameManager.getPlayerAt(2).getName());
		infoPlayer4Name = new Label(gameManager.getPlayerAt(3).getName());
	}

	public void setStage(Stage context) {
		this.context = context;
	}

	public void pauseGame() {
		new PausePopup().display(context);
	}
}