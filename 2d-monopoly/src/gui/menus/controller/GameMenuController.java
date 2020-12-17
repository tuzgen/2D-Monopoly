package gui.menus.controller;

import gui.menus.popups.PausePopup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import management.GameManager;

import java.text.DecimalFormat;

public class GameMenuController {
	private static GameMenuController instance;
	private DecimalFormat df = new DecimalFormat("####.##");

	public static GameMenuController getInstance() {
		if (instance == null)
			instance = new GameMenuController();
		return instance;
	}

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
	private Text infoPlayer2Money = new Text();;
	@FXML
	private Label infoPlayer3Name = new Label();
	@FXML
	private Text infoPlayer3Money = new Text();;
	@FXML
	private Label infoPlayer4Name = new Label();
	@FXML
	private Text infoPlayer4Money = new Text();;
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

	private Stage context;

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
	}

	private EventHandler<ActionEvent> buttonDollarBuy() {
		return e -> {
			GameManager.getInstance().buyForexDollar(Double.parseDouble(textFieldDollar.getText()));
			update();
		};
	}
	private EventHandler<ActionEvent> buttonDollarSell() {
		return e -> {
			GameManager.getInstance().sellForexDollar(Double.parseDouble(textFieldDollar.getText()));
			update();
		};
	}
	private EventHandler<ActionEvent> buttonEuroBuy() {
		return e -> {
			GameManager.getInstance().buyForexEuro(Double.parseDouble(textFieldEuro.getText()));
			update();
		};
	}
	private EventHandler<ActionEvent> buttonEuroSell() {
		return e -> {
			GameManager.getInstance().sellForexEuro(Double.parseDouble(textFieldEuro.getText()));
			update();
		};
	}
	private EventHandler<ActionEvent> buttonFrancBuy() {
		return e -> {
			GameManager.getInstance().buyForexFranc(Double.parseDouble(textFieldFranc.getText()));
			update();
		};
	}
	private EventHandler<ActionEvent> buttonFrancSell() {
		return e -> {
			GameManager.getInstance().sellForexFranc(Double.parseDouble(textFieldEuro.getText()));
			update();
		};
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

	public void pauseGame() {
		new PausePopup().display(context);
	}
}