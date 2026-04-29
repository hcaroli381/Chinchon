package chinchon.app;

import java.util.Comparator;

import chinchon.dominio.HandAnalyzer;
import chinchon.dominio.Player;

/**
 * Evalúa las condiciones de final de partida y muestra el resultado final.
 */
public class ScoreCalculator {
	private GameManager gameState;
	private HandAnalyzer handAnalyzer;

	/**
	 * Crea el calculador de puntuación asociado al estado de la partida.
	 *
	 * @param gameState    estado de la partida
	 * @param handAnalyzer analizador de manos
	 */
	public ScoreCalculator(GameManager gameState, HandAnalyzer handAnalyzer) {
		this.gameState = gameState;
		this.handAnalyzer = handAnalyzer;
	}

	/**
	 * Comprueba si la partida ha terminado por eliminación o por chinchón.
	 *
	 * @return {@code true} si la partida debe finalizar; {@code false} en caso
	 *         contrario
	 */
	protected boolean checkGameEnd() {

		if (gameState.getPlayers().size() <= 1) {
			pointsGameEnd();
			return true;
		}

		if (handAnalyzer.findChinchon(gameState.getPlayers().get(0).getHand())) {
			chinchonGameEnd();
			return true;
		}

		return false;
	}

	/**
	 * Resuelve el final de partida por puntos cuando solo queda un jugador.
	 */
	private void pointsGameEnd() {
		Player winner = gameState.getPlayers().get(0);
		System.out.printf("FIN DE LA PARTIDA : \n");
		gameState.getPlayers().sort(Comparator.comparingInt(Player::getScore).reversed());
		System.out.printf("%s gana con %d puntos!!\n", winner.toString(), winner.getScore());
	}

	/**
	 * Resuelve el final de partida cuando alguien consigue un chinchón.
	 */
	private void chinchonGameEnd() {
		int i = 0;
		System.out.printf("FIN DE LA PARTIDA : \n");
		gameState.getPlayers().sort(Comparator.comparingInt(Player::getScore).reversed());
		for (Player player : gameState.getPlayers()) {
			i++;
			if (handAnalyzer.findChinchon(player.getHand())) {
				System.out.printf("%s : CHINCHON!!\n", player.toString());
			} else {
				System.out.printf("%s : %d points\n", player.toString(), player.getScore());
			}

		}
	}
}
