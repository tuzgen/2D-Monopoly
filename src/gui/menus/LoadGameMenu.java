package gui.menus;

import gui.misc.FPSCounter;
import gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import management.GameManager;

public class LoadGameMenu {
	public void display(Stage context) {
		Button button_start = new Button("Start game");
		button_start.setStyle(Style.button_one);
		button_start.setOnAction( e -> {
			if (GameManager.loadGame())
				try {
					new GameMenu().display(context);
				} catch (Exception exception) {
					System.err.println("Load failed.");
				}
			else
				System.err.println("Load Failed");
		});

		Button button_return = new Button("Go back");
		button_return.setStyle(Style.button_one);
		button_return.setOnAction( e -> {
			new MainMenu().display(context);
		});

		VBox layout_load_game = new VBox(20);
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