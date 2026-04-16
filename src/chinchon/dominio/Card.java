package chinchon.dominio;

public class Card implements Comparable<Card> {
	private Suit suit;
	private Value value;

	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("%s de %s", value.toString(), suit.toString());
	}

	public Suit getSuit() {
		return suit;
	}

	public Value getValue() {
		return value;
	}

	public int compareTo(Card other) {

		if (this.suit != other.suit) {
			return this.suit.compareTo(other.suit);
		}

		return Integer.compare(this.value.getNumber(), other.value.getNumber());
	}
}
