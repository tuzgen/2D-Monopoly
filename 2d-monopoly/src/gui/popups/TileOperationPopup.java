package gui.popups;

import entity.map.tile.BuyableTile;
import entity.map.tile.Tile;
import entity.player.Player;
import gui.misc.Style;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import management.Map;


public class TileOperationPopup {

    private Tile tile;

    public TileOperationPopup(Tile tile){
        this.tile = tile;
    }

    public void display(Stage context){
        PauseTransition delay = new PauseTransition(Duration.millis(2000));
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Tile operations");
        window.setMinWidth(125);
        window.setMinHeight(125);

        Image house = new Image("file:src/vendor/image/city.png");
        ImageView houseView = new ImageView(house);
        houseView.setFitHeight(100);
        houseView.setFitWidth(300);

        Label label = new Label("Tile name: " + tile.getName());
        Label mortgagelb = new Label("Mortgage your tile: ");
        Label sellTilelb = new Label("Sell the tile: ");
        Label sellHouselb = new Label("Sell a house: ");
        Label sellHotellb = new Label("Sell a hotel: ");
        Label buildHotellb = new Label("Build an hotel: ");
        Label buildHouselb = new Label("Build an House: ");
        Label mortgageStatlb = new Label("Mortgage status: " + ((BuyableTile) tile).isMortgage());
        label.setTextFill(Color.rgb(101, 42, 73));
        label.setStyle("-fx-font-size: 22; -fx-font-family: Forte;");

        mortgagelb.setStyle(Style.label_font);
        sellTilelb.setStyle(Style.label_font);
        sellHouselb.setStyle(Style.label_font);
        sellHotellb.setStyle(Style.label_font);
        buildHotellb.setStyle(Style.label_font);
        buildHouselb.setStyle(Style.label_font);
        mortgageStatlb.setStyle(Style.label_font);

        mortgagelb.setTextFill(Color.rgb(56,123,181));
        sellHotellb.setTextFill(Color.AQUA);
        sellHouselb.setTextFill(Color.AQUA);
        sellTilelb.setTextFill(Color.AQUA);
        buildHotellb.setTextFill(Color.YELLOW);
        buildHouselb.setTextFill(Color.YELLOW);
        mortgageStatlb.setTextFill(Color.rgb(56,123,181));

        Button closeBtn = new Button("Close");
        Button sellHouseBtn = new Button("Sell");
        Button sellHotelBtn = new Button("Sell");
        Button sellTileBtn = new Button("Sell");
        Button mortgageBtn = new Button("Mortgage");
        Button removeMortgage = new Button("Remove Mortage");
        Button buildHotelBtn = new Button("Build");
        Button buildHouseBtn = new Button("Build");
        closeBtn.setStyle(Style.button_four);
        sellHotelBtn.setStyle(Style.button_four);
        sellHouseBtn.setStyle(Style.button_four);
        sellTileBtn.setStyle(Style.button_four);
        mortgageBtn.setStyle(Style.button_four);
        buildHotelBtn.setStyle(Style.button_four);
        buildHouseBtn.setStyle(Style.button_four);
        removeMortgage.setStyle(Style.button_four);

        HBox mortgageBox = new HBox(10);
        HBox sellHouseBox = new HBox(10);
        HBox sellHotelBox = new HBox(10);
        HBox sellTileBox = new HBox(10);
        HBox buildHouseBox = new HBox(10);
        HBox buildHotelBox = new HBox(10);
        VBox endBox = new VBox(10);
        VBox mortStatBox = new VBox(10);

        Background bg = new Background(new BackgroundFill(new Color(0,0,0,1), null, null));

        mortgageBox.setBackground(bg);
        sellHouseBox.setBackground(bg);
        sellHotelBox.setBackground(bg);
        sellTileBox.setBackground(bg);
        buildHouseBox.setBackground(bg);
        buildHotelBox.setBackground(bg);
        mortStatBox.setBackground(bg);
        endBox.setBackground(bg); // may be changed

        label.setAlignment(Pos.TOP_LEFT);
        mortStatBox.setAlignment(Pos.TOP_LEFT);
        mortgageBox.setAlignment(Pos.TOP_LEFT);
        sellHouseBox.setAlignment(Pos.TOP_LEFT);
        sellHotelBox.setAlignment(Pos.TOP_LEFT);
        sellTileBox.setAlignment(Pos.TOP_LEFT);
        buildHouseBox.setAlignment(Pos.TOP_LEFT);
        buildHotelBox.setAlignment(Pos.TOP_LEFT);
        endBox.setAlignment(Pos.CENTER);
        closeBtn.setAlignment(Pos.CENTER);

        mortgageBox.getChildren().addAll(mortgagelb, mortgageBtn, removeMortgage);
        sellHotelBox.getChildren().addAll(sellHotellb, sellHotelBtn);
        sellHouseBox.getChildren().addAll(sellHouselb, sellHouseBtn);
        sellTileBox.getChildren().addAll(sellTilelb, sellTileBtn);
        buildHotelBox.getChildren().addAll(buildHotellb, buildHotelBtn);
        buildHouseBox.getChildren().addAll(buildHouselb, buildHouseBtn);
        endBox.setStyle(Style.window_border);
        mortStatBox.getChildren().add(mortgageStatlb);
        endBox.getChildren().addAll(houseView, label, mortStatBox, mortgageBox, buildHouseBox, buildHotelBox, sellHotelBox, sellHouseBox, sellTileBox, closeBtn);

        closeBtn.setOnAction(event -> {
            window.close();
        });

        sellHouseBtn.setOnAction(event -> {

        });

        sellHotelBtn.setOnAction(event -> {

        });

        sellTileBtn.setOnAction(event -> {

        });

        mortgageBtn.setOnAction(event -> {
            ((BuyableTile) tile).setMortgage(GameManager.getInstance().getTurnOfPlayer());
            label.setText("You mortgaged your tile with 50% of its value.");
            endBox.getChildren().removeAll( sellHotelBox, sellHouseBox, mortStatBox, buildHotelBox, buildHouseBox, closeBtn, mortgageBox, sellTileBox);
            delay.setOnFinished(e -> window.close());
            delay.play();
        });

        removeMortgage.setOnAction(event -> {
            if(((BuyableTile) tile).removeMortgage(GameManager.getInstance().getTurnOfPlayer()) == 1)
                label.setText("You removed mortgage with 10% interest.");
            else if(((BuyableTile) tile).removeMortgage(GameManager.getInstance().getTurnOfPlayer()) == 2)
                label.setText("You don't have enough money.");
            else
                label.setText("Your tile is not mortgaged.");
            endBox.getChildren().removeAll( sellHotelBox, sellHouseBox, mortStatBox, buildHotelBox, buildHouseBox, closeBtn, mortgageBox, sellTileBox);
            delay.setOnFinished(e -> window.close());
            delay.play();
        });

        buildHotelBtn.setOnAction(event -> {
            if(GameManager.getInstance().getTurnOfPlayer().getLocation() != tile.getId()){
                label.setText("You need to be standing on the tile!!");
            } else if(Map.getInstance().buildHotel(GameManager.getInstance().getTurnOfPlayer(), tile.getId())){
                label.setText("Your hotel is ready!!");
            } else {
                label.setText("Hotel build is not available!!");
            }
            endBox.getChildren().removeAll( sellHotelBox, sellHouseBox, mortStatBox, buildHotelBox, buildHouseBox, closeBtn, mortgageBox, sellTileBox);
            delay.setOnFinished(e -> window.close());
            delay.play();
        });

        buildHouseBtn.setOnAction(event -> {
            if(GameManager.getInstance().getTurnOfPlayer().getLocation() != tile.getId()){
                label.setText("You need to be standing on the tile!!");
            } else if(Map.getInstance().buildHouse(GameManager.getInstance().getTurnOfPlayer(), tile.getId())) {
                label.setText("Your house is build!!");
            } else {
                label.setText("House build is not available!!");
            }
            endBox.getChildren().removeAll( sellHotelBox, sellHouseBox, mortStatBox, buildHotelBox, buildHouseBox, closeBtn, mortgageBox, sellTileBox);
            delay.setOnFinished(e -> window.close());
            delay.play();
        });

        Scene scene = new Scene(endBox);
        window.setScene(scene);
        window.showAndWait();

    }
}
