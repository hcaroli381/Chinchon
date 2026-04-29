# 🔄 GameLoop

> **Responsabilidad**: Ejecutar el bucle principal de turnos y rondas.

**Paquete**: `chinchon.app`

**Descripción**: Controla el flujo de una ronda completa, gestionando los turnos de cada jugador, verificando condiciones de cierre y calculando puntuaciones.

---

## Métodos

### 1️⃣ `startGameLoop()`

**Tipo**: Método público

**Descripción**: Ejecuta el bucle principal de turnos dentro de una ronda.

**Lógica**:
- Bucle de rondas: Mientras la ronda no haya terminado (!roundEnd)
- Bucle de turnos: Para cada jugador de la ronda
- Recarga el mazo si está vacío usando `deckManager.checkAndRefillDeck()`
- Ejecuta el turno del jugador: `player.playTurn()`
- Verifica si el jugador pueden cerrar (puntos < 100 - puntuación actual y turn > 1)
  - Si es humano: pregunta si quiere cerrar
  - Si es IA: cierra automáticamente
- Llama a `endRound()` si un jugador cierra la ronda

---

### 2️⃣ `endRound(Player ender)`

**Tipo**: Método privado

**Descripción**: Finaliza la ronda y calcula la puntuación de todos los jugadores.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `ender` | Player | Jugador que cerró la ronda |

**Lógica**:
- Verifica si el jugador que cerró tiene un Chinchón
- Calcula puntos sin combinar para cada jugador
- Actualiza puntuaciones:
  - Si el cierre tiene 0 puntos: se restan 10 puntos
  - Resto de jugadores: se suman sus puntos sin combinar
- Ordena jugadores por puntuación
- Muestra resultados finales de la ronda
- Llama a `gameState.eliminatePlayers()` para eliminar derrotados

---

### 3️⃣ `announceClose(Player player)`

**Tipo**: Método privado

**Descripción**: Anuncia visualmente que un jugador ha cerrado la ronda.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `player` | Player | Jugador que cerró |

**Lógica**:
- Muestra un mensaje indicando que el jugador cerró
- Espera 5 segundos con `Thread.sleep(5000)` para dar tiempo al usuario a leer