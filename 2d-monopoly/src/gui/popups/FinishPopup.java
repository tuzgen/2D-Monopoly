package gui.popups;

import gui.menus.MainMenu;
import gui.misc.Style;
import javafx.animation.PauseTransition;
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
import javafx.stage.StageStyle;
import javafx.util.Duration;
import management.FileManager;
import management.SoundManager;


public class FinishPopup {

    private String playerName;
    private boolean isWin;

    public FinishPopup(String playerName, boolean win){
        this.playerName = playerName;
        isWin = win;
    }

    public void display(Stage context){
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Gameover");
        window.setMinWidth(300);
        window.setMinHeight(125);

        Label label = new Label("Game is over!!!");
        Label infoLabel = new Label( playerName + " WON THE GAME");
        Label endLabel = new Label("Now, " + playerName + " is not a rich person.\n" + playerName + " is a poor person with money.");
        label.setStyle(Style.label_font_two);
        label.setTextFill(Color.GREEN);
        endLabel.setTextFill(Color.AQUA);

        infoLabel.setStyle(Style.label_font_two);
        infoLabel.setTextFill(Color.GREEN);
        endLabel.setStyle(Style.label_font_two);

        Button menuBtn = new Button("Return Main Menu");
        menuBtn.setStyle(Style.button_four);

        menuBtn.setOnAction( e -> onPressed_button_return_main_menu(context, window));

        VBox vbox = new VBox(10);
        vbox.setStyle(Style.window_border);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, infoLabel, endLabel, menuBtn);

        vbox.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();
    }

    private void onPressed_button_return_main_menu(Stage context, Stage window) {
        // Push the settings screen to the context
        MainMenu.soundCreated = 0;
        SoundManager.getInstance().stopMusic();
        window.close();
        try {
            FileManager.saveGame();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        new MainMenu().display(context);
    }

}
