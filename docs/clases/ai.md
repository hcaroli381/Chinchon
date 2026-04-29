## AI

Clase que representa un jugador controlado por inteligencia artificial. Extiende la clase Player e implementa la lógica para que la IA pueda jugar de forma autónoma tomando decisiones optimizadas.

### Funciones

1. **AI(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer)**

   Constructor que inicializa un jugador IA.

   - Llama al constructor de la clase padre (Player)
   - Inicializa la IA con nombre, mano vacía y puntuación 0

2. **playTurn(ConsoleInput input, Deck deck, List<Card> discardPile)**

   Responsabilidad: Ejecutar el turno completo del jugador IA.

   - Decide si coger del descarte o la baraja (draw)
   - Obtiene la mejor carta para descartar (handAnalyzer.getBestDiscard)
   - Muestra qué carta va a descartar
   - Elimina la carta de la mano
   - Agrega la carta al principio de la pila de descartes
   - Espera 1 segundo para sincronización visual

3. **draw(Deck deck, List<Card> discardPile)**

   Responsabilidad: Decidir si coger del descarte o la baraja (método privado).

   - Crea una copia temporal de la mano actual
   - Calcula los puntos con la mano actual
   - Calcula los puntos con la mano + descarte
   - Si los puntos con descarte son menores o iguales, coge del descarte
   - Si los puntos con descarte son mayores, coge de la baraja
   - Muestra qué acción tomó
   - Espera 1 segundo antes de retornar
