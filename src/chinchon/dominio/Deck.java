package chinchon.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
	}

	public void createDeck() {
		cards.clear();
		for (Suit suit : Suit.values()) {
			for (Value value : Value.values()) {
				cards.add(new Card(suit, value));
			}
		}
	}

	public void addCardsAndShuffle(List<Card> newCards) {
		this.cards.addAll(newCards);
		Collections.shuffle(this.cards);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card drawCard() {
		if (cards.isEmpty()) {
			return null;
		}

		return cards.remove(0);
	}

	public List<Card> getCards() {
		return cards;
	}
}
