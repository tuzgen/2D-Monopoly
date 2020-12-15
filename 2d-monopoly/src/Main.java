import entity.map.tile.CityTile;
import gui.menus.MainMenu;
import gui.menus.popups.ClosePopup;
import javafx.application.Application;
import javafx.stage.Stage;
import management.Map;

public class Main extends Application {
	// Constants

	// State variables
	Stage window;

	// Components

	public static void main( String[] args ) {
		// write your code here
		launch(args);

		Map map = new Map();
//
		// ((CityTile) map.getTileAt(1)).addHouse();
		// ((CityTile) map.getTileAt(1)).addHouse();
		// ((CityTile) map.getTileAt(1)).addHouse();
		// ((CityTile) map.getTileAt(1)).removeHouse();
		// ((CityTile) map.getTileAt(1)).addHouse();
		// ((CityTile) map.getTileAt(1)).addHouse();
		// ((CityTile) map.getTileAt(1)).addHotel();
		// ((CityTile) map.getTileAt(1)).removeHotel();
		// ((CityTile) map.getTileAt(1)).addHotel();

	}


	@Override
	public void start( Stage primaryStage ) throws Exception {

		primaryStage.setTitle( "Monopoly Sicilia" );
		window = primaryStage;
		window.setResizable(false);
		new MainMenu().display(window);
		window.setOnCloseRequest( e -> {
			e.consume();
			closeProgram();
		} );
		window.show();
	}

	private void closeProgram() {
		new ClosePopup().display(window);
	}

}