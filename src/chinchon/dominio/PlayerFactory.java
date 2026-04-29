package chinchon.dominio;

import java.util.List;

/**
 * Fábrica centralizada para crear instancias de jugadores.
 */
public class PlayerFactory {
	/**
	 * Crea un jugador concreto según el tipo indicado.
	 *
	 * @param type         tipo de jugador a construir
	 * @param name         nombre del jugador
	 * @param hand         mano inicial asignada
	 * @param handAnalyzer analizador de manos compartido
	 * @return instancia de {@link Player}
	 * @throws IllegalArgumentException si el tipo no es reconocido
	 */
	public static Player createPlayer(PlayerType type, String name, List<Card> hand, HandAnalyzer handAnalyzer)
			throws IllegalArgumentException {
		switch (type) {
		case HUMAN:
			return new Human(name, hand, 0, handAnalyzer);
		case AI:
			return new AI(name, hand, 0, handAnalyzer);
		default:
			throw new IllegalArgumentException("Tipo de jugador desconocido");
		}

	}
}
