package entity.map.tile;

import java.io.Serializable;

public class TaxTile extends Tile implements Serializable {
	private int amount;

	public TaxTile(String name, int id, int amount) {
		super(name, id);
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}