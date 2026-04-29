# 🎭 PlayerType (Enum)

> **Responsabilidad**: Definir tipos de jugadores disponibles.

**Paquete**: `chinchon.dominio`

**Descripción**: Enum que especifica los tipos de jugadores que pueden crearse en el juego.

---

## Valores

| Tipo | Descripción |
|------|-------------|
| **HUMAN** | Jugador controlado por un usuario humano que interactúa a través de la consola |
| **AI** | Jugador controlado por inteligencia artificial que juega de forma autónoma |

---

## Uso

Se utiliza junto con `PlayerFactory` para especificar qué tipo de jugador se desea crear:

```java
Player player = PlayerFactory.createPlayer(PlayerType.HUMAN, "Juan", hand, analyzer);
Player bot = PlayerFactory.createPlayer(PlayerType.AI, "Bot", hand, analyzer);
```

---

## Propósito

Este enum asegura que solo existan tipos de jugadores válidos en la aplicación, proporcionando type-safety y facilitando la extensión futura a nuevos tipos de jugadores.
