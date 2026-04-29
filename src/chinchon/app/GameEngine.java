
package chinchon.app;

import java.util.Scanner;

import chinchon.dominio.Colors;
import chinchon.dominio.HandAnalyzer;

/**
 * Orquesta la preparación y ejecución de la partida completa.
 * <p>
 * Se implementa como singleton para asegurar una única instancia de control.
 */
public class GameEngine {
	private static GameEngine instance;
	private GameManager gameState;
	private GameLoop gameLoop;
	private ScoreCalculator scoreCalculator;
	private ConsoleInput console;
	private HandAnalyzer handAnalyzer;
	private DeckManager deckManager;

	/**
	 * Crea el motor con todas las dependencias necesarias y deja la partida lista
	 * para comenzar.
	 *
	 * @param console      entrada de consola
	 * @param handAnalyzer analizador de manos
	 * @param deckManager  gestor de baraja
	 */
	private GameEngine(ConsoleInput console, HandAnalyzer handAnalyzer, DeckManager deckManager) {
		this.console = console;
		this.handAnalyzer = handAnalyzer;
		this.deckManager = deckManager;
		this.gameState = new GameManager(console, deckManager, handAnalyzer);
		this.gameLoop = new GameLoop(gameState, console, handAnalyzer, deckManager);
		this.scoreCalculator = new ScoreCalculator(gameState, handAnalyzer);

		gameState.setupGame();
	}

	/**
	 * Crea la instancia única del motor si todavía no existe.
	 *
	 * @param console      entrada de consola
	 * @param handAnalyzer analizador de manos
	 * @param deckManager  gestor de baraja
	 */
	public static void createInstance(ConsoleInput console, HandAnalyzer handAnalyzer, DeckManager deckManager) {
		if (instance == null) {
			instance = new GameEngine(console, handAnalyzer, deckManager);
		}
	}

	/**
	 * Obtiene la instancia creada previamente del motor.
	 *
	 * @param console      entrada de consola
	 * @param handAnalyzer analizador de manos
	 * @param deckManager  gestor de baraja
	 * @return instancia única del motor
	 * @throws Exception si todavía no se ha creado la instancia
	 */
	public static GameEngine getInstance(ConsoleInput console, HandAnalyzer handAnalyzer, DeckManager deckManager)
			throws Exception {
		if (instance == null) {
			throw new Exception("Debes hacer 'createInstance' primero");
		}
		return instance;
	}

	/**
	 * Inicia la partida completa y encadena las rondas hasta que haya un ganador.
	 */
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