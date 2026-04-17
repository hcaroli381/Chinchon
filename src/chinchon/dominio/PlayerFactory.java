package chinchon.dominio;

import java.util.List;

public class PlayerFactory {
	public static Player createPlayer(String type, String name, List<Card> hand, HandAnalyzer handAnalyzer) {
		if (type.equalsIgnoreCase("human")) {
			return new Human(name, hand, 0, handAnalyzer);
		} else if (type.equalsIgnoreCase("ai")) {
			return new AI(name, hand, 0, handAnalyzer);
		} else {
			return null;
		}
	}
}
