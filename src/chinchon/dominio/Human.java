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
		showHand();
		discard(input, discardPile);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void showHand() {
		List<Card> combined;
		getHand().sort(Comparator.comparingInt((Card c) -> c.getValue().getNumber()).thenComparing(c -> c.getSuit()));
		combined = getHandAnalyzer().getCombinedCards(getHand());
		for (Card c : getHand()) {
			c.setCombined(combined.contains(c));
		}
		System.out.printf("Mano actual : %s\n", getHand());
		System.out.printf("Puntos de la partida : %d\n", getScore());
		System.out.printf("Puntuacion de la ronda (provisional) : %s\n",
				getHandAnalyzer().calculateUncombinedCards(getHand()));

	}

	public void askForDraw(ConsoleInput input, Deck deck, List<Card> discardPile) {
		boolean option;
		option = input.readBooleanUsingChar('d', 'b', "Escribe d para descartes o b para coger de la baraja :");
		if (option) {
			System.out.printf("%s coge de los descartes\n", getName());
			getHand().add(discardPile.removeFirst());

		} else {
			System.out.printf("%s coge de la baraja\n", getName());
			getHand().add(deck.drawCard());
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
