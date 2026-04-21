package chinchon.app;

import java.util.ArrayList;
import java.util.List;

import chinchon.dominio.Card;
import chinchon.dominio.Deck;
import chinchon.dominio.Suit;
import chinchon.dominio.Value;

public class DeckManager {

	public void addFullSetsToDeck(Deck deck, int numberOfDecks) {
		for (int i = 0; i < numberOfDecks; i++) {
			addFullSetToDeck(deck);
		}
	}

	private void addFullSetToDeck(Deck deck) {
		for (Suit suit : Suit.values()) {
			for (Value value : Value.values()) {
				deck.getCards().add(new Card(suit, value));
			}
		}
	}

	public void prepareDeckForNewRound(Deck deck, List<Card> discardPile, int numberOfDecks) {
		deck.getCards().clear();
		addFullSetsToDeck(deck, numberOfDecks);
		deck.shuffle();
		discardPile.clear();
		discardPile.add(deck.drawCard());
	}

	public void checkAndRefillDeck(Deck deck, List<Card> discardPile) {
		if (deck.getCards().isEmpty()) {
			System.out.println("\n El mazo se ha agotado. Rebarajando descartes... ");

			Card topDiscard = discardPile.remove(0);

			deck.addCardsAndShuffle(new ArrayList<>(discardPile));

			discardPile.clear();
			discardPile.add(topDiscard);
		}
	}
}
