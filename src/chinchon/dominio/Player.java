package chinchon.dominio;

import java.util.List;

public abstract class Player {
	private String name;
	private List<Card> hand;
	private int score;

	public Player(String name, List<Card> hand, int score) {
		this.name = name;
		this.hand = hand;
		this.score = score;
	}

	abstract void playTurn();
}
