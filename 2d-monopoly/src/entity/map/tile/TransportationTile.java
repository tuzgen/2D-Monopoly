package entity.map.tile;

import java.io.Serializable;

public class TransportationTile extends BuyableTile implements Serializable {
	private double rentAmount;

	public TransportationTile(String name, int id, int price, int rentAmount) {
		super(name, id, price, rentAmount);
		this.rentAmount = rentAmount;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
}
