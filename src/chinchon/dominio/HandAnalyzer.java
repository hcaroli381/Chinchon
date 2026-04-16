package chinchon.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandAnalyzer {

	public int calculateUncombinedCards(List<Card> hand) {
		int uncombined = 0;
		List<Card> auxiliarHand = new ArrayList<>(hand);

		findSets(auxiliarHand);
		findRuns(auxiliarHand);
		for (Card card : auxiliarHand) {
			uncombined += card.getValue().getNumber();
		}
		return uncombined;
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
			group.sort((c1, c2) -> Integer.compare(c1.getValue().getNumber(), c2.getValue().getNumber()));

			if ((group.size() >= 3) && ((deck.cards.indexOf(group.get(deck.cards.size() - 1))
					- (deck.cards.indexOf(group.get(0)))) < (group.size() + 1))) {
				auxiliarHand.removeAll(group);
			}
		}
	}

	public boolean findChinchon(List<Card> auxiliarHand) {
		int ordinal, nextOrdinal;
		if (auxiliarHand.size() < 7) {
			return false;
		}
		Collections.sort(auxiliarHand);
		for (Card card : auxiliarHand) {
			if (card.getSuit() != auxiliarHand.get(0).getSuit()) {
				return false;
			}
		}

		for (int i = 0; i < auxiliarHand.size() - 1; i++) {
			ordinal = auxiliarHand.get(i).getValue().ordinal();
			nextOrdinal = auxiliarHand.get(i + 1).getValue().ordinal();
			if (nextOrdinal - ordinal != 1) {
				return false;
			}
		}
		return true;

	}

	public boolean canClose(List<Card> hand) {
		if (hand.size() == 1 && hand.get(0).getValue().getNumber() <= 6) {
			return true;
		} else {
			return false;
		}
	}

}
