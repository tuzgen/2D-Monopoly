package com.twod.gui.menus;

import com.twod.gui.misc.FPSCounter;
import com.twod.gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoadGameMenu {
	public static void display(Stage context) {
		Button button_return = new Button("Go back");
		button_return.setStyle(Style.button_one);
		button_return.setOnAction( e -> {
			MainMenu.display(context);
		});

		VBox layout_load_game = new VBox(20);
		layout_load_game.setAlignment(Pos.CENTER);
		layout_load_game.getChildren().addAll(
				button_return
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
