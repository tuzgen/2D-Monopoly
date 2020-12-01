package com.twod.gui.menus.popups;

import com.twod.gui.menus.MainMenu;
import com.twod.gui.menus.SettingsMenu;
import com.twod.gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PausePopup {
	public static void display(Stage context) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Pause game");
		window.setMinWidth(300);
		window.setMinHeight(125);

		Button button_continue = new Button("Continue");
		button_continue.setStyle(Style.button_one);
		button_continue.setOnAction( e -> window.close());

		Button button_settings_menu = new Button("Settings");
		button_settings_menu.setStyle(Style.button_one);
		button_settings_menu.setOnAction( e -> onPressed_button_settings_menu(context, window) );

		Button button_return_main_menu = new Button("Go back to main menu");
		button_return_main_menu.setStyle(Style.button_one);
		button_return_main_menu.setOnAction( e -> onPressed_button_return_main_menu(context, window));

		VBox layout = new VBox(10);
		layout.getChildren().addAll(button_continue, button_settings_menu, button_return_main_menu);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

	private static void onPressed_button_settings_menu(Stage context, Stage window) {
		// Push the settings screen to the context
		window.close();
		SettingsMenu.display(context);
	}

	private static void onPressed_button_return_main_menu(Stage context, Stage window) {
		// Push the settings screen to the context
		window.close();
		MainMenu.display(context);
	}
}
