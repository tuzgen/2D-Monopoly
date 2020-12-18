package gui.menus.popups;

import entity.player.Playable;
import entity.player.Player;
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
import java.util.ArrayList;

public class MafiaPopup {

    public void display(Stage context){
        PauseTransition delay = new PauseTransition(Duration.millis(1500));
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
        ArrayList<Player> otherPlayers = new ArrayList<Player>();
        Player currentPlayer = GameManager.getInstance().getTurnOfPlayer();
        Label blabel = new Label("I'm gonna make him an offer he can't refuse.\n\t\t\tSelect one of them.");
        Label endLabel = new Label("Great deal...");
        int yourIndex = GameManager.getInstance().getTurnOfPlayerIndex();
        for(int i = 0; i < 4; i++)
            if( i != yourIndex)
                otherPlayers.add(GameManager.getInstance().getPlayerAt(i));
        Button pl1 = new Button(otherPlayers.get(0).getName());
        Button pl2 = new Button(otherPlayers.get(1).getName());
        Button pl3 = new Button(otherPlayers.get(2).getName());
        VBox blayout = new VBox(10);

        pl1.setOnAction(event -> {
            GameManager.getInstance().getMafia().blackmail(otherPlayers.get(0), currentPlayer);
            blayout.getChildren().clear();
            blayout.getChildren().add(endLabel);
            delay.setOnFinished(e -> window.close());
            delay.play();

        });

        pl2.setOnAction(event -> {
            GameManager.getInstance().getMafia().blackmail(otherPlayers.get(1), currentPlayer);
            blayout.getChildren().clear();
            blayout.getChildren().add(endLabel);
            delay.setOnFinished(e -> window.close());
            delay.play();
        });

        pl3.setOnAction(event -> {
            GameManager.getInstance().getMafia().blackmail(otherPlayers.get(2), currentPlayer);
            blayout.getChildren().clear();
            blayout.getChildren().add(endLabel);
            delay.setOnFinished(e-> window.close());
            delay.play();
        });

        pl1.setStyle(Style.button_one);
        pl2.setStyle(Style.button_one);
        pl3.setStyle(Style.button_one);

        blabel.setPadding(new Insets(10,5,0,5));
        blabel.setTextFill(Color.WHITE);
        endLabel.setTextFill(Color.WHITE);

        blayout.setAlignment(Pos.CENTER);
        blayout.getChildren().addAll(blabel, pl1, pl2, pl3);
        blayout.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        Scene bscene = new Scene(blayout);

        //CommunityCard------------------------------------------------------------------------------
        Label clabel = new Label("This will cost you 20.000₺. Are you sure?");
        Button yButton = new Button("Yes");
        VBox clayout = new VBox(10);
        HBox chlayout = new HBox(10);
        Button nButton = new Button("No");

        clabel.setPadding(new Insets(10,0,0,0));
        clabel.setTextFill(Color.WHITE);

        yButton.setOnAction( e -> {
            Player player = GameManager.getInstance().getTurnOfPlayer();
            String result = GameManager.getInstance().getMafia().sellCard(player);
            if(result.equals("false"))
            {
                clabel.setText("You couldn't meet the requirements,\n\t\tdeal is over, leave!");
            } else {
                clabel.setText("Feature: " + result);
            }
            window.setWidth(600);
            clayout.getChildren().clear();
            clayout.getChildren().add(clabel);
            delay.setOnFinished(event -> window.close());
            delay.play();
        });

        nButton.setOnAction( e -> {
            window.close();
        });

        yButton.setStyle(Style.button_one);
        nButton.setStyle(Style.button_one);
        chlayout.getChildren().addAll(yButton, nButton);
        chlayout.setAlignment(Pos.CENTER);
        clayout.getChildren().addAll(clabel, chlayout);
        clayout.setAlignment(Pos.CENTER);
        clayout.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        Scene cscene = new Scene(clayout);

        // End of the popup
        jailbreakButton.setOnAction(event -> {
            window.setScene(jscene);
        });

        blackmailButton.setOnAction(event -> {
            window.setScene(bscene);
        });

        buyCommunityCardButton.setOnAction(event -> {
            window.setScene(cscene);
        });

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
