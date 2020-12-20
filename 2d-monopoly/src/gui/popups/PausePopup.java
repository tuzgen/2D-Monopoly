package gui.popups;

import gui.menus.MainMenu;
import gui.menus.controller.GameMenuController;
import gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import management.FileManager;
import management.GameManager;
import management.SoundManager;


public class PausePopup {
	public void display(Stage context) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.initStyle(StageStyle.UNDECORATED);
		window.setTitle("Pause game");
		window.setResizable(false);
		window.setMinWidth(300);
		window.setMinHeight(125);

		Button button_continue = new Button("Continue");
		button_continue.setStyle(Style.button_one);
		button_continue.setOnAction( e -> {
			SoundManager.getInstance().continueMusic();
			window.close();
		});

		Button button_return_main_menu = new Button("Go back to main menu");
		button_return_main_menu.setStyle(Style.button_one);
		button_return_main_menu.setOnAction( e -> onPressed_button_return_main_menu(context, window));

		Button button_resign = new Button("Resign");
		button_resign.setStyle(Style.button_one);
		button_resign.setOnAction(e -> resign(window));



		VBox layout = new VBox(10);
		layout.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
		layout.getChildren().addAll(button_continue, button_resign, button_return_main_menu);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle(Style.window_border);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}



	private void onPressed_button_return_main_menu(Stage context, Stage window) {
		// Push the settings screen to the context
		MainMenu.soundCreated = 0;
		SoundManager.getInstance().stopMusic();
		window.close();
		try {
			FileManager.saveGame();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		new MainMenu().display(context);
	}

	private void resign(Stage window){
		SoundManager.getInstance().continueMusic();
		GameManager.getInstance().resign(GameManager.getInstance().getTurnOfPlayer());
		window.close();
	}
}