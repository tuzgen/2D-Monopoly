package management;

import entity.Bank;
import entity.Dice;
import entity.card.CardDeck;
import entity.map.tile.BuyableTile;
import entity.map.tile.CityTile;
import entity.player.BotCharacter;
import entity.player.Player;
import entity.player.User;
import entity.player.npcs.Mafia;
import entity.player.npcs.Police;
import gui.menus.MainMenu;
import gui.menus.SettingsMenu;

import java.io.*;

public class GameManager implements Serializable {
	private static final int NPC_COUNT = 2;
	private static final int MAX_MONEY = 1000000;
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
	CardDeck communitydeck;
	CardDeck changedeck;
	Police police;
	Player player1;
	Player player2;
	Player player3;
	Player player4;
	int[] turnOrder;

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

		communitydeck = new CardDeck(false, false);
		changedeck = new CardDeck(true, false);

		dice = new Dice();
		tradeManager = TradeManager.getInstance();
		forexManager = ForexManager.getInstance();
		bank = Bank.getInstance();
		map = Map.getInstance();

		turnOfPlayerIndex = 0;
		determineTurn();
		if(SettingsMenu.muteSound == 0)
			MainMenu.sm.music(1);
	}

	public CardDeck getChangedeck() {
		return changedeck;
	}

	public CardDeck getCommunitydeck() {
		return communitydeck;
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

		}
	}

	public boolean isGameOver() {
		for (Player p : players) {
			if (p.getAccount().getTrl() >= MAX_MONEY || isEveryoneBankrupt()) {
				return true;
			}
		}
		return false;
	}

	private boolean isEveryoneBankrupt() {
		int count = 0;
		for (Player p : players) {
			if (p.getIsBankrupt()) {
				count++;
			}
		}
		return count >= 3;
	}

	public int[] determineTurn() {
		int sum0, sum1, sum2, sum3;
		Player tmp;
		int[] arr = new int[4];
		turnOrder = new int[4];
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
				turnOrder[i] = 0;
			} else if (arr[i] == sum1) {
				turnOrder[i] = 1;
			} else if (arr[i] == sum2) {
				turnOrder[i] = 2;
			} else if (arr[i] == sum3) {
				turnOrder[i] = 3;
			}
		}

		for (int i = 0; i < 4; i++) {
			System.out.println("Real: " + players[turnOrder[i]].getName());
			System.out.println("\tChanged: " + players[turnOrder[i]].getName());
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
		// TODO fill this with the functionality in the PowerUpPopup
	}

	public void mapBuyTile(Player player, int tileNo, boolean fromMafia) {
		// if the player has enough money to buy the tile
		// precondition: tile at tileNo is a BuyableTile
		int price = ((BuyableTile) map.getTileAt(tileNo)).getPrice();
		if (fromMafia) { // a deal is made with the mafia
			mafia.addDeal(player);
			price = (int) (price * Mafia.TILE_DISCOUNT);
		}

		if (player.getAccount().getTrl() >= price) {
			if (map.buyTile(player, tileNo))
				player.getAccount().setTrl(player.getAccount().getTrl() - price);
		} else
			System.out.println("mapBuyTile --- Buy tile failed...");
	}

	public void mapSellTile(Player player, int tileNo) {
		if (map.sellTile(player, tileNo))
			// add to the player's account
			player.getAccount().setTrl(player.getAccount().getTrl() + ((BuyableTile) map.getTileAt(tileNo)).getPrice());

	}

	public void buildHouse(Player player, int tileNo, boolean fromMafia) {
		// precondition: the player is on a CityTile
		int price = ((CityTile) map.getTileAt(tileNo)).getHouseBuildPrice();

		if (fromMafia) { // a deal is made with the mafia
			mafia.addDeal(player);
			price = (int) (price * Mafia.TILE_DISCOUNT); // discounted price
		}

		if (player.getAccount().getTrl() >= price) {
			if (map.buildHouse(player, tileNo))
				player.getAccount().setTrl(player.getAccount().getTrl() - price);
		} else
			System.out.println("mapBuildHouse --- Buy house failed...");
	}

	public void buildHotel(Player player, int tileNo, boolean fromMafia) {
		// precondition: the player is on a CityTile
		int price = ((CityTile) map.getTileAt(tileNo)).getHotelBuildPrice();

		if (fromMafia) { // a deal is made with the mafia
			mafia.addDeal(player);
			price = (int) (price * Mafia.TILE_DISCOUNT); // discounted price
		}

		if (player.getAccount().getTrl() >= price) {
			if (map.buildHotel(player, tileNo))
				player.getAccount().setTrl(player.getAccount().getTrl() - price);
		} else
			System.out.println("mapBuildHouse --- Buy hotel failed...");
	}

	public double getForexDollar() { return forexManager.getDollarExRate(); }
	public double getForexEuro() { return forexManager.getEuroExRate(); }
	public double getForexFrank() { return forexManager.getFrankExRate(); }

	public void buyForexDollar(double amount) {
		double tryAmount = forexManager.getDollarExRate() * amount;
		if (bank.hasEnoughTRY(players[getTurnOfPlayerIndex()], tryAmount)) {
			// TODO refactor
			players[getTurnOfPlayerIndex()].getAccount()
					.setDollar(players[getTurnOfPlayerIndex()].getAccount().getDollar() + amount);
			players[getTurnOfPlayerIndex()].getAccount()
					.setTrl(players[getTurnOfPlayerIndex()].getAccount().getTrl() - tryAmount);
			forexManager.push("Dollar", amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());

		}
	}

	public void buyForexEuro(double amount) {
		double tryAmount = forexManager.getEuroExRate() * amount;
		if (bank.hasEnoughTRY(players[getTurnOfPlayerIndex()], tryAmount)) {
			// TODO refactor
			players[getTurnOfPlayerIndex()].getAccount()
					.setEuro(players[getTurnOfPlayerIndex()].getAccount().getEuro() + amount);
			players[getTurnOfPlayerIndex()].getAccount()
					.setTrl(players[getTurnOfPlayerIndex()].getAccount().getTrl() - tryAmount);
			forexManager.push("Euro", amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());
		}
	}

	public void buyForexFranc(double amount) {
		double tryAmount = forexManager.getFrankExRate() * amount;
		if (bank.hasEnoughTRY(players[getTurnOfPlayerIndex()], tryAmount)) {
			// TODO refactor
			players[getTurnOfPlayerIndex()].getAccount()
					.setSwissFrank(players[getTurnOfPlayerIndex()].getAccount().getSwissFrank() + amount);
			players[getTurnOfPlayerIndex()].getAccount()
					.setTrl(players[getTurnOfPlayerIndex()].getAccount().getTrl() - tryAmount);
			forexManager.push("Frank", amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());

		}
	}

	public void sellForexDollar(double amount) {
		double tryAmount = forexManager.getDollarExRate() * amount;
		if (players[getTurnOfPlayerIndex()].getAccount().getDollar() >= amount) {
			// TODO refactor
			players[getTurnOfPlayerIndex()].getAccount()
					.setDollar(players[getTurnOfPlayerIndex()].getAccount().getDollar() - amount);
			players[getTurnOfPlayerIndex()].getAccount()
					.setTrl(players[getTurnOfPlayerIndex()].getAccount().getTrl() + tryAmount);
			forexManager.push("Dollar", -amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());

		}
	}

	public void sellForexEuro(double amount) {
		double tryAmount = forexManager.getEuroExRate() * amount;
		if (players[getTurnOfPlayerIndex()].getAccount().getEuro() >= amount) {
			// TODO refactor
			players[getTurnOfPlayerIndex()].getAccount()
					.setEuro(players[getTurnOfPlayerIndex()].getAccount().getEuro() - amount);
			players[getTurnOfPlayerIndex()].getAccount()
					.setTrl(players[getTurnOfPlayerIndex()].getAccount().getTrl() + tryAmount);
			forexManager.push("Euro", -amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());

		}
	}

	public void sellForexFranc(double amount) {
		double tryAmount = forexManager.getFrankExRate() * amount;
		if (players[getTurnOfPlayerIndex()].getAccount().getSwissFrank() >= amount) {
			// TODO refactor
			players[getTurnOfPlayerIndex()].getAccount()
					.setSwissFrank(players[getTurnOfPlayerIndex()].getAccount().getSwissFrank() - amount);
			players[getTurnOfPlayerIndex()].getAccount()
					.setTrl(players[getTurnOfPlayerIndex()].getAccount().getTrl() + tryAmount);
			forexManager.push("Frank", -amount);
			forexManager.calcSupDemand(); // TODO move to end of game loop debug here
			System.out.println("\nDollar rate: " + forexManager.getDollarExRate() + "\n" +
					"Euro rate: " + forexManager.getEuroExRate() + "\n" +
					"Franc rate: " + forexManager.getFrankExRate());
		}
	}

	public Player getPlayerAt(int index) {
		return players[index];
	}

	public Player getTurnOfPlayer() {
		if (turnOfPlayerIndex < 4) // is not mafia or police
			return players[turnOrder[turnOfPlayerIndex]];
		return players[players.length - 1];
	}

	public Mafia getMafia() { return mafia; }

	public Police getPolice() { return police;}

	public int getTurnOfPlayerIndex() {
		if (turnOfPlayerIndex > 3){
			return turnOfPlayerIndex;
		} else
			return turnOrder[turnOfPlayerIndex];
	}

	public int playTurn() {
		dice.rollTheDice();
		int diceTotal = dice.getSum();

		int temp = turnOfPlayerIndex;
		if(temp == 4){
			if(mafia.getIsArrested()){
				int[] dices = dice.getPair();
				if(dices[0] == dices[1] ){
					mafia.setIsArrested(false);
				}
			}
			if( !mafia.getIsArrested()){
				mafia.setLocation(mafia.getLocation() + diceTotal % Map.TILE_COUNT);

			}
			turnOfPlayerIndex = 5;
			return 4;
		}
		if(temp == 5){
			police.setLocation(police.getLocation() + diceTotal % Map.TILE_COUNT);
			if (police.getAtSameLoc(mafia)) {
				mafia.setIsArrested(true);
			}

			System.out.println(police.getLocation());
			turnOfPlayerIndex = 0;
			return 5;
		}

		if(players[turnOfPlayerIndex] == players[turnOrder[turnOfPlayerIndex]]){
			if(players[turnOfPlayerIndex].getIsArrested()){ // checks if the player is arrested or not
				int[] dices = dice.getPair();
				if(dices[0] == dices[1] ){
					players[turnOfPlayerIndex].setIsArrested(false);
					players[turnOfPlayerIndex].setLocation(players[turnOfPlayerIndex].getLocation() + diceTotal % Map.TILE_COUNT);
				}
			}else {
				if(players[turnOfPlayerIndex].getLocation() + diceTotal > 40)
					players[turnOfPlayerIndex].getAccount().setTrl(players[turnOfPlayerIndex].getAccount().getTrl() + 200);
				players[turnOfPlayerIndex].setLocation(players[turnOfPlayerIndex].getLocation() + diceTotal % Map.TILE_COUNT);
			}
			System.out.println("Player: " + players[turnOfPlayerIndex].getName());
		} else {
			while(players[temp] != players[turnOrder[turnOfPlayerIndex]]) {
				temp++;
				if(temp > 3)
					temp = 0;
			}
			if(players[temp].getIsArrested()) {
				int[] dices = dice.getPair();
				if(dices[0] == dices[1] ){
					players[temp].setIsArrested(false);
					players[temp].setLocation(players[temp].getLocation() + diceTotal % Map.TILE_COUNT);
				}
			}else {
				if(players[temp].getLocation() + diceTotal > 40)
					players[temp].getAccount().setTrl(players[temp].getAccount().getTrl() + 200);
				players[temp].setLocation(players[temp].getLocation() + diceTotal % Map.TILE_COUNT);
			}
			System.out.println("Player: " + players[temp].getName());
		}

		return temp;
	}

	public void increaseTurn(){
		turnOfPlayerIndex = (turnOfPlayerIndex + 1) % (6);
	}

	public void gotoJail(){
		getTurnOfPlayer().setIsArrested(true);

	}
	public String toString() {
		return players[0].toString() + players[1].toString() + players[2].toString() + players[3].toString();
	}
}