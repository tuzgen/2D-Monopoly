package gui.menus.controller;

import entity.map.tile.*;
import gui.menus.popups.PausePopup;
import gui.menus.popups.TilePopup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import management.GameManager;
import management.Map;

import java.text.DecimalFormat;

public class GameMenuController {
	private static GameMenuController instance;
	private DecimalFormat df = new DecimalFormat("####.##");

	public static GameMenuController getInstance() {
		if (instance == null)
			instance = new GameMenuController();
		return instance;
	}

	@FXML private Label currentPlayerName = new Label();
	@FXML private Label showDollarAmount = new Label();
	@FXML private Label showEuroAmount = new Label();
	@FXML private Label showFrancAmount = new Label();
	@FXML private Label infoPlayer1Name = new Label();
	@FXML private Text infoPlayer1Money = new Text();
	@FXML private Label infoPlayer2Name = new Label();
	@FXML private Text infoPlayer2Money = new Text();
	@FXML private Label infoPlayer3Name = new Label();
	@FXML private Text infoPlayer3Money = new Text();
	@FXML private Label infoPlayer4Name = new Label();
	@FXML private Text infoPlayer4Money = new Text();
	@FXML private Label textForexDollar = new Label();
	@FXML private Button buttonDollarBuy = new Button();
	@FXML private Button buttonDollarSell = new Button();
	@FXML private Label textForexEuro = new Label();
	@FXML private Button buttonEuroBuy = new Button();
	@FXML private Button buttonEuroSell = new Button();
	@FXML private Label textForexFrank = new Label();
	@FXML private Button buttonFrancBuy = new Button();
	@FXML private Button buttonFrancSell = new Button();
	@FXML private TextField textFieldDollar = new TextField();
	@FXML private TextField textFieldEuro = new TextField();
	@FXML private TextField textFieldFranc = new TextField();
	@FXML private Button buttonTile39 = new Button();
	@FXML private Button buttonTile38 = new Button();
	@FXML private Button buttonTile37 = new Button();
	@FXML private Button buttonTile36 = new Button();
	@FXML private Button buttonTile35 = new Button();
	@FXML private Button buttonTile34= new Button();
	@FXML private Button buttonTile33= new Button();
	@FXML private Button buttonTile32= new Button();
	@FXML private Button buttonTile31= new Button();
	@FXML private Button buttonTile30= new Button();
	@FXML private Button buttonTile29= new Button();
	@FXML private Button buttonTile28= new Button();
	@FXML private Button buttonTile27= new Button();
	@FXML private Button buttonTile26= new Button();
	@FXML private Button buttonTile25= new Button();
	@FXML private Button buttonTile24= new Button();
	@FXML private Button buttonTile23= new Button();
	@FXML private Button buttonTile22= new Button();
	@FXML private Button buttonTile21= new Button();
	@FXML private Button buttonTile20= new Button();
	@FXML private Button buttonTile19= new Button();
	@FXML private Button buttonTile18= new Button();
	@FXML private Button buttonTile17= new Button();
	@FXML private Button buttonTile16= new Button();
	@FXML private Button buttonTile15= new Button();
	@FXML private Button buttonTile14= new Button();
	@FXML private Button buttonTile13= new Button();
	@FXML private Button buttonTile12= new Button();
	@FXML private Button buttonTile11= new Button();
	@FXML private Button buttonTile10= new Button();
	@FXML private Button buttonTile9= new Button();
	@FXML private Button buttonTile8= new Button();
	@FXML private Button buttonTile7= new Button();
	@FXML private Button buttonTile6= new Button();
	@FXML private Button buttonTile5= new Button();
	@FXML private Button buttonTile4= new Button();
	@FXML private Button buttonTile3= new Button();
	@FXML private Button buttonTile2= new Button();
	@FXML private Button buttonTile1= new Button();
	@FXML private Button buttonTile0= new Button();
	@FXML private Button buttonPowerUpCrate = new Button();
	@FXML private ImageView iconPlayer1; // = new ImageView(new Image("file:src/vendor/image/diamond-green.png"));
	@FXML private ImageView iconMafia; // = new ImageView(new Image("file:src/vendor/image/mafia-face.png"));
	@FXML private ImageView iconPlayer3; // = new ImageView(new Image("file:src/vendor/image/diamond-pink.png"));
	@FXML private ImageView iconPolice; // = new ImageView(new Image("file:src/vendor/image/police-logo.png"));
	@FXML private ImageView iconPlayer2; // = new ImageView(new Image("file:src/vendor/image/diamond-red.png"));
	@FXML private ImageView iconPlayer4; // = new ImageView(new Image("file:src/vendor/image/diamond-blue.png"));

	private Stage context;
	private Button[] buttons;
	private ImageView[] icons;
	private final int[][] offsets = new int[][]{
			{8, 18}, {28, 18},
			{8, 38}, {28, 38},
			{8, 58}, {28, 58},
	};

	@FXML
	public void initialize() {
		currentPlayerName.setText(GameManager.getInstance().getTurnOfPlayer().getName());
		infoPlayer1Name.setText(GameManager.getInstance().getPlayerAt(0).getName());
		infoPlayer2Name.setText(GameManager.getInstance().getPlayerAt(1).getName());
		infoPlayer3Name.setText(GameManager.getInstance().getPlayerAt(2).getName());
		infoPlayer4Name.setText(GameManager.getInstance().getPlayerAt(3).getName());
		infoPlayer1Money.setText(df.format(GameManager.getInstance().getPlayerAt(0).getAccount().getTrl()) + "₺");
		infoPlayer2Money.setText(df.format(GameManager.getInstance().getPlayerAt(1).getAccount().getTrl()) + "₺");
		infoPlayer3Money.setText(df.format(GameManager.getInstance().getPlayerAt(2).getAccount().getTrl()) + "₺");
		infoPlayer4Money.setText(df.format(GameManager.getInstance().getPlayerAt(3).getAccount().getTrl()) + "₺");
		textForexDollar.setText(Double.toString(GameManager.getInstance().getForexDollar()));
		textForexEuro.setText(Double.toString(GameManager.getInstance().getForexEuro()));
		textForexFrank.setText(Double.toString(GameManager.getInstance().getForexFrank()));

		buttonDollarBuy.setOnAction(buttonDollarBuy());
		buttonEuroBuy.setOnAction(buttonEuroBuy());
		buttonFrancBuy.setOnAction(buttonFrancBuy());

		buttonDollarSell.setOnAction(buttonDollarSell());
		buttonEuroSell.setOnAction(buttonEuroSell());
		buttonFrancSell.setOnAction(buttonFrancSell());

		buttonTile0.setOnAction(e -> showTileActions(0));
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
		buttonTile39.setOnAction(e -> showTileActions(39));

		buttons = new Button[] {
				buttonTile0,buttonTile1,buttonTile2,buttonTile3,buttonTile4,
				buttonTile5,buttonTile6,buttonTile7,buttonTile8,buttonTile9,
				buttonTile10,buttonTile11,buttonTile12,buttonTile13,buttonTile14,
				buttonTile15,buttonTile16,buttonTile17,buttonTile18,buttonTile19,
				buttonTile20,buttonTile21,buttonTile22,buttonTile23,buttonTile24,
				buttonTile25,buttonTile26,buttonTile27,buttonTile28,buttonTile29,
				buttonTile30,buttonTile31,buttonTile32,buttonTile33,buttonTile34,
				buttonTile35,buttonTile36,buttonTile37,buttonTile38,buttonTile39
		};
		icons = new ImageView[] {
			iconPlayer1, iconPlayer2, iconPlayer3, iconPlayer4, iconMafia, iconPolice
		};
	}

	private void showTileActions(int tileNo) {
		if (Map.getInstance().getTileAt(tileNo).getClass() == CityTile.class) {
			new TilePopup().display("City Tile", (CityTile) Map.getInstance().getTileAt(tileNo));
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == CardTile.class) {

		} else if (Map.getInstance().getTileAt(tileNo).getClass() == CompanyTile.class) {

		} else if (Map.getInstance().getTileAt(tileNo).getClass() == DoNothingTile.class) {

		} else if (Map.getInstance().getTileAt(tileNo).getClass() == StartTile.class) {

		} else if (Map.getInstance().getTileAt(tileNo).getClass() == TaxTile.class) {

		} else if (Map.getInstance().getTileAt(tileNo).getClass() == JailTile.class) {

		} else if (Map.getInstance().getTileAt(tileNo).getClass() == TransportationTile.class) {

		}

	}

	private EventHandler<ActionEvent> buttonDollarBuy() {
		return e -> {
			GameManager.getInstance().buyForexDollar(
					Double.parseDouble(textFieldDollar.getText()) >= 0 ? Double.parseDouble(textFieldDollar.getText()) : 0);
			update();
		};
	}
	private EventHandler<ActionEvent> buttonDollarSell() {
		return e -> {
			GameManager.getInstance().sellForexDollar(
					Double.parseDouble(textFieldDollar.getText()) >= 0 ? Double.parseDouble(textFieldDollar.getText()) : 0);
			update();
		};
	}
	private EventHandler<ActionEvent> buttonEuroBuy() {
		return e -> {
			GameManager.getInstance().buyForexEuro(
					Double.parseDouble(textFieldEuro.getText()) >= 0 ? Double.parseDouble(textFieldEuro.getText()) : 0);
			update();
		};
	}
	private EventHandler<ActionEvent> buttonEuroSell() {
		return e -> {
			GameManager.getInstance().sellForexEuro(
					Double.parseDouble(textFieldEuro.getText()) >= 0 ? Double.parseDouble(textFieldEuro.getText()) : 0);
			update();
		};
	}
	private EventHandler<ActionEvent> buttonFrancBuy() {
		return e -> {
			GameManager.getInstance().buyForexFranc(
					Double.parseDouble(textFieldFranc.getText()) >= 0 ? Double.parseDouble(textFieldFranc.getText()) : 0);
			update();
		};
	}
	private EventHandler<ActionEvent> buttonFrancSell() {
		return e -> {
			GameManager.getInstance().sellForexFranc(
					Double.parseDouble(textFieldFranc.getText()) >= 0 ? Double.parseDouble(textFieldFranc.getText()) : 0);
			update();
		};
	}

	public void buttonOpenPowerUpCrate() {
		GameManager.getInstance().getPlayerAt(GameManager.getInstance().getTurnOfPlayerIndex());
		update();
	}

	public void update() {
		System.out.println(
				Double.toString(GameManager.getInstance().getPlayerAt(0).getAccount().getTrl()));
		infoPlayer1Money.setText(df.format(GameManager.getInstance().getPlayerAt(0).getAccount().getTrl()) + "₺");
		infoPlayer2Money.setText(df.format(GameManager.getInstance().getPlayerAt(1).getAccount().getTrl()) + "₺");
		infoPlayer3Money.setText(df.format(GameManager.getInstance().getPlayerAt(2).getAccount().getTrl()) + "₺");
		infoPlayer4Money.setText(df.format(GameManager.getInstance().getPlayerAt(3).getAccount().getTrl()) + "₺");
		showDollarAmount.setText("$" + df.format(GameManager.getInstance().getTurnOfPlayer().getAccount().getDollar()));
		showEuroAmount.setText(df.format(GameManager.getInstance().getTurnOfPlayer().getAccount().getEuro()) + "€");
		showFrancAmount.setText("CHF " + df.format(GameManager.getInstance().getTurnOfPlayer().getAccount().getSwissFrank()));

		currentPlayerName.setText(GameManager.getInstance().getTurnOfPlayer().getName()); // Bu burada mı olmalı her tur sonunda değiştirilcek
	}

	public void setStage(Stage context) {
		this.context = context;
	}

	public void rollTheDice() {
		GameManager.getInstance().playTurn();
		System.out.println("Player location " + GameManager.getInstance().getTurnOfPlayer().getLocation());

		icons[GameManager.getInstance().getTurnOfPlayerIndex()]
				.setLayoutX(buttons[GameManager.getInstance().getTurnOfPlayer().getLocation() % Map.TILECOUNT].getLayoutX()
						+ offsets[GameManager.getInstance().getTurnOfPlayerIndex()][0]);
		icons[GameManager.getInstance().getTurnOfPlayerIndex()]
				.setLayoutY(buttons[GameManager.getInstance().getTurnOfPlayer().getLocation() % Map.TILECOUNT].getLayoutY()
						+ offsets[GameManager.getInstance().getTurnOfPlayerIndex()][1]);
	}

	public void pauseGame() {
		new PausePopup().display(context);
	}
}