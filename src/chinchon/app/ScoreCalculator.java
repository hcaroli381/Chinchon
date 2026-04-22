package chinchon.app;

import java.util.Comparator;
import java.util.List;
import chinchon.dominio.HandAnalyzer;
import chinchon.dominio.Player;

public class ScoreCalculator {
	private GameManager gameState;
	private HandAnalyzer handAnalyzer;

	public ScoreCalculator(GameManager gameState, HandAnalyzer handAnalyzer) {
		this.gameState = gameState;
		this.handAnalyzer = handAnalyzer;
	}

	protected boolean checkGameEnd() {

		if (gameState.getPlayers().size() <= 1) {
			pointsGameEnd();
			return true;
		}

		if (handAnalyzer.findChinchon(gameState.getPlayers().get(0).getHand())) {
			pointsGameEnd();
			return true;
		}

		return false;
	}

	private void pointsGameEnd() {
		int i = 0;
		System.out.printf("FIN DE LA PARTIDA : \n");
		gameState.getPlayers().sort(Comparator.comparingInt(Player::getScore).reversed());
		for (Player player : gameState.getPlayers()) {
			i++;
			System.out.printf("%s : %d points\n", player.toString(), player.getScore());
		}
	}
}
