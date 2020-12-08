package gui.menus;

import gui.misc.FPSCounter;
import gui.misc.Style;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class NewGameMenu {

	public void display(Stage context) throws Exception{
		Label label_title = new Label("New game");
		label_title.setStyle(Style.text_two);

		Label label_player1_name = new Label("Player 1");
		label_player1_name.setStyle(Style.text_three);
		TextField textField_player1 = new TextField();

		Label label_player2_name = new Label("Player 2");
		label_player2_name.setStyle(Style.text_three);
		TextField textField_player2 = new TextField();

		Label label_player3_name = new Label("Player 3");
		label_player3_name.setStyle(Style.text_three);
		TextField textField_player3 = new TextField();

		Label label_player4_name = new Label("Player 4");
		label_player4_name.setStyle(Style.text_three);
		TextField textField_player4 = new TextField();

		Button button_play = new Button("Play");
		button_play.setStyle(Style.button_one);
		button_play.setOnAction(  e -> {
			try {
				new GameMenu().display(context);
			} catch (Exception exception) {
				System.err.println(exception.toString());
			}
		});

		Button button_return = new Button("Go back");
		button_return.setStyle(Style.button_one);
		button_return.setOnAction( e -> {
			new MainMenu().display(context);
		});

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(45);
		gridPane.setVgap(15);
		gridPane.add(label_player1_name, 0, 0);
		gridPane.add(textField_player1, 0, 1);
		gridPane.add(label_player2_name, 1, 0);
		gridPane.add(textField_player2, 1, 1);
		gridPane.add(label_player3_name, 0, 2);
		gridPane.add(textField_player3, 0, 3);
		gridPane.add(label_player4_name, 1, 2);
		gridPane.add(textField_player4, 1, 3);

		// Layout 1 vertical column
		VBox layout_fields = new VBox(20);
		layout_fields.setAlignment(Pos.CENTER);
		layout_fields.getChildren().addAll(
				label_title, gridPane, button_play, button_return
		);

		BorderPane layout = new BorderPane(layout_fields);
		layout.setBackground(new Background(new BackgroundFill(Color.color(0, 0, 0), null, null)));
		Scene scene = new Scene(layout, 1280, 720);

		HBox layout_FPS = new HBox(0);
		layout_FPS.setAlignment(Pos.TOP_RIGHT);
		layout_FPS.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 1), null, null)));
		layout_FPS.getChildren().add(new FPSCounter().display(scene));

		layout.setTop(layout_FPS);

		Box emptyBox = new Box(0, 50, 0);

		context.setScene(scene);
		context.show();
	}
}
