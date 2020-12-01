package com.twod.gui.menus;

import com.twod.gui.menus.popups.ClosePopup;
import com.twod.gui.misc.FPSCounter;
import com.twod.gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainMenu {
	// Constants

	// State variables

	// Components
	private static Scene scene_main_menu;

	private static Text label_title;
	private static Button button_new_game, button_settings_menu, button_how_to_play,
			button_load_game, button_credits_menu, button_quit_game;
	private static AudioClip clip_main;

	public static void display(Stage context) {
		// "D:\\dev\\courses\\cs319\\2D-Monopoly\\2d-monopoly\\vendor\\sound\\main_menu.wav").toURI().toString()
		// clip_main = new AudioClip("file:vendor/sound/main_menu.wav");
		// clip_main.play();

		// Media media = new Media(new File("D:\\dev\\courses\\cs319\\2D-Monopoly\\2d-monopoly\\vendor\\sound\\main_menu.wav").toURI().toString());
		// MediaPlayer mediaPlayer = new MediaPlayer(media);
		// mediaPlayer.play();

		// initialize components
		label_title = new Text("Monopoly Sicilia");
		label_title.setStyle(Style.text_one);
		label_title.setFill(Color.RED);

		button_new_game = new Button("New Game");
		button_new_game.setStyle(Style.button_one);
		button_new_game.setOnAction( e -> onPressed_button_new_game(context) );

		button_how_to_play = new Button("How to play");
		button_how_to_play.setStyle(Style.button_one);
		button_how_to_play.setOnAction( e -> onPressed_button_how_to_play(context) );

		button_settings_menu = new Button("Settings");
		button_settings_menu.setStyle(Style.button_one);
		button_settings_menu.setOnAction( e -> onPressed_button_settings_menu(context) );

		button_load_game = new Button("Load Game");
		button_load_game.setStyle(Style.button_one);
		button_load_game.setOnAction( e -> onPressed_button_load_game(context) );

		button_credits_menu = new Button("Credits");
		button_credits_menu.setStyle(Style.button_one);
		button_credits_menu.setOnAction( e -> onPressed_button_credits_menu(context) );

		button_quit_game = new Button("Quit Game");
		button_quit_game.setStyle(Style.button_one);
		button_quit_game.setOnAction( e -> onPressed_button_quit_game(context) );

		// Layout 1 vertical column
		VBox layout_menu_buttons = new VBox(20);
		layout_menu_buttons.setAlignment(Pos.CENTER);
		layout_menu_buttons.getChildren().addAll(
				label_title, button_new_game, button_how_to_play, button_settings_menu,
				button_load_game, button_credits_menu, button_quit_game
		);

		// TODO get and replace this placeholder with real bg
		BackgroundImage myBI= new BackgroundImage(new Image("file:vendor/image/main.png", 734, 440, true,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(100, 100, true, true, true, true));


		BorderPane layout_main_menu = new BorderPane(layout_menu_buttons);

		layout_menu_buttons.setBackground(new Background(myBI));

		scene_main_menu = new Scene(layout_main_menu, 1280, 720);

		HBox layout_FPS = new HBox(0);
		layout_FPS.setAlignment(Pos.TOP_RIGHT);
		layout_FPS.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 1), null, null)));
		layout_FPS.getChildren().add(new FPSCounter().display(scene_main_menu));

		layout_main_menu.setTop(layout_FPS);

		context.setScene(scene_main_menu);
		context.show();
	}

	private static void onPressed_button_new_game(Stage context) {
		startNewGame(context);
	}

	private static void startNewGame(Stage context) {
		NewGameMenu.display(context);
	}

	private static void onPressed_button_how_to_play(Stage context) {
		HowToPlayMenu.display(context);
	}

	private static void onPressed_button_settings_menu(Stage context) {
		// Push the settings screen to the context
		SettingsMenu.display(context);
	}

	private static void onPressed_button_load_game(Stage context) {
		LoadGameMenu.display(context);
	}

	private static void onPressed_button_credits_menu(Stage context) {
		CreditsMenu.display(context);
	}

	private static void onPressed_button_quit_game(Stage context) {
		ClosePopup.display(context);
	}
}