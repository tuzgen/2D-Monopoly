package gui.menus.controller;

import entity.Bank;
import entity.Trade;
import entity.card.Card;
import entity.card.CardDeck;
import entity.map.tile.*;
import entity.player.Player;
import entity.powerup.PowerUp;
import gui.misc.Style;
import gui.popups.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import management.ForexManager;
import management.GameManager;
import management.Map;
import management.SoundManager;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GameMenuController {
	private static GameMenuController instance;
	private DecimalFormat df = new DecimalFormat("####.##");

	public static GameMenuController getInstance() {
		if (instance == null)
			instance = new GameMenuController();
		return instance;
	}

	@FXML
	private AnchorPane listItems = new AnchorPane();
	@FXML
	private Label currentPlayerName = new Label();
	@FXML
	private Label showDollarAmount = new Label();
	@FXML
	private Label showEuroAmount = new Label();
	@FXML
	private Label showFrancAmount = new Label();
	@FXML
	private Label infoPlayer1Name = new Label();
	@FXML
	private Text infoPlayer1Money = new Text();
	@FXML
	private Label infoPlayer2Name = new Label();
	@FXML
	private Text infoPlayer2Money = new Text();
	@FXML
	private Label infoPlayer3Name = new Label();
	@FXML
	private Text infoPlayer3Money = new Text();
	@FXML
	private Label infoPlayer4Name = new Label();
	@FXML
	private Text infoPlayer4Money = new Text();
	@FXML
	private Label textForexDollar = new Label();
	@FXML
	private Button buttonDollarBuy = new Button();
	@FXML
	private Button buttonDollarSell = new Button();
	@FXML
	private Label textForexEuro = new Label();
	@FXML
	private Button buttonEuroBuy = new Button();
	@FXML
	private Button buttonEuroSell = new Button();
	@FXML
	private Label textForexFrank = new Label();
	@FXML
	private Button buttonFrancBuy = new Button();
	@FXML
	private Button buttonFrancSell = new Button();
	@FXML
	private TextField textFieldDollar = new TextField();
	@FXML
	private TextField textFieldEuro = new TextField();
	@FXML
	private TextField textFieldFranc = new TextField();
	@FXML
	private Button buttonTile39 = new Button();
	@FXML
	private Button buttonTile38 = new Button();
	@FXML
	private Button buttonTile37 = new Button();
	@FXML
	private Button buttonTile36 = new Button();
	@FXML
	private Button buttonTile35 = new Button();
	@FXML
	private Button buttonTile34 = new Button();
	@FXML
	private Button buttonTile33 = new Button();
	@FXML
	private Button buttonTile32 = new Button();
	@FXML
	private Button buttonTile31 = new Button();
	@FXML
	private Button buttonTile30 = new Button();
	@FXML
	private Button buttonTile29 = new Button();
	@FXML
	private Button buttonTile28 = new Button();
	@FXML
	private Button buttonTile27 = new Button();
	@FXML
	private Button buttonTile26 = new Button();
	@FXML
	private Button buttonTile25 = new Button();
	@FXML
	private Button buttonTile24 = new Button();
	@FXML
	private Button buttonTile23 = new Button();
	@FXML
	private Button buttonTile22 = new Button();
	@FXML
	private Button buttonTile21 = new Button();
	@FXML
	private Button buttonTile20 = new Button();
	@FXML
	private Button buttonTile19 = new Button();
	@FXML
	private Button buttonTile18 = new Button();
	@FXML
	private Button buttonTile17 = new Button();
	@FXML
	private Button buttonTile16 = new Button();
	@FXML
	private Button buttonTile15 = new Button();
	@FXML
	private Button buttonTile14 = new Button();
	@FXML
	private Button buttonTile13 = new Button();
	@FXML
	private Button buttonTile12 = new Button();
	@FXML
	private Button buttonTile11 = new Button();
	@FXML
	private Button buttonTile10 = new Button();
	@FXML
	private Button buttonTile9 = new Button();
	@FXML
	private Button buttonTile8 = new Button();
	@FXML
	private Button buttonTile7 = new Button();
	@FXML
	private Button buttonTile6 = new Button();
	@FXML
	private Button buttonTile5 = new Button();
	@FXML
	private Button buttonTile4 = new Button();
	@FXML
	private Button buttonTile3 = new Button();
	@FXML
	private Button buttonTile2 = new Button();
	@FXML
	private Button buttonTile1 = new Button();
	@FXML
	private Button buttonTile0 = new Button();
	@FXML
	private Button buttonPowerUpCrate = new Button();
	@FXML
	private ImageView iconPlayer1; // = new ImageView(new Image("file:src/vendor/image/diamond-green.png"));
	@FXML
	private ImageView iconMafia; // = new ImageView(new Image("file:src/vendor/image/mafia-face.png"));
	@FXML
	private ImageView iconPlayer3; // = new ImageView(new Image("file:src/vendor/image/diamond-pink.png"));
	@FXML
	private ImageView iconPolice; // = new ImageView(new Image("file:src/vendor/image/police-logo.png"));
	@FXML
	private ImageView iconPlayer2; // = new ImageView(new Image("file:src/vendor/image/diamond-red.png"));
	@FXML
	private ImageView iconPlayer4; // = new ImageView(new Image("file:src/vendor/image/diamond-blue.png"));
	@FXML
	private Button buttonPlayer1;
	@FXML
	private Button buttonPlayer2;
	@FXML
	private Button buttonPlayer3;
	@FXML
	private Button buttonPlayer4;
	@FXML
	private ImageView turnIndicator1;
	@FXML
	private ImageView turnIndicator2;
	@FXML
	private ImageView turnIndicator3;
	@FXML
	private ImageView turnIndicator4;
	@FXML
	private VBox root;// = new VBox();
	@FXML
	private Button endTurnButton = new Button();
	@FXML
	private Button rollRice = new Button();
	@FXML
	private Label roundCounter = new Label();
	@FXML
	private Label diceLabel = new Label();

	int[] player;

	private Stage context;
	private Button[] buttons;
	private ImageView[] icons;
	private final int[][] offsets = new int[][]{
			{22, 17}, {32, 17},
			{22, 27}, {32, 27},
			{22, 37}, {32, 37},
	};

	SoundManager sm = new SoundManager(false);

	@FXML
	public void initialize() {
		setupPlayersBar();
		setupAccountGUI();

		/*buttonTile0.setOnAction(e -> showTileActions(0));
		buttonTile1.setOnAction(e -> showTileActions(1));
		buttonTile2.setOnAction(e -> showTileActions(2));
		buttonTile3.setOnAction(e -> showTileActions(3));
		buttonTile4.setOnAction(e -> showTileActions(4));
		buttonTile5.setOnAction(e -> showTileActions(5));
		buttonTile6.setOnAction(e -> showTileActions(6));
		buttonTile7.setOnAction(e -> showTileActions(7));
		buttonTile8.setOnAction(e -> showTileActions(8));
		buttonTile9.setOnAction(e -> showTileActions(9));
		buttonTile10.setOnAction(e -> showTileActions(10));
		buttonTile11.setOnAction(e -> showTileActions(11));
		buttonTile12.setOnAction(e -> showTileActions(12));
		buttonTile13.setOnAction(e -> showTileActions(13));
		buttonTile14.setOnAction(e -> showTileActions(14));
		buttonTile15.setOnAction(e -> showTileActions(15));
		buttonTile16.setOnAction(e -> showTileActions(16));
		buttonTile17.setOnAction(e -> showTileActions(17));
		buttonTile18.setOnAction(e -> showTileActions(18));
		buttonTile19.setOnAction(e -> showTileActions(19));
		buttonTile20.setOnAction(e -> showTileActions(20));
		buttonTile21.setOnAction(e -> showTileActions(21));
		buttonTile22.setOnAction(e -> showTileActions(22));
		buttonTile23.setOnAction(e -> showTileActions(23));
		buttonTile24.setOnAction(e -> showTileActions(24));
		buttonTile25.setOnAction(e -> showTileActions(25));
		buttonTile26.setOnAction(e -> showTileActions(26));
		buttonTile27.setOnAction(e -> showTileActions(27));
		buttonTile28.setOnAction(e -> showTileActions(28));
		buttonTile29.setOnAction(e -> showTileActions(29));
		buttonTile30.setOnAction(e -> showTileActions(30));
		buttonTile31.setOnAction(e -> showTileActions(31));
		buttonTile32.setOnAction(e -> showTileActions(32));
		buttonTile33.setOnAction(e -> showTileActions(33));
		buttonTile34.setOnAction(e -> showTileActions(34));
		buttonTile35.setOnAction(e -> showTileActions(35));
		buttonTile36.setOnAction(e -> showTileActions(36));
		buttonTile37.setOnAction(e -> showTileActions(37));
		buttonTile38.setOnAction(e -> showTileActions(38));
		buttonTile39.setOnAction(e -> showTileActions(39)); */

		setupBoardGUI();
		update();
		endTurnButton.setDisable(true);
	}

	private void setupBoardGUI() {
		buttons = new Button[] {
				buttonTile0, buttonTile1, buttonTile2, buttonTile3, buttonTile4,
				buttonTile5, buttonTile6, buttonTile7, buttonTile8, buttonTile9,
				buttonTile10, buttonTile11, buttonTile12, buttonTile13, buttonTile14,
				buttonTile15, buttonTile16, buttonTile17, buttonTile18, buttonTile19,
				buttonTile20, buttonTile21, buttonTile22, buttonTile23, buttonTile24,
				buttonTile25, buttonTile26, buttonTile27, buttonTile28, buttonTile29,
				buttonTile30, buttonTile31, buttonTile32, buttonTile33, buttonTile34,
				buttonTile35, buttonTile36, buttonTile37, buttonTile38, buttonTile39
		};

		icons = new ImageView[]{
				iconPlayer1, iconPlayer2, iconPlayer3, iconPlayer4, iconMafia, iconPolice
		};
	}

	private void setupPlayersBar() {
		infoPlayer1Name.setText(GameManager.getInstance().getPlayerAt(0).getName());
		infoPlayer2Name.setText(GameManager.getInstance().getPlayerAt(1).getName());
		infoPlayer3Name.setText(GameManager.getInstance().getPlayerAt(2).getName());
		infoPlayer4Name.setText(GameManager.getInstance().getPlayerAt(3).getName());
		infoPlayer1Money.setText(df.format(GameManager.getInstance().getPlayerAt(0).getAccount().getTrl()) + "₺");
		infoPlayer2Money.setText(df.format(GameManager.getInstance().getPlayerAt(1).getAccount().getTrl()) + "₺");
		infoPlayer3Money.setText(df.format(GameManager.getInstance().getPlayerAt(2).getAccount().getTrl()) + "₺");
		infoPlayer4Money.setText(df.format(GameManager.getInstance().getPlayerAt(3).getAccount().getTrl()) + "₺");
		buttonPlayer1.setOnAction(this::showTradeActions);
		buttonPlayer2.setOnAction(this::showTradeActions);
		buttonPlayer3.setOnAction(this::showTradeActions);
		buttonPlayer4.setOnAction(this::showTradeActions);
		endTurnButton.setOnAction(this::endButton);
		rollRice.setOnAction(this::roll);
	}

	private void setupAccountGUI() {
		currentPlayerName.setText(GameManager.getInstance().getTurnOfPlayer().getName());
		textForexDollar.setText(Double.toString(GameManager.getInstance().getForexDollar()));
		textForexEuro.setText(Double.toString(GameManager.getInstance().getForexEuro()));
		textForexFrank.setText(Double.toString(GameManager.getInstance().getForexFrank()));

		buttonDollarBuy.setOnAction(buttonDollarBuy());
		buttonEuroBuy.setOnAction(buttonEuroBuy());
		buttonFrancBuy.setOnAction(buttonFrancBuy());

		buttonDollarSell.setOnAction(buttonDollarSell());
		buttonEuroSell.setOnAction(buttonEuroSell());
		buttonFrancSell.setOnAction(buttonFrancSell());
	}

	private void showTradeActions(ActionEvent e) {
		int playerNo = GameManager.getInstance().getTurnOfPlayerIndex();

		sm.music(5);
		if (e.getSource() == buttonPlayer1) {
			if (playerNo != 0)
				new TradePopup(0).display(context);
		} else if (e.getSource() == buttonPlayer2) {
			if (playerNo != 1)
				new TradePopup(1).display(context);
		} else if (e.getSource() == buttonPlayer3) {
			if (playerNo != 2)
				new TradePopup(2).display(context);
		} else if (e.getSource() == buttonPlayer4) {
			if (playerNo != 3)
				new TradePopup(3).display(context);
		}
		update();
	}

	private void showTileActions(int tileNo) {
		if (Map.getInstance().getTileAt(tileNo).getClass() == CityTile.class) {
			if(  !((BuyableTile)Map.getInstance().getTileAt(tileNo)).isOwned()) {
				new TilePopup().display("City Tile", (BuyableTile) Map.getInstance().getTileAt(tileNo));
			}
			if( ((BuyableTile)Map.getInstance().getTileAt(tileNo)).isOwned()){
				if (((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner() != GameManager.getInstance().getTurnOfPlayer()) {
					Bank.getInstance().takeMoney(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
				}
			}
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == CardTile.class) {
			System.out.print("CARD POP UP");
			if(((CardTile)(Map.getInstance().getTileAt(tileNo))).getIsChance() == true){
				new CardPopup().display("Card Tile", GameManager.getInstance().getChangedeck().drawCard(GameManager.getInstance().getTurnOfPlayer()) );
			}
			else{
				new CardPopup().display("Card Tile", GameManager.getInstance().getCommunitydeck().drawCard(GameManager.getInstance().getTurnOfPlayer()) );
			}
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == CompanyTile.class) {
			if( ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner() != GameManager.getInstance().getTurnOfPlayer() ){
				Bank.getInstance().takeMoney(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
			}
			if( !((CompanyTile)Map.getInstance().getTileAt(tileNo)).isOwned()){
			new TilePopup().display("Company Tile", (BuyableTile) Map.getInstance().getTileAt(tileNo));
			}
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == DoNothingTile.class) {
			// do nothing OwO
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == StartTile.class) {
			// unused might be deleted, handled in another place
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == TaxTile.class) {
			new TaxPopup().display("Tax Tile", (TaxTile) Map.getInstance().getTileAt(tileNo), tileNo != Map.LUXURYNO);
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == JailTile.class) {
			GameManager.getInstance().gotoJail();
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == TransportationTile.class) {
			if( ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner() != GameManager.getInstance().getTurnOfPlayer() ){
				Bank.getInstance().takeMoney(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
			}
			new TilePopup().display("Transportation Tile", (BuyableTile) Map.getInstance().getTileAt(tileNo));
		}
		update();

	}

	private void handleTileLanded(int tileNo) {
		if (Map.getInstance().getTileAt(tileNo).getClass() == CityTile.class) {

		}
	}

	private EventHandler<ActionEvent> buttonDollarBuy() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().buyForexDollar(
					Double.parseDouble(textFieldDollar.getText()) >= 0 ? Double.parseDouble(textFieldDollar.getText()) : 0);
			update();
		};
	}

	private EventHandler<ActionEvent> buttonDollarSell() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().sellForexDollar(
					Double.parseDouble(textFieldDollar.getText()) >= 0 ? Double.parseDouble(textFieldDollar.getText()) : 0);
			update();
		};
	}

	private EventHandler<ActionEvent> buttonEuroBuy() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().buyForexEuro(
					Double.parseDouble(textFieldEuro.getText()) >= 0 ? Double.parseDouble(textFieldEuro.getText()) : 0);
			update();
		};
	}

	private EventHandler<ActionEvent> buttonEuroSell() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().sellForexEuro(
					Double.parseDouble(textFieldEuro.getText()) >= 0 ? Double.parseDouble(textFieldEuro.getText()) : 0);
			update();
		};
	}

	private EventHandler<ActionEvent> buttonFrancBuy() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().buyForexFranc(
					Double.parseDouble(textFieldFranc.getText()) >= 0 ? Double.parseDouble(textFieldFranc.getText()) : 0);
			update();
		};
	}

	private EventHandler<ActionEvent> buttonFrancSell() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().sellForexFranc(
					Double.parseDouble(textFieldFranc.getText()) >= 0 ? Double.parseDouble(textFieldFranc.getText()) : 0);
			update();
		};
	}

	private void endButton(ActionEvent e) {
		endTurnButton.setDisable(true);
		updateAllLocations();
		GameManager.getInstance().increaseTurn();

		int turnOf = GameManager.getInstance().getTurnOfPlayerIndex();
		while (turnOf > 3) {
			GameManager.getInstance().playTurn();
			turnOf = GameManager.getInstance().getTurnOfPlayerIndex();
		}

		if (!GameManager.getInstance().getTurnOfPlayer().getTrades().isEmpty()){
			new ShowTradesPopup().display(context);
			update();
			endTurnButton.setDisable(true);
		}
		updateAllLocations();
		diamondUpdate(turnOf);
		rollRice.setDisable(false);
		updatePlayerLabels();
		getItems();
		roundCounter.setText("Round " + GameManager.getInstance().getRoundNo());

	}

	private void updatePlayerLabels() {
		showDollarAmount.setText("$" + df.format(GameManager.getInstance().getTurnOfPlayer().getAccount().getDollar()));
		showEuroAmount.setText(df.format(GameManager.getInstance().getTurnOfPlayer().getAccount().getEuro()) + "€");
		showFrancAmount.setText("CHF " + df.format(GameManager.getInstance().getTurnOfPlayer().getAccount().getSwissFrank()));
		currentPlayerName.setText(GameManager.getInstance().getTurnOfPlayer().getName());
	}

	public void update() {
		// player money's on the player bar
		infoPlayer1Money.setText(df.format(GameManager.getInstance().getPlayerAt(0).getAccount().getTrl()) + "₺");
		infoPlayer2Money.setText(df.format(GameManager.getInstance().getPlayerAt(1).getAccount().getTrl()) + "₺");
		infoPlayer3Money.setText(df.format(GameManager.getInstance().getPlayerAt(2).getAccount().getTrl()) + "₺");
		infoPlayer4Money.setText(df.format(GameManager.getInstance().getPlayerAt(3).getAccount().getTrl()) + "₺");

		// player money stats in the account bar
		updatePlayerLabels();

		int turnOf = GameManager.getInstance().getTurnOfPlayerIndex();

		while(turnOf > 4){
			GameManager.getInstance().playTurn();
			turnOf = GameManager.getInstance().getTurnOfPlayerIndex();
		}

		diamondUpdate(turnOf);

		getItems();
		updateAllLocations();
	}

	private void diamondUpdate(int turnOf) {
		turnIndicator1.setOpacity(turnOf == 0 ? 1 : 0);
		turnIndicator2.setOpacity(turnOf == 1 ? 1 : 0);
		turnIndicator3.setOpacity(turnOf == 2 ? 1 : 0);
		turnIndicator4.setOpacity(turnOf == 3 ? 1 : 0);
	}


	private void updateAllLocations() {
		for (int i = 0; i < 6; i++) {
			updateLocations(i);
		}
	}

	public void setStage(Stage context) {
		this.context = context;
	}

	public void roll(ActionEvent e){
		rollTheDice();
		rollRice.setDisable(true);
	}

	public void rollTheDice() {
		SoundManager sm = new SoundManager(false);
		sm.music(2);
		Player p = GameManager.getInstance().getTurnOfPlayer();
		int[] dices = GameManager.getInstance().playTurn();
		diceLabel.setText("Dices: " + dices[0] + ", " + dices[1]);
		update();
		endTurnButton.setDisable(false);
		showTileActions(p.getLocation());
	}

	private void updateLocations(int index) {
		if (index == 4) {
			System.out.println(GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT);
			if (GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT <= 10) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutX() + 14);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutY() + 44);
			} else if (GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT <= 20) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutX() + 24);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutY() + 28);
			} else if (GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT <= 30) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutX() + 16);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutY() + 37);
			} else if (GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT > 30) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutX() + 39);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutY() + 5);
			}
		} else if (index == 5) {
			System.out.println("Police " + GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT);
			if (GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT <= 10) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutX() + 31);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutY() + 43);
			} else if (GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT <= 20) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutX() + 26);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutY() + 7);
			}
			if (GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT <= 30) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutX() + 16);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutY() + 17);
			}
			if (GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT > 30) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutX() + 41);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutY() + 29);
			}
		} else {
			System.out.println("Player: " + GameManager.getInstance().getPlayerAt(index).getName() + " location: " + GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT);
			System.out.println("-----------");

			if (index == 0) {
				if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 10) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 3);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 20);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 20) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() - 1);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 1);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() - 1);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 1);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 18);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 1);
				}

			} else if (index == 1) {
				if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 10) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 34);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 20);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 20) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 43);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 2);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 30);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 0);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 62);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 1);
				}

			} else if (index == 2) {
				if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 10) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 4);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 58);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 20) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 1);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 27);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 0);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 39);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 19);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 26);
				}

			} else if (index == 3) {
				if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 10) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 33);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 60);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 20) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 44);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 25);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 30);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + Map.TILE_COUNT);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 62);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 27);
				}
			}
		}
	}

	public void getItems(){
		ListView list = new ListView();
		SoundManager sm = new SoundManager(false);
		Player currentPlayer = GameManager.getInstance().getTurnOfPlayer();
		ArrayList<PowerUp> powerUps;
		ArrayList<Tile> tiles;
		ArrayList<Card> cards;
		list.setStyle("-fx-font-family: Forte;");
		Label label = new Label("Your Power-ups:");
		Label label2 = new Label("Your special cards:");
		Label label3 = new Label("Your special cards:");
		label.setTextFill(Color.rgb(194,58,178));
		label2.setTextFill(Color.rgb(194,58,178));
		label3.setTextFill(Color.rgb(194,58,178));
		//Add PowerUps
		list.getItems().add(label);
		powerUps = currentPlayer.getPowerUps();
		if(powerUps.size() == 0)
			list.getItems().add("No Power-Ups available!");
		else
			for(int i = 0; i < powerUps.size(); i++){
				Button btn = new Button(powerUps.get(i).getBehaviourName());
				btn.setStyle(Style.button_two);
				list.getItems().add(btn);
				int x = i;

				btn.setOnAction(event -> {
					sm.music(5);
					new PowerupInfoPopup(powerUps.get(x)).display(context);
					getItems();
				});
			}
		//Add Cards
		list.getItems().add(label2);
		cards = currentPlayer.getCards();
		if(cards.size() == 0)
			list.getItems().add("No cards available!");
		else
			for(int k = 0; k < cards.size(); k++){
				Button button = new Button("Jailbreak Daddy Card");
				button.setStyle(Style.button_two);
				list.getItems().add(button);

				button.setOnAction(event -> {
					sm.music(5);
					if(currentPlayer.getIsArrested()){
						new UseCardPopup().display(context);
						getItems();
					}
				});
			}
		//Add Tiles
		list.getItems().add(label3);
		tiles = currentPlayer.getTileList();
		if(tiles.size() == 0)
			list.getItems().add("No tiles available!");
		else
			for(int m = 0; m < tiles.size(); m++){
				Button bttn = new Button(tiles.get(m).getName());

				if (tiles.get(m).getClass() != CityTile.class) {
					bttn.setStyle(Style.button_three + "-fx-text-fill: #647399");
					list.getItems().add(bttn);

					bttn.setOnAction(event -> {
						System.out.println("ben city tile ım");
					});
					continue; // skip the city tile styling if the tile is not a city
				}

				switch (((CityTile) (tiles.get(m))).getColorGroup()) {
					case 1:
						bttn.setStyle(Style.button_three + "-fx-text-fill: #F29BC8;");
						break;
					case 2:
						bttn.setStyle(Style.button_three + "-fx-text-fill: #95F9EA;");
						break;
					case 3:
						bttn.setStyle(Style.button_three + "-fx-text-fill: #FDF071;");
						break;
					case 4:
						bttn.setStyle(Style.button_three + "-fx-text-fill: #EF6E57;");
						break;
					case 5:
						bttn.setStyle(Style.button_three + "-fx-text-fill: #ADE581;");
						break;
					case 6:
						bttn.setStyle(Style.button_three + "-fx-text-fill: #B893E3;");
						break;
					case 7:
						bttn.setStyle(Style.button_three + "-fx-text-fill: #EFBE6E;");
						break;
					case 8:
						bttn.setStyle(Style.button_three + "-fx-text-fill: #A6D3FF;");
						break;
					default:
						bttn.setStyle(Style.button_two);
				}

				list.getItems().add(bttn);
				int n = m;
				bttn.setOnAction(event -> {
					sm.music(5);
					new TileOperationPopup(tiles.get(n)).display(context);
					System.out.println("ben city tile ım");
				});
			}
		listItems.getChildren().add(list);
	}

	public void pauseGame() {
		sm.music(5);
		SoundManager.getInstance().pauseMusic();
		blurScreen();
		new PausePopup().display(context);
		removeBlur();
	}

	private void removeBlur() {
		root.setEffect(null);
	}

	public void trade () {
		//new TradePopup(1).display(context);
		new ShowTradesPopup().display(context);
		update();
	}

	private void blurScreen () {
		ColorAdjust adj = new ColorAdjust(0, -0.9, -0.5, 0);
		GaussianBlur blur = new GaussianBlur(55);
		adj.setInput(blur);
		root.setEffect(adj);
	}

	public void mafiaButton () {
		if(!GameManager.getInstance().getMafia().getIsArrested()){
			sm.music(5);
			new MafiaPopup().display(context);
			update();
		}
	}

	public void powerupCrate(){
		sm.music(5);
		new PowerUpPopup().display(context);
		update();
	}

}