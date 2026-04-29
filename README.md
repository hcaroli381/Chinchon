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

## [GameManager](docs/clases/gameManager.md)
La encargada de gestionar el estado del juego.


## GameLoop
Encargada del bucle principal del juego, turnos, cierre de ronda y cálculo de puntos.

### Funciones
1. startGameLoop()

Responsabilidad: Ejecutar el bucle principal de turnos y rondas.

Bucle de rondas: Mientras no termine la ronda (!roundEnd).
Bucle de turnos: Para cada jugador en la ronda.
Verificación de mazo: Usa deckManager.checkAndRefillDeck para rellenar el mazo si está vacío.
Turno del jugador: Llama a player.playTurn.
Verificación de cierre: Si el jugador puede cerrar (puntos < 100 - puntuación actual y turn > 1), se le pregunta si quiere cerrar (si es humano) o se cierra automáticamente (si es IA).
Fin de ronda: Llama a endRound si un jugador cierra.

2. endRound(Player ender)

Responsabilidad: Finalizar la ronda y calcular puntos.

Verificar Chinchón: Si el jugador que cerró tiene un Chinchón, se anuncia.
Calcular puntos: Para cada jugador, calcula los puntos sin combinar (handAnalyzer.calculateUncombinedCards).
Actualizar puntuaciones: Si el jugador que cerró tiene 0 puntos sin combinar, se le restan 10 puntos. A los demás, se les suman sus puntos sin combinar.
Ordenar jugadores: Por puntuación.
Mostrar resultados: Puntos de cada jugador y si fueron eliminados.
Eliminar jugadores: Llama a gameState.eliminatePlayers.

3. announceClose(Player player)

Responsabilidad: Anunciar que un jugador ha cerrado.
Acciones:

Muestra un mensaje indicando que el jugador ha cerrado.
Espera 5 segundos (Thread.sleep(5000)).


