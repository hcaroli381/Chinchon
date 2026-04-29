package chinchon.dominio;

import java.util.ArrayList;
import java.util.List;

import chinchon.app.ConsoleInput;

/**
 * Jugador automático que toma decisiones básicas sin intervención humana.
 */
public class AI extends Player {

	/**
	 * Crea una IA con el estado inicial de la partida.
	 *
	 * @param name         nombre visible del jugador
	 * @param hand         mano inicial
	 * @param score        puntuación acumulada
	 * @param handAnalyzer analizador de combinaciones de la mano
	 */
	public AI(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer) {
		super(name, hand, score, handAnalyzer);

	}

	/**
	 * Ejecuta el turno completo de la IA: roba, elige el mejor descarte y lo
	 * coloca en la pila de descartes.
	 *
	 * @param input       no se utiliza en esta implementación
	 * @param deck        baraja principal
	 * @param discardPile pila de descartes
	 */
	@Override
	public void playTurn(ConsoleInput input, Deck deck, List<Card> discardPile) {
		Card discard;
		draw(deck, discardPile);

		discard = getHandAnalyzer().getBestDiscard(getHand());
		System.out.printf("%s descarta : %s\n", getName(), discard.toString());
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		getHand().remove(discard);
		discardPile.add(0, discard);

	}

	/**
	 * Decide si la IA roba de la pila de descartes o de la baraja comparando la
	 * puntuación actual con la que tendría tras tomar la carta visible.
	 *
	 * @param deck        baraja principal
	 * @param discardPile pila de descartes
	 */
	private void draw(Deck deck, List<Card> discardPile) {
		Card auxCard = discardPile.get(0);
		List<Card> auxHand = new ArrayList<>(getHand());
		auxHand.add(auxCard);
		int currentPoints, optionalPoints;
		currentPoints = getHandAnalyzer().calculateUncombinedCards(getHand());
		optionalPoints = getHandAnalyzer().calculateUncombinedCards(auxHand);

		if (optionalPoints <= currentPoints) {
			System.out.printf("%s coge de los descartes\n", getName());
			getHand().add(discardPile.remove(0));
		} else {
			System.out.printf("%s coge de la baraja\n", getName());
			getHand().add(deck.drawCard());
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
