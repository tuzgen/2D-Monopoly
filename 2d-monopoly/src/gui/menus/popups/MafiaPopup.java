package gui.menus.popups;

import gui.misc.Style;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MafiaPopup {

    public void display(Stage context){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Use Mafia Favour.");
        window.setMinWidth(300);
        window.setMinHeight(125);

        Label label = new Label("What you want?");
        Button blackmailButton = new Button("Blackmail someone");
        Button jailbreakButton = new Button("Get me out of this filthy hole");
        Button buyCommunityCardButton = new Button("Give me some handy cards");
        VBox layout = new VBox(10);

        label.setPadding(new Insets(10,0,0,0));
        label.setTextFill(Color.WHITE);
        blackmailButton.setStyle(Style.button_one);
        jailbreakButton.setStyle(Style.button_one);
        buyCommunityCardButton.setStyle(Style.button_one);

        blackmailButton.setOnAction(event -> {
            System.out.println("Blackmail");
        });

        jailbreakButton.setOnAction(event -> {
            System.out.println("jailbreakButton");
        });

        buyCommunityCardButton.setOnAction(event -> {
            System.out.println("buyCommunityCardButton");
        });

        layout.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        layout.getChildren().addAll(label, blackmailButton, jailbreakButton, buyCommunityCardButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}
