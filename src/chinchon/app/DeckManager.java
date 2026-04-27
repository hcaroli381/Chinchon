package chinchon.app;

import java.util.ArrayList;
import java.util.List;

import chinchon.dominio.Card;
import chinchon.dominio.Deck;
import chinchon.dominio.Suit;
import chinchon.dominio.Value;

/**
 * Clase utilizada para administrar la baraja durante la partida
 */
public class DeckManager {

	/**
	 * Ejecuta addFullSetToDeck tantas veces como pida el numero de mazos pasado por
	 * parametro.
	 * 
	 * @param deck          mazo actual
	 * @param numberOfDecks numero de mazos (1 o 2)
	 */
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

	/**
	 * Prepara el mazo cuando se empieza una nueva ronda
	 * 
	 * @param deck          mazo principal
	 * @param discardPile   pila de descartes de la ronda anterior
	 * @param numberOfDecks numero de barajas con el que se jugará
	 */
	public void prepareDeckForNewRound(Deck deck, List<Card> discardPile, int numberOfDecks) {
		deck.getCards().clear();
		addFullSetsToDeck(deck, numberOfDecks);
		deck.shuffle();
		discardPile.clear();
		discardPile.add(deck.drawCard());
	}

	/**
	 * Función utilizada para que el juego no se rompa cuando la pila de descartes
	 * se acabe en la ronda
	 * 
	 * @param deck        baraja principal
	 * @param discardPile pila de descartes actual
	 */
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
