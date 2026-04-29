## Funciones

1. createInstance

Crea una nueva instancia de GameEngine si no existe.

2. getInstance()

Lanza IllegalStateException si la instancia no ha sido inicializada.

Acciones:

 - Retorna la instancia única de GameEngine.


3. startGame()
Inicia el bucle principal del juego.
Acciones:

 - Bucle de juego: Mientras no termine el juego (!gameEnd).
 - Preparar ronda: Llama a gameState.prepareNextRound().
 - Ejecutar ronda: Llama a gameLoop.startGameLoop().
 - Verificar fin del juego: Llama a scoreCalculator.checkGameEnd().
 - Mensaje de nueva ronda: Muestra un mensaje al inicio de cada ronda.

