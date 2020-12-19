package entity.map.property;

import java.io.Serializable;

public abstract class Property implements Serializable {
	// Properties
	private int price;

	public Property(int price) {
		this.price = price;
	}

	// getters and setters
	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}