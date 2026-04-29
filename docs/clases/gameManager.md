# 📊 GameManager

> **Responsabilidad**: Gestionar el estado del juego.

**Paquete**: `chinchon.app`

**Descripción**: Centraliza el estado del juego incluyendo jugadores, baraja y pila de descartes. Coordina la configuración inicial y preparación de rondas.

---

## Métodos

### 1️⃣ `setUpGame()`

**Tipo**: Método público

**Descripción**: Configura el juego al inicio de la partida.

**Lógica**:
- Pide el número de jugadores mediante `requestNumberOfPlayers()`
- Crea la baraja (Deck) y la baraja
- Crea los jugadores mediante `createPlayers()`
- Inicializa la pila de descartes con una carta del mazo

---

### 2️⃣ `prepareNextRound()`

**Tipo**: Método público

**Descripción**: Prepara la siguiente ronda del juego.

**Lógica**:
- Prepara el mazo para la nueva ronda usando `deckManager.prepareDeckForNewRound()`
- Reparte 7 cartas a cada jugador (`GameConstants.INITIAL_CARDS_PER_PLAYER`)
- Reinicia la mano de cada jugador

---

### 3️⃣ `eliminatePlayers()`

**Tipo**: Método público

**Descripción**: Elimina a los jugadores que han alcanzado la puntuación máxima.

**Lógica**:
- Itera sobre los jugadores
- Verifica si la puntuación es >= a `GameConstants.ELIMINATION_SCORE` (100 puntos)
- Elimina a los jugadores que han sido derrotados
- Muestra mensajes de eliminación
