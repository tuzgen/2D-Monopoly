package gui.menus.controller;

import gui.menus.popups.MafiaPopup;
import gui.menus.popups.PausePopup;
import gui.menus.popups.TradePopup;
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
	private Button buttonTile34= new Button();
	@FXML
	private Button buttonTile33= new Button();
	@FXML
	private Button buttonTile32= new Button();
	@FXML
	private Button buttonTile31= new Button();
	@FXML
	private Button buttonTile30= new Button();
	@FXML
	private Button buttonTile29= new Button();
	@FXML
	private Button buttonTile28= new Button();
	@FXML
	private Button buttonTile27= new Button();
	@FXML
	private Button buttonTile26= new Button();
	@FXML
	private Button buttonTile25= new Button();
	@FXML
	private Button buttonTile24= new Button();
	@FXML
	private Button buttonTile23= new Button();
	@FXML
	private Button buttonTile22= new Button();
	@FXML
	private Button buttonTile21= new Button();
	@FXML
	private Button buttonTile20= new Button();
	@FXML
	private Button buttonTile19= new Button();
	@FXML
	private Button buttonTile18= new Button();
	@FXML
	private Button buttonTile17= new Button();
	@FXML
	private Button buttonTile16= new Button();
	@FXML
	private Button buttonTile15= new Button();
	@FXML
	private Button buttonTile14= new Button();
	@FXML
	private Button buttonTile13= new Button();
	@FXML
	private Button buttonTile12= new Button();
	@FXML
	private Button buttonTile11= new Button();
	@FXML
	private Button buttonTile10= new Button();
	@FXML
	private Button buttonTile9= new Button();
	@FXML
	private Button buttonTile8= new Button();
	@FXML
	private Button buttonTile7= new Button();
	@FXML
	private Button buttonTile6= new Button();
	@FXML
	private Button buttonTile5= new Button();
	@FXML
	private Button buttonTile4= new Button();
	@FXML
	private Button buttonTile3= new Button();
	@FXML
	private Button buttonTile2= new Button();
	@FXML
	private Button buttonTile1= new Button();
	@FXML
	private Button buttonTile0= new Button();
	@FXML
	private Button buttonPowerUpCrate = new Button();

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

		/*
		buttonTile0.setOnAction();
		buttonTile1.setOnAction();
		buttonTile2.setOnAction();
		buttonTile3.setOnAction();
		buttonTile4.setOnAction();
		buttonTile5.setOnAction();
		buttonTile6.setOnAction();
		buttonTile7.setOnAction();
		buttonTile8.setOnAction();
		buttonTile9.setOnAction();
		buttonTile10.setOnAction();
		buttonTile11.setOnAction();
		buttonTile12.setOnAction();
		buttonTile13.setOnAction();
		buttonTile14.setOnAction();
		buttonTile15.setOnAction();
		buttonTile16.setOnAction();
		buttonTile17.setOnAction();
		buttonTile18.setOnAction();
		buttonTile19.setOnAction();
		buttonTile20.setOnAction();
		buttonTile21.setOnAction();
		buttonTile22.setOnAction();
		buttonTile23.setOnAction();
		buttonTile24.setOnAction();
		buttonTile25.setOnAction();
		buttonTile26.setOnAction();
		buttonTile27.setOnAction();
		buttonTile28.setOnAction();
		buttonTile29.setOnAction();
		buttonTile30.setOnAction();
		buttonTile31.setOnAction();
		buttonTile32.setOnAction();
		buttonTile33.setOnAction();
		buttonTile34.setOnAction();
		buttonTile35.setOnAction();
		buttonTile36.setOnAction();
		buttonTile37.setOnAction();
		buttonTile38.setOnAction();
		buttonTile39.setOnAction();
		*/

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

	public void pauseGame() {
		new PausePopup().display(context);
	}

	public void mafiaButton() {
		new MafiaPopup().display(context);
		update();
	}

	public void trade(){
		new TradePopup(1).display(context);
	}

	public void pl1trade(){
		new TradePopup(1).display(context);
	}

	public void pl2trade(){
		new TradePopup(2).display(context);
	}

	public void pl3trade(){
		new TradePopup(3).display(context);
	}

}