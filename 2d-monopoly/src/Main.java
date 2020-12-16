import entity.Dice;
import entity.map.tile.CityTile;
import entity.player.Player;
import entity.player.User;
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
		// launch(args);

		Player p1, p2;
		p1 = new Player(new User(), "Player 1");
		p2 = new Player(new User(), "Player 2");

		Map map = new Map();

		((CityTile)map.getTileAt(6)).setWhoseTile(p1);
		System.out.println(map.isColorGroupOwnedByPlayer(p1, 2));
		((CityTile)map.getTileAt(8)).setWhoseTile(p1);
		System.out.println(map.isColorGroupOwnedByPlayer(p1, 2));
		((CityTile)map.getTileAt(9)).setWhoseTile(p1);
		System.out.println(map.isColorGroupOwnedByPlayer(p1, 2));


		map.isColorGroupOwnedByPlayer(p1, 2);
		map.isColorGroupOwnedByPlayer(p1, 2);
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