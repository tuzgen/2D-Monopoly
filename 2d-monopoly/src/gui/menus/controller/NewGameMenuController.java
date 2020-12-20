package gui.menus.controller;

import gui.menus.GameMenu;
import gui.menus.MainMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewGameMenuController {
	private Stage context;

	@FXML
	private TextField textField1;
	@FXML
	private TextField textField2;
	@FXML
	private TextField textField4;
	@FXML
	private TextField textField3;
	@FXML
	private CheckBox checkBox2;
	@FXML
	private CheckBox checkBox3;
	@FXML
	private CheckBox checkBox4;

	@FXML
	void returnToMainMenu(ActionEvent event) {
		new MainMenu().display(context);
	}

	@FXML
	void startNewGame(ActionEvent event) throws Exception {
		System.out.println("StartButton");
		System.out.println("Invoked " + textField1.getText());
		MainMenu.sm.stopMusic();
		MainMenu.soundCreated = 0;
		new GameMenu().display(context, textField1.getText(),
				textField2.getText(),
				checkBox2.isSelected(),
				textField3.getText(),
				checkBox3.isSelected(),
				textField4.getText(),
				checkBox4.isSelected());
	}

	public void setStage(Stage context) {
		this.context = context;
	}
}
