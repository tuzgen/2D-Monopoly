package gui.menus;

import gui.popups.ClosePopup;
import gui.misc.FPSCounter;
import gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import management.FileManager;
import management.GameManager;
import management.SoundManager;


public class MainMenu {
	// Constants

	// State variables

	// Components
	private Scene scene_main_menu;
	public static int soundCreated = 0;
	public static SoundManager sm = SoundManager.getInstance();
	private Text label_title;
	private Button button_new_game, button_settings_menu, button_how_to_play,
			button_load_game, button_credits_menu, button_quit_game;

	public void display(Stage context) {
		FileManager.loadSettings();
		GameManager.getInstance().deleteInstance();

		// initialize components
		if(soundCreated == 0) {
			sm.music(0);
			soundCreated = 1;
		}
		label_title = new Text("Monopoly Sicilia");
		label_title.setStyle(Style.text_one);
		label_title.setFill(Color.RED);

		button_new_game = new Button("New Game");
		button_new_game.setStyle(Style.button_five);
		button_new_game.setOnAction( e -> {
			try {
				onPressed_button_new_game(context);

			} catch (Exception exception) {
				System.err.println(exception.toString());// exception.toString());
			}
		} );

		button_how_to_play = new Button("How to play");
		button_how_to_play.setStyle(Style.button_five);
		button_how_to_play.setOnAction( e -> {
			try {
				onPressed_button_how_to_play(context);
			} catch (Exception exception) {
				System.err.println(exception.toString());
			}
		});

		button_settings_menu = new Button("Settings");
		button_settings_menu.setStyle(Style.button_five);
		button_settings_menu.setOnAction( e -> {
			try {
				onPressed_button_settings_menu(context);
			} catch (Exception exception) {
				System.err.println(exception.toString());
			}
		});

		button_load_game = new Button("Load Game");
		button_load_game.setStyle(Style.button_five);
		button_load_game.setOnAction( e -> {
			try {
				onPressed_button_load_game(context);
			} catch (Exception exception) {
				System.err.println(exception.toString());
			}
		} );

		button_credits_menu = new Button("Credits");
		button_credits_menu.setStyle(Style.button_five);
		button_credits_menu.setOnAction( e -> {
			try {
				onPressed_button_credits_menu(context);
			} catch (Exception exception) {
				System.err.println(exception.toString());
			}
		} );

		button_quit_game = new Button("Quit Game");
		button_quit_game.setStyle(Style.button_five);
		button_quit_game.setOnAction( e -> {
			try {
				onPressed_button_quit_game(context);
			} catch (Exception exception) {
				System.err.println(exception.toString());
			}
		});

		// Layout 1 vertical column
		VBox layout_menu_buttons = new VBox(20);
		layout_menu_buttons.setAlignment(Pos.CENTER);
		layout_menu_buttons.getChildren().addAll(
				label_title, button_new_game, button_how_to_play, button_settings_menu,
				button_load_game, button_credits_menu, button_quit_game
		);

		BackgroundImage myBI= new BackgroundImage(new Image("file:src/vendor/image/main.png", 734, 440, true,true),
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

	private void onPressed_button_new_game(Stage context) throws Exception {
		startNewGame(context);
	}

	private void startNewGame(Stage context) throws Exception {
		new NewGameMenu().display(context);
	}

	private void onPressed_button_how_to_play(Stage context) throws Exception {
		new HowToPlayMenu().display(context);
	}

	private void onPressed_button_settings_menu(Stage context) throws Exception {
		// Push the settings screen to the context
		new SettingsMenu().display(context);
	}

	private void onPressed_button_load_game(Stage context) throws Exception {
		new LoadGameMenu().display(context);
	}

	private void onPressed_button_credits_menu(Stage context) throws Exception {
		new CreditsMenu().display(context);
	}

	private void onPressed_button_quit_game(Stage context) throws Exception {
		new ClosePopup().display(context);
	}
}