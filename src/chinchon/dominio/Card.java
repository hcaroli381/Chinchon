package chinchon.dominio;

/**
 * Representa una carta de la baraja española usada en el juego.
 * <p>
 * La clase almacena su palo, su valor y si forma parte de una combinación ya
 * detectada por el analizador de manos.
 */
public class Card implements Comparable<Card> {
	private Suit suit;
	private Value value;
	private boolean combined;

	/**
	 * Crea una carta con un palo y un valor concretos.
	 *
	 * @param suit  palo de la carta
	 * @param value valor de la carta
	 */
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
		combined = false;
	}

	/**
	 * Devuelve una representación legible de la carta.
	 * <p>
	 * Si la carta está marcada como combinada, se muestra en verde para destacarla
	 * en la interfaz de consola.
	 */
	@Override
	public String toString() {

		if (combined) {
			return String.format("%s%s de %s%s", Colors.GREEN, value.getNumber(), suit.getSymbol(), Colors.RESET);
		} else {
			return String.format("%s de %s", value.getNumber(), suit.getSymbol());
		}

	}

	/**
	 * Obtiene el palo de la carta.
	 *
	 * @return palo de la carta
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Obtiene el valor de la carta.
	 *
	 * @return valor de la carta
	 */
	public Value getValue() {
		return value;
	}

	/**
	 * Marca o desmarca la carta como combinada.
	 *
	 * @param combined {@code true} si la carta pertenece a una combinación,
	 *                 {@code false} en caso contrario
	 */
	public void setCombined(boolean combined) {
		this.combined = combined;
	}

	/**
	 * Compara primero por palo y, si coincide, por valor numérico.
	 *
	 * @param other carta con la que comparar
	 * @return resultado de la comparación
	 */
	public int compareTo(Card other) {

		if (this.suit != other.suit) {
			return this.suit.compareTo(other.suit);
		}

		return Integer.compare(this.value.getNumber(), other.value.getNumber());
	}
}
