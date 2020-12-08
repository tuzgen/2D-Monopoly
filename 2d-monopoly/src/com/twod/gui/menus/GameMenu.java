package com.twod.gui.menus;

import com.twod.gui.menus.popups.PausePopup;
import com.twod.gui.misc.FPSCounter;
import com.twod.gui.misc.ImageButton;
import com.twod.gui.misc.Style;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;


public class GameMenu {
	public static void display(Stage context) {
		BorderPane layout_game_menu = new BorderPane();
		// layout_game_menu.setAlignment(Pos.CENTER);
		layout_game_menu.setBackground(new Background(
				new BackgroundFill(new Color(0, 0, 0, 1), null, null)));

		Scene scene_game_menu = new Scene(layout_game_menu, 1280, 720);

		HBox layout_FPS = new HBox(0);
		layout_FPS.setAlignment(Pos.TOP_RIGHT);
		layout_FPS.setBackground(new Background(
				new BackgroundFill(new Color(0, 0, 0, 1), null, null)));
		layout_FPS.getChildren().add(new FPSCounter().display(scene_game_menu));

		ImageView testImage = new ImageView();
		testImage.setImage(new Image("file:vendor/image/board.png",
				655, 655, true, true));

		StackPane board_space = new StackPane();
		board_space.setAlignment(Pos.CENTER);
		// board_space.setBackground(new Background(test));
		board_space.getChildren().addAll(testImage);

		HBox forex_space = new HBox();
// TODO add forex		forex_space

		VBox properties_space = new VBox();


		HBox properties_account_powerup_space = new HBox();


		VBox entity_elements = new VBox();
		entity_elements.getChildren().addAll(

		);

		HBox layout_playable_space = new HBox(20);
		layout_playable_space.setAlignment(Pos.CENTER_LEFT);
		layout_playable_space.getChildren().addAll(board_space, entity_elements);

		ImageButton button_test = new ImageButton(
				new Image("file:vendor/image/trezegames/gui_pack_white/white_pause.png"), 20, 20);
		button_test.setStyle(Style.button_one);
		button_test.setOnAction(e -> PausePopup.display(context));

		HBox layout_top_menu_buttons = new HBox(10);
		layout_top_menu_buttons.setAlignment(Pos.TOP_CENTER);
		layout_top_menu_buttons.getChildren().addAll(button_test);

		VBox layout2 = new VBox(10);
		layout2.getChildren().addAll(layout_playable_space);
		layout2.setAlignment(Pos.CENTER);

		VBox layout = new VBox(10);
		layout.getChildren().addAll(layout_top_menu_buttons, layout2);
		layout.setAlignment(Pos.TOP_CENTER);

		layout_game_menu.getChildren().addAll();
		layout_game_menu.setTop(layout_FPS);
		layout_game_menu.setCenter(layout);

		context.setScene(scene_game_menu);
		context.show();
	}
}