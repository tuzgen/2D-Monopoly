package entity.map.tile;

import management.GameManager;

import java.io.Serializable;

public class CompanyTile extends BuyableTile implements Serializable {
	public CompanyTile(String name, int id, int price, double rentAmount) {
		super(name, id, price, rentAmount);
	}

	private final static int COMPANY_RENT_MULTIPLIER = 10;

	@Override
	public double getRentAmount() { // TODO test this
		double result = 0;
		int diceSum = GameManager.getInstance().getDice()[0] + GameManager.getInstance().getDice()[1];
		switch (getOwner().getCompanyCount()) {
			case 1 : result = diceSum * 8 * COMPANY_RENT_MULTIPLIER;
			case 2 : result *= 2.5;
		}

		return result;
	}
}
