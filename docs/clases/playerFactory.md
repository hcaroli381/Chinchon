# 🏭 PlayerFactory

> **Responsabilidad**: Crear instancias de jugadores.

**Paquete**: `chinchon.dominio`

**Patrón**: Factory Method

**Descripción**: Centraliza la lógica de creación de jugadores (Human o AI) basándose en su tipo, facilitando la extensión futura del código.

---

## Métodos

### 1️⃣ `createPlayer(PlayerType type, String name, List<Card> hand, HandAnalyzer handAnalyzer)` (estático)

**Tipo**: Método estatico (Factory Method)

**Retorna**: `Player` - Instancia del jugador creado

**Descripción**: Crea un jugador del tipo especificado.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `type` | PlayerType | Tipo de jugador a crear (HUMAN o AI) |
| `name` | String | Nombre del jugador |
| `hand` | List<Card> | Mano inicial del jugador |
| `handAnalyzer` | HandAnalyzer | Analizador de manos |

**Lógica**:
- Switch sobre el tipo de jugador:
  - **HUMAN**: Crea instancia de `Human`
  - **AI**: Crea instancia de `AI`
  - **Desconocido**: Lanza `IllegalArgumentException`
- Retorna la instancia del jugador creado (puntuación inicial: 0)

---

## Ventajas del Patrón Factory

✅ Centraliza la lógica de creación de objetos  
✅ Facilita agregar nuevos tipos de jugadores sin modificar código existente  
✅ Mantiene bajo acoplamiento entre creador y usuarios  
✅ Simplifica el cambio de implementación
