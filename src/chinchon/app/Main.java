package chinchon.app;

import java.util.Scanner;

import chinchon.dominio.HandAnalyzer;

/**
 * Punto de entrada de la aplicación de Chinchón.
 */
public class Main {

	/**
	 * Inicializa las dependencias principales y arranca la partida.
	 *
	 * @param args argumentos de línea de comandos, no utilizados
	 */
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
