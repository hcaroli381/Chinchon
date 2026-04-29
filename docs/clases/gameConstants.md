# ⚙️ GameConstants

> **Responsabilidad**: Centralizar todas las constantes del juego.

**Paquete**: `chinchon.dominio`

**Descripción**: Almacena valores de configuración clave del juego. Cambiar estos valores aquí afecta automáticamente a toda la aplicación.

---

## Constantes

| Constante | Valor | Descripción |
|-----------|-------|-------------|
| **MAX_PLAYERS** | 5 | Número máximo de jugadores permitidos |
| **MIN_PLAYERS** | 2 | Número mínimo de jugadores requeridos |
| **ELIMINATION_SCORE** | 100 | Puntuación máxima antes de ser eliminado |
| **INITIAL_CARDS_PER_PLAYER** | 7 | Cartas iniciales por jugador en cada ronda |

---

## Propósito

Esta clase centraliza todos los valores de configuración clave del juego. Al cambiar cualquier constante aquí, el cambio se refleja automáticamente en toda la aplicación, facilitando el mantenimiento y la personalización del juego.

**Ventajas**:
- ✅ Fácil mantenimiento centralizado
- ✅ Cambios globales sin buscar en múltiples archivos
- ✅ Mejor legibilidad del código
- ✅ Permite configuración rápida del juego
