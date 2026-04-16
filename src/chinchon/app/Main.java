package chinchon.app;

import java.util.Iterator;

import chinchon.dominio.Card;
import chinchon.dominio.Deck;

public class Main {

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.createDeck();
		Iterator<Card> it = deck.cards.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
