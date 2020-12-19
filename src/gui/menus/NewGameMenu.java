package gui.menus;

import gui.menus.controller.NewGameMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGameMenu {

	public void display(Stage context) throws Exception{
		FXMLLoader loader
				= new FXMLLoader(getClass().getResource("../../NewGameMenu.fxml"));
		Parent root = loader.load();
		NewGameMenuController newGameMenuController = loader.getController();
		newGameMenuController.setStage(context);
		context.setScene(new Scene(root, 1280, 720));
		context.show();
	}
}
