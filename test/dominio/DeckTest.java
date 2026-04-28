package dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chinchon.dominio.Card;
import chinchon.dominio.Deck;

class DeckTest {
	private Deck deck;

	@BeforeEach
	void setUp() {
		deck = new Deck();
		deck.createDeck();
	}

	@Test
	void createDeck40Cards() {
		assertEquals(40, deck.getCards().size());
	}

	@Test
	void testDrawCard_ReduceDeck() {
		int size = deck.getCards().size();
		deck.drawCard();
		assertEquals(size - 1, deck.getCards().size());
	}

	@Test
	void testShuffle() {
		List<Card> before, after;
		before = new ArrayList<>(deck.getCards());
		deck.shuffle();
		after = deck.getCards();
		assertNotEquals(before, after);
	}

}
