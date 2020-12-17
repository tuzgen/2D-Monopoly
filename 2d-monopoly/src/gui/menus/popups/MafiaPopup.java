package gui.menus.popups;

import gui.misc.Style;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
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
import javafx.util.Duration;
import management.GameManager;
import sun.misc.JavaLangAccess;

import javax.swing.*;

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

        layout.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        layout.getChildren().addAll(label, blackmailButton, jailbreakButton, buyCommunityCardButton);
        layout.setAlignment(Pos.CENTER);

        //Jailbreak-----------------------------------------------------------------------------
        Label jlabel = new Label("This will cost you 50.000₺. Are you sure?");
        Button yesButton = new Button("Yes");
        Button noButton = noButton = new Button("No");
        VBox jlayout = new VBox(10);
        HBox jhlayout = new HBox(10);

        jlabel.setPadding(new Insets(10,0,0,0));
        jlabel.setTextFill(Color.WHITE);

        yesButton.setOnAction( e -> {
            jlayout.getChildren().removeAll(jlabel, jhlayout);
            Label finalLabel;
            if(GameManager.getInstance().getMafia().jailbreak(GameManager.getInstance().getTurnOfPlayer())){
                finalLabel = new Label("RUN!");
            }
            else{
                finalLabel = new Label("You couldn't meet the requirements,\n\t\tdeal is over, leave!");
            }
            finalLabel.setPadding(new Insets(10,0,0,0));
            finalLabel.setTextFill(Color.WHITE);
            jlayout.getChildren().add(finalLabel);
            PauseTransition delay = new PauseTransition(Duration.millis(1500));
            delay.setOnFinished(event -> window.close());
            delay.play();
        });

        noButton.setOnAction( e -> {
            window.close();
        });

        yesButton.setStyle(Style.button_one);
        noButton.setStyle(Style.button_one);
        jhlayout.getChildren().addAll(yesButton, noButton);
        jhlayout.setAlignment(Pos.CENTER);
        jlayout.getChildren().addAll(jlabel, jhlayout);
        jlayout.setAlignment(Pos.CENTER);
        jlayout.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        Scene jscene = new Scene(jlayout);

        //Blackmail----------------------------------------------------------------------------------


        //CommunityCard------------------------------------------------------------------------------


        // End of the popup
        jailbreakButton.setOnAction(event -> {
            window.setScene(jscene);
        });

        blackmailButton.setOnAction(event -> {
            System.out.println("Blackmail");
        });

        buyCommunityCardButton.setOnAction(event -> {
            System.out.println("buyCommunityCardButton");
        });

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
