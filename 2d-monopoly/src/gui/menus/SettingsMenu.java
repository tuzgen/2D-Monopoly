package gui.menus;

import cached.Settings;
import gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import management.FileManager;
import management.GameManager;

public class SettingsMenu {
	// Constants

	// State variables

	// Components
	private Scene scene_settings_menu;

	private Label label_title, label_colorblind, label_mute;
	private Button button_return;
	private CheckBox checkBox_colorblind, checkBox_mute;

	public void display(Stage context) {

		// initialize components
		label_title = new Label("Settings");
		label_title.setStyle(Style.text_two);

		label_colorblind = new Label("Colorblind mode ");
		label_colorblind.setStyle(Style.text_three);

		checkBox_colorblind = new CheckBox();
		checkBox_colorblind.setStyle(Style.checkbox_one);
		checkBox_colorblind.setOnAction( e -> updateSettings() );

		label_mute = new Label("Mute Sound");
		label_mute.setStyle(Style.text_three);

		checkBox_mute = new CheckBox();
		checkBox_mute.setStyle(Style.checkbox_one);
		checkBox_mute.setOnAction( e -> updateSettings() );

		updateDisplay();

		button_return = new Button("Go back");
		button_return.setStyle(Style.button_one);
		button_return.setOnAction( e -> onPressed_button_return(context) );

		// Layout 2 horizontal row
		HBox layout_row1 = new HBox(10);
		layout_row1.getChildren().addAll(
				label_colorblind, checkBox_colorblind
		);
		layout_row1.setAlignment(Pos.CENTER);

		HBox layout_row2 = new HBox(10);
		layout_row2.getChildren().addAll(
				label_mute, checkBox_mute
		);
		layout_row2.setAlignment(Pos.CENTER);

		// Layout 1 vertical column
		VBox layout_main_menu = new VBox(20);
		layout_main_menu.getChildren().addAll(
				label_title, layout_row1, layout_row2, button_return
		);
		layout_main_menu.setAlignment(Pos.CENTER);

		layout_main_menu.setBackground(new Background(new BackgroundFill(Color.color(0, 0, 0), null, null)));
		scene_settings_menu = new Scene(layout_main_menu, 1280, 720);

		context.setScene(scene_settings_menu);
		context.show();
	}

	private void onPressed_button_return(Stage context) {
		updateSettings();
		new MainMenu().display(context);
	}

	private void updateSettings() {
		FileManager.updateSettings(
				new Settings(checkBox_colorblind.isSelected(), checkBox_mute.isSelected()));
	}

	private void updateDisplay() {
		checkBox_mute.setSelected(FileManager.loadSettings().getMutedMode());
		checkBox_colorblind.setSelected(FileManager.loadSettings().getColorblindMode());
	}
}