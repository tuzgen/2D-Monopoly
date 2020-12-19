package gui.popups;
import entity.card.Card;
import entity.map.tile.BuyableTile;
import entity.player.npcs.Mafia;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import management.GameManager;

public class CardPopup {
    // Constants

    // State variables

    // Methods
    public void display(String title, Card c) {
        // Initiate pop up
        PauseTransition delay = new PauseTransition(Duration.millis(4500));
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(150);

        //texts
        Text inform = new Text(c.getFeature());
        inform.setFill(Color.WHITE);

        // Create layout and add Text and Button
        VBox layout = new VBox(20);
        layout.setBackground(new Background(new BackgroundFill( Color.rgb(102,102,153), null, null)));
        layout.getChildren().addAll(inform);
        layout.setAlignment(Pos.CENTER);

        // Set the scene for the pop up
        Scene scene = new Scene(layout);
        window.setScene(scene);
        layout.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 6;" +
                "-fx-border-insets: 0;" +
                "-fx-border-radius: 0;" +
                "-fx-border-color: #CCCCFF;");
        delay.setOnFinished(event -> window.close());
        delay.play();
        window.showAndWait();


    }
}
