package gui.popups;

import entity.map.tile.CityTile;
import entity.player.npcs.Mafia;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class HousePopup {
	// Constants

	// State variables

	// Methods
	public static void display(String title, CityTile tile) {
		// Initiate pop up
		Stage window = new Stage();
		window.initStyle(StageStyle.UNDECORATED);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		window.setMinHeight(400);

		//texts
		Text infoText = new Text("Do you wanna build a house at " + tile.getName() + "?");
		infoText.setFill(Color.WHITE);
		Text mafiaDealText = new Text("Do you wanna deal with mafia to build a house at "
				+ tile.getName() + " for " + (int)(tile.getPrice()*(Mafia.TILE_DISCOUNT))+"₺ ?");
		mafiaDealText.setFill(Color.WHITE);
		Text price = new Text(tile.getHouseBuildPrice()+ "₺");
		price.setFill(Color.WHITE);

		// A button which displays a message and quits
		Button returnButton = new Button("Return");
		returnButton.setOnAction( e -> {
			System.out.println("Button pressed on pop up");
			window.close();
		});
		returnButton.setStyle("-fx-background-color: #9999FF;");

		// A button which lets the player buy a house
		Button buildButton = new Button("Build");
		buildButton.setOnAction( e -> {
			System.out.println("Button pressed on pop up");
			GameManager.getInstance().buildHouse(GameManager.getInstance().getTurnOfPlayer(), tile.getId(), false);
			window.close();
		});
		buildButton.setStyle("-fx-background-color: #CCFFCC");

		// A button which lets the player buy a house cheaper using mafia favor
		Button mafiaButton = new Button("Deal");
		mafiaButton.setOnAction( e -> {
			System.out.println("Button pressed on pop up");
			GameManager.getInstance().buildHouse(GameManager.getInstance().getTurnOfPlayer(), tile.getId(), true);
			window.close();
		});
		mafiaButton.setStyle("-fx-background-color: #FF6666;");


		// A button which lets the player buy a house cheaper using mafia favor
		Button hotelButton = new Button("Build Hotel for "+ tile.getHotelBuildPrice()+"₺");
		hotelButton.setDisable(true);
		if (tile.isHotelBuildAvailable()) {
			hotelButton.setDisable(false);
		}
		mafiaButton.setOnAction( e -> {
			System.out.println("Button pressed on pop up");
			GameManager.getInstance().buildHotel(GameManager.getInstance().getTurnOfPlayer(), tile.getId(), false);
			window.close();
		});
		returnButton.setStyle("-fx-background-color: #6699CC;");


		// Image
		Image house = new Image("file:src/vendor/image/house.png");
		ImageView houseView = new ImageView(house);
		houseView.setFitHeight(100);
		houseView.setFitWidth(100);

		// Create layout and add Text and Button
		VBox layout = new VBox(20);
		layout.setBackground(new Background(new BackgroundFill( Color.rgb(102,102,153), null, null)));
		layout.setAlignment(Pos.CENTER);
		HBox hLayout = new HBox(30);
		hLayout.setAlignment(Pos.CENTER);
		hLayout.getChildren().addAll(returnButton, buildButton);
		layout.getChildren().addAll(houseView, infoText, price, hLayout, mafiaDealText, mafiaButton, hotelButton);
		layout.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 6;" +
				"-fx-border-insets: 0;" +
				"-fx-border-radius: 0;" +
				"-fx-border-color: #CCCCFF;");

		// Set the scene for the pop up
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}