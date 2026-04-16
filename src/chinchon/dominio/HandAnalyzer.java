package chinchon.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandAnalyzer {

	public int calculateUncombinedCards(List<Card> hand) {
		List<Card> auxiliarHand = new ArrayList<>(hand);

		findSets(auxiliarHand);
		findRuns(auxiliarHand);

		return 0;
	}

	public void findSets(List<Card> auxiliarHand) {
		Value val;
		Map<Value, List<Card>> groups = new HashMap<>();

		for (Card card : auxiliarHand) {
			val = card.getValue();
			groups.putIfAbsent(val, new ArrayList<>());
			groups.get(val).add(card);
		}

		for (List<Card> group : groups.values()) {
			if (group.size() >= 3) {
				auxiliarHand.removeAll(group);
			}
		}
	}

	public void findRuns(List<Card> auxiliarHand) {
		Deck deck = new Deck();
		deck.createDeck();
		Suit suit;
		Map<Suit, List<Card>> groups = new HashMap<>();
		for (Card card : auxiliarHand) {
			suit = card.getSuit();
			groups.putIfAbsent(suit, new ArrayList<>());
			groups.get(suit).add(card);
		}

		for (List<Card> group : groups.values()) {
			group.sort((c1, c2) -> Integer.compare(c1.getValue().getValue(), c2.getValue().getValue()));

			if ((group.size() >= 3) && ((deck.cards.indexOf(group.get(deck.cards.size() - 1))
					- (deck.cards.indexOf(group.get(0)))) < (group.size() + 1))) {
				auxiliarHand.removeAll(group);
			}
		}
	}

	public boolean findChinchon(List<Card> auxiliarHand) {
		if (auxiliarHand.size() < 7) {
			return false;
		}
		Collections.sort(auxiliarHand);

	}

}
