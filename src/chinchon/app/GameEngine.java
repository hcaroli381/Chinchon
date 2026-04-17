package chinchon.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import chinchon.dominio.Card;
import chinchon.dominio.Deck;
import chinchon.dominio.HandAnalyzer;
import chinchon.dominio.Human;
import chinchon.dominio.Player;
import chinchon.dominio.PlayerFactory;

public class GameEngine {
	private static GameEngine instance;
	private HandAnalyzer handAnalyzer;
	private List<Player> players;
	private Deck deck;
	private List<Card> discardPile;
	private ConsoleInput console;

	private GameEngine() {
		Scanner sc = new Scanner(System.in);
		console = new ConsoleInput(sc);
		players = new ArrayList<>();
		discardPile = new ArrayList<>();
		deck = new Deck();
		deck.createDeck();
		setupGame();
	}

	public static GameEngine getInstance() {
		if (instance == null) {
			instance = new GameEngine();
		}
		return instance;
	}

	public void setupGame() {
		deck = new Deck();
		deck.createDeck();
		deck.shuffle();

		int numPlayers = requestNumberOfPlayers();
		createPlayers(numPlayers);

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

	public void startGameLoop() {
		boolean option, roundEnd = false;
		setupGame();
		while (!roundEnd) {
			for (Player player : players) {
				player.playTurn(console, deck, discardPile);
				if (handAnalyzer.canClose(player.getHand())) {
					if (player instanceof Human) {
						System.out.println("¿Quieres cerrar?");
						option = console.readBooleanUsingChar('s', 'n');
						if (option) {
							endRound(player);
							roundEnd = true;
						}
					} else {
						endRound(player);
						roundEnd = true;
					}
				}

			}
		}

	}

	private void endRound(Player ender) {
		if (handAnalyzer.findChinchon(ender.getHand())) {
			System.out.printf("CHINCHON, %s ha ganado!!", ender.getName());
		}

		for (Player player : players) {
			int points;
			points = handAnalyzer.calculateUncombinedCards(player.getHand());

			if (player.equals(ender) && points == 0) {
				player.setScore(player.getScore() - 10);
			} else if (player.getScore() >= 100) {
				pointsGameEnd();
			} else {
				player.setScore(points + player.getScore());
			}

		}
		for (Player player : players) {
			System.out.printf("%s : %d puntos", player.getName(), player.getScore());
		}

	}

	private void pointsGameEnd() {
		int i = 0;
		System.out.printf("FIN DE LA PARTIDA : \n");
		players.sort(Comparator.comparingInt(Player::getScore).reversed());
		for (Player player : players) {
			i++;
			System.out.printf("%d. %s\n", player.toString());
		}
	}

}
