package management;

import cached.Settings;
import entity.Player;

import java.io.*;

public class GameManager {
	private static GameManager instance;

	// FILE PATHS
	private static final String SETTINGS_DIRECTORY = "local/settings.ser";
	private static Settings settings;

	// properties
	Player players[];

	private GameManager() {
		settings = new Settings(false, false);
	}

	public static synchronized GameManager getInstance() {
		if (instance == null) {
			instance = new GameManager();
		}
		return instance;
	}

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

	public void updateSettings(boolean colorblind, boolean muted) {
		try {
			FileOutputStream writeFile = new FileOutputStream(new File(SETTINGS_DIRECTORY));
			ObjectOutputStream writeObject = new ObjectOutputStream(writeFile);
			settings.setColorblindMode(colorblind);
			settings.setMutedMode(muted);

			writeObject.writeObject(settings);
			System.out.println("Saved settings successfully.");
		} catch (Exception e) {
			System.err.println("Save failed settings cannot be saved.");
		}
	}

	public Settings loadSettings() {
		try {
			FileInputStream readFile = new FileInputStream(new File(SETTINGS_DIRECTORY));
			ObjectInputStream readObject = new ObjectInputStream(readFile);

			settings = (Settings) readObject.readObject();

			System.out.println("Read successful settings object created.\n" + settings.toString());
			return settings;
		} catch (Exception e) {
			System.err.println("Read failed setting the default settings to false, false");
			settings = new Settings(false, false);
			return settings;
		}
	}

	public Settings getSettings() {
		return settings;
	}
}
