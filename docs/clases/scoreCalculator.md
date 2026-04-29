## ScoreCalculator

Clase responsable de calcular y gestionar la puntuación durante las rondas, así como determinar el final de la partida.

### Funciones

1. **ScoreCalculator(GameManager gameState, HandAnalyzer handAnalyzer)**

   Constructor que inicializa la clase.

   - Recibe el gestor del estado del juego
   - Recibe el analizador de manos para cálculos de puntuación

2. **checkGameEnd()**

   Responsabilidad: Verificar si la partida ha terminado.

   - Comprueba si quedan 1 o menos jugadores en juego
   - Comprueba si el primer jugador tiene un Chinchón
   - Retorna true si la partida termina, false en caso contrario
   - Llama al método correspondiente (pointsGameEnd o chinchonGameEnd)

3. **pointsGameEnd()**

   Responsabilidad: Manejar el final de la partida por puntuación (método privado).

   - Muestra el mensaje de fin de partida
   - Ordena los jugadores por puntuación de mayor a menor
   - Anuncia al ganador (jugador con menor puntuación)
   - Muestra la puntuación final

4. **chinchonGameEnd()**

   Responsabilidad: Manejar el final de la partida por Chinchón (método privado).

   - Muestra el mensaje de fin de partida
   - Ordena los jugadores por puntuación de menor a mayor
   - Recorre todos los jugadores mostrando:
     - Si tienen Chinchón: el mensaje "CHINCHON!!"
     - Si no tienen Chinchón: su puntuación de la ronda
