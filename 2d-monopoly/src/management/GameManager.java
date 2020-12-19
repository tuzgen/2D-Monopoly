package management;

import entity.Bank;
import entity.Dice;
import entity.player.BotCharacter;
import entity.player.Player;
import entity.player.User;
import entity.player.npcs.Mafia;
import entity.player.npcs.Police;
import gui.menus.MainMenu;
import gui.menus.SettingsMenu;
import sun.applet.Main;

import java.io.*;

public class GameManager implements Serializable {
	private static final int NPC_COUNT = 2;
	private static GameManager instance;

	// Cached singletons
	private static ForexManager forexManager;
	private static Bank bank;
	private static Map map;
	private static TradeManager tradeManager;

	// properties
	Player[] players;
	Dice dice;
	Mafia mafia;
	Police police;
	Player player1;
	Player player2;
	Player player3;
	Player player4;
	Player[] turnOrder;

	// state variables
	private int turnOfPlayerIndex;

	private GameManager(String name0, String name1, boolean isBot1, String name2,
						boolean isBot2, String name3, boolean isBot3) {

		System.out.println("Constructor\n" + name0 + " " + "false" + " \n" +
				name1 + " " + isBot1 + " \n" +
				name2 + " " + isBot2 + " \n" +
				name3 + " " + isBot3 + " \n");

		players = new Player[4];
		player1 = new Player(new User(), name0.equals("") ? "Player1" : name0);
		player2 = new Player(isBot1 ? new User() : new BotCharacter(), name1.equals("") ? "Player2" : name1);
		player3 = new Player(isBot2 ? new User() : new BotCharacter(), name2.equals("") ? "Player3" : name2);
		player4 = new Player(isBot3 ? new User() : new BotCharacter(), name3.equals("") ? "Player4" : name3);
		players[0] = player1;
		players[1] = player2;
		players[2] = player3;
		players[3] = player4;
		mafia = new Mafia();
		police = new Police();

		dice = new Dice();
		tradeManager = TradeManager.getInstance();
		forexManager = ForexManager.getInstance();
		bank = Bank.getInstance();
		map = Map.getInstance();
		turnOfPlayerIndex = 0;
		if(SettingsMenu.muteSound == 0)
			MainMenu.sm.music(1);
	}

	public static boolean loadGame() {
		try {
			FileManager.loadGame();
			return true;

		} catch (Exception e) {
			System.err.println("Load game not successfull");
			return false;
		}
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
			instance = new GameManager("", "", false, "", false, "", false);
		}
		return instance;
	}

	public static synchronized void setInstance(GameManager load) {
		instance = load;
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
		for (Player p : players) {
			// TODO if any player has over the limit end game
			if (true) {
				return true;
			}
		}
		return false;
	}

	public Player[] determineTurn() {
		int sum0, sum1, sum2, sum3;
		Player tmp;
		int[] arr = new int[4];
		turnOrder = new Player[4];
		dice.rollTheDice();
		sum0 = dice.getSum();
		arr[0] = sum0;

		dice.rollTheDice();
		sum1 = dice.getSum();
		while(sum0 == sum1){
			dice.rollTheDice();
			sum1 = dice.getSum();
		}
		arr[1] = sum1;

		dice.rollTheDice();
		sum2 = dice.getSum();
		while(sum0 == sum2 || sum1 == sum2){
			dice.rollTheDice();
			sum2 = dice.getSum();
		}
		arr[2] = sum2;

		dice.rollTheDice();
		sum3 = dice.getSum();
		while(sum0 == sum3 || sum1 == sum3 || sum2 == sum3){
			dice.rollTheDice();
			sum3 = dice.getSum();
		}
		arr[3] = sum3;

		bubbleSort(arr);

		for (int i = 0; i < 4; i++) {
			System.out.println(arr[i]);
		}

		for (int i = 0; i < 4; i++) {
			if (arr[i] == sum0) {
				turnOrder[i] = player1;
			} else if (arr[i] == sum1) {
				turnOrder[i] = player2;
			} else if (arr[i] == sum2) {
				turnOrder[i] = player3;
			} else if (arr[i] == sum3) {
				turnOrder[i] = player4;
			}
		}


//		if(turnOrder[0] == player1){
//			turnOfPlayerIndex = 0;
//		}else if(turnOrder[0] == player2){
//			turnOfPlayerIndex = 1;
//		}else if(turnOrder[0] == player3){
//			turnOfPlayerIndex = 2;
//		}else if(turnOrder[0] == player4){
//			turnOfPlayerIndex = 3;
//		}



		for (int i = 0; i < 4; i++) {
			System.out.println("Real: " + turnOrder[i].getName());
			System.out.println("\tChanged: " + turnOrder[i].getName());
		}

		return turnOrder;
	}

	void bubbleSort(int arr[]) {
	int n = arr.length;
	for (int i = 0; i < n - 1; i++)
		for (int j = 0; j < n - i - 1; j++)
			if (arr[j] > arr[j + 1]) {
				// swap temp and arr[i]
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
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

	public Player getTurnOfPlayer() {
		if (turnOfPlayerIndex < 4) // is not mafia or police
			return players[turnOfPlayerIndex];
		return players[players.length - 1];
	}

	public Mafia getMafia() {return mafia; }

	public Police getPolice(){return police;}

	public int getTurnOfPlayerIndex() { return turnOfPlayerIndex; }

	public int playTurn() {

		dice.rollTheDice();

		int diceTotal = dice.getSum();

		int temp = turnOfPlayerIndex;
		if(temp == 4){
			mafia.setLocation(mafia.getLocation() + diceTotal % Map.TILE_COUNT);

			turnOfPlayerIndex = 5;
			return 4;
		}
		if(temp == 5){
			police.setLocation(police.getLocation() + diceTotal % Map.TILE_COUNT);

			System.out.println(police.getLocation());
			turnOfPlayerIndex = 0;
			return 5;
		}

		if(players[turnOfPlayerIndex] == turnOrder[turnOfPlayerIndex]){
			players[turnOfPlayerIndex].setLocation(players[turnOfPlayerIndex].getLocation() + diceTotal % Map.TILE_COUNT);
			System.out.println("Player: " + players[turnOfPlayerIndex].getName());
		} else{
			while(players[temp]!=turnOrder[turnOfPlayerIndex]) {
				temp++;
				if(temp > 3)
					temp = 0;
			}
			players[temp].setLocation(players[temp].getLocation() + diceTotal % Map.TILE_COUNT);
			System.out.println("Player: " + players[temp].getName());
		}

		int result = temp;
		turnOfPlayerIndex = (turnOfPlayerIndex + 1) % (6); // TODO add mafia and police to the loop + NPC_COUNT);

		return result;
	}

	public String toString() {
		return players[0].toString() + players[1].toString() + players[2].toString() + players[3].toString();
	}
}