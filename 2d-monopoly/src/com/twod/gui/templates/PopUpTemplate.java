package com.twod.gui.templates;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopUpTemplate {
	// Constants


	// State variables


	// Methods
	public static void display(String title, String message) {
		// Initiate pop up
		Stage window = new Stage();
		window.initStyle(StageStyle.UNDECORATED);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		// Some text to display
		Label label = new Label(message);

		// A button which displays a message and quits
		Button yesButton = new Button("Yes");
		yesButton.setOnAction( e -> {
			System.out.println("Button pressed on pop up");
			window.close();
		});

		// Create layout and add Text and Button
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton);
		layout.setAlignment(Pos.CENTER);

		// Set the scene for the pop up
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
