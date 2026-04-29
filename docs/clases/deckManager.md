# 🂠 DeckManager

> **Responsabilidad**: Administrar la baraja durante la partida.

**Paquete**: `chinchon.app`

**Descripción**: Gestiona la creación, preparación y reabastecimiento del mazo. También se encarga de rellenar el mazo cuando se agota durante el juego.

---

## Métodos

### 1️⃣ `addFullSetsToDeck(Deck deck, int numberOfDecks)`

**Tipo**: Método público

**Descripción**: Agrega una o más barajas completas al mazo.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `deck` | Deck | El mazo destino |
| `numberOfDecks` | int | Número de barajas a agregar (1 o 2) |

**Lógica**:
- Bucle que se ejecuta según el número de mazos
- Llama a `addFullSetToDeck()` para cada mazo
- Construye la baraja con todas las combinaciones

---

### 2️⃣ `addFullSetToDeck(Deck deck)` (privado)

**Tipo**: Método privado

**Descripción**: Agrega una baraja completa (40 cartas) al mazo.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `deck` | Deck | El mazo destino |

**Lógica**:
- Itera sobre todos los palos (OROS, COPAS, BASTOS, ESPADAS)
- Para cada palo, itera sobre todos los valores (UNO-SIETE, SOTA, CABALLO, REY)
- Crea una carta para cada combinación
- Agrega cada carta al mazo

---

### 3️⃣ `prepareDeckForNewRound(Deck deck, List<Card> discardPile, int numberOfDecks)`

**Tipo**: Método público

**Descripción**: Prepara el mazo para una nueva ronda.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `deck` | Deck | El mazo a preparar |
| `discardPile` | List<Card> | Pila de descartes anterior |
| `numberOfDecks` | int | Número de mazos a usar |

**Lógica**:
- Limpia las cartas del mazo actual
- Agrega nuevos mazos completos
- Baraja el mazo
- Vacía la pila de descartes anterior
- Coloca una carta inicial en descartes

---

### 4️⃣ `checkAndRefillDeck(Deck deck, List<Card> discardPile)` (público)

**Tipo**: Método público

**Descripción**: Verifica si el mazo está vacío y lo rellena si es necesario.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `deck` | Deck | El mazo a verificar |
| `discardPile` | List<Card> | Pila de descartes para reponer |

**Lógica**:
- Comprueba si el mazo está vacío
- Si está vacío:
  - Toma todas las cartas de descartes excepto la última
  - Las agrega al mazo
  - Baraja para aleatorizar
  - Deja la última carta como nueva base de descartes
