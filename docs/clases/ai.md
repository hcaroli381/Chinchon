# 🤖 AI

> **Responsabilidad**: Representar un jugador controlado por inteligencia artificial.

**Paquete**: `chinchon.dominio`

**Hereda de**: `Player`

**Descripción**: Implementa la lógica para que la IA juegue de forma autónoma, tomando decisiones optimizadas basadas en el análisis de la mano actual.

---

## Métodos

### 1️⃣ `AI(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer)`

**Tipo**: Constructor

**Descripción**: Inicializa un jugador controlado por IA.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `name` | String | Nombre del jugador |
| `hand` | List<Card> | Mano inicial del jugador |
| `score` | int | Puntuación inicial |
| `handAnalyzer` | HandAnalyzer | Analizador de manos |

**Lógica**:
- Llama al constructor de la clase padre (Player)
- Inicializa la IA con los parámetros proporcionados

---

### 2️⃣ `playTurn(ConsoleInput input, Deck deck, List<Card> discardPile)` (override)

**Tipo**: Método público

**Descripción**: Ejecuta el turno completo del jugador IA.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `input` | ConsoleInput | Gestor de entrada (no utilizado) |
| `deck` | Deck | Baraja boca abajo |
| `discardPile` | List<Card> | Pila de descartes |

**Lógica**:
- Decide inteligentemente si coger del descarte o baraja
- Obtiene la mejor carta para descartar
- Muestra la acción al usuario
- Elimina la carta de la mano
- Agrega la carta a la pila de descartes
- Espera 1 segundo para mejor visualización

---

### 3️⃣ `draw(Deck deck, List<Card> discardPile)` (privado)

**Tipo**: Método privado

**Descripción**: Decide inteligentemente si coger del descarte o de la baraja.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `deck` | Deck | Baraja boca abajo |
| `discardPile` | List<Card> | Pila de descartes |

**Lógica**:
- Crea copia temporal de la mano actual
- Calcula puntos con mano actual
- Calcula puntos si agrega carta del descarte
- **Estrategia IA**: Si puntos con descarte ≤ puntos actuales → coge descarte
- En caso contrario → coge de la baraja
- Muestra la decisión tomada
- Espera 1 segundo para sincronización visual
