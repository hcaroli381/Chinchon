// GameEngine.java (con inyección de dependencias y Singleton)
package chinchon.app;

import java.util.Scanner;

import chinchon.dominio.Colors;
import chinchon.dominio.HandAnalyzer;

public class GameEngine {
	private static GameEngine instance;
	private GameManager gameState;
	private GameLoop gameLoop;
	private ScoreCalculator scoreCalculator;
	private ConsoleInput console;
	private HandAnalyzer handAnalyzer;
	private DeckManager deckManager;

	private GameEngine(ConsoleInput console, HandAnalyzer handAnalyzer, DeckManager deckManager) {
		this.console = console;
		this.handAnalyzer = handAnalyzer;
		this.deckManager = deckManager;
		this.gameState = new GameManager(console, deckManager, handAnalyzer);
		this.gameLoop = new GameLoop(gameState, console, handAnalyzer);
		this.scoreCalculator = new ScoreCalculator(gameState, handAnalyzer);

		gameState.setupGame();
	}

	public static GameEngine getInstance(ConsoleInput console, HandAnalyzer handAnalyzer, DeckManager deckManager) {
		if (instance == null) {
			instance = new GameEngine(console, handAnalyzer, deckManager);
		}
		return instance;
	}

	public void startGame() {
		boolean gameEnd = false;
		while (!gameEnd) {
			gameState.prepareNextRound();
			gameLoop.startGameLoop();
			gameEnd = scoreCalculator.checkGameEnd();
			if (!gameEnd) {
				gameState.prepareNextRound();
				System.out.printf("%sNew round!!%s\n", new Colors().YELLOW, new Colors().RESET);
			}
		}
	}
}