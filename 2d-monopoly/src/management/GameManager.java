package management;

import cached.Settings;
import entity.Bank;
import entity.Dice;
import entity.player.BotCharacter;
import entity.player.Player;
import entity.player.User;

import java.io.*;

public class GameManager implements Serializable {
	private static final int NPC_COUNT = 2;
	private static GameManager instance;

	// Cached singletons
	private static ForexManager forexManager;
	private static Bank bank;
	private static Map map;
	private static TradeManager tradeManager;

	// FILE PATHS
	private static final String SETTINGS_DIRECTORY = "local/";
	private static final String SETTINGS_FILE = "settings.ser";
	private static Settings settings;

	// properties
	Player[] players;
	Dice dice;

	// state variables
	private int turnOfPlayerIndex;

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
		bank = Bank.getInstance();
		map = Map.getInstance();
		turnOfPlayerIndex = 0;
	}

	// TODO delete Debug
	public int[] rollTheDicePair() {
		dice.rollTheDice();
		return dice.getPair();
	}

	public static void deleteInstance() {
		map = null;
		tradeManager = null;
		forexManager = null;
		bank = null;
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

	public void update() {
		while (isGameOver()) {
			for (Player player : players) {
				//playTurn(player);
			}
		}
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


	public void openPowerUpCrate(Player player) {
		// TODO
	}
	public void mapBuyTile(Player player, int tileNo) { map.buyTile(player, tileNo); }
	public void mapSellTile(Player player, int tileNo) { map.sellTile(player, tileNo); }
	public void buildHouse(Player player, int tileNo) { map.buildHouse(player, tileNo); }
	public void buildHotel(Player player, int tileNo) { map.buildHotel(player, tileNo); }
	public double getForexDollar() { return forexManager.getDollarExRate(); }
	public double getForexEuro() { return forexManager.getEuroExRate(); }
	public double getForexFrank() { return forexManager.getFrankExRate(); }
	public void buyForexDollar(double amount) {
		double tryAmount = forexManager.getDollarExRate() * amount;
		if (bank.hasEnoughTRY(players[turnOfPlayerIndex], tryAmount)) {
			// TODO refactor
			players[turnOfPlayerIndex].getAccount()
					.setDollar(players[turnOfPlayerIndex].getAccount().getDollar() + amount);
			players[turnOfPlayerIndex].getAccount()
					.setTrl(players[turnOfPlayerIndex].getAccount().getTrl() - tryAmount);
			forexManager.push("Dollar", amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());

		}
	}
	public void buyForexEuro(double amount) {
		double tryAmount = forexManager.getEuroExRate() * amount;
		if (bank.hasEnoughTRY(players[turnOfPlayerIndex], tryAmount)) {
			// TODO refactor
			players[turnOfPlayerIndex].getAccount()
					.setEuro(players[turnOfPlayerIndex].getAccount().getEuro() + amount);
			players[turnOfPlayerIndex].getAccount()
					.setTrl(players[turnOfPlayerIndex].getAccount().getTrl() - tryAmount);
			forexManager.push("Euro", amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());

		}
	}
	public void buyForexFranc(double amount) {
		double tryAmount = forexManager.getFrankExRate() * amount;
		if (bank.hasEnoughTRY(players[turnOfPlayerIndex], tryAmount)) {
			// TODO refactor
			players[turnOfPlayerIndex].getAccount()
					.setSwissFrank(players[turnOfPlayerIndex].getAccount().getSwissFrank() + amount);
			players[turnOfPlayerIndex].getAccount()
					.setTrl(players[turnOfPlayerIndex].getAccount().getTrl() - tryAmount);
			forexManager.push("Frank", amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());

		}
	}
	public void sellForexDollar(double amount) {
		double tryAmount = forexManager.getDollarExRate() * amount;
		if (players[turnOfPlayerIndex].getAccount().getDollar() >= amount) {
			// TODO refactor
			players[turnOfPlayerIndex].getAccount()
					.setDollar(players[turnOfPlayerIndex].getAccount().getDollar() - amount);
			players[turnOfPlayerIndex].getAccount()
					.setTrl(players[turnOfPlayerIndex].getAccount().getTrl() + tryAmount);
			forexManager.push("Dollar", -amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());

		}
	}
	public void sellForexEuro(double amount) {
		double tryAmount = forexManager.getEuroExRate() * amount;
		if (players[turnOfPlayerIndex].getAccount().getEuro() >= amount) {
			// TODO refactor
			players[turnOfPlayerIndex].getAccount()
					.setEuro(players[turnOfPlayerIndex].getAccount().getEuro() - amount);
			players[turnOfPlayerIndex].getAccount()
					.setTrl(players[turnOfPlayerIndex].getAccount().getTrl() + tryAmount);
			forexManager.push("Euro", -amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());

		}
	}
	public void sellForexFranc(double amount) {
		double tryAmount = forexManager.getFrankExRate() * amount;
		if (players[turnOfPlayerIndex].getAccount().getSwissFrank() >= amount) {
			// TODO refactor
			players[turnOfPlayerIndex].getAccount()
					.setSwissFrank(players[turnOfPlayerIndex].getAccount().getSwissFrank() - amount);
			players[turnOfPlayerIndex].getAccount()
					.setTrl(players[turnOfPlayerIndex].getAccount().getTrl() + tryAmount);
			forexManager.push("Frank", -amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());
		}
	}

	public Player getPlayerAt(int index) { return players[index]; }
	public Player getTurnOfPlayer() { return players[turnOfPlayerIndex]; }
	public int getTurnOfPlayerIndex() { return turnOfPlayerIndex; }

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


	public void playTurn() {
		dice.rollTheDice();
		int diceTotal = dice.getSum();
		System.out.println(
				"TurnOf: " + turnOfPlayerIndex + "\n" +
				"Location before: " + players[turnOfPlayerIndex].getLocation() + "\n" +
						"");
		players[turnOfPlayerIndex].setLocation(players[turnOfPlayerIndex].getLocation() + diceTotal);
		turnOfPlayerIndex = (turnOfPlayerIndex + 1) % (players.length); // TODO add mafia and police to the loop + NPC_COUNT);
	}
}