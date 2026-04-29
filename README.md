# Chinchón
El Chichón es un juego de cartas jugado con la baraja española, en el que los jugadores intentan formar escaleras o grupos para cerrar y ganar rondas.

# Reglas
- Cada jugador tiene 7 cartas.
- En cada turno decidirá si tomar de la pila de descartes o de la baraja boca abajo, despues de tomarla, descartará para tener 7.
- Podemos formar combinaciones de mínimo 3 cartas, escaleras *del mismo palo* o combinaciones de un mismo número.
- El objetivo del juego es tener el mínimo número de puntos posible o formar un *chinchón*.
- El chinchón se forma con una escalera de 7 cartas.
- Solo podemos cerrar y acabar la ronda si solo tenemos una carta sin combinar cuyo valor sea 1-5, si tenemos todas combinadas o si tenemos chinchón ( victoria automática ).
- Una vez acabada la ronda :
    - Los jugadores que tengan cartas sin combinar, sumaran el valor de ellas a su puntuación.
    - Si acabas la ronda con todas las cartas combinadas te restan 10 puntos a tu puntuación total.
    - Si cierras con chinchón ganas automáticamente la partida.
- Un jugador es eliminado cuando llegue a 100 puntos
- Gana el último jugadir en pie
# Características del proyecto
- Nomenclatura de funciones, clases y variables completamente en inglés
- Comunicación con el usuario a través de la clase ConsoleInput


# Estructura

```
Chinchon
├─ docs
│  └─ chinchonUML.png
├─ README.md
├─ src
│  └─ chinchon
│     ├─ app
│     │  ├─ ConsoleInput.java
│     │  ├─ DeckManager.java
│     │  ├─ GameEngine.java
│     │  ├─ GameLoop.java
│     │  ├─ GameManager.java
│     │  ├─ Main.java
│     │  └─ ScoreCalculator.java
│     └─ dominio
│        ├─ AI.java
│        ├─ Card.java
│        ├─ Colors.java
│        ├─ Deck.java
│        ├─ GameConstants.java
│        ├─ HandAnalyzer.java
│        ├─ Human.java
│        ├─ Player.java
│        ├─ PlayerFactory.java
│        ├─ PlayerType.java
│        ├─ Suit.java
│        └─ Value.java
└─ test
   └─ dominio
      ├─ DeckManagerTest.java
      ├─ DeckTest.java
      ├─ HandAnalyzerTest.java
      ├─ PlayerFactoryTest.java
      └─ PlayerTest.java

```

# Explicación de clases

Click en el nombre de cada clase para ver su explicación detallada.

## Clases de la aplicación (app)

- [**GameEngine**](docs/clases/gameEngine.md) - Clase principal del juego usando patrón Singleton. Coordina el flujo general.
- [**GameManager**](docs/clases/gameManager.md) - Gestiona el estado del juego (jugadores, mazo, descartes).
- [**GameLoop**](docs/clases/gameLoop.md) - Ejecuta el bucle principal de turnos y rondas.
- [**ScoreCalculator**](docs/clases/scoreCalculator.md) - Calcula la puntuación y determina el final de la partida.
- [**DeckManager**](docs/clases/deckManager.md) - Administra la baraja y su preparación.
- [**ConsoleInput**](docs/clases/consoleInput.md) - Gestiona la entrada del usuario desde la consola.
- [**Main**](docs/clases/main.md) - Punto de entrada de la aplicación.

## Clases del dominio (dominio)

### Jugadores
- [**Player**](docs/clases/player.md) - Clase abstracta base para todos los jugadores.
- [**Human**](docs/clases/human.md) - Jugador humano con control interactivo.
- [**AI**](docs/clases/ai.md) - Jugador controlado por inteligencia artificial.
- [**PlayerFactory**](docs/clases/playerFactory.md) - Factory para crear jugadores del tipo especificado.
- [**PlayerType**](docs/clases/playerType.md) - Enum con tipos de jugadores disponibles.

### Cartas y Baraja
- [**Card**](docs/clases/card.md) - Representa una carta individual con palo y valor.
- [**Deck**](docs/clases/deck.md) - Gestiona la baraja y sus operaciones.
- [**Suit**](docs/clases/suit.md) - Enum con los cuatro palos de la baraja española.
- [**Value**](docs/clases/value.md) - Enum con los valores de las cartas.

### Análisis y Utilidades
- [**HandAnalyzer**](docs/clases/handAnalyzer.md) - Analiza manos, detecta combinaciones y calcula puntuación.
- [**GameConstants**](docs/clases/gameConstants.md) - Constantes centralizadas del juego.
- [**Colors**](docs/clases/colors.md) - Códigos ANSI para colorear la salida de la consola.




