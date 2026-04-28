package dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chinchon.app.DeckManager;
import chinchon.dominio.Card;
import chinchon.dominio.Deck;
import chinchon.dominio.Suit;
import chinchon.dominio.Value;

class DeckManagerTest {

	private DeckManager deckManager;
	private Deck deck;

	@BeforeEach
	void setUp() {
		deckManager = new DeckManager();
		deck = new Deck();
	}

	@Test
	void testAddFullSetsToDeck_OneDeck() {
		deckManager.addFullSetsToDeck(deck, 1);
		assertEquals(40, deck.getCards().size());
	}

	@Test
	void testAddFullSetsToDeck_TwoDecks() {
		deckManager.addFullSetsToDeck(deck, 2);
		assertEquals(80, deck.getCards().size());
	}

	@Test
	void testPrepareDeckForNewRound() {
		List<Card> discards = new ArrayList<>();
		deck.createDeck();
		discards.add(new Card(Suit.BASTOS, Value.CABALLO));
		discards.add(new Card(Suit.COPAS, Value.DOS));

		deckManager.prepareDeckForNewRound(deck, discards, 1);
		assertEquals(39, deck.getCards().size());
		assertEquals(1, discards.size());
	}

	@Test
	void testCheckAndRefillDeck() {
		List<Card> discards = new ArrayList<>();
		deck.getCards().clear();
		discards.add(new Card(Suit.BASTOS, Value.CABALLO));
		discards.add(new Card(Suit.COPAS, Value.DOS));

		deckManager.checkAndRefillDeck(deck, discards);
		assertEquals(1, deck.getCards().size());
		assertEquals(1, discards.size());

	}

}
