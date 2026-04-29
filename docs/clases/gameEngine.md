# 🎯 GameEngine

> **Responsabilidad**: Coordinar el flujo general del juego.

**Paquete**: `chinchon.app`

**Patrón**: Singleton

**Descripción**: Clase principal del juego que actúa como punto central de coordinación. Delega tareas específicas a otras clases (GameManager, GameLoop, ScoreCalculator) y mantiene una única instancia durante toda la ejecución.

---

## Métodos

### 1️⃣ `createInstance(ConsoleInput console, HandAnalyzer handAnalyzer, DeckManager deckManager)` (estático)

**Tipo**: Método estático de inicialización

**Descripción**: Crea la única instancia de GameEngine si no existe.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `console` | ConsoleInput | Gestor de entrada del usuario |
| `handAnalyzer` | HandAnalyzer | Analizador de manos |
| `deckManager` | DeckManager | Gestor de la baraja |

---

### 2️⃣ `getInstance(ConsoleInput console, HandAnalyzer handAnalyzer, DeckManager deckManager)` (estático)

**Tipo**: Método estático

**Retorna**: `GameEngine` - La instancia única de GameEngine

**Descripción**: Retorna la instancia única de GameEngine. Lanza IllegalStateException si no ha sido inicializada con createInstance.

**Lógica**:
- Verifica que la instancia haya sido creada
- Si no existe, lanza excepción
- Retorna la instancia única del juego

---

### 3️⃣ `startGame()`

**Tipo**: Método público

**Descripción**: Inicia el bucle principal del juego.

**Lógica**:
- Bucle principal: Mientras el juego no haya terminado (!gameEnd)
- Prepara la siguiente ronda: Llama a `gameState.prepareNextRound()`
- Ejecuta la ronda: Llama a `gameLoop.startGameLoop()`
- Verifica fin: Llama a `scoreCalculator.checkGameEnd()`
- Muestra mensaje de nueva ronda al inicio de cada iteración

