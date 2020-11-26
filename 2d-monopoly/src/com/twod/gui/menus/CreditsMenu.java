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

public class CreditsMenu {
	public static void display(Stage context) {
		Button button_return = new Button("Go back");
		button_return.setStyle(Style.button_one);
		button_return.setOnAction( e -> {
			MainMenu.display(context);
		});

		VBox layout_credits = new VBox(20);
		layout_credits.setAlignment(Pos.CENTER);
		layout_credits.getChildren().addAll(
				button_return
		);

		BorderPane layout = new BorderPane(layout_credits);

		Scene scene_credits = new Scene(layout, 1280, 720);

		HBox layout_FPS = new HBox(0);
		layout_FPS.setAlignment(Pos.TOP_RIGHT);
		layout_FPS.getChildren().add(new FPSCounter().display(scene_credits));

		layout.setTop(layout_FPS);

		context.setScene(scene_credits);
	}
}