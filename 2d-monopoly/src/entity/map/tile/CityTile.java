package entity.map.tile;

import entity.map.property.Hotel;
import entity.map.property.House;
import entity.map.property.Property;
import management.Map;

import java.io.Serializable;

public class CityTile extends BuyableTile implements Serializable {
	private final int PROPERTY_COUNT = 4;
	final private int houseBuildPrice, hotelBuildPrice, colorGroup;

	Property[] properties;

	public CityTile(String name, int id, int price, int rentAmount, int houseBuildPrice, int hotelBuildPrice, int colorGroup) {
		super(name, id, price, rentAmount);
		properties = new Property[PROPERTY_COUNT]; // has a max of four properties
		this.houseBuildPrice = houseBuildPrice;
		this.hotelBuildPrice = hotelBuildPrice;
		this.colorGroup = colorGroup;
	}

	public int getHouseBuildPrice() { return houseBuildPrice; }
	public int getHotelBuildPrice() { return hotelBuildPrice; }

	public double getRentAmount() {
		double amount = super.getRentAmount();
		if (Map.getInstance().isColorGroupOwnedbyAnyPlayer(colorGroup)) {
			amount *= 2;

			switch (getHouseCount()) {
				case 1 : amount *= 2.5;
				case 2 : amount *= 3.0;
				case 3 : {
					amount *= 1.5;
					amount = getHotelCount() == 1 ? amount * 1.5 : amount;
				}
			}
		}

		return amount;
	}

	public int getHouseCount() {
		int result = 0;
		// count each class in properties with class House
		for (int i = 0; i < PROPERTY_COUNT - 1; i++) {
			if (properties[i] != null) {
				result++;
			}
		}
		return result;
	}

	public void addHouse() {
		// Search if there are a slot for a new house
		for (int i = 0; i < PROPERTY_COUNT - 1; i++) {
			if (properties[i] == null) {//.getClass() != House.class) {
				properties[i] = new House(houseBuildPrice);
				return;
			}
		}
	}

	public void removeHouse() {
		// search the first available house for deletion
		for (int i = 2; i >= 0; i--) {
			if (properties[i] != null) {
				properties[i] = null;
				return;
			}
		}
	}

	public int getHotelCount() {
		return properties[3] == null ? 0 : 1;
	}

	public void addHotel() {
		if (isHotelBuildAvailable()) {
			properties[3] = new Hotel(hotelBuildPrice);
			return;
		}
	}

	public void removeHotel() {
		if (getHotelCount() == 1) {
			properties[3] = null;
		}
	}


	public boolean isHotelBuildAvailable() {
		return getHouseCount() == 3 && getHotelCount() == 0;
	}

	public int getColorGroup() {
		return colorGroup;
	}

}