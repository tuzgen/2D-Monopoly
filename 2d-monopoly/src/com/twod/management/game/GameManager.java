package com.twod.management.game;

import com.twod.management.entity.*;

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
