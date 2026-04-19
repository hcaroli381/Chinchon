package chinchon.dominio;

import java.util.Comparator;
import java.util.List;

import chinchon.app.ConsoleInput;

public class Human extends Player {

	public Human(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer) {
		super(name, hand, score, handAnalyzer);

	}

	@Override
	public void playTurn(ConsoleInput input, Deck deck, List<Card> discardPile) {
		showHand();
		askForDraw(input, deck, discardPile);
		System.out.println("Mano actual :");
		showHand();
		discard(input, discardPile);
	}

	public void showHand() {
		List<Card> combined;
		getHand().sort(Comparator.comparingInt((Card c) -> c.getValue().getNumber()).thenComparing(c -> c.getSuit()));
		combined = getHandAnalyzer().getCombinedCards(getHand());
		for (Card c : getHand()) {
			c.setCombined(combined.contains(c));
		}
		System.out.printf("Mano actual : %s", getHand());
		System.out.println(getScore() + " points");
		System.out.printf("Puntuacion de la ronda (provisional) : %s\n",
				getHandAnalyzer().calculateUncombinedCards(getHand()));

	}

	public void askForDraw(ConsoleInput input, Deck deck, List<Card> discardPile) {
		boolean option;
		Card c;
		option = input.readBooleanUsingChar('r', 'c', "Escribe r para robar o c para coger del mazo visible");
		if (option) {
			c = deck.drawCard();
			getHand().add(c);

		} else {
			c = discardPile.removeFirst();
			getHand().add(c);
		}
	}

	public void discard(ConsoleInput input, List<Card> discardPile) {
		int card;
		System.out.println("Selecciona del 1 al 8 la carta que descartar");
		card = input.readIntInRange(1, 8);
		discardPile.add(0, getHand().get(card - 1));
		getHand().remove(card - 1);
	}

	public int currentScore(HandAnalyzer handAnalyzer) {
		return handAnalyzer.calculateUncombinedCards(getHand());
	}
}
