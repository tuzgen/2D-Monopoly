package entity.map.tile;

public class TaxTile extends Tile {
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