package entity.map.tile;

import java.io.Serializable;

public class CompanyTile extends BuyableTile implements Serializable {
	public CompanyTile(String name, int id, int price, double rentAmount) {
		super(name, id, price, rentAmount);
	}

}
