package dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chinchon.dominio.Card;
import chinchon.dominio.HandAnalyzer;
import chinchon.dominio.Suit;
import chinchon.dominio.Value;

class HandAnalyzerTest {

	private HandAnalyzer handAnalyzer;
	private List<Card> hand;

	@BeforeEach
	void setUp() {
		handAnalyzer = new HandAnalyzer();
	}

	@Test
	void testUncombinedCardsChinchon() {
		hand = Arrays.asList(new Card(Suit.COPAS, Value.UNO), new Card(Suit.COPAS, Value.DOS),
				new Card(Suit.COPAS, Value.TRES), new Card(Suit.COPAS, Value.CUATRO), new Card(Suit.COPAS, Value.CINCO),
				new Card(Suit.COPAS, Value.SEIS), new Card(Suit.COPAS, Value.SIETE));
		assertEquals(0, handAnalyzer.calculateUncombinedCards(hand));
	}

	@Test
	void testUncombinedCards() {
		hand = Arrays.asList(new Card(Suit.COPAS, Value.UNO), new Card(Suit.COPAS, Value.TRES),
				new Card(Suit.BASTOS, Value.TRES), new Card(Suit.COPAS, Value.TRES), new Card(Suit.COPAS, Value.CINCO),
				new Card(Suit.COPAS, Value.SEIS), new Card(Suit.BASTOS, Value.SIETE));
		assertEquals(19, handAnalyzer.calculateUncombinedCards(hand));
	}

	@Test
	void testCanClose_true() {
		hand = Arrays.asList(new Card(Suit.BASTOS, Value.UNO), new Card(Suit.COPAS, Value.DOS),
				new Card(Suit.COPAS, Value.TRES), new Card(Suit.COPAS, Value.CUATRO), new Card(Suit.COPAS, Value.CINCO),
				new Card(Suit.COPAS, Value.SEIS), new Card(Suit.COPAS, Value.SIETE));
		assertTrue(handAnalyzer.canClose(hand));
	}

	@Test
	void testCanClose_false() {
		hand = Arrays.asList(new Card(Suit.COPAS, Value.UNO), new Card(Suit.COPAS, Value.TRES),
				new Card(Suit.BASTOS, Value.TRES), new Card(Suit.COPAS, Value.TRES), new Card(Suit.COPAS, Value.CINCO),
				new Card(Suit.COPAS, Value.SEIS), new Card(Suit.BASTOS, Value.SIETE));
		assertFalse(handAnalyzer.canClose(hand));
	}

	@Test
	void testFindChinchon() {
		hand = Arrays.asList(new Card(Suit.COPAS, Value.UNO), new Card(Suit.COPAS, Value.DOS),
				new Card(Suit.COPAS, Value.TRES), new Card(Suit.COPAS, Value.CUATRO), new Card(Suit.COPAS, Value.CINCO),
				new Card(Suit.COPAS, Value.SEIS), new Card(Suit.COPAS, Value.SIETE));
		assertTrue(handAnalyzer.findChinchon(hand));
	}

}
