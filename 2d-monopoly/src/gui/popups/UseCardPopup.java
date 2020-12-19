package gui.popups;

import gui.misc.Style;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import management.GameManager;

public class UseCardPopup {

    public void display(Stage context) {
        PauseTransition delay = new PauseTransition(Duration.millis(2000));
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Use Card");
        window.setMinWidth(125);
        window.setMinHeight(125);

        VBox allBox = new VBox(10);
        HBox btnBox = new HBox(10);
        Label label = new Label("Do you want to use Jailbreak Daddy Card?");
        label.setTextFill(Color.AQUA);
        Button useBtn = new Button("Use");
        Button cancelBtn = new Button("Cancel");

        useBtn.setStyle(Style.button_one);
        cancelBtn.setStyle(Style.button_one);
        btnBox.setAlignment(Pos.CENTER);
        allBox.setAlignment(Pos.TOP_LEFT);
        btnBox.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        allBox.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        btnBox.getChildren().addAll(useBtn, cancelBtn);
        allBox.setStyle(Style.window_border);
        allBox.getChildren().addAll(label, btnBox);
        useBtn.setOnAction(event -> {
            GameManager.getInstance().getTurnOfPlayer().playCard();
            label.setText("Now you are free...");
            allBox.getChildren().remove(btnBox);
            allBox.setAlignment(Pos.CENTER);
            delay.setOnFinished(e -> window.close());
            delay.play();
        });

        cancelBtn.setOnAction(event -> {
            window.close();
        });

        Scene scene = new Scene(allBox);
        window.setScene(scene);
        window.showAndWait();
    }
}
