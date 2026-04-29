## Deck

Clase que representa la baraja del juego. Gestiona la colección de cartas, permite barajar y extraer cartas según sea necesario.

### Funciones

1. **Deck()**

   Constructor que inicializa el mazo.

   - Crea una ArrayList vacía para almacenar las cartas

2. **createDeck()**

   Responsabilidad: Crear un mazo completo de cartas.

   - Limpia la lista de cartas actual
   - Itera sobre todos los palos (Suit.values())
   - Para cada palo, itera sobre todos los valores (Value.values())
   - Crea una carta para cada combinación y la agrega

3. **shuffle()**

   Responsabilidad: Barajar las cartas del mazo.

   - Usa Collections.shuffle para mezclar aleatoriamente el orden de las cartas

4. **drawCard()**

   Responsabilidad: Extraer la primera carta del mazo.

   - Comprueba si el mazo tiene cartas disponibles
   - Si está vacío, retorna null
   - Si hay cartas, extrae y retorna la primera (índice 0)

5. **addCardsAndShuffle(List<Card> newCards)**

   Responsabilidad: Agregar un conjunto de cartas y barajar.

   - Agrega todas las nuevas cartas al mazo
   - Baraja el mazo después de agregar

6. **getCards()**

   Responsabilidad: Obtener la lista completa de cartas del mazo.

   - Retorna la referencia a la lista de cartas
   - Permite acceso directo para manipulación del mazo
