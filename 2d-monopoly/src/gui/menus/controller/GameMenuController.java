package gui.menus.controller;

import com.sun.javafx.scene.CameraHelper;
import gui.menus.popups.PausePopup;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import management.GameManager;

public class GameMenuController {
	private static GameManager gameManager;
	private Stage context;

	public void setStage(Stage context) {
		this.context = context;
	}

	public void pauseGame() {
		new PausePopup().display(context);
	}
}