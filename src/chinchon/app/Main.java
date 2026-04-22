package chinchon.app;

import java.util.Scanner;

import chinchon.dominio.HandAnalyzer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConsoleInput console = new ConsoleInput(sc);
		HandAnalyzer handAnalyzer = new HandAnalyzer();
		DeckManager deckManager = new DeckManager();
		GameEngine gameEngine = GameEngine.getInstance(console, handAnalyzer, deckManager);

		gameEngine.startGame();

	}
}
