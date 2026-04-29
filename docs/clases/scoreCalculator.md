# 🏆 ScoreCalculator

> **Responsabilidad**: Calcular la puntuación y determinar el final de la partida.

**Paquete**: `chinchon.app`

**Descripción**: Gestiona la puntuación durante las rondas y determina cuándo la partida ha terminado, ya sea por puntuación o por Chinchón.

---

## Métodos

### 1️⃣ `ScoreCalculator(GameManager gameState, HandAnalyzer handAnalyzer)`

**Tipo**: Constructor

**Descripción**: Inicializa el calculador de puntuación.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `gameState` | GameManager | Gestor del estado del juego |
| `handAnalyzer` | HandAnalyzer | Analizador de manos |

---

### 2️⃣ `checkGameEnd()`

**Tipo**: Método público

**Retorna**: `boolean` - true si la partida ha terminado

**Descripción**: Verifica si la partida ha terminado.

**Condiciones de finalización**:
- Quedan 1 o menos jugadores en juego
- Un jugador ha conseguido un Chinchón

**Lógica**:
- Verifica if hay 1 o menos jugadores → llama a `pointsGameEnd()`
- Verifica si el primer jugador tiene Chinchón → llama a `chinchonGameEnd()`
- Retorna true si se cumple alguna condición, false en caso contrario

---

### 3️⃣ `pointsGameEnd()` (privado)

**Tipo**: Método privado

**Descripción**: Maneja el final de la partida cuando se alcanza el límite de puntuación.

**Lógica**:
- Muestra el mensaje "FIN DE LA PARTIDA"
- Ordena los jugadores por puntuación de mayor a menor
- Anuncia al ganador (jugador con la menor puntuación)
- Muestra la puntuación final

---

### 4️⃣ `chinchonGameEnd()` (privado)

**Tipo**: Método privado

**Descripción**: Maneja el final de la partida cuando alguien consigue Chinchón.

**Lógica**:
- Muestra el mensaje "FIN DE LA PARTIDA"
- Ordena los jugadores por puntuación de menor a mayor
- Para cada jugador muestra:
  - Si tiene Chinchón: "CHINCHON!!"
  - Si no: su puntuación de la ronda
