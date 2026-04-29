package chinchon.dominio;

import java.util.Comparator;
import java.util.List;

import chinchon.app.ConsoleInput;

/**
 * Jugador controlado por una persona a través de la consola.
 */
public class Human extends Player {

	/**
	 * Crea un jugador humano con el estado inicial de la partida.
	 *
	 * @param name         nombre visible del jugador
	 * @param hand         mano inicial
	 * @param score        puntuación acumulada
	 * @param handAnalyzer analizador de combinaciones de la mano
	 */
	public Human(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer) {
		super(name, hand, score, handAnalyzer);

	}

	/**
	 * Ejecuta el turno del jugador humano mostrando la mano, pidiendo la carta a
	 * robar y la carta a descartar.
	 *
	 * @param input       entrada de consola para interactuar con el jugador
	 * @param deck        baraja principal
	 * @param discardPile pila de descartes actual
	 */
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

	/**
	 * Ordena y muestra la mano actual, resaltando las cartas que forman parte de
	 * una combinación.
	 */
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

	/**
	 * Pide al usuario si roba de la baraja o de la pila de descartes.
	 *
	 * @param input       entrada de consola
	 * @param deck        baraja principal
	 * @param discardPile pila de descartes
	 */
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

	/**
	 * Permite seleccionar una carta de la mano para descartarla.
	 *
	 * @param input       entrada de consola
	 * @param discardPile pila de descartes donde se añade la carta elegida
	 */
	public void discard(ConsoleInput input, List<Card> discardPile) {
		int card;
		System.out.println("Selecciona del 1 al 8 la carta que descartar");
		card = input.readIntInRange(1, 8);
		discardPile.add(0, getHand().get(card - 1));
		getHand().remove(card - 1);
	}

	/**
	 * Calcula la puntuación provisional de la mano actual.
	 *
	 * @param handAnalyzer analizador de manos a utilizar
	 * @return puntos de las cartas todavía no combinadas
	 */
	public int currentScore(HandAnalyzer handAnalyzer) {
		return handAnalyzer.calculateUncombinedCards(getHand());
	}
}
