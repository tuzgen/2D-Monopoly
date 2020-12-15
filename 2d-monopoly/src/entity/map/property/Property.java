package entity.map.property;

public abstract class Property {
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
