package entity.map.tile;

import java.io.Serializable;

public class TransportationTile extends BuyableTile implements Serializable {
	private double rentAmount;

	public TransportationTile(String name, int id, int price, int rentAmount) {
		super(name, id, price, rentAmount);
		this.rentAmount = rentAmount;
	}

	public double getRentAmount() { // TODO test owner setlemiyo
		return rentAmount * Math.pow(2, getOwner().getVehicleCount());
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
}
