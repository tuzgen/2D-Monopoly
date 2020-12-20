package gui.popups;

import entity.powerup.PowerUpCrate;
import gui.menus.GameMenu;
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
import management.SoundManager;

import javax.swing.*;

public class PowerUpPopup {

    public void display(Stage context){
        Stage stage = new Stage();
        PauseTransition delay = new PauseTransition(Duration.millis(2000));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setTitle("Buy power-up crate");
        stage.setMinWidth(300);
        stage.setMinHeight(150);
        Background bg = new Background(new BackgroundFill(Color.rgb(115,115,115), null, null));
        VBox vBox = new VBox(10);
        HBox hBox = new HBox(10);
        Button buy = new Button("Buy");
        Button cancel = new Button("Cancel");
        PowerUpCrate crate = new PowerUpCrate(GameManager.getInstance().getTurnOfPlayer()); // TODO refactor move this to gameManager
        Label label = new Label("This will cost you " + crate.getPrice() + "₺. Do you want to buy a power-up crate?");
        label.setTextFill(Color.rgb(240,158,110));
        buy.setStyle(Style.button_one);
        cancel.setStyle(Style.button_one);
        SoundManager sm = new SoundManager(false);

        vBox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        vBox.setBackground(bg);
        hBox.setBackground(bg);

        hBox.getChildren().addAll(buy, cancel);
        vBox.getChildren().addAll(label, hBox);

        buy.setOnAction(event -> {

            if(crate.buyPowerUp()){
                label.setText("If there's one way to disrupt a man's plans,\nit is to destabilize his timeline.");
                sm.music(4);
            }
            else{
                label.setText("You don't have enough money!");
            }
            vBox.getChildren().remove(hBox);
            delay.setOnFinished(e -> stage.close());
            delay.play();
        });

        cancel.setOnAction(event -> {
            stage.close();
        });

        vBox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 6;" +
                "-fx-border-insets: 0;" +
                "-fx-border-radius: 0;" +
                "-fx-border-color: #f09e6e;");

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.showAndWait();
    }

}
