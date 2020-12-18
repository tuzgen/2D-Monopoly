package gui.popups;

import entity.map.tile.Tile;
import entity.player.Player;
import gui.misc.Style;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import javafx.util.Duration;
import management.GameManager;
import management.TradeManager;

import java.util.ArrayList;

public class TradePopup {

    private int playerNo;
    public TradePopup(int playerNo){ this.playerNo = playerNo; }

    public void display(Stage context) {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        PauseTransition delay = new PauseTransition(Duration.millis(2000));
        ArrayList<Tile> yourTiles = GameManager.getInstance().getTurnOfPlayer().getTileList();
        ArrayList<Tile> theirTiles = GameManager.getInstance().getPlayerAt(playerNo).getTileList();
        ArrayList<Tile> selectedyours = new ArrayList<Tile>();
        ArrayList<Tile> selectedtheirs = new ArrayList<Tile>();
        ArrayList<CheckBox> yourChecks = new ArrayList<CheckBox>();
        ArrayList<CheckBox> theirChecks = new ArrayList<CheckBox>();
        Player currentPlayer = GameManager.getInstance().getTurnOfPlayer();
        Player targetPlayer = GameManager.getInstance().getPlayerAt(playerNo);
        Label showTheirTiles = new Label("Select the tiles you want: (0 or more)");
        Label showYourTiles = new Label("Select tiles to offer: (0 or more)");
        Button offerBtn = new Button("Offer");
        Button cancelBtn = new Button("Cancel");
        TextField yourTF = new TextField();
        TextField theirTF = new TextField();
        VBox selectYours = new VBox(10);
        VBox selectTheirs = new VBox(10);
        VBox buttonsLayout = new VBox(10);
        HBox finalLayout = new HBox(10);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("Trade with me");
        stage.setMinWidth(600);
        stage.setMaxHeight(600);

        showTheirTiles.setPadding(new Insets(10,5,0,5));
        showYourTiles.setPadding(new Insets(10,5,0,5));
        showTheirTiles.setTextFill(Color.rgb(194,58,178));
        showYourTiles.setTextFill(Color.rgb(130,178,255));

        offerBtn.setStyle(Style.button_one);
        cancelBtn.setStyle(Style.button_one);

        yourTF.setPromptText("Offered amount: (optional)");
        theirTF.setPromptText("Requested amount: (optional)");

        selectYours.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        selectTheirs.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        buttonsLayout.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        finalLayout.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
        selectYours.setAlignment(Pos.TOP_LEFT);
        selectTheirs.setAlignment(Pos.TOP_LEFT);
        buttonsLayout.setAlignment(Pos.BOTTOM_CENTER);
        finalLayout.setAlignment(Pos.BOTTOM_CENTER);
        selectYours.getChildren().addAll(showYourTiles);
        selectTheirs.getChildren().addAll(showTheirTiles);
        buttonsLayout.getChildren().addAll(offerBtn, cancelBtn);
        finalLayout.getChildren().addAll(selectYours, selectTheirs, buttonsLayout);

        for(int i = 0; i < yourTiles.size(); i++) {
            yourChecks.add(new CheckBox(yourTiles.get(i).getName()));
            yourChecks.get(i).setTextFill(Color.rgb(130,178,255));
            selectYours.getChildren().add(yourChecks.get(i));
        }
        for(int k = 0; k < theirTiles.size(); k++) {
            theirChecks.add(new CheckBox(theirTiles.get(k).getName()));
            theirChecks.get(k).setTextFill(Color.rgb(194,58,178));
            selectTheirs.getChildren().add(theirChecks.get(k));
        }

       // for(int j = 0; j < yourChecks.size(); j++) // will be deleted if works fine later
         //   selectYours.getChildren().add(yourChecks.get(j));
       // for(int m = 0; m < theirChecks.size(); m++)
         //   selectTheirs.getChildren().add(theirChecks.get(m));

        selectYours.getChildren().add(yourTF);
        selectTheirs.getChildren().add(theirTF);

        offerBtn.setOnAction(event -> {
            int yourtxt = yourTF.getText().equals("") ? 0 : Integer.parseInt(yourTF.getText());
            int theirtxt = theirTF.getText().equals("") ? 0 : Integer.parseInt(theirTF.getText());

            for(int i = 0; i < yourChecks.size(); i++)
                if(yourChecks.get(i).isSelected())
                    selectedyours.add(yourTiles.get(i));

            for(int k = 0; k < theirChecks.size(); k++)
                if(theirChecks.get(k).isSelected())
                    selectedtheirs.add(theirTiles.get(k));
            if(!((yourChecks.size() == 0) && (theirChecks.size() == 0))) {
                System.out.println(TradeManager.getInstance().openTrade(currentPlayer, targetPlayer, selectedtheirs, selectedyours, yourtxt, theirtxt));

                Label lastLbl = new Label("We will ask, wait your next turn for a result!\nNote that the lowest price isn't always the best deal...");
                lastLbl.setTextFill(Color.GREEN);
                lastLbl.setAlignment(Pos.CENTER);
                VBox vbox = new VBox(10);
                vbox.setAlignment(Pos.CENTER);
                vbox.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
                vbox.getChildren().add(lastLbl);
                Scene endsc = new Scene(vbox);
                stage.setScene(endsc);
                delay.setOnFinished(e -> stage.close());
                delay.play();
            }
        });

        cancelBtn.setOnAction(event -> {
            stage.close();
        });

        Scene scene = new Scene(finalLayout);
        stage.setScene(scene);
        stage.showAndWait();
    }

}
