package chinchon.app;

import java.util.ArrayList;
import java.util.List;

import chinchon.dominio.Card;
import chinchon.dominio.Deck;
import chinchon.dominio.Suit;
import chinchon.dominio.Value;

/**
 * Gestiona las operaciones de alto nivel sobre la baraja durante la partida.
 */
public class DeckManager {

	/**
	 * Añade una o varias barajas completas al mazo indicado.
	 * 
	 * @param deck          mazo actual
	 * @param numberOfDecks número de barajas a incorporar
	 */
	public void addFullSetsToDeck(Deck deck, int numberOfDecks) {
		for (int i = 0; i < numberOfDecks; i++) {
			addFullSetToDeck(deck);
		}
	}

	/**
	 * Añade al mazo todas las combinaciones posibles de palo y valor.
	 *
	 * @param deck mazo destino
	 */
	private void addFullSetToDeck(Deck deck) {
		for (Suit suit : Suit.values()) {
			for (Value value : Value.values()) {
				deck.getCards().add(new Card(suit, value));
			}
		}
	}

	/**
	 * Deja el mazo preparado para comenzar una ronda nueva.
	 * 
	 * @param deck          mazo principal
	 * @param discardPile   pila de descartes de la ronda anterior
	 * @param numberOfDecks número de barajas con el que se jugará
	 */
	public void prepareDeckForNewRound(Deck deck, List<Card> discardPile, int numberOfDecks) {
		deck.getCards().clear();
		addFullSetsToDeck(deck, numberOfDecks);
		deck.shuffle();
		discardPile.clear();
		discardPile.add(deck.drawCard());
	}

	/**
	 * Reincorpora los descartes al mazo cuando la baraja principal se agota.
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
