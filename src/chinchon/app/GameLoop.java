package chinchon.app;

import java.util.Comparator;
import java.util.List;

import chinchon.dominio.Card;
import chinchon.dominio.Colors;
import chinchon.dominio.Deck;
import chinchon.dominio.GameConstants;
import chinchon.dominio.HandAnalyzer;
import chinchon.dominio.Human;
import chinchon.dominio.Player;

public class GameLoop {
	private GameManager gameState;
	private ConsoleInput console;
	private HandAnalyzer handAnalyzer;
	private DeckManager deckManager;

	public GameLoop(GameManager gameState, ConsoleInput console, HandAnalyzer handAnalyzer, DeckManager deckManager) {
		this.gameState = gameState;
		this.console = console;
		this.handAnalyzer = handAnalyzer;
		this.deckManager = deckManager;
	}

	protected void startGameLoop() {
		int turn = 0;
		boolean option, roundEnd = false;
		while (!roundEnd) {
			turn = 0;
			for (int i = 0; i < gameState.getPlayers().size() && !roundEnd; i++) {
				turn++;
				Player player = gameState.getPlayers().get(i);
				Deck deck = gameState.getDeck();
				List<Card> discardPile = gameState.getDiscardPile();
				deckManager.checkAndRefillDeck(deck, discardPile);
				System.out.println(player.toString());
				System.out.printf("Descartes : %s   Baraja : 🂠\n", discardPile.get(0));
				System.out.println(deck.getCards().size());
				player.playTurn(console, deck, discardPile);
				if (turn > 1 && handAnalyzer.calculateUncombinedCards(
						player.getHand()) < (GameConstants.ELIMINATION_SCORE - player.getScore())) {
					if (handAnalyzer.canClose(player.getHand())) {
						if (player instanceof Human) {
							option = console.readBooleanUsingChar('s', 'n', "¿Quieres cerrar? (s/n)");
							if (option) {
								announceClose(player);
								endRound(player);
								roundEnd = true;

							}
						} else {
							announceClose(player);
							endRound(player);
							roundEnd = true;

						}
					}

				}
			}
		}
	}

	private void endRound(Player ender) {
		if (handAnalyzer.findChinchon(ender.getHand())) {
			System.out.printf("CHINCHON, %s ha ganado!!", ender.getName());
		}

		for (Player player : gameState.getPlayers()) {
			int points;
			points = handAnalyzer.calculateUncombinedCards(player.getHand());

			if (player.equals(ender) && points == 0) {
				player.setScore(player.getScore() - 10);
			} else {
				player.setScore(points + player.getScore());
			}

		}
		gameState.getPlayers().sort(Comparator.comparingInt(player -> player.getScore()));
		for (Player player : gameState.getPlayers()) {
			System.out.printf("%s : %d puntos ", player.getName(), player.getScore());
			if (player.getScore() >= GameConstants.ELIMINATION_SCORE) {
				System.out.printf("%sELIMINADO%s ", Colors.RED, Colors.RESET);
			}
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gameState.eliminatePlayers();
		System.out.println();
	}

	private void announceClose(Player player) {
		System.out.printf("%s ha cerrado!!\n", player);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
