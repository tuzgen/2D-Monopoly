package management;

import java.io.*;

public class FileManager {
	public static void loadGame() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream readFile = new FileInputStream(
				new File("local/savedgame.ser"));

		ObjectInputStream loadGame = new ObjectInputStream(readFile);
		GameManager.setInstance((GameManager) loadGame.readObject());
		GameManager.getInstance().toString();
		System.out.println("Game loaded successfully.");
	}

	public static void saveGame() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileOutputStream writeFile = new FileOutputStream(
				new File("local/savedgame.ser"));

		ObjectOutputStream saveGame = new ObjectOutputStream(writeFile);
		saveGame.writeObject(GameManager.getInstance());
		System.out.println("Game saved successfully.");
	}
}