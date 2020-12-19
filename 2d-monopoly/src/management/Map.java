package management;

import entity.map.tile.*;
import entity.player.Player;

import java.io.Serializable;

public class Map implements Serializable {
	private static Map instance;

	public static final int TILE_COUNT = 40;
	public static final int JAILNO = 30;

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
		return tiles[index];
	}

	private void createMap() {
		tiles = new Tile[TILE_COUNT];

		tiles[0] = new StartTile("Start", 0);
		tiles[1] = new CityTile("City 1", 1, 60, 2, 50, 70, 1);
		tiles[2] = new CardTile("Card 1", 2, false);
		tiles[3] = new CityTile("City 2", 3, 60, 4, 50, 70, 1);
		tiles[4] = new TaxTile("Tax 1", 4, 60);
		tiles[5] = new TransportationTile("Transportation 1", 5, 60, 3);
		tiles[6] = new CityTile("City 3", 6, 100, 6, 50, 70, 2);
		tiles[7] = new CardTile("Card 2", 7, true);
		tiles[8] = new CityTile("City 4", 8, 100, 6, 50, 70, 2);
		tiles[9] = new CityTile("City 5", 9, 100, 6, 50, 70, 2);
		tiles[10] = new DoNothingTile("Jail visit", 10, false);
		tiles[11] = new CityTile("City 6", 11, 100, 6, 50, 70, 3);
		tiles[12] = new CompanyTile("Company 1", 12, 100, 6);
		tiles[13] = new CityTile("City 7", 13, 100, 6, 50, 70, 3);
		tiles[14] = new CityTile("City 8", 14, 100, 6, 50, 70, 3);
		tiles[15] = new TransportationTile("Transportation 2", 15, 100, 6);
		tiles[16] = new CityTile("City 9", 16, 100, 6, 50, 70, 4);
		tiles[17] = new CardTile("Card 3", 17, false);
		tiles[18] = new CityTile("City 10", 18, 100, 6, 50, 70, 4);
		tiles[19] = new CityTile("City 11", 19, 100, 6, 50, 70, 4);
		tiles[20] = new DoNothingTile("Free parking", 20, true);
		tiles[21] = new CityTile("City 12", 21, 100, 6, 50, 70, 5);
		tiles[22] = new CardTile("Card 4", 22, true);
		tiles[23] = new CityTile("City 13", 23, 100, 6, 50, 70, 5);
		tiles[24] = new CityTile("City 14", 24, 100, 6, 50, 70, 5);
		tiles[25] = new TransportationTile("Transportation 3", 25, 100, 6);
		tiles[26] = new CityTile("City 15", 26, 100, 6, 50, 70, 6);
		tiles[27] = new CityTile("City 16", 27, 100, 6, 50, 70, 6);
		tiles[28] = new CompanyTile("Company 2", 28, 100, 6);
		tiles[29] = new CityTile("City 17", 29, 100, 6, 50, 70, 6);
		tiles[30] = new JailTile("Jail", 30);
		tiles[31] = new CityTile("City 18", 31, 100, 6, 50, 70, 7);
		tiles[32] = new CityTile("City 19", 32, 100, 6, 50, 70, 7);
		tiles[33] = new CardTile("Card 5", 33, false);
		tiles[34] = new CityTile("City 20", 34, 100, 6, 50, 70, 7);
		tiles[35] = new TransportationTile("Transportation 4", 35, 100, 6);
		tiles[36] = new CardTile("Card 6", 36, true);
		tiles[37] = new CityTile("City 21", 37, 100, 6, 50, 70, 8);
		tiles[38] = new TaxTile("Tax 2", 38, 100);
		tiles[39] = new CityTile("City 22", 39, 100, 6, 50, 70, 8);
	}

	// Invokes CityTile's setOwner method
	public boolean buyTile(Player player, int tileNo) {
		if (!((CityTile)tiles[tileNo]).isOwned()) {
			((CityTile) tiles[tileNo]).setOwner(player);
			return true;
		}

		return false;
	}

	// Invokes CityTile's setOwner method
	public boolean sellTile(Player player, int tileNo) {
		if (((CityTile)tiles[tileNo]).getOwner().equals(player)) {
			((CityTile)tiles[tileNo]).setOwner(null);
			return true;
		}

		return false;
	}

	public boolean buildHouse(Player player, int tileNo) {
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
		/*
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (Math.abs(colorGroup[i].getHouseCount() - colorGroup[j].))
			}
		}
		*/

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

	public String toString() {
		String result = "";

		for (Tile t : tiles) {
			result = result + t.toString();
		}

		return result;
	}

}