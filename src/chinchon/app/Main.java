package chinchon.app;

import java.util.Scanner;

import chinchon.dominio.HandAnalyzer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConsoleInput console = new ConsoleInput(sc);
		HandAnalyzer handAnalyzer = new HandAnalyzer();
		DeckManager deckManager = new DeckManager();
		GameEngine.createInstance(console, handAnalyzer, deckManager);
		GameEngine engine = null;
		try {
			engine = GameEngine.getInstance(console, handAnalyzer, deckManager);
		} catch (Exception e) {
			System.err.println(e);
			;
		}

		engine.startGame();

	}
}
