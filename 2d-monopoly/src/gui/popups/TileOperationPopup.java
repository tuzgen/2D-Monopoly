package gui.popups;

import entity.map.tile.Tile;
import gui.misc.Style;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;



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

        Label label = new Label("Tile name:" + tile.getName());
        Label mortgagelb = new Label("Mortgage your tile: ");
        Label sellTilelb = new Label("Sell the tile: ");
        Label sellHouselb = new Label("Sell a house: ");
        Label sellHotellb = new Label("Sell a hotel: ");
        Label buildHotellb = new Label("Build an hotel: ");
        Label buildHouselb = new Label("Build an House: ");
        label.setTextFill(Color.WHITE);
        mortgagelb.setTextFill(Color.AQUA);
        sellHotellb.setTextFill(Color.AQUA);
        sellHouselb.setTextFill(Color.AQUA);
        sellTilelb.setTextFill(Color.AQUA);
        buildHotellb.setTextFill(Color.YELLOW);
        buildHouselb.setTextFill(Color.YELLOW);

        Button closeBtn = new Button("Close");
        Button sellHouseBtn = new Button("Sell");
        Button sellHotelBtn = new Button("Sell");
        Button sellTileBtn = new Button("Sell");
        Button mortgageBtn = new Button("Mortgage");
        Button buildHotelBtn = new Button("Build");
        Button buildHouseBtn = new Button("Build");
        closeBtn.setStyle(Style.button_one);
        sellHotelBtn.setStyle(Style.button_one);
        sellHouseBtn.setStyle(Style.button_one);
        sellTileBtn.setStyle(Style.button_one);
        mortgageBtn.setStyle(Style.button_one);
        buildHotelBtn.setStyle(Style.button_one);
        buildHouseBtn.setStyle(Style.button_one);

        HBox mortgageBox = new HBox(10);
        HBox sellHouseBox = new HBox(10);
        HBox sellHotelBox = new HBox(10);
        HBox sellTileBox = new HBox(10);
        HBox buildHouseBox = new HBox(10);
        HBox buildHotelBox = new HBox(10);
        VBox endBox = new VBox(10);

        Background bg = new Background(new BackgroundFill(new Color(0,0,0,1), null, null));

        mortgageBox.setBackground(bg);
        sellHouseBox.setBackground(bg);
        sellHotelBox.setBackground(bg);
        sellTileBox.setBackground(bg);
        buildHouseBox.setBackground(bg);
        buildHotelBox.setBackground(bg);
        endBox.setBackground(bg); // may be changed

        mortgageBox.getChildren().addAll(mortgagelb, mortgageBtn);
        sellHotelBox.getChildren().addAll(sellHotellb, sellHotelBtn);
        sellHouseBox.getChildren().addAll(sellHouselb, sellHouseBtn);
        sellTileBox.getChildren().addAll(sellTilelb, sellTileBtn);
        buildHotelBox.getChildren().addAll(buildHotellb, buildHotelBtn);
        buildHouseBox.getChildren().addAll(buildHouselb, buildHouseBtn);

        closeBtn.setOnAction(event -> {

        });

        sellHouseBtn.setOnAction(event -> {

        });

        sellHotelBtn.setOnAction(event -> {

        });

        sellTileBtn.setOnAction(event -> {

        });

        mortgageBtn.setOnAction(event -> {

        });

        buildHotelBtn.setOnAction(event -> {

        });

        buildHouseBtn.setOnAction(event -> {

        });
    }
}
