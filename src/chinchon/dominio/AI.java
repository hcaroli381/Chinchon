package chinchon.dominio;

import java.util.ArrayList;
import java.util.List;

import chinchon.app.ConsoleInput;

public class AI extends Player {
	private HandAnalyzer handAnalyzer;

	public AI(String name, List<Card> hand, int score) {
		super(name, hand, score);
		handAnalyzer = new HandAnalyzer();
	}

	public void playTurn(ConsoleInput input, Deck deck, List<Card> discardPile) {
		Card discard;
		draw(deck, discardPile);

		discard = handAnalyzer.getBestDiscard(getHand());
		System.out.printf("%s descarta : %s", getName(), discard.toString());
		getHand().remove(discard);
		discardPile.add(0, discard);

	}

	private void draw(Deck deck, List<Card> discardPile) {
		Card auxCard = discardPile.getFirst();
		List<Card> auxHand = new ArrayList<>(getHand());
		auxHand.add(auxCard);
		int currentPoints, optionalPoints;
		currentPoints = handAnalyzer.calculateUncombinedCards(getHand());
		optionalPoints = handAnalyzer.calculateUncombinedCards(auxHand);

		if (optionalPoints < currentPoints || optionalPoints == currentPoints) {
			System.out.printf("%s coge de los descartes", getName());
			getHand().add(discardPile.removeFirst());
		} else {
			System.out.printf("%s coge de la baraja", getName());
			getHand().add(deck.drawCard());
		}

	}

}
