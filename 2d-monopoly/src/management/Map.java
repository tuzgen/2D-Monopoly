package management;


import entity.map.tile.*;

public class Map {
	private final int TILECOUNT = 40;

	// properties
	Tile[] tiles;

	public Map() {
		createMap();
	}

	public Tile[] getTiles() {
		return tiles;
	}

	public void updateMap() {
		// TODO
	}

	public Tile getTileAt(int index) {
		return tiles[index];
	}

	private void createMap() {
		tiles = new Tile[TILECOUNT];

		tiles[0] = new StartTile("Start", 0);
		tiles[1] = new CityTile("City 1", 1, 60, 2, 50, 70);
		tiles[2] = new CardTile("Card 1", 2, false);
		tiles[3] = new CityTile("City 2", 3, 60, 4, 50, 70);
		tiles[4] = new TaxTile("Tax 1", 4, 60);
		tiles[5] = new TransportationTile("Transportation 1", 5, 60, 3);
		tiles[6] = new CityTile("City 3", 5, 100, 6, 50, 70);
		tiles[7] = new CardTile("Card 2", 6, true);
		tiles[8] = new CityTile("City 4", 7, 100, 6, 50, 70);
		tiles[9] = new CityTile("City 5", 8, 100, 6, 50, 70);
		tiles[10] = new DoNothingTile("Jail visit", 9, false);
		tiles[11] = new CityTile("City 6", 10, 100, 6, 50, 70);
		tiles[12] = new CompanyTile("Company 1", 11, 100, 6);
		tiles[13] = new CityTile("City 7", 12, 100, 6, 50, 70);
		tiles[14] = new CityTile("City 8", 13, 100, 6, 50, 70);
		tiles[15] = new TransportationTile("Transportation 2", 15, 100, 6);
		tiles[16] = new CityTile("City 9", 16, 100, 6, 50, 70);
		tiles[17] = new CardTile("Card 3", 17, false);
		tiles[18] = new CityTile("City 10", 18, 100, 6, 50, 70);
		tiles[19] = new CityTile("City 11", 19, 100, 6, 50, 70);
		tiles[20] = new DoNothingTile("Free parking", 20, true);
		tiles[21] = new CityTile("City 12", 21, 100, 6, 50, 70);
		tiles[22] = new CardTile("Card 4", 22, true);
		tiles[23] = new CityTile("City 13", 23, 100, 6, 50, 70);
		tiles[24] = new CityTile("City 14", 24, 100, 6, 50, 70);
		tiles[25] = new TransportationTile("Transportation 3", 25, 100, 6);
		tiles[26] = new CityTile("City 15", 26, 100, 6, 50, 70);
		tiles[27] = new CityTile("City 16", 27, 100, 6, 50, 70);
		tiles[28] = new CompanyTile("Company 2", 28, 100, 6);
		tiles[29] = new CityTile("City 17", 29, 100, 6, 50, 70);
		tiles[30] = new JailTile("Jail", 30);
		tiles[31] = new CityTile("City 18", 31, 100, 6, 50, 70);
		tiles[32] = new CityTile("City 19", 32, 100, 6, 50, 70);
		tiles[33] = new CardTile("Card 5", 33, false);
		tiles[34] = new CityTile("City 20", 34, 100, 6, 50, 70);
		tiles[35] = new TransportationTile("Transportation 4", 35, 100, 6);
		tiles[36] = new CardTile("Card 6", 36, true);
		tiles[37] = new CityTile("City 21", 37, 100, 6, 50, 70);
		tiles[38] = new TaxTile("Tax 2", 38, 100);
		tiles[39] = new CityTile("City 22", 39, 100, 6, 50, 70);
	}

	public String toString() {
		String result = "";

		for (Tile t : tiles) {
			result = result + t.toString();
		}

		return result;
	}
}