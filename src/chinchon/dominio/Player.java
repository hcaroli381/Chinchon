package chinchon.dominio;

import java.util.List;

import chinchon.app.ConsoleInput;

public abstract class Player {
	private String name;
	private List<Card> hand;
	private int score;

	public Player(String name, List<Card> hand, int score) {
		this.name = name;
		this.hand = hand;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	abstract void playTurn(ConsoleInput input, Deck deck, List<Card> discardPile);
}
