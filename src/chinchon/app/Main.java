package chinchon.app;

import java.util.Iterator;
import java.util.Scanner;

import chinchon.dominio.Card;
import chinchon.dominio.Deck;

public class Main {

	public static void main(String[] args) {

		GameEngine gameEngine = GameEngine.getInstance();

		gameEngine.startGameLoop();
	}
}
