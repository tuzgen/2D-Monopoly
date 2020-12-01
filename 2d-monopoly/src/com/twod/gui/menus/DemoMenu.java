package com.twod.gui.menus;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DemoMenu {
	public static void display(Stage context) {
		// board
		BackgroundImage test = new BackgroundImage(
				new Image("file:vendor/image/test.png", 500, 500, true, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(1280, 720, false, false, true, true));

		StackPane board_space = new StackPane();
		board_space.setAlignment(Pos.CENTER_LEFT);
		board_space.setBackground(new Background(test));
		board_space.getChildren().addAll(new Button("bruh"));

		Pane border = new Pane();
		border.getChildren().addAll(board_space, new Button("xd"));
		Scene scene = new Scene(border, 1280, 720);

		context.setScene(scene);
		context.show();
	}
}
