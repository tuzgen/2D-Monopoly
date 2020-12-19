package gui.popups;

import entity.player.Player;
import gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import management.GameManager;
import management.TradeManager;

public class ShowTradesPopup {

    public void display(Stage context){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("Trades");
        stage.setWidth(410);
        stage.setHeight(300);
        Background bg = new Background(new BackgroundFill(new Color(0,0,0,1), null, null));
        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setBackground(bg);

        ScrollPane sp = new ScrollPane();
        sp.setFitToWidth(true);
        sp.setFitToHeight(true);
        Player currentPlayer = GameManager.getInstance().getTurnOfPlayer();

        for(int i = 0; i < currentPlayer.getTrades().size(); i++) {
            VBox yourTilesBox = new VBox(10);
            VBox offeredTilesBox = new VBox(10);
            HBox buttonBox = new HBox(10);
            HBox tilesBox = new HBox(25);
            VBox endBox = new VBox(10);

            yourTilesBox.setBackground(bg);
            offeredTilesBox.setBackground(bg);
            buttonBox.setBackground(bg);
            tilesBox.setBackground(bg);
            endBox.setBackground(bg);
            yourTilesBox.setAlignment(Pos.TOP_LEFT);
            offeredTilesBox.setAlignment(Pos.TOP_LEFT);
            buttonBox.setAlignment(Pos.CENTER);
            tilesBox.setAlignment(Pos.CENTER);
            endBox.setAlignment(Pos.CENTER);

            Label namelbl = new Label("Offered Player: " + currentPlayer.getTrades().get(i).getOwner().getName());
            namelbl.setTextFill(Color.WHITE);

            Button acceptBtn = new Button("Accept");
            Button declineBtn = new Button("Decline");
            buttonBox.getChildren().addAll(acceptBtn, declineBtn);
            acceptBtn.setStyle(Style.button_one);
            declineBtn.setStyle(Style.button_one);
            Label offered = new Label("Offered tiles:");
            offered.setTextFill(Color.rgb(130,178,255));
            Label requested = new Label("Requested tiles:");
            requested.setTextFill(Color.rgb(194,58,178));
            offeredTilesBox.getChildren().add(offered);
            yourTilesBox.getChildren().add(requested);

            for(int k = 0; k < currentPlayer.getTrades().get(i).getOwnersTile().size(); k++){
                Label lbl = new Label(currentPlayer.getTrades().get(i).getOwnersTile().get(k).getName());
                lbl.setTextFill(Color.rgb(130,178,255));
                offeredTilesBox.getChildren().add(lbl);
            }
            Label offeredAmount = new Label("Offered amount: " + currentPlayer.getTrades().get(i).getOfferedAmount());
            offeredAmount.setTextFill(Color.rgb(130,178,255));
            offeredTilesBox.getChildren().add(offeredAmount);
            for(int j = 0; j < currentPlayer.getTrades().get(i).getTargetTile().size(); j++) {
                Label lb = new Label(currentPlayer.getTrades().get(i).getTargetTile().get(j).getName());
                lb.setTextFill(Color.rgb(194,58,178));
                yourTilesBox.getChildren().add(lb);
            }
            Label requestedLabel = new Label("Requested amount: " + currentPlayer.getTrades().get(i).getRequestedAmount());
            requestedLabel.setTextFill(Color.rgb(194,58,178));
            yourTilesBox.getChildren().add(requestedLabel);
            tilesBox.getChildren().addAll(offeredTilesBox, yourTilesBox);
            endBox.getChildren().addAll(namelbl, tilesBox, buttonBox);
            endBox.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-border-width: 6;" +
                    "-fx-border-insets: 0;" +
                    "-fx-border-radius: 0;" +
                    "-fx-border-color: teal;");

            mainBox.getChildren().add(endBox);
            sp.setContent(mainBox);
            int x = i;
            acceptBtn.setOnAction(event -> {
                TradeManager.getInstance().acceptTrade(currentPlayer.getTrades().get(x));
                buttonBox.getChildren().clear();
                Label lab = new Label("Deal is done!");
                lab.setTextFill(Color.GREEN);
                buttonBox.getChildren().addAll(lab);
            });

            declineBtn.setOnAction(event -> {
                TradeManager.getInstance().denyTrade(currentPlayer.getTrades().get(x));
                buttonBox.getChildren().clear();
                Label lab = new Label("Denied!");
                lab.setTextFill(Color.RED);
                buttonBox.getChildren().addAll(lab);
            });
        }

        Button close = new Button("Close");
        close.setStyle(Style.button_one);
        close.setAlignment(Pos.CENTER);
        mainBox.getChildren().add(close);

        close.setOnAction(event -> {
            for(int t = 0; t < currentPlayer.getTrades().size(); t++){
                TradeManager.getInstance().denyTrade(currentPlayer.getTrades().get(t));
            }
            stage.close();
        });

        Scene scene = new Scene(sp);
        stage.setScene(scene);
        stage.showAndWait();

    }

}
