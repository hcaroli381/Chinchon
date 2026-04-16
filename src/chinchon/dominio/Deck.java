package chinchon.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public List<Card> cards;

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

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card drawCard() {
		return cards.get(0);
	}
}
