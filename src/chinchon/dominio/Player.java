package chinchon.dominio;

import java.util.List;

import chinchon.app.ConsoleInput;

public abstract class Player {
	private String name;
	private List<Card> hand;
	private int score;
	private HandAnalyzer handAnalyzer;

	public Player(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer) {
		this.name = name;
		this.hand = hand;
		this.score = score;
		this.setHandAnalyzer(handAnalyzer);
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

	/**
	 * Funcion que se encargara de jugar el turno, que será definida por las clases
	 * hijas
	 * 
	 * @param input       consola que se encarga de hablar con el usuario
	 * @param deck        baraja boca abajo actual
	 * @param discardPile pila de descartes de la ronda
	 */
	public abstract void playTurn(ConsoleInput input, Deck deck, List<Card> discardPile);

	public HandAnalyzer getHandAnalyzer() {
		return handAnalyzer;
	}

	public void setHandAnalyzer(HandAnalyzer handAnalyzer) {
		this.handAnalyzer = handAnalyzer;
	}

	@Override
	public String toString() {
		return String.format("%s%s%s", Colors.CYAN, name, Colors.RESET);
	}
}
