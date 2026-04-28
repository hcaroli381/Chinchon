package dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chinchon.dominio.Card;
import chinchon.dominio.HandAnalyzer;
import chinchon.dominio.Player;
import chinchon.dominio.PlayerFactory;
import chinchon.dominio.PlayerType;
import chinchon.dominio.Suit;
import chinchon.dominio.Value;

class PlayerTest {
	private HandAnalyzer handAnalyzer;
	private List<Card> hand;
	private Player player;

	@BeforeEach
	void setUp() {
		handAnalyzer = new HandAnalyzer();
		hand = Arrays.asList(new Card(Suit.COPAS, Value.UNO), new Card(Suit.COPAS, Value.DOS),
				new Card(Suit.COPAS, Value.TRES), new Card(Suit.COPAS, Value.CUATRO), new Card(Suit.COPAS, Value.CINCO),
				new Card(Suit.COPAS, Value.SEIS), new Card(Suit.COPAS, Value.SIETE));
		player = PlayerFactory.createPlayer(PlayerType.HUMAN, "Hugo", hand, handAnalyzer);
	}

	@Test
	void testName() {
		assertEquals("Hugo", player.getName());
		player.setName("Carlos");
		assertEquals("Carlos", player.getName());
	}

	@Test
	void testScore() {
		assertEquals(0, player.getScore());
		player.setScore(23);
		assertEquals(23, player.getScore());
	}

}
