import entity.player.BotCharacter;
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

		Player p1, p2, p3;
		p1 = new Player(new User(), "Player 1");
		p2 = new Player(new User(), "Player 2");
		p3 = new Player(new BotCharacter(), "Player 3");

		Map map = Map.getInstance();
		// can buy
		map.buyTile(p1, 1);
		map.buyTile(p1, 3);

		// Cannot buy since owned
		map.buyTile(p2, 1);
		map.buyTile(p2, 3);

		// can buy
		map.buyTile(p3, 6);
		// cannot build hotels the color group not owned
		//map.buildHouse(p3, 6);
		//map.buildHouse(p3, 6);

		map.buyTile(p3, 8);
		map.buyTile(p3, 9);
		map.buildHouse(p3, 6);
		map.buildHouse(p3, 6); // dont
		map.buildHouse(p3, 8);
		map.buildHouse(p3, 8); // dont
		map.buildHouse(p3, 9);
		map.buildHouse(p3, 9);
		map.buildHouse(p3, 6);
		map.buildHouse(p3, 8);
		map.buildHouse(p3, 8);
		map.buildHouse(p3, 6);
		map.buildHouse(p3, 9);
		map.buildHotel(p3, 6);
		map.buildHotel(p3, 9);
		map.buildHotel(p3, 8);
		map.buildHotel(p3, 8);
		map.buildHotel(p3, 6);


		// map.buildHouse(p3, 6);
		// map.buildHouse(p1, 1);
		// map.buildHouse(p1, 1);
		// map.buildHouse(p2, 1);
		// map.buildHouse(p1, 1);
		// map.buildHotel(p1, 1);
		// map.buildHotel(p1, 1);
		// map.buildHotel(p1, 1);
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