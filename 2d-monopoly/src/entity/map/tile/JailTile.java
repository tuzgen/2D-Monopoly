package entity.map.tile;

import entity.player.Player;

import java.io.Serializable;

public class JailTile extends Tile implements Serializable {
	public JailTile(String name, int id) {
		super(name, id);
	}
	public boolean getIsArrested(Player player) {
		return player.getIsArrested();
	}
}