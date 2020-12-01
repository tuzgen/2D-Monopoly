package com.twod.gui.menus;

import com.twod.gui.misc.FPSCounter;
import com.twod.gui.misc.Style;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HowToPlayMenu {
	public static void display(Stage context) {
		Button button_return = new Button("Go back");
		button_return.setStyle(Style.button_one);
		button_return.setOnAction( e -> {
			MainMenu.display(context);
		});

		Text text_how_to_play = new Text("Git gud");
		text_how_to_play.setStyle(Style.text_one);

		Text text2 = new Text("JK this functionality is coming soon..");
		text_how_to_play.setStyle(Style.text_two);


		VBox layout_how_to_play = new VBox(20);
		layout_how_to_play.setAlignment(Pos.CENTER);
		layout_how_to_play.getChildren().addAll(
				text_how_to_play, text2, button_return
		);

		BorderPane layout = new BorderPane(layout_how_to_play);

		Scene scene_how_to_play = new Scene(layout, 1280, 720);

		HBox layout_FPS = new HBox(0);
		layout_FPS.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 1), null, null)));
		layout_FPS.setAlignment(Pos.TOP_RIGHT);
		layout_FPS.getChildren().add(new FPSCounter().display(scene_how_to_play));

		layout.setTop(layout_FPS);

		context.setScene(scene_how_to_play);
	}
}
