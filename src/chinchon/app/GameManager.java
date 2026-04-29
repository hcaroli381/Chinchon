package chinchon.app;

import java.util.ArrayList;
import java.util.List;

import chinchon.dominio.Card;
import chinchon.dominio.Deck;
import chinchon.dominio.GameConstants;
import chinchon.dominio.HandAnalyzer;
import chinchon.dominio.Player;
import chinchon.dominio.PlayerFactory;
import chinchon.dominio.PlayerType;

/**
 * Mantiene y prepara el estado global de la partida.
 */
public class GameManager {
	private List<Player> players;
	private Deck deck;
	private List<Card> discardPile;
	private ConsoleInput console;
	private DeckManager deckManager;
	private HandAnalyzer handAnalyzer;

	/**
	 * Crea el gestor de la partida con sus dependencias principales.
	 *
	 * @param console      entrada de consola
	 * @param deckManager  gestor de baraja
	 * @param handAnalyzer analizador de manos
	 */
	public GameManager(ConsoleInput console, DeckManager deckManager, HandAnalyzer handAnalyzer) {
		this.players = new ArrayList<>();
		this.discardPile = new ArrayList<>();
		this.console = console;
		this.deckManager = deckManager;
		this.handAnalyzer = handAnalyzer;
		this.deck = new Deck();
	}

	/**
	 * Prepara una nueva partida: pide datos, crea la baraja, reparte cartas y
	 * sitúa la primera carta en la pila de descartes.
	 */
	protected void setupGame() {
		int numPlayers = requestNumberOfPlayers();

		deck = new Deck();
		int numberOfDecks = (numPlayers >= 3) ? 2 : 1;

		deckManager.addFullSetsToDeck(deck, numberOfDecks);
		deck.shuffle();
		createPlayers(numPlayers);

		discardPile.clear();
		discardPile.add(deck.drawCard());
	}

	/**
	 * Solicita el número de jugadores que participarán en la partida.
	 *
	 * @return número de jugadores válido
	 */
	private int requestNumberOfPlayers() {

		int players;
		System.out.println("¿Cuantos jugadores quieres añadir?");
		players = console.readIntInRange(GameConstants.MIN_PLAYERS, GameConstants.MAX_PLAYERS);
		return players;
	}

	/**
	 * Pregunta si el jugador será humano o IA.
	 *
	 * @return {@code true} para humano, {@code false} para IA
	 */
	private boolean requestPlayerNature() {
		boolean player;
		player = console.readBooleanUsingChar('h', 'i', "Introduce 'h' para humano o 'i' para IA");
		return player;

	}

	/**
	 * Crea la lista de jugadores con sus manos iniciales.
	 *
	 * @param numberOfPlayers número total de jugadores a crear
	 */
	private void createPlayers(int numberOfPlayers) {
		List<Card> hand = new ArrayList<Card>();
		boolean player;
		String name;
		for (int i = 0; i < numberOfPlayers; i++) {

			hand = startHand();
			System.out.printf("Jugador %d :\n", i + 1);
			player = requestPlayerNature();
			name = requestPlayerName();
			if (player) {
				try {
					players.add(PlayerFactory.createPlayer(PlayerType.HUMAN, name, hand, handAnalyzer));
				} catch (IllegalArgumentException e) {
					System.err.println(e);
				}
			} else {
				try {
					players.add(PlayerFactory.createPlayer(PlayerType.AI, name, hand, handAnalyzer));
				} catch (IllegalArgumentException e) {
					System.err.println(e);
				}
			}

		}
	}

	/**
	 * Reparte la mano inicial de un jugador.
	 *
	 * @return lista con las cartas iniciales
	 */
	private List<Card> startHand() {
		List<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.drawCard());
		}
		return hand;
	}

	/**
	 * Solicita un nombre de jugador que no esté repetido.
	 *
	 * @return nombre válido para el jugador
	 */
	private String requestPlayerName() {
		String auxName;
		String name;
		System.out.println("Escribe su nombre :");
		name = console.readString(15);
		for (Player player : players) {
			auxName = player.getName();

			while (auxName.trim().equalsIgnoreCase(name)) {
				System.err.println("Nombre ya existente. Introduzca otro nombre :");
				name = console.readString(15);
			}

		}
		return name;
	}

	/**
	 * Prepara la baraja y reparte una nueva mano para la siguiente ronda.
	 */
	protected void prepareNextRound() {
		int decks;
		decks = (players.size() >= 3) ? 2 : 1;
		deckManager.prepareDeckForNewRound(deck, discardPile, decks);

		for (Player player : players) {
			player.getHand().clear();
			for (int i = 0; i < GameConstants.INITIAL_CARDS_PER_PLAYER; i++) {
				player.getHand().add(deck.drawCard());
			}
		}
	}

	/**
	 * Elimina a los jugadores que han alcanzado o superado el límite de puntos.
	 */
	protected void eliminatePlayers() {
		players.removeIf(p -> p.getScore() >= GameConstants.ELIMINATION_SCORE);

	}

	/**
	 * Devuelve la lista de jugadores activos.
	 *
	 * @return jugadores de la partida
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Devuelve la baraja principal actual.
	 *
	 * @return baraja de la ronda
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * Devuelve la pila de descartes actual.
	 *
	 * @return descartes de la ronda
	 */
	public List<Card> getDiscardPile() {
		return discardPile;
	}

}
