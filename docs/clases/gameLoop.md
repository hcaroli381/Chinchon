### Funciones
1. startGameLoop()

Responsabilidad: Ejecutar el bucle principal de turnos y rondas.

    - Bucle de rondas: Mientras no termine la ronda (!roundEnd).
    - Bucle de turnos: Para cada jugador en la ronda.
    - Verificación de mazo: Usa deckManager.checkAndRefillDeck para rellenar el mazo si está vacío.
    - Turno del jugador: Llama a player.playTurn.
    - Verificación de cierre: Si el jugador puede cerrar (puntos < 100 - puntuación actual y turn > 1), se le pregunta si quiere  cerrar (si es humano) o se cierra automáticamente (si es IA).
    - Fin de ronda: Llama a endRound si un jugador cierra.

2. endRound(Player ender)

Responsabilidad: Finalizar la ronda y calcular puntos.

    - Verificar Chinchón: Si el jugador que cerró tiene un Chinchón, se anuncia.
    - Calcular puntos: Para cada jugador, calcula los puntos sin combinar (handAnalyzer.calculateUncombinedCards).
    - Actualizar puntuaciones: Si el jugador que cerró tiene 0 puntos sin combinar, se le restan 10 puntos. A los demás, se les suman sus puntos sin combinar.
    - Ordenar jugadores: Por puntuación.
    - Mostrar resultados: Puntos de cada jugador y si fueron eliminados.
    - Eliminar jugadores: Llama a gameState.eliminatePlayers.

3. announceClose(Player player)

Responsabilidad: Anunciar que un jugador ha cerrado.
Acciones:
    - Muestra un mensaje indicando que el jugador ha cerrado.
    - Espera 5 segundos (Thread.sleep(5000)).