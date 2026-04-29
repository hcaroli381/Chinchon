# 🏅 Suit (Enum)

> **Responsabilidad**: Representar los palos de la baraja.

**Paquete**: `chinchon.dominio`

**Descripción**: Define los cuatro palos de la baraja española con sus símbolos emoji correspondientes.

---

## Valores

| Palo | Símbolo | Descripción |
|------|---------|-------------|
| **OROS** | 🟡 | Palo de oros (monedas) de la baraja española |
| **COPAS** | 🏆 | Palo de copas (cálices) de la baraja española |
| **BASTOS** | 🌿 | Palo de bastos (palillos/flores) de la baraja española |
| **ESPADAS** | ⚔️ | Palo de espadas de la baraja española |

---

## Métodos

### 1️⃣ `Suit(String symbol)` (constructor)

**Tipo**: Constructor del enum

**Descripción**: Asigna un símbolo emoji a cada palo.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `symbol` | String | Símbolo emoji del palo |

---

### 2️⃣ `getSymbol()`

**Tipo**: Método público

**Retorna**: `String` - El símbolo emoji del palo

**Descripción**: Retorna el símbolo visual del palo para mostrar en consola.
