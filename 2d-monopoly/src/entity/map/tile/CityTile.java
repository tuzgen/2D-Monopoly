package entity.map.tile;

import entity.map.property.Hotel;
import entity.map.property.House;
import entity.map.property.Property;

public class CityTile extends BuyableTile {
	private final int PROPERTY_COUNT = 4;
	final private int houseBuildPrice;
	final private int hotelBuildPrice;
	Property[] properties;

	public CityTile(String name, int id, int price, int rentAmount, int houseBuildPrice, int hotelBuildPrice) {
		super(name, id, price, rentAmount);
		properties = new Property[PROPERTY_COUNT]; // has a max of four properties
		this.houseBuildPrice = houseBuildPrice;
		this.hotelBuildPrice = hotelBuildPrice;
	}

	public int getHouseCount() {
		int result = 0;
		// count each class in properties with class House
		for (Property p : properties) {
			if (p.getClass() == House.class) {
				result++;
			}
		}
		return 0;
	}

	public void addHouse() {
		// Search if there are a slot for a new house
		for (int i = 0; i < PROPERTY_COUNT - 1; i++) {
			if (properties[i].getClass() != House.class) {
				properties[i] = new House(houseBuildPrice);
			}
		}
		// TODO test
	}

	public int getHotelCount() {
		return properties[3].getClass() == Hotel.class ? 1 : 0; // TODO
	}

	public void addHotel() {
		if (isHotelBuildAvailable()) {
			properties[3] = new Hotel(hotelBuildPrice);
		}
		// TODO
	}

	public boolean isHotelBuildAvailable() {
		return getHouseCount() == 3 && getHotelCount() == 0; // TODO test
	}
}