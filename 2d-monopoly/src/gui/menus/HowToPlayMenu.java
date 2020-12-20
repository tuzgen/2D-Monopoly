package gui.menus;

import gui.misc.FPSCounter;
import gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HowToPlayMenu {
	public void display(Stage context) {
		Button button_return = new Button("Go back");
		button_return.setStyle(Style.button_one);
		button_return.setOnAction( e -> {
			new MainMenu().display(context);
		});

		ImageView myBI= new ImageView(
				new Image("file:src/vendor/image/how-to-play.png", 1024, 576, true,true));

		VBox layout_how_to_play = new VBox(20);
		layout_how_to_play.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
		layout_how_to_play.setAlignment(Pos.CENTER);
		layout_how_to_play.getChildren().addAll(myBI, button_return);

		BorderPane layout = new BorderPane(layout_how_to_play);

		Scene scene_how_to_play = new Scene(layout, 1280, 720);

		HBox layout_FPS = new HBox(0);
		layout_FPS.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 1), null, null)));
		layout_FPS.setAlignment(Pos.TOP_RIGHT);
		layout_FPS.getChildren().add(new FPSCounter().display(scene_how_to_play));

		layout.setTop(layout_FPS);

		context.setScene(scene_how_to_play);
	}
}
