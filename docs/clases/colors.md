# 🎨 Colors

> **Responsabilidad**: Definir códigos ANSI para colores en consola.

**Paquete**: `chinchon.dominio`

**Descripción**: Centraliza todos los códigos ANSI para mostrar texto coloreado en la consola. Incluye colores básicos, brillantes y fondos de color.

---

## Colores Básicos

| Constante | Código | Uso |
|-----------|--------|-----|
| **BLACK** | \u001B[30m | Negro |
| **RED** | \u001B[31m | Rojo |
| **GREEN** | \u001B[32m | Verde (cartas combinadas) |
| **YELLOW** | \u001B[33m | Amarillo |
| **BLUE** | \u001B[34m | Azul |
| **PURPLE** | \u001B[35m | Púrpura |
| **CYAN** | \u001B[36m | Cian (nombres de jugadores) |
| **WHITE** | \u001B[37m | Blanco |

---

## Colores Brillantes

| Constante | Código | Descripción |
|-----------|--------|-------------|
| **BLACK_BRIGHT** | \u001B[90m | Negro brillante |
| **RED_BRIGHT** | \u001B[91m | Rojo brillante |
| **GREEN_BRIGHT** | \u001B[92m | Verde brillante |
| **YELLOW_BRIGHT** | \u001B[93m | Amarillo brillante |
| **BLUE_BRIGHT** | \u001B[94m | Azul brillante |
| **PURPLE_BRIGHT** | \u001B[95m | Púrpura brillante |
| **CYAN_BRIGHT** | \u001B[96m | Cian brillante |
| **WHITE_BRIGHT** | \u001B[97m | Blanco brillante |

---

## Fondos de Color

Disponibles fondos para todos los colores básicos (40-47):
- **BLACK_BACKGROUND**, **RED_BACKGROUND**, **GREEN_BACKGROUND**, **YELLOW_BACKGROUND**, **BLUE_BACKGROUND**, **PURPLE_BACKGROUND**, **CYAN_BACKGROUND**, **WHITE_BACKGROUND**

---

## Propósito

Esta clase centraliza todos los códigos ANSI para mejorar la presentación visual del juego en consola. Se utiliza para:
- Resaltar nombres de jugadores (CYAN)
- Destacar cartas combinadas (GREEN)
- Mejorar la legibilidad general de la interfaz
