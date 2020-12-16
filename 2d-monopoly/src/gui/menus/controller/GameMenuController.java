package gui.menus.controller;

import gui.menus.popups.PausePopup;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import management.GameManager;

public class GameMenuController {
	@FXML
	Label infoPlayer1Name = new Label(GameManager.getInstance().getPlayerAt(0).getName());
	@FXML
	Label infoPlayer2Name = new Label(GameManager.getInstance().getPlayerAt(1).getName());
	@FXML
	Label infoPlayer3Name = new Label(GameManager.getInstance().getPlayerAt(2).getName());
	@FXML
	Label infoPlayer4Name = new Label(GameManager.getInstance().getPlayerAt(3).getName());

	@FXML
	Text infoPlayer1Money = new Text();
	@FXML
	Text infoPlayer2Money = new Text();
	@FXML
	Text infoPlayer3Money = new Text();
	@FXML
	Text infoPlayer4Money = new Text();

	@FXML
	private Label textForexDollar = new Label();
	@FXML
	private Label textForexEuro = new Label();
	@FXML
	private Label textForexFrank = new Label();

	private GameManager gameManager;
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
	}

	public void setStage(Stage context) {
		this.context = context;
	}

	public void pauseGame() {
		new PausePopup().display(context);
	}
}