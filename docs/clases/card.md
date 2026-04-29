# ♠️ Card

> **Responsabilidad**: Representar una carta individual de la baraja.

**Paquete**: `chinchon.dominio`

**Descripción**: Contiene el palo y valor de la carta, además de un estado que indica si está combinada en una escalera o grupo.

---

## Métodos

### 1️⃣ `Card(Suit suit, Value value)`

**Tipo**: Constructor

**Descripción**: Inicializa una carta con palo y valor.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `suit` | Suit | El palo de la carta (OROS, COPAS, BASTOS, ESPADAS) |
| `value` | Value | El valor de la carta (UNO-SIETE, SOTA, CABALLO, REY) |

**Lógica**:
- Asigna el palo y valor proporcionados
- Inicializa `combined` como false (sin combinar)

---

### 2️⃣ `toString()`

**Tipo**: Método público (override)

**Retorna**: `String` - Representación textual de la carta

**Descripción**: Genera una representación visual de la carta.

**Lógica**:
- Si la carta está combinada: muestra en color verde (Colors.GREEN)
- Si no está combinada: muestra en color normal
- Formato: "número de palo"

---

### 3️⃣ `getSuit()`

**Tipo**: Método público

**Retorna**: `Suit` - El palo de la carta

---

### 4️⃣ `getValue()`

**Tipo**: Método público

**Retorna**: `Value` - El valor de la carta

---

### 5️⃣ `setCombined(boolean combined)`

**Tipo**: Método público

**Descripción**: Establece si la carta está combinada en una escalera o grupo.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `combined` | boolean | true si está combinada, false si no |

---

### 6️⃣ `compareTo(Card other)` (override)

**Tipo**: Método público

**Retorna**: `int` - Valor de comparación

**Descripción**: Compara esta carta con otra para ordenamiento (implementa Comparable<Card>).

**Lógica de comparación**:
1. Primero compara por palo (suit)
2. Si los palos son iguales, compara por valor numérico
3. Retorna: negativo si menor, 0 si igual, positivo si mayor
