## Human

Clase que representa un jugador humano controlado por el usuario. Extiende la clase Player e implementa la lógica para que un usuario pueda jugar interactivamente.

### Funciones

1. **Human(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer)**

   Constructor que inicializa un jugador humano.

   - Llama al constructor de la clase padre (Player)
   - Inicializa el jugador con nombre, mano vacía y puntuación 0

2. **playTurn(ConsoleInput input, Deck deck, List<Card> discardPile)**

   Responsabilidad: Ejecutar el turno completo del jugador humano.

   - Muestra la mano actual del jugador (showHand)
   - Pregunta si quiere coger de descartes o baraja (askForDraw)
   - Muestra la mano actualizada (showHand)
   - Solicita qué carta descartar (discard)
   - Espera 1 segundo para una mejor experiencia visual

3. **showHand()**

   Responsabilidad: Mostrar la mano del jugador al usuario.

   - Ordena la mano por valor y palo
   - Obtiene las cartas combinadas del jugador
   - Marca visualmente cuáles cartas están combinadas (en verde)
   - Muestra la mano actual
   - Muestra la puntuación acumulada de la partida
   - Muestra la puntuación provisional de la ronda (cartas sin combinar)

4. **askForDraw(ConsoleInput input, Deck deck, List<Card> discardPile)**

   Responsabilidad: Preguntar al jugador si quiere coger de descartes o baraja.

   - Pregunta al usuario si quiere descartes (d) o baraja (b)
   - Si elige descartes: coge la carta de la pila de descartes
   - Si elige baraja: coge una carta del mazo
   - Toma la decisión más inteligente: compara los puntos de la mano original vs mano con descarte

5. **discard(ConsoleInput input, List<Card> discardPile)**

   Responsabilidad: Solicitar al jugador qué carta descartar.

   - Muestra las cartas disponibles para descartar
   - Pide el índice de la carta a descartar
   - Valida que el índice sea válido
   - Agrega la carta a la pila de descartes
   - Elimina la carta de la mano
