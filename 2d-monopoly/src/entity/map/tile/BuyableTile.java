package entity.map.tile;

import entity.player.Player;

public abstract class BuyableTile extends Tile {
	// constants
	public final double MORTGAGE_RATE = 0.5; // TODO

	// state variables
	private boolean isOwned;
	private Player whoseTile;
	private int price;
	private double rentAmount;
	private boolean soldByMafia;
	private boolean isMortgage;

	public BuyableTile(String name, int id, int price, double rentAmount) {
		super(name, id);
		this.price = price;
		this.rentAmount = rentAmount;
		this.isMortgage = false;
		this.isOwned = false;
		this.soldByMafia = false;
		this.whoseTile = null;
	}

	// getters and setters

	public boolean isOwned() {
		return isOwned;
	}

	private void setOwned(boolean owned) {
		isOwned = owned;
	}

	public void setWhoseTile(Player whoseTile) {
		this.whoseTile = whoseTile;
		if (whoseTile == null)
			setOwned(true);
	}

	public Player getWhoseTile() {
		return whoseTile;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public void setSoldByMafia(boolean soldByMafia) {
		this.soldByMafia = soldByMafia;
	}

	public boolean isSoldByMafia() {
		return soldByMafia;
	}

	public boolean isMortgage() {
		return isMortgage;
	}

	public void setMortgage(boolean mortgage) {
		isMortgage = mortgage;
	}
}
