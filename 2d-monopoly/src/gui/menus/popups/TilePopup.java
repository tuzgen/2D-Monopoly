package gui.menus.popups;

import entity.map.tile.CityTile;
import entity.map.tile.CompanyTile;
import entity.map.tile.TransportationTile;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import management.GameManager;
import entity.player.Player;

public class TilePopup {
		// Constants

		// State variables

		// Methods
		public void display(String title, CityTile tile) {
			// Initiate pop up
			Stage window = new Stage();
			window.initStyle(StageStyle.UNDECORATED);
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle(title);
			window.setMinWidth(300);
			window.setMinHeight(400);

			Text infoText = new Text("Do you wanna buy " + tile.getName() + "?");
			infoText.setFill(Color.WHITE);
			Text mafiaDealText = new Text("Do you wanna deal with mafia to buy "
					+ tile.getName() + " for " + (int)(tile.getPrice()*(0.8))+"₺ ?");
			mafiaDealText.setFill(Color.WHITE);
			Text price = new Text(tile.getPrice() + "₺");
			price.setFill(Color.WHITE);

			// A button which displays a message and quits
			Button yesButton = new Button("Return");
			yesButton.setOnAction( e -> {
				System.out.println("Button pressed on pop up");
				window.close();
			});
			Button buyButton = new Button("Buy");
			buyButton.setOnAction( e -> {
				System.out.println("Button pressed on pop up");
				GameManager.getInstance().mapBuyTile(GameManager.getInstance().getTurnOfPlayer(),tile.getId());
				window.close();
			});
			Button mafiaButton = new Button("Deal");
			mafiaButton.setOnAction( e -> {
				System.out.println("Button pressed on pop up");
				GameManager.getInstance().getMafia().sellCard(GameManager.getInstance().getTurnOfPlayer());
				window.close();
			});

			// Image
			Image house = new Image("file:src/vendor/image/house.png");
			ImageView houseView = new ImageView(house);
			//houseView.setX(10);
			//houseView.setY(10);
			houseView.setFitHeight(100);
			houseView.setFitWidth(100);

			// Create layout and add Text and Button
			VBox layout = new VBox(20);
			layout.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
			HBox hLayout = new HBox(30);
			hLayout.setAlignment(Pos.CENTER);
			layout.getChildren().addAll( houseView, infoText, price, hLayout);
			layout.setAlignment(Pos.CENTER);
			hLayout.getChildren().addAll( yesButton, buyButton);
			layout.getChildren().addAll(mafiaDealText, mafiaButton);

			// Set the scene for the pop up
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		}
		public void display(String title, TransportationTile tile) {
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
		public void display(String title, CompanyTile tile) {

		}
	}