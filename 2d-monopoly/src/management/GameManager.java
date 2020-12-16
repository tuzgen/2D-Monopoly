package management;

import cached.Settings;
import entity.Bank;
import entity.Dice;
import entity.player.Player;

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

	private GameManager() {
		players = new Player[4];
		settings = new Settings(false, false);
		dice = new Dice();
		tradeManager = TradeManager.getInstance();
		forexManager = ForexManager.getInstance();
		map = Map.getInstance();
	}

	public static synchronized GameManager getInstance() {
		if (instance == null) {
			instance = new GameManager();
		}
		return instance;
	}

	public void update() {
		while (!isGameOver()) {
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