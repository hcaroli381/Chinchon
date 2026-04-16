package chinchon.dominio;

import java.util.List;

public class PlayerFactory {
	public static Player createPlayer(String type, String name, List<Card> hand) {
		if (type.equalsIgnoreCase("human")) {
			return new Human(name, hand, 0);
		} else if (type.equalsIgnoreCase("ai")) {
			return new AI(name, hand, 0);
		} else {
			return null;
		}
	}
}
