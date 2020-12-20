package entity.map.tile;

import entity.Bank;
import entity.player.Player;

import java.io.Serializable;

public abstract class BuyableTile extends Tile implements Serializable {
	// constants
	public static final double MORTGAGE_RATE = 0.5;

	// state variables
	private boolean isOwned;
	private Player owner;
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
		this.owner = null;
	}

	// getters and setters

	public boolean isOwned() {
		return isOwned;
	}

	public void setOwned(boolean owned) {
		isOwned = owned;
	}

	public void setOwner(Player whoseTile) {
		if (this.owner == null)
			setOwned(true);
		this.owner = whoseTile;
	}

	public Player getOwner() {
		return owner;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getRentAmount() {
		if(!isMortgage)
			return rentAmount;
		return 0;
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

	public void setMortgage(Player player) {
		isMortgage = true;
		Bank.getInstance().giveMoney(player, price*MORTGAGE_RATE);
	}

	public int removeMortgage(Player player) {
		if(!isMortgage)
			return 0;
		isMortgage = false;
		if(Bank.getInstance().takeMoney(player, price * MORTGAGE_RATE + price / 10))
			return 2;
		return 1;
	}


}
