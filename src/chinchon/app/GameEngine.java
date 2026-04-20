package chinchon.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import chinchon.dominio.Card;
import chinchon.dominio.Colors;
import chinchon.dominio.Deck;
import chinchon.dominio.HandAnalyzer;
import chinchon.dominio.Human;
import chinchon.dominio.Player;
import chinchon.dominio.PlayerFactory;
import chinchon.dominio.Suit;
import chinchon.dominio.Value;

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
		handAnalyzer = new HandAnalyzer();
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
		int numPlayers = requestNumberOfPlayers();

		deck = new Deck();
		int numberOfDecks = (numPlayers >= 3) ? 2 : 1;

		for (int i = 0; i < numberOfDecks; i++) {
			addFullSetToDeck();
		}

		deck.shuffle();
		createPlayers(numPlayers);

		discardPile.clear();
		discardPile.add(deck.drawCard());
	}

	private void addFullSetToDeck() {
		for (Suit suit : Suit.values()) {
			for (Value value : Value.values()) {
				deck.getCards().add(new Card(suit, value));
			}
		}
	}

	public int requestNumberOfPlayers() {
		int players;
		System.out.println("¿Cuantos jugadores quieres añadir?");
		players = console.readIntInRange(2, 5);
		return players;
	}

	public boolean requestPlayerNature() {
		boolean player;
		player = console.readBooleanUsingChar('h', 'i', "Introduce 'h' para humano o 'i' para IA");
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
			System.out.printf("Jugador %d :\n", i + 1);
			player = requestPlayerNature();
			name = requestPlayerName();
			if (player) {
				players.add(PlayerFactory.createPlayer("human", name, hand, handAnalyzer));
			} else {
				players.add(PlayerFactory.createPlayer("ai", name, hand, handAnalyzer));
			}

		}
	}

	public List<Card> startHand() {
		List<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.drawCard());
		}
		return hand;
	}

	public void startGameLoop() {
		boolean option, roundEnd = false;
		while (!roundEnd) {

			for (int i = 0; i < players.size() && !roundEnd; i++) {
				Player player = players.get(i);

				System.out.println(player.toString());
				System.out.printf("Descartes : %s   Baraja : 🂠\n", discardPile.get(0));
				System.out.println(deck.getCards().size());
				player.playTurn(console, deck, discardPile);

				if (handAnalyzer.canClose(player.getHand())) {
					if (player instanceof Human) {
						option = console.readBooleanUsingChar('s', 'n', "¿Quieres cerrar? (s/n)");
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

	public void startGame() {
		boolean gameEnd = false;

		while (!gameEnd) {
			prepareNextRound();
			startGameLoop();
			gameEnd = checkGameEnd();
			if (!gameEnd) {
				prepareNextRound();
				System.out.printf("%sNew round!!%s\n", Colors.YELLOW, Colors.RESET);
			}

		}
	}

	private boolean checkGameEnd() {
		for (Player player : players) {
			if (player.getScore() >= 100) {
				pointsGameEnd();
				return true;
			}
		}

		if (handAnalyzer.findChinchon(players.get(0).getHand())) {
			pointsGameEnd();
			return true;
		}

		return false;
	}

	private void prepareNextRound() {
		int decks;
		deck.getCards().clear();
		decks = (players.size() >= 3) ? 2 : 1;
		for (int i = 0; i < decks; i++) {
			addFullSetToDeck();
		}
		deck.shuffle();
		discardPile.clear();
		discardPile.add(deck.drawCard());

		for (Player player : players) {
			player.getHand().clear();
			for (int i = 0; i < 7; i++) {
				player.getHand().add(deck.drawCard());
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
			System.out.printf("%s : %d puntos ", player.getName(), player.getScore());
		}
		System.out.println();
	}

	private void pointsGameEnd() {
		int i = 0;
		System.out.printf("FIN DE LA PARTIDA : \n");
		players.sort(Comparator.comparingInt(Player::getScore).reversed());
		for (Player player : players) {
			i++;
			System.out.printf("%s : %d points\n", player.toString(), player.getScore());
		}
	}

	public void checkAndRefillDeck() {
		if (deck.getCards().isEmpty()) {
			System.out.println("\n El mazo se ha agotado. Rebarajando descartes... ");

			Card topDiscard = discardPile.remove(0);

			deck.addCardsAndShuffle(new ArrayList<>(discardPile));

			discardPile.clear();
			discardPile.add(topDiscard);
		}
	}

}
