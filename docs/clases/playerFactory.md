## PlayerFactory

Clase encargada de crear instancias de jugadores siguiendo el patrón de diseño **Factory Method**. Centraliza la lógica de creación de jugadores basándose en su tipo.

### Funciones

1. **createPlayer(PlayerType type, String name, List<Card> hand, HandAnalyzer handAnalyzer)**

   Responsabilidad: Crear un jugador del tipo especificado.

   - Recibe el tipo de jugador a crear (HUMAN o AI)
   - Recibe el nombre del jugador
   - Recibe la mano inicial del jugador (lista de cartas)
   - Recibe el analizador de manos para el jugador
   - Usa un switch para determinar qué tipo de jugador crear:
     - Si es HUMAN: crea una instancia de Human
     - Si es AI: crea una instancia de AI
     - Si es un tipo desconocido: lanza IllegalArgumentException
   - Retorna la instancia del jugador creado (con puntuación inicial de 0)

### Propósito

El patrón Factory Method centraliza la lógica de creación de objetos, facilitando el mantenimiento y permitiendo agregar nuevos tipos de jugadores en el futuro sin modificar el código que los utiliza.
