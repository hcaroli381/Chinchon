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

## GameManager
La encargada de gestionar el estado del juego.

### Funciones
- setUpGame
Responsabilidad de configurar el juego al inicio
    - Pide el número de jugadores (requestNumberOfPlayers).
    - Crea el mazo (Deck) y lo baraja.
    - Crea los jugadores (createPlayers).
    - Inicializa el descarte con una carta.
