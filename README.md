# 🎴 Chinchón

> Un juego de cartas jugado con la baraja española, donde los jugadores intentan formar escaleras o grupos para cerrar y ganar rondas.

---

## 📋 Reglas del Juego

- **Cartas iniciales**: Cada jugador comienza con 7 cartas
- **Turnos**: En cada turno, el jugador elige coger de descartes o baraja boca abajo, luego descarta para mantener 7 cartas
- **Combinaciones válidas**: Mínimo 3 cartas
  - Escaleras del mismo palo
  - Grupos del mismo número
- **Objetivo**: Tener el mínimo número de puntos posible o formar un **Chinchón**
- **Chinchón**: Escalera de 7 cartas (victoria automática)
- **Condición de cierre**: Solo puedes cerrar si tienes una carta sin combinar de valor 1-5, todas las cartas combinadas, o Chinchón
- **Puntuación de ronda**:
  - Cartas sin combinar: Se suma su valor a la puntuación total
  - Todas combinadas: Se restan 10 puntos
  - Chinchón: Victoria automática de la partida
- **Eliminación**: Un jugador es eliminado al alcanzar 100 puntos
- **Ganador**: El último jugador en pie

---

## ⚙️ Características del Proyecto

- ✅ Nomenclatura de funciones, clases y variables completamente en **inglés**
- ✅ Interfaz de usuario mediante consola (`ConsoleInput`)
- ✅ Patrón Singleton para `GameEngine`
- ✅ Factory Pattern para creación de jugadores
- ✅ Soporte para jugadores humanos e IA
- ✅ Colores ANSI en la salida de consola

---

## 📁 Estructura del Proyecto

```
Chinchon
├─ docs/
│  ├─ clases/
│  │  ├─ gameEngine.md
│  │  ├─ gameLoop.md
│  │  ├─ gameManager.md
│  │  ├─ scoreCalculator.md
│  │  ├─ deckManager.md
│  │  ├─ consoleInput.md
│  │  ├─ main.md
│  │  ├─ player.md
│  │  ├─ human.md
│  │  ├─ ai.md
│  │  ├─ handAnalyzer.md
│  │  ├─ card.md
│  │  ├─ deck.md
│  │  ├─ gameConstants.md
│  │  ├─ suit.md
│  │  ├─ value.md
│  │  ├─ colors.md
│  │  ├─ playerFactory.md
│  │  └─ playerType.md
│  └─ chinchonUML.png
├─ README.md
├─ src/
│  └─ chinchon/
│     ├─ app/
│     │  ├─ ConsoleInput.java
│     │  ├─ DeckManager.java
│     │  ├─ GameEngine.java
│     │  ├─ GameLoop.java
│     │  ├─ GameManager.java
│     │  ├─ Main.java
│     │  └─ ScoreCalculator.java
│     └─ dominio/
│        ├─ AI.java
│        ├─ Card.java
│        ├─ Colors.java
│        ├─ Deck.java
│        ├─ GameConstants.java
│        ├─ HandAnalyzer.java
│        ├─ Human.java
│        ├─ Player.java
│        ├─ PlayerFactory.java
│        ├─ PlayerType.java
│        ├─ Suit.java
│        └─ Value.java
└─ test/
   └─ dominio/
      ├─ DeckManagerTest.java
      ├─ DeckTest.java
      ├─ HandAnalyzerTest.java
      ├─ PlayerFactoryTest.java
      └─ PlayerTest.java
```

---

## 📚 Explicación de Clases

Para una explicación detallada de cada clase, haz click en su nombre.

### 🎮 Clases de la Aplicación (app)

Estas clases controlan el flujo general del juego:

| Clase | Descripción |
|-------|-------------|
| [**GameEngine**](docs/clases/gameEngine.md) | Clase principal usando patrón Singleton. Coordina el flujo general del juego. |
| [**GameManager**](docs/clases/gameManager.md) | Gestiona el estado del juego (jugadores, mazo, descartes). |
| [**GameLoop**](docs/clases/gameLoop.md) | Ejecuta el bucle principal de turnos y rondas. |
| [**ScoreCalculator**](docs/clases/scoreCalculator.md) | Calcula puntuaciones y determina el final de la partida. |
| [**DeckManager**](docs/clases/deckManager.md) | Administra la baraja y su preparación. |
| [**ConsoleInput**](docs/clases/consoleInput.md) | Gestiona la entrada del usuario desde la consola. |
| [**Main**](docs/clases/main.md) | Punto de entrada de la aplicación. |

### 👥 Clases de Jugadores (dominio)

Implementan la lógica de diferentes tipos de jugadores:

| Clase | Descripción |
|-------|-------------|
| [**Player**](docs/clases/player.md) | Clase abstracta base para todos los jugadores. |
| [**Human**](docs/clases/human.md) | Jugador humano con control interactivo. |
| [**AI**](docs/clases/ai.md) | Jugador controlado por inteligencia artificial. |
| [**PlayerFactory**](docs/clases/playerFactory.md) | Factory para crear jugadores del tipo especificado. |
| [**PlayerType**](docs/clases/playerType.md) | Enum con tipos de jugadores disponibles. |

### 🃏 Clases de Cartas y Baraja (dominio)

Representan los elementos de la baraja:

| Clase | Descripción |
|-------|-------------|
| [**Card**](docs/clases/card.md) | Representa una carta individual con palo y valor. |
| [**Deck**](docs/clases/deck.md) | Gestiona la baraja y sus operaciones. |
| [**Suit**](docs/clases/suit.md) | Enum con los cuatro palos de la baraja española. |
| [**Value**](docs/clases/value.md) | Enum con los valores de las cartas. |

### 🔧 Clases de Análisis y Utilidades (dominio)

Proporcionan funcionalidad auxiliar:

| Clase | Descripción |
|-------|-------------|
| [**HandAnalyzer**](docs/clases/handAnalyzer.md) | Analiza manos, detecta combinaciones y calcula puntuación. |
| [**GameConstants**](docs/clases/gameConstants.md) | Constantes centralizadas del juego. |
| [**Colors**](docs/clases/colors.md) | Códigos ANSI para colorear la salida de consola. |

---

## 🚀 Cómo Ejecutar

1. Compila el proyecto
2. Ejecuta la clase `Main`
3. Sigue las instrucciones en consola

---

## 📝 Notas de Desarrollo

- El proyecto usa la baraja española estándar (40 cartas)
- La IA toma decisiones basadas en análisis de puntuación
- Se incluyen colores ANSI para mejor experiencia visual en la consola




