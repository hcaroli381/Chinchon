# 👨 Human

> **Responsabilidad**: Representar un jugador humano controlado por el usuario.

**Paquete**: `chinchon.dominio`

**Hereda de**: `Player`

**Descripción**: Implementa la lógica para que un usuario pueda jugar interactivamente, mostrando su mano, pidiendo decisiones y validando acciones.

---

## Métodos

### 1️⃣ `Human(String name, List<Card> hand, int score, HandAnalyzer handAnalyzer)`

**Tipo**: Constructor

**Descripción**: Inicializa un jugador humano.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `name` | String | Nombre del jugador |
| `hand` | List<Card> | Mano inicial del jugador |
| `score` | int | Puntuación inicial |
| `handAnalyzer` | HandAnalyzer | Analizador de manos |

**Lógica**:
- Llama al constructor de la clase padre (Player)
- Inicializa el jugador con los parámetros proporcionados

---

### 2️⃣ `playTurn(ConsoleInput input, Deck deck, List<Card> discardPile)` (override)

**Tipo**: Método público

**Descripción**: Ejecuta el turno completo del jugador humano.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `input` | ConsoleInput | Gestor de entrada |
| `deck` | Deck | Baraja boca abajo |
| `discardPile` | List<Card> | Pila de descartes |

**Lógica**:
- Muestra la mano actual del jugador
- Pregunta si quiere coger de descartes o baraja
- Muestra la mano actualizada
- Solicita qué carta descartar
- Espera 1 segundo para mejor experiencia visual

---

### 3️⃣ `showHand()`

**Tipo**: Método público

**Descripción**: Muestra la mano del jugador formateada en la consola.

**Lógica**:
- Ordena la mano por valor y palo
- Obtiene las cartas que forman combinaciones válidas
- Marca visualmente en verde las cartas combinadas
- Muestra:
  - Mano actual con colores
  - Puntuación acumulada de la partida
  - Puntuación provisional de la ronda

---

### 4️⃣ `askForDraw(ConsoleInput input, Deck deck, List<Card> discardPile)`

**Tipo**: Método público

**Descripción**: Pregunta al jugador si quiere coger de descartes o baraja.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `input` | ConsoleInput | Gestor de entrada |
| `deck` | Deck | Baraja boca abajo |
| `discardPile` | List<Card> | Pila de descartes |

**Lógica**:
- Pregunta al usuario: descartes (d) o baraja (b)
- Si elige descartes: coge la carta del principio de descartes
- Si elige baraja: coge una carta del mazo
- Valida la elección del usuario

---

### 5️⃣ `discard(ConsoleInput input, List<Card> discardPile)` (privado)

**Tipo**: Método privado

**Descripción**: Solicita al jugador qué carta descartar.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `input` | ConsoleInput | Gestor de entrada |
| `discardPile` | List<Card> | Pila de descartes |

**Lógica**:
- Muestra las cartas disponibles para descartar
- Pide el índice de la carta a descartar
- Valida que el índice sea válido
- Agrega la carta a la pila de descartes
- Elimina la carta de la mano
