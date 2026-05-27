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

class DeckManagerWhiteBoxTest {

    private DeckManager deckManager;
    private Deck deck;

    @BeforeEach
    void setUp() {
        deckManager = new DeckManager();
        deck = new Deck();
    }

    @Test
    void testCheckAndRefillDeck_NoRefillWhenDeckNotEmpty() {
        deck.createDeck(); // mazo con cartas
        List<Card> discards = new ArrayList<>();
        discards.add(new Card(Suit.BASTOS, Value.CABALLO));
        int beforeDeck = deck.getCards().size();
        int beforeDiscards = discards.size();

        deckManager.checkAndRefillDeck(deck, discards);

        assertEquals(beforeDeck, deck.getCards().size(), "El mazo no debe cambiar si ya tiene cartas");
        assertEquals(beforeDiscards, discards.size(), "Los descartes no deben modificarse cuando no se repone");
    }

    @Test
    void testCheckAndRefillDeck_OnlyOneDiscard_LeftAsIs() {
        deck.getCards().clear();
        List<Card> discards = new ArrayList<>();
        discards.add(new Card(Suit.COPAS, Value.UNO));

        deckManager.checkAndRefillDeck(deck, discards);

        assertTrue(deck.getCards().isEmpty(), "Mazo vacío si sólo hay un descarte");
        assertEquals(1, discards.size(), "Debe permanecer la única carta en descartes");
    }

    @Test
    void testCheckAndRefillDeck_MultipleDiscards_ReplenishLeavesOne() {

        deck.getCards().clear();
        List<Card> discards = new ArrayList<>();
        discards.add(new Card(Suit.BASTOS, Value.CABALLO));
        discards.add(new Card(Suit.COPAS, Value.DOS));
        discards.add(new Card(Suit.OROS, Value.TRES));
        discards.add(new Card(Suit.COPAS, Value.CUATRO));

        deckManager.checkAndRefillDeck(deck, discards);
        assertEquals(3, deck.getCards().size(), "El mazo debe reponerse con discard.size()-1 cartas");
        assertEquals(1, discards.size(), "Debe quedar exactamente 1 carta en descartes tras reponer");
    }

}

