package gui.menus;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GameMenu {
	public void display(Stage context) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../GameMenu.fxml"));
		Parent root = loader.load();
		GameMenuController gameMenuController = loader.getController();
		gameMenuController.setStage(context);
		context.setScene(new Scene(root, 1280, 720));
		context.show();
	}
}