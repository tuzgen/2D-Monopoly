package gui.popups;

import entity.powerup.PowerUp;
import gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.text.DecimalFormat;

public class PowerupInfoPopup {

    private String behName;
    private PowerUp powerup;
    public PowerupInfoPopup(PowerUp powerup){
        this.behName = powerup.getBehaviourName();
        this.powerup = powerup;
    }

    public void display(Stage context){
        DecimalFormat df = new DecimalFormat("####.##");
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Use Pop-up");
        window.setMinWidth(300);
        window.setMinHeight(125);


        Label label = new Label("Do you want to use " + behName + "?");
        Label amLabel = new Label();
        Label lifetimeLabel = new Label();
        Label enterLabel = new Label("Please enter target player's name:");
        TextField tf = new TextField();
        tf.setPromptText("This cannot be empty!");
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

        lifetimeLabel.setText("Lifetime: " + powerup.getLifetime() + " tours");
        if(powerup.getBehaviourName().equals("Forex Power-up")){
            amLabel.setText("Change Rate: " + df.format(powerup.getAmount()) + "%");
            enterLabel.setText("Please enter a name of currency:");
        } else if(powerup.getBehaviourName().equals(("Earning Power-up"))) {
            amLabel.setText("Earning coefficient: " + df.format(powerup.getAmount()) + " times higher");
        } else if(powerup.getBehaviourName().equals("Strike Power-up")) {
            amLabel.setText("Move: " + df.format(powerup.getAmount()) + " tiles backward");
            lifetimeLabel.setText("Lifetime: 1 tours");
        } else { //"Slowdown Power-up"
            amLabel.setText("Slow Rate: " + df.format(powerup.getAmount()) + "%");
        }

        allBox.getChildren().addAll(lifetimeLabel, amLabel, enterLabel, tf, label, btnBox);
        useBtn.setOnAction(event -> {
            
        });

        cancelBtn.setOnAction(event -> {
            window.close();
        });

        Scene scene = new Scene(allBox);
        window.setScene(scene);
        window.showAndWait();
    }
}
