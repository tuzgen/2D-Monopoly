package gui.menus;

import gui.misc.FPSCounter;
import gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import management.FileManager;
import management.GameManager;

public class LoadGameMenu {
	public void display(Stage context) {
		Button button_start = new Button("Start game");
		button_start.setStyle(Style.button_six);
		button_start.setOnAction( e -> {
			try {
				FileManager.loadGame();
				new GameMenu().display(context);
			} catch (Exception exception) {
				System.out.println(exception.toString());
				System.err.println("Load failed.");
			}
		});

		Button button_return = new Button("Go back");
		button_return.setStyle(Style.button_one);
		button_return.setOnAction( e -> {
			new MainMenu().display(context);
		});

		VBox layout_load_game = new VBox(20);
		layout_load_game.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
		layout_load_game.setAlignment(Pos.CENTER);
		layout_load_game.getChildren().addAll(
				button_start, button_return
		);

		BorderPane layout = new BorderPane(layout_load_game);

		Scene scene_load_game = new Scene(layout, 1280, 720);

		HBox layout_FPS = new HBox(0);
		layout_FPS.setAlignment(Pos.TOP_RIGHT);
		layout_FPS.getChildren().add(new FPSCounter().display(scene_load_game));

		layout.setTop(layout_FPS);

		context.setScene(scene_load_game);
	}
}
