package gui.popups;

import entity.player.Player;
import entity.powerup.PowerUp;
import gui.misc.Style;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PowerupInfoPopup {

    private String behName;
    private PowerUp powerup;
    public PowerupInfoPopup(PowerUp powerup){
        this.behName = powerup.getBehaviourName();
        this.powerup = powerup;
    }

    public void display(Stage context){
        DecimalFormat df = new DecimalFormat("####.##");
        PauseTransition delay = new PauseTransition(Duration.millis(2000));
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Use Pop-up");
        window.setMinWidth(125);
        window.setMinHeight(125);
        ArrayList<Player> otherPlayers = new ArrayList<Player>();
        int yourIndex = GameManager.getInstance().getTurnOfPlayerIndex();

        Label label = new Label("Do you want to use " + behName + "?");
        Label amLabel = new Label();
        Label lifetimeLabel = new Label();
        Label enterLabel = new Label("Please enter target player's name:");
        ToggleGroup tg = new ToggleGroup();
        RadioButton rb0 = new RadioButton();
        RadioButton rb1 = new RadioButton();
        RadioButton rb2 = new RadioButton();
        rb0.setSelected(true);
        rb0.setToggleGroup(tg);
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        label.setTextFill(Color.AQUA);
        amLabel.setTextFill(Color.rgb(0, 129, 52));
        lifetimeLabel.setTextFill(Color.AQUA);
        enterLabel.setTextFill(Color.WHITE);
        Button useBtn = new Button("Use");
        Button cancelBtn = new Button("Cancel");
        useBtn.setStyle(Style.button_one);
        cancelBtn.setStyle(Style.button_one);

        VBox allBox = new VBox(10);
        HBox btnBox = new HBox(10);
        btnBox.setAlignment(Pos.CENTER);
        allBox.setAlignment(Pos.TOP_LEFT);
        btnBox.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        allBox.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        btnBox.getChildren().addAll(useBtn, cancelBtn);
        allBox.setStyle(Style.window_border);

        for(int i = 0; i < 4; i++)
            if( i != yourIndex)
                otherPlayers.add(GameManager.getInstance().getPlayerAt(i));

        rb0.setText(otherPlayers.get(0).getName());
        rb0.setStyle("-fx-text-fill: red;");
        rb1.setText(otherPlayers.get(1).getName());
        rb1.setStyle("-fx-text-fill: red;");
        rb2.setText(otherPlayers.get(2).getName());
        rb2.setStyle("-fx-text-fill: red;");

        lifetimeLabel.setText("Lifetime: " + powerup.getLifetime() + " tours");
        if(powerup.getBehaviourName().equals("Forex Power-up")){
            rb0.setText("Dollar");
            rb1.setText("Euro");
            rb2.setText("Swiss Franc");
            amLabel.setText("Change Rate: " + df.format(powerup.getAmount()) + "%");
            enterLabel.setText("Please enter a name of currency:");
            allBox.getChildren().addAll(lifetimeLabel, amLabel, enterLabel, rb0, rb1, rb2, label, btnBox);
        } else if(powerup.getBehaviourName().equals(("Earning Power-up"))) {
            amLabel.setText("Earning coefficient: " + df.format(powerup.getAmount()) + " times higher");
            allBox.getChildren().addAll(lifetimeLabel, amLabel, label, btnBox);
        } else if(powerup.getBehaviourName().equals("Strike Power-up")) {
            amLabel.setText("Move: " + df.format(powerup.getAmount()) + " tiles backward");
            allBox.getChildren().addAll(amLabel, enterLabel, rb0, rb1, rb2, label, btnBox);
        } else { //"Slowdown Power-up"
            amLabel.setText("Slow Rate: " + df.format(powerup.getAmount()) + "%");
            allBox.getChildren().addAll(lifetimeLabel, amLabel, enterLabel, rb0, rb1, rb2, label, btnBox);
        }

        useBtn.setOnAction(event -> {
            String targetPersonsName = ((RadioButton) tg.getSelectedToggle()).getText();
            boolean isY = false;
            if(powerup.getBehaviourName().equals("Forex Power-up")){
                powerup.activate(GameManager.getInstance().getTurnOfPlayer(), targetPersonsName);
                isY = true;
            } else if(powerup.getBehaviourName().equals(("Earning Power-up"))) {
                powerup.activate(GameManager.getInstance().getTurnOfPlayer(), targetPersonsName);
                isY = true;
            } else if(powerup.getBehaviourName().equals("Strike Power-up")) {
                powerup.activate(GameManager.getInstance().getTurnOfPlayer(), targetPersonsName);
                isY = true;
            } else  if(powerup.getBehaviourName().equals("Slowdown Power-up")) {
                powerup.activate(GameManager.getInstance().getTurnOfPlayer(), targetPersonsName);
                isY = true;
            }
            if(isY){
                label.setText("Your power corrupts\nthose who don't have it...");
                allBox.getChildren().clear();
                allBox.getChildren().add(label);
                allBox.setAlignment(Pos.CENTER);
                delay.setOnFinished(e -> window.close());
                delay.play();
            }
        });

        cancelBtn.setOnAction(event -> {
            window.close();
        });

        Scene scene = new Scene(allBox);
        window.setScene(scene);
        window.showAndWait();
    }
}
