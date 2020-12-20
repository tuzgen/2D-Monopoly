package management;

import entity.Bank;
import entity.map.tile.*;
import entity.player.Player;

import java.io.Serializable;

public class Map implements Serializable {
	private static final long serialVersionUID = 1580945254386458072L;

	private static Map instance;

	public static final int TILE_COUNT = 40;
	public static final int CITY_TILE_COUNT = 22;
	public static final int JAILNO = 10;
	public static final int LUXURYNO = 38;

	public static Map getInstance() {
		if (instance == null)
			instance = new Map();
		return instance;
	}
	// properties
	Tile[] tiles;

	private Map() {
		createMap();
	}

	public Tile[] getTiles() {
		return tiles;
	}


	public Tile getTileAt(int index) {
		if(index < 0){
			index = 40 + index;
		}
		return tiles[index % 40];
	}

	private void createMap() {
		tiles = new Tile[TILE_COUNT];

		tiles[0] = new StartTile("Start", 0);
		tiles[1] = new CityTile("Bayburt", 1, 20000, 2500, 50, 70, 1);
		tiles[2] = new CardTile("Card 1", 2, false);
		tiles[3] = new CityTile("Batman", 3, 22000, 2700, 50, 70, 1);
		tiles[4] = new TaxTile("Tax 1", 4, 25000);
		tiles[5] = new TransportationTile("Konya YHT", 5, 50000, 5000);
		tiles[6] = new CityTile("Adıyaman", 6, 27000, 3000, 50, 70, 2);
		tiles[7] = new CardTile("Card 2", 7, true);
		tiles[8] = new CityTile("Kampala", 8, 30000, 3150, 50, 70, 2);
		tiles[9] = new CityTile("Abuja", 9, 32000, 3300, 50, 70, 2);
		tiles[10] = new DoNothingTile("Jail visit", 10, false);
		tiles[11] = new CityTile("Kuala Lumpur", 11, 32500, 3500, 50, 70, 3);
		tiles[12] = new CompanyTile("Company 1", 12, 55000, 5500);
		tiles[13] = new CityTile("Fontana", 13, 43000, 4700, 50, 70, 3);
		tiles[14] = new CityTile("Pueblo", 14, 49500, 5000, 50, 70, 3);
		tiles[15] = new TransportationTile("Airport", 15, 50000, 5500);
		tiles[16] = new CityTile("Trinidad", 16, 52500, 5700, 50, 70, 4);
		tiles[17] = new CardTile("Card 3", 17, false);
		tiles[18] = new CityTile("L'Aquilla", 18, 55000, 5750, 50, 70, 4);
		tiles[19] = new CityTile("Caprice", 19, 55500, 6000, 50, 70, 4);
		tiles[20] = new DoNothingTile("Free parking", 20, true);
		tiles[21] = new CityTile("Bologna", 21, 60000, 6200, 50, 70, 5);
		tiles[22] = new CardTile("Card 4", 22, true);
		tiles[23] = new CityTile("Napoli", 23, 70000, 6350, 50, 70, 5);
		tiles[24] = new CityTile("Venice", 24, 75000, 6520, 50, 70, 5);
		tiles[25] = new TransportationTile("St.Petersburg Rails", 25, 50000, 6000);
		tiles[26] = new CityTile("Florence", 26, 82000, 7000, 50, 70, 6);
		tiles[27] = new CityTile("Parma", 27, 85000, 7500, 50, 70, 6);
		tiles[28] = new CompanyTile("Company 2", 28, 75000, 10000);
		tiles[29] = new CityTile("Milan", 29, 90000, 10000, 50, 70, 6);
		tiles[30] = new JailTile("Jail", 30);
		tiles[31] = new CityTile("Rome", 31, 100000, 12500, 50, 70, 7);
		tiles[32] = new CityTile("Staten Island", 32, 12500, 6, 50, 70, 7);
		tiles[33] = new CardTile("Card 5", 33, false);
		tiles[34] = new CityTile("Manhattan", 34, 100000, 15000, 50, 70, 7);
		tiles[35] = new TransportationTile("Harbour", 35, 50000, 10000);
		tiles[36] = new CardTile("Card 6", 36, true);
		tiles[37] = new CityTile("Palermo", 37, 120000, 20000, 50, 70, 8);
		tiles[38] = new TaxTile("Tax 2", 38, 25000);
		tiles[39] = new CityTile("The Bronx", 39, 120000, 20000, 50, 70, 8);
	}

	// Invokes CityTile's setOwner method
	public boolean buyTile(Player player, int tileNo) {
		if (!((BuyableTile)tiles[tileNo]).isOwned()) {
			((BuyableTile) tiles[tileNo]).setOwner(player);
			player.addToTileList(tiles[tileNo]);
			Bank.getInstance().takeMoney(player, ((BuyableTile) tiles[tileNo]).getPrice());
			return true;
		}

		return false;
	}

	// Invokes CityTile's setOwner method
	public boolean sellTile(Player player, int tileNo) {
		if (((BuyableTile)tiles[tileNo]).getOwner().equals(player)) {

			((BuyableTile)tiles[tileNo]).setOwner(null);
			player.removeFromTileList(tiles[tileNo]);
			((BuyableTile)tiles[tileNo]).setOwned(false);
			return true;
		}
		return false;
	}


	public boolean buildHouse(Player player, int tileNo) {
		if(((CityTile) tiles[tileNo]).isMortgage())
			return false;
		if (isHouseBuildAvailable(player, (CityTile) tiles[tileNo])) {
			((CityTile) tiles[tileNo]).addHouse();
			return true;
		}
		return false;
	}

	private boolean isHouseBuildAvailable(Player player, CityTile tile) {
		// assume the player has built the house and build
		// if the absolute difference is smaller than or equal to one
		int minHouse = 50; // giving absurdly high initial value
		for (Tile t : tiles) {
			if (t.getClass() == CityTile.class && ((CityTile) t).getColorGroup() == tile.getColorGroup()) {
				// for every tile in the same color group as "tile"
				minHouse = Math.min(minHouse, ((CityTile)t).getHouseCount());
			}
		}

		return isColorGroupOwnedByPlayer(player, tile.getColorGroup())
				&& (Math.abs(minHouse - (tile.getHouseCount() + 1)) <= 1);
	}

	public boolean buildHotel(Player player, int tileNo) {
		if (isHouseBuildAvailable(player, (CityTile) tiles[tileNo]) && ((CityTile)tiles[tileNo]).isHotelBuildAvailable()) {
			((CityTile) tiles[tileNo]).addHotel();
			return true;
		}
		return false;
	}

	private boolean isColorGroupOwnedByPlayer(Player player, int colorGroup) {
		boolean result = true;
		for (Tile tile : tiles) {
			if (tile.getClass() == CityTile.class && ((CityTile) tile).getColorGroup() == colorGroup) {
				// if the tile is a city tile and the tile is in the specified color group
				// return false if the player is not the owner
				if (!player.equals(((CityTile) tile).getOwner()))
					result = false;
			}
		}
		return result;
	}

	public boolean isColorGroupOwnedbyAnyPlayer(int colorGroup) {
		boolean result = false;
		for (int i = 0; i < GameManager.PLAYER_COUNT; i++) {
			result = result || isColorGroupOwnedByPlayer(GameManager.getInstance().getPlayerAt(i), colorGroup);
		}

		return result;
	}

	public String toString() {
		String result = "";

		for (Tile t : tiles) {
			result = result + t.toString();
		}

		return result;
	}

	public void deleteInstance() {
		tiles = null;
		instance = null;
	}
}