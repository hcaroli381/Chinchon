### Funciones
1. setUpGame
Responsabilidad de configurar el juego al inicio
    - Pide el número de jugadores (requestNumberOfPlayers).
    - Crea el mazo (Deck) y lo baraja.
    - Crea los jugadores (createPlayers).
    - Inicializa el descarte con una carta.

2. prepareNextRound
Prepara la siguiente ronda
    - Prepara el mazo para la nueva ronda (deckManager.prepareDeckForNewRound).
    - Reparte 7 cartas a cada jugador

3. eliminatePlayers
Eliminar a los jugadores
    - Elimina a los jugadores con puntuacion >= a la configurada en las constantes del juego
