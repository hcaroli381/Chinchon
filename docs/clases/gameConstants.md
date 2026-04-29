## GameConstants

Clase utilizada para centralizar todas las constantes del juego. Permite cambiar valores de configuración en un único lugar sin afectar el resto del código.

### Constantes

1. **MAX_PLAYERS = 5**

   Define el número máximo de jugadores permitidos en una partida.

2. **MIN_PLAYERS = 2**

   Define el número mínimo de jugadores requeridos para comenzar una partida.

3. **ELIMINATION_SCORE = 100**

   Define la puntuación máxima que un jugador puede acumular antes de ser eliminado del juego. Al alcanzar o superar este valor, el jugador es eliminado.

4. **INITIAL_CARDS_PER_PLAYER = 7**

   Define la cantidad inicial de cartas que recibe cada jugador al inicio de cada ronda.

### Propósito

Esta clase facilita el mantenimiento del código permitiendo que los valores clave de configuración del juego se cambien desde un único lugar, sin necesidad de modificar múltiples archivos o métodos en el código.
