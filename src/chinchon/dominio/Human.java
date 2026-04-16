package chinchon.dominio;

import java.util.List;

import chinchon.app.ConsoleInput;

public class Human extends Player {

	public Human(String name, List<Card> hand, int score) {
		super(name, hand, score);

	}

	@Override
	public void playTurn(ConsoleInput input, Deck deck, List<Card> discardPile) {
		showHand();
		askForDraw(input, deck, discardPile);
		System.out.println("Mano actual :");
		showHand();
		discard(input, discardPile);
	}

	public void showHand() {
		System.out.println(getHand());
	}

	public void askForDraw(ConsoleInput input, Deck deck, List<Card> discardPile) {
		boolean option;
		System.out.println("Escribe r para robar o c para coger del mazo visible");
		option = input.readBooleanUsingChar('r', 'c');
		if (option) {
			getHand().add(deck.drawCard());
			deck.removeCard();
		} else {
			getHand().add(discardPile.getFirst());
			discardPile.removeFirst();
		}
	}

	public void discard(ConsoleInput input, List<Card> discardPile) {
		int card;
		System.out.println("Selecciona del 1 al 8 la carta que descartar");
		card = input.readIntInRange(1, 8);
		discardPile.add(getHand().get(card - 1));
		getHand().remove(card - 1);
	}

}
