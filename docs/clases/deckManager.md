## DeckManager

Clase encargada de administrar la baraja durante la partida. Gestiona la creación, preparación y reabastecimiento del mazo según sea necesario.

### Funciones

1. **addFullSetsToDeck(Deck deck, int numberOfDecks)**

   Responsabilidad: Agregar una o más barajas completas al mazo.

   - Bucle que se ejecuta según el número de mazos especificado
   - Llama a addFullSetToDeck para cada mazo
   - Construye la baraja con todas las combinaciones de palos y valores

2. **addFullSetToDeck(Deck deck)**

   Responsabilidad: Agregar una baraja completa al mazo (método privado).

   - Itera sobre todos los palos (Suit.values())
   - Para cada palo, itera sobre todos los valores (Value.values())
   - Crea una carta para cada combinación y la agrega al mazo

3. **prepareDeckForNewRound(Deck deck, List<Card> discardPile, int numberOfDecks)**

   Responsabilidad: Preparar el mazo para una nueva ronda.

   - Limpia las cartas del mazo actual (deck.getCards().clear())
   - Agrega nuevos mazos completos (addFullSetsToDeck)
   - Baraja el mazo (deck.shuffle())
   - Vacía la pila de descartes (discardPile.clear())
   - Pone una carta inicial en los descartes

4. **checkAndRefillDeck(Deck deck, List<Card> discardPile)**

   Responsabilidad: Verificar si el mazo está vacío y rellenarlo si es necesario.

   - Comprueba si el mazo está vacío
   - Si está vacío, toma las cartas de la pila de descartes (excepto la última)
   - Las agrega al mazo con shuffle para que queden aleatoriamente ordenadas
   - Deja la última carta de descartes como nueva pila base
