package gui.popups;

import entity.Bank;
import entity.map.tile.TaxTile;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import management.GameManager;

public class TaxPopup {

	public void display(String title, TaxTile tile, boolean isIncomeTax) {
		// Initiate pop up
		Stage window = new Stage();
		window.initStyle(StageStyle.UNDECORATED);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		window.setMinHeight(400);

		//texts
		Text infoText = new Text(" " + tile.getName() + "?");
		infoText.setFill(Color.WHITE);
		Text taxInfoText = new Text( isIncomeTax ? "Income tax " : "Luxury tax " + "pay " + tile.getAmount() + "₺." );
		taxInfoText.setFill(Color.WHITE);

		// A button which displays a message and quits
		Button returnButton = new Button("OK");
		returnButton.setOnAction(e -> {
			// forces the player to give all of their money
			Bank.getInstance().takeMoney(GameManager.getInstance().getTurnOfPlayer(), tile.getAmount());
			window.close();
		});
		returnButton.setStyle("-fx-background-color: #9999FF;");

		// Image
		Image house = new Image("file:src/vendor/image/house.png"); // TODO change this image
		ImageView houseView = new ImageView(house);
		houseView.setFitHeight(100);
		houseView.setFitWidth(100);

		// Create layout and add Text and Button
		VBox layout = new VBox(20);
		layout.setBackground(new Background(new BackgroundFill(Color.rgb(102, 102, 153), null, null)));
		HBox hLayout = new HBox(30);
		hLayout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(houseView, infoText, hLayout);
		layout.setAlignment(Pos.CENTER);
		hLayout.getChildren().addAll(returnButton);
		layout.getChildren().addAll(taxInfoText);
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
