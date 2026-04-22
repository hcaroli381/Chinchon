package chinchon.dominio;

import java.util.List;

public class PlayerFactory {
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
