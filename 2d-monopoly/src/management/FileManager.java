package management;

import cached.Settings;

import java.io.*;

public class FileManager {
	// FILE PATHS
	private static final String SETTINGS_DIRECTORY = "local/";
	private static final String SETTINGS_FILE = "settings.ser";
	private static Settings settings = new Settings(false, false);;

	public static void loadGame() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream readFile = new FileInputStream(
				new File("local/savedgame.ser"));

		ObjectInputStream loadGame = new ObjectInputStream(readFile);
		GameManager.setInstance((GameManager) loadGame.readObject());
		System.out.println(GameManager.getInstance().toString());
		System.out.println("Game loaded successfully.");
	}

	public static void saveGame() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileOutputStream writeFile = new FileOutputStream(
				new File("local/savedgame.ser"));

		ObjectOutputStream saveGame = new ObjectOutputStream(writeFile);
		saveGame.writeObject(GameManager.getInstance());
		System.out.println("Game saved successfully.");
	}

	public static void updateSettings(Settings settings) {
		try {
			FileOutputStream writeFile = new FileOutputStream(new File(SETTINGS_DIRECTORY + SETTINGS_FILE));
			ObjectOutputStream writeObject = new ObjectOutputStream(writeFile);
			settings.setColorblindMode(settings.getColorblindMode());
			settings.setMutedMode(settings.getMutedMode());

			writeObject.writeObject(settings);
			System.out.println("Saved settings successfully.");
		} catch (Exception e) {
			System.err.println("Save failed settings cannot be saved.");
		}
	}
	public static Settings loadSettings() {
		try {
			FileInputStream readFile = new FileInputStream(new File(SETTINGS_DIRECTORY + SETTINGS_FILE));
			ObjectInputStream readObject = new ObjectInputStream(readFile);

			settings = (Settings) readObject.readObject();

			System.out.println("Read successful settings object created.\n" + settings.toString());
			return settings;
		} catch (Exception e) {
			System.err.println("Read failed setting the default settings to false, false");
			File saveFile = new File(SETTINGS_DIRECTORY);
			saveFile.mkdir();
			settings = new Settings(false, false);
			updateSettings(settings);
			return settings;
		}
	}
}