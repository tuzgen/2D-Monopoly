package management.game;

import management.entity.*;
import management.entity.Player;

public class GameManager {
	// properties
	Player players[];

	public void update() {
		while (!isGameOver()) {

		}
	}

	public boolean isGameOver() {
		for (Player p: players) {
			// TODO if any player has over the limit end game
			if (true) {
				return true;
			}
		}
		return false;
	}
}
