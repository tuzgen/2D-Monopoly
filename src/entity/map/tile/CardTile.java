package entity.map.tile;

import java.io.Serializable;

public class CardTile extends Tile implements Serializable {
	private boolean isChance;

	public CardTile(String name, int id, boolean isChance) {
		super(name, id);
		this.isChance = isChance;
	}

	public boolean getIsChance() {
		return isChance;
	}

	public void setIsChance(boolean chance) {
		isChance = chance;
	}
}
