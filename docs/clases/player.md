# 👤 Player (Abstracta)

> **Responsabilidad**: Definir la estructura base de todos los jugadores.

**Paquete**: `chinchon.dominio`

**Descripción**: Clase abstracta que define la interfaz común que deben cumplir tanto jugadores humanos (Human) como controlados por IA (AI).

---

## Métodos

### 1️⃣ `Player(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer)` (protegido)

**Tipo**: Constructor

**Descripción**: Inicializa un jugador base (solo llamable desde subclases).

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `name` | String | Nombre del jugador |
| `hand` | List<Card> | Mano inicial del jugador |
| `score` | int | Puntuación inicial |
| `handAnalyzer` | HandAnalyzer | Analizador de manos |

---

### 2️⃣ `playTurn(ConsoleInput input, Deck deck, List<Card> discardPile)` (abstracto)

**Tipo**: Método abstracto

**Descripción**: Define el comportamiento del turno de cada jugador. Debe ser implementado por subclases.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `input` | ConsoleInput | Gestor de entrada |
| `deck` | Deck | Baraja boca abajo |
| `discardPile` | List<Card> | Pila de descartes |

---

### 3️⃣ `getName()`

**Tipo**: Método público

**Retorna**: `String` - El nombre del jugador

---

### 4️⃣ `setName(String name)`

**Tipo**: Método público

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `name` | String | Nuevo nombre del jugador |

---

### 5️⃣ `getHand()`

**Tipo**: Método público

**Retorna**: `List<Card>` - La lista de cartas del jugador

---

### 6️⃣ `setHand(List<Card> hand)`

**Tipo**: Método público

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `hand` | List<Card> | Nueva mano del jugador |

---

### 7️⃣ `getScore()`

**Tipo**: Método público

**Retorna**: `int` - La puntuación acumulada total

---

### 8️⃣ `setScore(int score)`

**Tipo**: Método público

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `score` | int | Nueva puntuación total |

---

### 9️⃣ `getHandAnalyzer()`

**Tipo**: Método público

**Retorna**: `HandAnalyzer` - El analizador de manos

---

### 🔟 `setHandAnalyzer(HandAnalyzer handAnalyzer)`

**Tipo**: Método público

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `handAnalyzer` | HandAnalyzer | Nuevo analizador de manos |

---

### 1️⃣1️⃣ `toString()`

**Tipo**: Método público (override)

**Retorna**: `String` - Nombre del jugador coloreado en cyan

**Formato**: Nombre en color CYAN (Colors.CYAN)
