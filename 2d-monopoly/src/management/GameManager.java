package management;

import cached.Settings;
import entity.Bank;
import entity.Dice;
import entity.player.BotCharacter;
import entity.player.Player;
import entity.player.User;

import java.io.*;

public class GameManager implements Serializable {
	private static GameManager instance;

	// Cached singletons
	private ForexManager forexManager;
	private Bank bank;
	private Map map;
	private TradeManager tradeManager;

	// FILE PATHS
	private static final String SETTINGS_DIRECTORY = "local/";
	private static final String SETTINGS_FILE = "settings.ser";
	private static Settings settings;

	// properties
	Player[] players;
	Dice dice;

	private GameManager(String name0, String name1, boolean isBot1, String name2,
						boolean isBot2, String name3, boolean isBot3) {

		System.out.println("Constructor\n" + name0 + " " + "false" + " \n" +
				name1 + " " + isBot1 + " \n" +
				name2 + " " + isBot2 + " \n" +
				name3 + " " + isBot3 + " \n");

		players = new Player[4];
		players[0] = new Player(new User(), name0.equals("") ? "Player1" : name0);
		players[1] = new Player(isBot1 ? new User() : new BotCharacter(), name1.equals("") ? "Player2" : name1);
		players[2] = new Player(isBot2 ? new User() : new BotCharacter(), name2.equals("") ? "Player3" : name2);
		players[3] = new Player(isBot3 ? new User() : new BotCharacter(), name3.equals("") ? "Player4" : name3);

		settings = new Settings(false, false);
		dice = new Dice();
		tradeManager = TradeManager.getInstance();
		forexManager = ForexManager.getInstance();
		map = Map.getInstance();
	}

	public static void deleteInstance() {
		instance = null;
	}

	public static synchronized GameManager getInstance() {
		if (instance == null) {
			instance = new GameManager("", "", false, "", false ,"", false);
		}
		return instance;
	}

	public static synchronized GameManager getInstance(String name0,
													   String name1, boolean isBot1,
													   String name2, boolean isBot2,
													   String name3, boolean isBot3) {
		if (instance == null) {
			System.out.println(name0 + "false" + " \n" +
					name1 + isBot1 + " \n" +
					name2 + isBot2 + " \n" +
					name3 + isBot3 + " \n");
			instance = new GameManager(
					name0, name1, isBot1, name2, isBot2, name3, isBot3);
		}

		return instance;
	}

	// garbage
	/* private void setGameManager(String name0, String name1, boolean isBot1, String name2, boolean isBot2, String name3, boolean isBot3) {
		players[0].setName(name0);

		players[1].setBehavior(isBot1 ? new User() : new BotCharacter());
		players[1].setName(name1);

		players[2].setBehavior(isBot2 ? new User() : new BotCharacter());
		players[2].setName(name2);

		players[3].setBehavior(isBot3 ? new User() : new BotCharacter());
		players[3].setName(name3);

	}
	*/

	public void update() {
		while (isGameOver()) {
			for (Player player : players) {
				playTurn(player);
			}
		}
	}

	private void playTurn(Player player) {
		dice.rollTheDice();
		player.playTurn();
	}

	public boolean isGameOver() {
		for (Player p: players) {
			// TODO if any player has over the limit end game
			if (true) {
				return true;
			}
		}
		return false;
	}


	public void mapBuyTile(Player player, int tileNo) { map.buyTile(player, tileNo); }
	public void mapSellTile(Player player, int tileNo) { map.sellTile(player, tileNo); }
	public void buildHouse(Player player, int tileNo) { map.buildHouse(player, tileNo); }
	public void buildHotel(Player player, int tileNo) { map.buildHotel(player, tileNo); }
	public double getForexDollar() { return forexManager.getDollarExRate(); }
	public double getForexEuro() { return forexManager.getEuroExRate(); }
	public double getForexFrank() { return forexManager.getFrankExRate(); }

	public Player getPlayerAt(int index) { return players[index]; }

	public void updateSettings(Settings settings) {
		try {
			FileOutputStream writeFile = new FileOutputStream(new File(SETTINGS_DIRECTORY + SETTINGS_FILE));
			ObjectOutputStream writeObject = new ObjectOutputStream(writeFile);
			this.settings.setColorblindMode(settings.getColorblindMode());
			this.settings.setMutedMode(settings.getMutedMode());

			writeObject.writeObject(settings);
			System.out.println("Saved settings successfully.");
		} catch (Exception e) {
			System.err.println("Save failed settings cannot be saved.");
		}
	}
	public Settings loadSettings() {
		try {
			FileInputStream readFile = new FileInputStream(new File(SETTINGS_DIRECTORY + SETTINGS_FILE));
			ObjectInputStream readObject = new ObjectInputStream(readFile);

			settings = (Settings) readObject.readObject();

			System.out.println("Read successful settings object created.\n" + settings.toString());
			return settings;
		} catch (Exception e) {
			System.err.println("Read failed setting the default settings to false, false");
			File saveFile = new File(SETTINGS_DIRECTORY);
			saveFile.mkdir();
			settings = new Settings(false, false);
			updateSettings(settings);
			return settings;
		}
	}
	public Settings getSettings() {
		return settings;
	}
}