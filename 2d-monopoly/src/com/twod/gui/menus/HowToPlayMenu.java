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

public class HowToPlayMenu {
	public static void display(Stage context) {
		Button button_return = new Button("Go back");
		button_return.setStyle(Style.button_one);
		button_return.setOnAction( e -> {
			MainMenu.display(context);
		});

		VBox layout_how_to_play = new VBox(20);
		layout_how_to_play.setAlignment(Pos.CENTER);
		layout_how_to_play.getChildren().addAll(
				button_return
		);

		BorderPane layout = new BorderPane(layout_how_to_play);

		Scene scene_how_to_play = new Scene(layout, 1280, 720);

		HBox layout_FPS = new HBox(0);
		layout_FPS.setAlignment(Pos.TOP_RIGHT);
		layout_FPS.getChildren().add(new FPSCounter().display(scene_how_to_play));

		layout.setTop(layout_FPS);

		context.setScene(scene_how_to_play);
	}
}
