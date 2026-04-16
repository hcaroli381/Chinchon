package chinchon.app;

import java.util.ArrayList;
import java.util.List;

import chinchon.dominio.Card;
import chinchon.dominio.Deck;
import chinchon.dominio.Player;
import chinchon.dominio.PlayerFactory;

public class GameEngine {
	private static GameEngine instance;
	private List<Player> players;
	private Deck deck;
	private List<Card> discardPile;
	private ConsoleInput console;

	private GameEngine() {
		setupGame();
		discardPile = new ArrayList<Card>();
	}

	public static GameEngine getInstance() {
		if (instance == null) {
			instance = new GameEngine();
		}
		return instance;
	}

	public void setupGame() {
		Deck deck = new Deck();
		deck.createDeck();

		int players;
		players = requestNumberOfPlayers();
		createPlayers(players);

	}

	public int requestNumberOfPlayers() {
		int players;
		System.out.println("¿Cuantos jugadores quieres añadir?");
		players = console.readIntInRange(2, 5);
		return players;
	}

	public boolean requestPlayerNature() {
		boolean player;
		System.out.println("¿Humano o IA?");
		player = console.readBooleanUsingChar('h', 'i');
		return player;

	}

	public String requestPlayerName() {
		String name;
		System.out.println("Escribe su nombre :");
		name = console.readString(15);
		return name;
	}

	public void createPlayers(int numberOfPlayers) {

		List<Card> hand = new ArrayList<Card>();
		boolean player;
		String name;
		for (int i = 0; i < numberOfPlayers; i++) {
			hand = startHand();
			System.out.printf("Jugador %d :\n", i);
			player = requestPlayerNature();
			name = requestPlayerName();
			if (player) {
				players.add(PlayerFactory.createPlayer("human", name, hand));
			} else {
				players.add(PlayerFactory.createPlayer("ai", name, hand));
			}

		}
	}

	public List<Card> startHand() {
		List<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.drawCard());
			deck.removeCard();
		}
		return hand;
	}

}
