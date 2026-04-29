# 🎮 Main

> **Responsabilidad**: Punto de entrada de la aplicación.

**Paquete**: `chinchon.app`

**Descripción**: Inicializa todos los componentes necesarios (ConsoleInput, HandAnalyzer, DeckManager, GameEngine) y lanza el juego.

---

## Métodos

### 1️⃣ `main(String[] args)` (estático)

**Tipo**: Método estático (punto de entrada)

**Descripción**: Punto de entrada de la aplicación. Inicializa todos los componentes necesarios y lanza el juego.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `args` | String[] | Argumentos de la línea de comandos (no utilizados) |

**Lógica**:
1. Crea un `Scanner` para leer entrada del usuario
2. Inicializa `ConsoleInput` con el Scanner
3. Crea una instancia de `HandAnalyzer` para análisis de manos
4. Crea una instancia de `DeckManager` para gestión de baraja
5. Crea la instancia única de `GameEngine` (patrón Singleton)
6. Obtiene la instancia de `GameEngine`
7. Inicia el juego llamando a `engine.startGame()`
8. Captura excepciones si la instancia no se inicializó correctamente
