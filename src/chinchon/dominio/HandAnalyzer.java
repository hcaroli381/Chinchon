package chinchon.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Analiza una mano de cartas para detectar combinaciones, calcular puntos y
 * ayudar a la IA a tomar decisiones.
 */
public class HandAnalyzer {
	/**
	 * Calcula los puntos de las cartas que no pertenecen a ninguna combinación.
	 * 
	 * @param hand mano actual del jugador
	 * @return puntuación total de las cartas no combinadas
	 */
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

	private void findSets(List<Card> auxiliarHand) {
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

	private void findRuns(List<Card> auxiliarHand) {
		Suit suit;
		Map<Suit, List<Card>> groups = new HashMap<>();
		for (Card card : auxiliarHand) {
			suit = card.getSuit();
			groups.putIfAbsent(suit, new ArrayList<>());
			groups.get(suit).add(card);
		}

		for (List<Card> group : groups.values()) {
			group.sort((c1, c2) -> Integer.compare(c1.getValue().ordinal(), c2.getValue().ordinal()));

			if (group.size() >= 3) {
				List<Card> potentialRun = new ArrayList<>();
				potentialRun.add(group.get(0));

				for (int i = 0; i < group.size() - 1; i++) {
					int current = group.get(i).getValue().ordinal();
					int next = group.get(i + 1).getValue().ordinal();

					if (next - current == 1) {
						potentialRun.add(group.get(i + 1));
					} else {

						if (potentialRun.size() >= 3) {
							auxiliarHand.removeAll(potentialRun);
						}
						potentialRun.clear();
						potentialRun.add(group.get(i + 1));
					}
				}

				if (potentialRun.size() >= 3) {
					auxiliarHand.removeAll(potentialRun);
				}
			}
		}
	}

	private boolean isConsecutive(List<Card> group) {
		int current, next;
		for (int i = 0; i < group.size() - 1; i++) {
			current = group.get(i).getValue().ordinal();
			next = group.get(i + 1).getValue().ordinal();

			if (next - current != 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Comprueba si la mano forma un chinchón.
	 * 
	 * @param auxiliarHand mano auxiliar para la comprobación
	 * @return {@code true} si existe un chinchón; {@code false} en caso contrario
	 */
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

	/**
	 * Determina si la mano permite cerrar la ronda.
	 * 
	 * @param hand mano actual del jugador
	 * @return {@code true} si el jugador puede cerrar; {@code false} en caso contrario
	 */
	public boolean canClose(List<Card> hand) {

		List<Card> auxiliarHand = new ArrayList<>(hand);

		findSets(auxiliarHand);
		findRuns(auxiliarHand);

		if (auxiliarHand.size() == 1 && auxiliarHand.get(0).getValue().getNumber() < 6) {
			return true;
		}

		else if (auxiliarHand.isEmpty()) {
			return true;
		}

		return false;
	}

	/**
	 * Calcula qué carta deja la menor puntuación posible al descartarla.
	 * 
	 * @param hand mano actual del jugador
	 * @return carta que conviene descartar
	 */
	public Card getBestDiscard(List<Card> hand) {
		List<Card> auxHand;
		Card discardCard = null, auxCard;
		int minPoints = 200, points;

		for (int i = 0; i < hand.size(); i++) {
			auxHand = new ArrayList<>(hand);
			auxCard = auxHand.remove(i);

			points = calculateUncombinedCards(auxHand);

			if (points < minPoints) {
				minPoints = points;
				discardCard = auxCard;
			}
		}
		return discardCard;
	}

	/**
	 * Devuelve las cartas que forman parte de alguna combinación detectada.
	 * 
	 * @param hand mano actual del jugador
	 * @return lista de cartas combinadas
	 */
	public List<Card> getCombinedCards(List<Card> hand) {
		List<Card> combined = new ArrayList<Card>();
		List<Card> auxHand = new ArrayList<Card>(hand);

		findSets(auxHand);
		findRuns(auxHand);

		for (Card c : hand) {
			if (!auxHand.contains(c)) {
				combined.add(c);
			}
		}
		return combined;
	}

}
