# 🔍 HandAnalyzer

> **Responsabilidad**: Analizar la mano del jugador.

**Paquete**: `chinchon.dominio`

**Descripción**: Detecta combinaciones válidas (escaleras y grupos), calcula puntuaciones, verifica condiciones de cierre y determina el mejor descarte para la IA.

---

## Métodos

### 1️⃣ `calculateUncombinedCards(List<Card> hand)`

**Tipo**: Método público

**Retorna**: `int` - Suma de valores de cartas sin combinar

**Descripción**: Calcula la puntuación de cartas que no forman combinaciones válidas.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `hand` | List<Card> | Mano a analizar |

**Lógica**:
- Crea copia de la mano para análisis
- Busca y elimina grupos (3+ cartas del mismo valor)
- Busca y elimina escaleras (3+ cartas del mismo palo consecutivas)
- Suma el valor de las cartas restantes
- Retorna el total

---

### 2️⃣ `findSets(List<Card> auxiliarHand)` (privado)

**Tipo**: Método privado

**Descripción**: Encuentra y elimina grupos de 3+ cartas del mismo valor.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `auxiliarHand` | List<Card> | Mano a procesar |

**Lógica**:
- Agrupa cartas por valor en un mapa
- Para cada grupo con 3+ cartas: las marca como combinadas
- Elimina los grupos encontrados de la mano

---

### 3️⃣ `findRuns(List<Card> auxiliarHand)` (privado)

**Tipo**: Método privado

**Descripción**: Encuentra y elimina escaleras secuenciales de 3+ cartas del mismo palo.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `auxiliarHand` | List<Card> | Mano a procesar |

**Lógica**:
- Agrupa cartas por palo
- Para cada grupo: ordena por valor
- Busca secuencias consecutivas de 3+ cartas
- Elimina las escaleras encontradas de la mano

---

### 4️⃣ `findChinchon(List<Card> hand)`

**Tipo**: Método público

**Retorna**: `boolean` - true si hay Chinchón, false en caso contrario

**Descripción**: Verifica si la mano contiene un Chinchón (7 cartas en escalera).

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `hand` | List<Card> | Mano a verificar |

**Lógica**:
- Verifica si existe una escalera de exactamente 7 cartas del mismo palo

---

### 5️⃣ `canClose(List<Card> hand)`

**Tipo**: Método público

**Retorna**: `boolean` - true si puede cerrar, false si no

**Descripción**: Verifica si el jugador puede cerrar la ronda.

**Condiciones para cerrar**:
- Tiene 0 cartas sin combinar, O
- La mayor carta sin combinar tiene valor 1-5

---

### 6️⃣ `getCombinedCards(List<Card> hand)`

**Tipo**: Método público

**Retorna**: `List<Card>` - Lista de cartas que forman combinaciones

**Descripción**: Obtiene las cartas que forman combinaciones válidas.

**Lógica**:
- Similar a calculateUncombinedCards pero retorna las cartas combinadas
- Retorna todas las cartas que están en grupos o escaleras

---

### 7️⃣ `getBestDiscard(List<Card> hand)`

**Tipo**: Método público

**Retorna**: `Card` - La mejor carta para descartar

**Descripción**: Determina la mejor carta para descartar según la estrategia de la IA.

**Estrategia**:
- Analiza cada carta de la mano
- Calcula la puntuación resultante si se descarta cada una
- Retorna la carta cuyo descarte produce la menor puntuación
- En caso de empate: retorna la carta de mayor valor
