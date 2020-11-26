package com.twod.gui.menus.popups;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClosePopup {

	static boolean answer;

	public static void display(Stage context) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Quit game");
		window.setMinWidth(300);
		window.setMinHeight(125);

		Label label = new Label("Are you sure you want to exit?");

		Button yesButton = new Button("Yes");
		yesButton.setOnAction( e -> {
			window.close();
			context.close();
		});

		Button noButton = new Button("No");
		noButton.setOnAction( e -> {
			window.close();
		});

		HBox layout_button = new HBox(10);
		layout_button.getChildren().addAll(yesButton, noButton);
		layout_button.setAlignment(Pos.CENTER);

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, layout_button);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

	}
}