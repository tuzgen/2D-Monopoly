package gui.menus.popups;

import gui.misc.Style;
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

import javax.swing.*;

public class PowerUpPopup {

    public void display(Stage context){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("Buy power-up crate");
        stage.setMinWidth(300);
        stage.setMinHeight(150);
        Background bg = new Background(new BackgroundFill(new Color(0,0,0,1), null, null));
        VBox vBox = new VBox(10);
        HBox hBox = new HBox(10);
        Button buy = new Button("Buy");
        Button cancel = new Button("Cancel");
        Label label = new Label("This will cost you 50.000₺. Do you want to buy a power-up crate?");

        label.setTextFill(Color.rgb(240,158,110));
        buy.setStyle(Style.button_one);
        cancel.setStyle(Style.button_one);

        vBox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        vBox.setBackground(bg);
        hBox.setBackground(bg);

        hBox.getChildren().addAll(buy, cancel);
        vBox.getChildren().addAll(label, hBox);

        buy.setOnAction(event -> {

        });

        cancel.setOnAction(event -> {
            stage.close();
        });

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.showAndWait();
    }

}
