package gui.templates;

import gui.misc.FPSCounter;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class MenuTemplate{
	// Constants


	// State variables

	// Methods
	public static void display(Stage context) {
		Scene scene;

		// Layout 1 vertical column
		VBox layout_menu_buttons = new VBox(20);
		layout_menu_buttons.setAlignment(Pos.CENTER);
		layout_menu_buttons.getChildren().addAll(

		);

		BorderPane layout = new BorderPane(layout_menu_buttons);

		scene = new Scene(layout, 1280, 720);

		HBox layout_FPS = new HBox(0);
		layout_FPS.setAlignment(Pos.TOP_RIGHT);
		layout_FPS.getChildren().add(new FPSCounter().display(scene));

		layout.setTop(layout_FPS);

		Box emptyBox = new Box(0, 50, 0);

		context.setScene(scene);
		context.show();
	}
}