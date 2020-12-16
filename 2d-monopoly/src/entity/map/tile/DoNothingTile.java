package entity.map.tile;

public class DoNothingTile extends Tile {
	private boolean isFreePark;

	public DoNothingTile(String name, int id, boolean isFreePark) {
		super(name, id);
		this.isFreePark = isFreePark;
	}

	public boolean isFreePark() {
		return isFreePark;
	}

	public void setFreePark(boolean freePark) {
		isFreePark = freePark;
	}
}