package gui.menus.controller;

import gui.menus.GameMenu;
import gui.menus.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewGameMenuController {
	private Stage context;

	@FXML
	TextField textField1, textField2, textField3, textField4;
	@FXML
	CheckBox checkBox2, checkBox3, checkBox4;

	@FXML
	void initialize() {
		textField1 = new TextField();
		textField2 = new TextField();
		textField3 = new TextField();
		textField4 = new TextField();
		checkBox2 = new CheckBox();
		checkBox3 = new CheckBox();
		checkBox4 = new CheckBox();
	}

	public void returnToMainMenu() {
		new MainMenu().display(context);
	}

	public void startNewGame() throws Exception {

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
