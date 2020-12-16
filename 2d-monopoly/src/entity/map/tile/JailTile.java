package entity.map.tile;

import entity.player.Player;

public class JailTile extends Tile {
	public JailTile(String name, int id) {
		super(name, id);
	}

	public void arrested(Player player) {
		// TODO player.setArrested();
	}

	public boolean getIsArrested(Player player) {
		return player.getIsArrested();
	}
}