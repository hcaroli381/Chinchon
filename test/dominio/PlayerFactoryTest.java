package dominio;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import chinchon.dominio.AI;
import chinchon.dominio.Card;
import chinchon.dominio.HandAnalyzer;
import chinchon.dominio.Human;
import chinchon.dominio.Player;
import chinchon.dominio.PlayerFactory;
import chinchon.dominio.PlayerType;
import chinchon.dominio.Suit;
import chinchon.dominio.Value;

class PlayerFactoryTest {
	private HandAnalyzer handAnalyzer;

	@Test
	void testCreateHuman() {
		Player player = PlayerFactory.createPlayer(PlayerType.HUMAN, "Hugo",
				Arrays.asList(new Card(Suit.COPAS, Value.UNO), new Card(Suit.COPAS, Value.DOS),
						new Card(Suit.COPAS, Value.TRES), new Card(Suit.COPAS, Value.CUATRO),
						new Card(Suit.COPAS, Value.CINCO), new Card(Suit.COPAS, Value.SEIS),
						new Card(Suit.COPAS, Value.SIETE)),
				handAnalyzer);
		assertTrue(player instanceof Human);
		assertEquals("Hugo", player.getName());
	}

	@Test
	void testCreateAi() {
		Player player = PlayerFactory.createPlayer(PlayerType.AI, "Ia", Arrays.asList(new Card(Suit.COPAS, Value.UNO),
				new Card(Suit.COPAS, Value.DOS), new Card(Suit.COPAS, Value.TRES), new Card(Suit.COPAS, Value.CUATRO),
				new Card(Suit.COPAS, Value.CINCO), new Card(Suit.COPAS, Value.SEIS), new Card(Suit.COPAS, Value.SIETE)),
				handAnalyzer);
		assertTrue(player instanceof AI);
		assertEquals("Ia", player.getName());
	}

}
