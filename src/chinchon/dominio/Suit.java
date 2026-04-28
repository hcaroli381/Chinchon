package chinchon.dominio;

/**
 * Palos de la baraja española
 */
public enum Suit {
	OROS("\uD83D\uDFE1"), COPAS("\uD83C\uDFC6"), BASTOS("\uD83C\uDF3F"), ESPADAS("\u2694\uFE0F");

	private String symbol;

	Suit(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
}
