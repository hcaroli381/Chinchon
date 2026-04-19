package chinchon.dominio;

public class Card implements Comparable<Card> {
	private Suit suit;
	private Value value;
	private boolean combined;

	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
		combined = false;
	}

	@Override
	public String toString() {
		String green = "\u001B[32m";
		String reset = "\u001B[0m";

		if (combined) {
			return String.format("%s%s de %s%s", green, value.getNumber(), suit.getSymbol(), reset);
		} else {
			return String.format("%s de %s", value.getNumber(), suit.getSymbol());
		}

	}

	public Suit getSuit() {
		return suit;
	}

	public Value getValue() {
		return value;
	}

	public void setCombined(boolean combined) {
		this.combined = combined;
	}

	public int compareTo(Card other) {

		if (this.suit != other.suit) {
			return this.suit.compareTo(other.suit);
		}

		return Integer.compare(this.value.getNumber(), other.value.getNumber());
	}
}
