# 🔢 Value (Enum)

> **Responsabilidad**: Representar los valores de las cartas.

**Paquete**: `chinchon.dominio`

**Descripción**: Define todos los valores válidos en la baraja española (1-7, Sota, Caballo, Rey) con sus valores numéricos para puntuación.

---

## Valores

| Valor | Número | Descripción |
|-------|--------|-------------|
| **UNO** | 1 | Carta de valor 1 |
| **DOS** | 2 | Carta de valor 2 |
| **TRES** | 3 | Carta de valor 3 |
| **CUATRO** | 4 | Carta de valor 4 |
| **CINCO** | 5 | Carta de valor 5 |
| **SEIS** | 6 | Carta de valor 6 |
| **SIETE** | 7 | Carta de valor 7 |
| **SOTA** | 10 | Figura - Sota |
| **CABALLO** | 11 | Figura - Caballo |
| **REY** | 12 | Figura - Rey |

---

## Métodos

### 1️⃣ `Value(int number)` (constructor)

**Tipo**: Constructor del enum

**Descripción**: Asigna un valor numérico a cada carta.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `number` | int | Valor numérico para puntuación |

---

### 2️⃣ `getNumber()`

**Tipo**: Método público

**Retorna**: `int` - El valor numérico de la carta

**Descripción**: Retorna el valor usado para cálculos de puntuación y ordenamiento.
