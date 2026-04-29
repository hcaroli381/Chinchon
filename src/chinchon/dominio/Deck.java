package chinchon.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa el mazo de cartas que se usa durante la partida.
 */
public class Deck {
	private List<Card> cards;

	/**
	 * Crea una baraja vacía lista para ser rellenada o barajada.
	 */
	public Deck() {
		cards = new ArrayList<Card>();
	}

	/**
	 * Genera una baraja completa con todas las combinaciones de palo y valor.
	 */
	public void createDeck() {
		cards.clear();
		for (Suit suit : Suit.values()) {
			for (Value value : Value.values()) {
				cards.add(new Card(suit, value));
			}
		}
	}

	/**
	 * Añade nuevas cartas al mazo y lo mezcla posteriormente.
	 *
	 * @param newCards cartas que se incorporan al mazo
	 */
	public void addCardsAndShuffle(List<Card> newCards) {
		this.cards.addAll(newCards);
		Collections.shuffle(this.cards);
	}

	/**
	 * Mezcla el contenido actual del mazo.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Roba la carta superior del mazo.
	 *
	 * @return la primera carta disponible, o {@code null} si el mazo está vacío
	 */
	public Card drawCard() {
		if (cards.isEmpty()) {
			return null;
		}

		return cards.remove(0);
	}

	/**
	 * Devuelve la lista interna de cartas del mazo.
	 *
	 * @return cartas actuales del mazo
	 */
	public List<Card> getCards() {
		return cards;
	}
}
