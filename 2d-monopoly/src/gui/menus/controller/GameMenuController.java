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

public class GameMenuController {
	private static GameMenuController instance;

	public static GameMenuController getInstance() {
		if (instance == null)
			instance = new GameMenuController();
		return instance;
	}

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

	private Stage context;

	@FXML
	public void initialize() {
		infoPlayer1Name.setText(GameManager.getInstance().getPlayerAt(0).getName());
		infoPlayer2Name.setText(GameManager.getInstance().getPlayerAt(1).getName());
		infoPlayer3Name.setText(GameManager.getInstance().getPlayerAt(2).getName());
		infoPlayer4Name.setText(GameManager.getInstance().getPlayerAt(3).getName());
		infoPlayer1Money.setText(Double.toString(GameManager.getInstance().getPlayerAt(0).getAccount().getTrl()));
		infoPlayer2Money.setText(Double.toString(GameManager.getInstance().getPlayerAt(1).getAccount().getTrl()));
		infoPlayer3Money.setText(Double.toString(GameManager.getInstance().getPlayerAt(2).getAccount().getTrl()));
		infoPlayer4Money.setText(Double.toString(GameManager.getInstance().getPlayerAt(3).getAccount().getTrl()));
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
		infoPlayer1Money.setText(Double.toString(
				GameManager.getInstance().getPlayerAt(0).getAccount().getTrl()));
		infoPlayer2Money.setText(Double.toString(
				GameManager.getInstance().getPlayerAt(1).getAccount().getTrl()));
		infoPlayer3Money.setText(Double.toString(
				GameManager.getInstance().getPlayerAt(2).getAccount().getTrl()));
		infoPlayer4Money.setText(Double.toString(
				GameManager.getInstance().getPlayerAt(3).getAccount().getTrl()));
	}

	public void setStage(Stage context) {
		this.context = context;
	}

	public void pauseGame() {
		new PausePopup().display(context);
	}
}