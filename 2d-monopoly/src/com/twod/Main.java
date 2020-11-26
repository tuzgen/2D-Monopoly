package com.twod;

import com.twod.gui.menus.MainMenu;
import com.twod.gui.menus.popups.ClosePopup;
import javafx.application.Application;
import javafx.stage.Stage;

import java.security.AccessControlException;

public class Main extends Application {
	// Constants

	// State variables

	// Components
	Stage window;

	public static void main( String[] args ) {
		// write your code here
		launch(args);
	}

	@Override
	public void start( Stage primaryStage ) throws Exception {
		primaryStage.setTitle( "Monopoly Sicilia" );
		window = primaryStage;
		window.setResizable(false);
		window.setOnCloseRequest( e -> {
			e.consume();
			closeProgram();
		} );

		try {
			System.setProperty("prism.verbose", "true");
			System.setProperty("prism.dirtyopts", "false");
			System.setProperty("javafx.animation.fullspeed", "true");
			System.setProperty("javafx.animation.pulse", "10");
		} catch (AccessControlException e) {
			System.out.println(e.toString());
		}

		MainMenu.display(window);
	}

	private void closeProgram() {
		ClosePopup.display(window);
	}
}