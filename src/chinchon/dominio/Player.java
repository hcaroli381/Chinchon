package chinchon.dominio;

import java.util.List;

import chinchon.app.ConsoleInput;

/**
 * Clase base para cualquier participante de la partida.
 * <p>
 * Centraliza los datos comunes de nombre, mano, puntuación y analizador de
 * combinaciones, dejando en las subclases la lógica concreta del turno.
 */
public abstract class Player {
	private String name;
	private List<Card> hand;
	private int score;
	private HandAnalyzer handAnalyzer;

	/**
	 * Crea un jugador con su estado inicial.
	 *
	 * @param name         nombre visible del jugador
	 * @param hand         mano actual
	 * @param score        puntuación acumulada en la partida
	 * @param handAnalyzer analizador de manos compartido
	 */
	public Player(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer) {
		this.name = name;
		this.hand = hand;
		this.score = score;
		this.setHandAnalyzer(handAnalyzer);
	}

	/**
	 * Obtiene el nombre del jugador.
	 *
	 * @return nombre del jugador
	 */
	public String getName() {
		return name;
	}

	/**
	 * Actualiza el nombre del jugador.
	 *
	 * @param name nuevo nombre
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene la mano actual del jugador.
	 *
	 * @return cartas de la mano
	 */
	public List<Card> getHand() {
		return hand;
	}

	/**
	 * Sustituye la mano del jugador.
	 *
	 * @param hand nueva lista de cartas
	 */
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	/**
	 * Obtiene la puntuación acumulada del jugador.
	 *
	 * @return puntos de partida
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Actualiza la puntuación acumulada del jugador.
	 *
	 * @param score nueva puntuación
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Ejecuta el turno del jugador.
	 * <p>
	 * La implementación concreta depende de si el jugador es humano o IA.
	 * 
	 * @param input       entrada de consola para interactuar con el usuario
	 * @param deck        baraja principal de robo
	 * @param discardPile pila de descartes de la ronda
	 */
	public abstract void playTurn(ConsoleInput input, Deck deck, List<Card> discardPile);

	/**
	 * Obtiene el analizador de manos asociado al jugador.
	 *
	 * @return analizador de combinaciones
	 */
	public HandAnalyzer getHandAnalyzer() {
		return handAnalyzer;
	}

	/**
	 * Asigna el analizador de manos utilizado por el jugador.
	 *
	 * @param handAnalyzer analizador de combinaciones
	 */
	public void setHandAnalyzer(HandAnalyzer handAnalyzer) {
		this.handAnalyzer = handAnalyzer;
	}

	@Override
	public String toString() {
		return String.format("%s%s%s", Colors.CYAN, name, Colors.RESET);
	}
}
