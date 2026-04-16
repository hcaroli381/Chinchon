package chinchon.app;

import java.util.List;

import chinchon.dominio.AI;
import chinchon.dominio.Card;
import chinchon.dominio.Deck;
import chinchon.dominio.Human;
import chinchon.dominio.Player;

public class GameEngine {
	private static GameEngine instance;
	private List<Player> players;
	private Deck deck;
	private List<Card> discardPile;
	private ConsoleInput console;

	private GameEngine() {

	}

	public static GameEngine getInstance() {
		if (instance == null) {
			instance = new GameEngine();
		}
		return instance;
	}

	public void setupGame() {

	}

	public int numberOfPlayers() {
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
		boolean player;
		String name;
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.printf("Jugador %d\n", i);
			player = requestPlayerNature();
			name = requestPlayerName();
			if (player) {
				players.add(new Human(name, new Deck().createDeck()));
			} else {
				players.add(new AI(name, new Deck().createDeck()));
			}

		}
	}

}
