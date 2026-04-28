package chinchon.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Analiza la mano del jugador, para determinar su puntuacion, si encuentra
 * escaleras o combinaciones, si puede cerrar o determinar el mejor descarte de
 * la IA.
 */
public class HandAnalyzer {
	/**
	 * Calcula la puntuación de la ronda para sumarla al fianl.
	 * 
	 * @param hand mano actual del jugador
	 * @return puntuacion a sumar
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
	 * Encuentra si hay chinchon
	 * 
	 * @param auxiliarHand mano auxiliar para la comprobacion
	 * @return true si hay chinchon (fin de partida) o false si no lo hay
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
	 * Da la posibilidad o se la quita al jugador de cerrar
	 * 
	 * @param hand mano actual del jugador
	 * @return true si puede cerrar false si no puede hacerlo
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
	 * Funcion utilizada para la IA, para que esta sepa cual es el mejor descarte
	 * 
	 * @param hand mano actual del jugador
	 * @return devuelve la carta marcada como "mejor" para descartar
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
	 * Determina que cartas deben ser marcadas como combinadas (atributo de la clase
	 * Card)
	 * 
	 * @param hand mano actual del jugador
	 * @return mano de combinadas
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
