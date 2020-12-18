package gui.menus.popups;

import gui.menus.MainMenu;
import gui.menus.SettingsMenu;
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
import management.SoundManager;

public class PausePopup {
	public void display(Stage context) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Pause game");
		window.setResizable(false);
		window.setMinWidth(300);
		window.setMinHeight(125);

		Button button_continue = new Button("Continue");
		button_continue.setStyle(Style.button_one);
		button_continue.setOnAction( e -> window.close());

		Button button_return_main_menu = new Button("Go back to main menu");
		button_return_main_menu.setStyle(Style.button_one);
		button_return_main_menu.setOnAction( e -> onPressed_button_return_main_menu(context, window));

		VBox layout = new VBox(10);
		layout.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
		layout.getChildren().addAll(button_continue, button_return_main_menu);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

	private void onPressed_button_return_main_menu(Stage context, Stage window) {
		// Push the settings screen to the context
		SoundManager.getInstance().stopMusic();
		window.close();
		new MainMenu().display(context);
	}
}