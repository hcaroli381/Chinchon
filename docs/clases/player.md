## Player

Clase abstracta que representa un jugador genérico del juego. Define la estructura común que tanto jugadores humanos como IA deben implementar.

### Funciones

1. **Player(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer)**

   Constructor protegido que inicializa un jugador.

   - Asigna el nombre del jugador
   - Asigna la mano (lista de cartas) del jugador
   - Asigna la puntuación inicial
   - Asigna el analizador de manos

2. **playTurn(ConsoleInput input, Deck deck, List<Card> discardPile)**

   Responsabilidad: Ejecutar el turno del jugador (método abstracto).

   - Debe ser implementado por las clases hijas (Human y AI)
   - Define el comportamiento específico del turno según el tipo de jugador

3. **getName()**

   Responsabilidad: Obtener el nombre del jugador.

   - Retorna el nombre del jugador

4. **setName(String name)**

   Responsabilidad: Establecer el nombre del jugador.

   - Actualiza el nombre del jugador

5. **getHand()**

   Responsabilidad: Obtener la mano del jugador.

   - Retorna la lista de cartas del jugador

6. **setHand(List<Card> hand)**

   Responsabilidad: Establecer la mano del jugador.

   - Actualiza la mano del jugador

7. **getScore()**

   Responsabilidad: Obtener la puntuación acumulada del jugador.

   - Retorna la puntuación total de la partida

8. **setScore(int score)**

   Responsabilidad: Establecer la puntuación del jugador.

   - Actualiza la puntuación total del jugador

9. **getHandAnalyzer()**

   Responsabilidad: Obtener el analizador de manos del jugador.

   - Retorna la instancia de HandAnalyzer

10. **setHandAnalyzer(HandAnalyzer handAnalyzer)**

    Responsabilidad: Establecer el analizador de manos del jugador.

    - Actualiza la instancia de HandAnalyzer

11. **toString()**

    Responsabilidad: Representar al jugador como texto.

    - Retorna el nombre del jugador con color cyan (Colors.CYAN)
