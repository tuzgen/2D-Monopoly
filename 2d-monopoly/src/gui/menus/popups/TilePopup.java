package gui.menus.popups;

import entity.map.tile.CityTile;
import entity.map.tile.TransportationTile;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TilePopup {
		// Constants

		// State variables

		// Methods
		public static void display(String title, CityTile tile) {
			// Initiate pop up
			System.out.println();
			Stage window = new Stage();
			window.initStyle(StageStyle.UNDECORATED);
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle(title);
			window.setMinWidth(250);

			Text infoText = new Text(tile.getName() + " Tile no " + tile.getId());

			// A button which displays a message and quits
			Button yesButton = new Button("Return");
			yesButton.setOnAction( e -> {
				System.out.println("Button pressed on pop up");
				window.close();
			});

			// Create layout and add Text and Button
			VBox layout = new VBox(10);
			layout.getChildren().addAll(infoText, yesButton);
			layout.setAlignment(Pos.CENTER);

			// Set the scene for the pop up
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		}
		public static void display(String title, TransportationTile tile) {
		// Initiate pop up
		System.out.println();
		Stage window = new Stage();
		window.initStyle(StageStyle.UNDECORATED);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		Text infoText = new Text(tile.getName() + " Tile no " + tile.getId());

		// A button which displays a message and quits
		Button yesButton = new Button("Return");
		yesButton.setOnAction( e -> {
			System.out.println("Button pressed on pop up");
			window.close();
		});

		// Create layout and add Text and Button
		VBox layout = new VBox(10);
		layout.getChildren().addAll(infoText, yesButton);
		layout.setAlignment(Pos.CENTER);

		// Set the scene for the pop up
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	}