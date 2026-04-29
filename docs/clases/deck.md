# 🃏 Deck

> **Responsabilidad**: Gestionar la colección de cartas de la baraja.

**Paquete**: `chinchon.dominio`

**Descripción**: Almacena las cartas, permite crear barajas completas, barajarlas y extraer cartas durante el juego.

---

## Métodos

### 1️⃣ `Deck()`

**Tipo**: Constructor

**Descripción**: Inicializa el mazo con una lista vacía.

---

### 2️⃣ `createDeck()`

**Tipo**: Método público

**Descripción**: Crea un mazo completo de cartas desde cero.

**Lógica**:
- Limpia la lista de cartas actual
- Itera sobre todos los palos (OROS, COPAS, BASTOS, ESPADAS)
- Para cada palo, itera sobre todos los valores (UNO-SIETE, SOTA, CABALLO, REY)
- Crea una carta para cada combinación y la agrega

---

### 3️⃣ `shuffle()`

**Tipo**: Método público

**Descripción**: Baraja aleatoriamente las cartas del mazo.

**Lógica**:
- Usa `Collections.shuffle()` para mezclar el orden

---

### 4️⃣ `drawCard()`

**Tipo**: Método público

**Retorna**: `Card` - La primera carta del mazo, o null si está vacío

**Descripción**: Extrae la primera carta del mazo.

**Lógica**:
- Comprueba si el mazo tiene cartas
- Si está vacío: retorna null
- Si hay cartas: extrae y retorna la primera (índice 0)

---

### 5️⃣ `addCardsAndShuffle(List<Card> newCards)`

**Tipo**: Método público

**Descripción**: Agrega un conjunto de cartas y baraja el mazo.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `newCards` | List<Card> | Cartas a agregar |

**Lógica**:
- Agrega todas las cartas nuevas al mazo
- Baraja el mazo después de agregar

---

### 6️⃣ `getCards()`

**Tipo**: Método público

**Retorna**: `List<Card>` - La lista de cartas del mazo

**Descripción**: Acceso directo a la lista de cartas para manipulación.
