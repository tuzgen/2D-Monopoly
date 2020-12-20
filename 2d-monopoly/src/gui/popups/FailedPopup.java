package gui.popups;

import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class FailedPopup {
    public void display(Stage context){
        PauseTransition delay = new PauseTransition(Duration.millis(2000));
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Gameover");
        window.setMinWidth(300);
        window.setMinHeight(125);

        Label label = new Label();
        label.setText("Failed to buy not enough money");
        VBox vbox = new VBox();
        vbox.getChildren().add(label);
        vbox.setPadding(new Insets(50, 50, 50, 50));
        Scene scene = new Scene(vbox);

        window.setScene(scene);
        delay.setOnFinished(event -> window.close());
        delay.play();
        window.showAndWait();
    }
}
