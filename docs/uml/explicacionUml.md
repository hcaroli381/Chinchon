### 🏗️ **Diseño Detallado del UML**

#### **1. Patrones de Diseño en el Diagrama**
El UML refleja **dos patrones clave** que estructuran el proyecto:

- **Singleton (`GameEngine`)**:
  - **En el UML**: Se representa con un **atributo estático** (`- instance: GameEngine`) y un método estático (`+ getInstance(): GameEngine`).
  - **Relación en el diagrama**: `GameEngine` tiene **composición** con todas sus dependencias (`GameManager`, `GameLoop`, etc.), lo que significa que **no pueden existir sin él**.
  - **Impacto en el UML**: Reduce la complejidad del diagrama al evitar múltiples instancias de `GameEngine` conectadas a otros componentes.

- **Factory Method (`PlayerFactory`)**:
  - **En el UML**: Aparece como una **clase independiente** con un método de creación (`+ createPlayer(): Player`).
  - **Relación en el diagrama**: `GameManager` **depende** de `PlayerFactory` , pero **no la contiene**. Esto indica que la usa **temporalmente** para crear jugadores.
  - **Impacto en el UML**: Permite que `GameManager` no tenga acoplamiento directo con `Human` o `AI`, simplificando las relaciones en el diagrama.

---

#### **2. Tipos de Relaciones y su Significado**
El UML utiliza **tres tipos de relaciones** para representar cómo interactúan las clases:
   **Tipo**          | **Símbolo en UML**       | **Ejemplo en Chinchón**                     | **Implicación**                                                                                     |
 |-------------------|--------------------------|--------------------------------------------|---------------------------------------------------------------------------------------------------|
 | **Composición**   | Diamante negro (●)       | `GameEngine` —● `GameManager`               | `GameManager` **no puede existir** sin `GameEngine`. Si se destruye `GameEngine`, `GameManager` también. |
 | **Agregación**    | Diamante blanco (◇)      | `GameManager` ◇— `Player`                   | `Player` **puede existir** sin `GameManager` (ej: un jugador creado pero no asignado a un juego).    |
 | **Dependencia**   | Flecha discontinua (---->)| `GameManager` ---> `PlayerFactory`           | `GameManager` **usa** `PlayerFactory` temporalmente (ej: para crear jugadores).                   |

- **¿Por qué composición en `GameEngine`?**
  `GameEngine` es el **núcleo del juego** y necesita garantizar que sus componentes (`GameManager`, `GameLoop`, etc.) estén siempre disponibles y sincronizados. La composición asegura que:
  - Las dependencias se crean y destruyen **junto a `GameEngine`**.
  - Se cumple el **principio de responsabilidad única**: `GameEngine` no gestiona la lógica de `GameManager`, pero sí su ciclo de vida.

- **¿Por qué agregación en `GameManager` con `Player`?**
  Los jugadores (`Human`/`AI`) pueden **existir fuera del contexto de un juego**. La agregación permite:
  - Reutilizar instancias de `Player` en diferentes partidas.
  - Separar jugadores de la gestión del juego.

- **¿Por qué dependencia en `GameManager` con `PlayerFactory`?**
  `PlayerFactory` es una **herramienta temporal** para crear jugadores. `GameManager` no necesita poseerla, solo usarla cuando sea necesario. Esto:
  - Reduce el acoplamiento.
  - Facilita el **cambio de implementación**.

---

#### **3. Cardinalidad: ¿Qué Significa en el Juego?**
La cardinalidad en el UML define **cuántas instancias de una clase se relacionan con otra**. En Chinchón:
 | **Relación**               | **Cardinalidad** | **Ejemplo**                          | **Explicación**                                                                                     |
 |----------------------------|------------------|--------------------------------------|---------------------------------------------------------------------------------------------------|
 | `GameEngine` — `GameManager`| 1..1             | 1 `GameEngine` tiene 1 `GameManager` | Un juego solo puede tener **un gestor de estado** a la vez.                                       |
 | `GameManager` — `Player`    | 1..*             | 1 `GameManager` gestiona N `Player`   | Un juego puede tener **de 2 a 5 jugadores** (según las reglas).                                     |
 | `GameManager` — `Deck`      | 1..1             | 1 `GameManager` tiene 1 `Deck`        | Cada partida usa **un mazo principal**, aunque puede haber 1 o 2 barajas físicas (80 cartas).     |
 | `Deck` — `Card`             | 1..*             | 1 `Deck` contiene N `Card`           | Un mazo tiene **40 o 80 cartas** (según el número de jugadores).                                   |
 | `Player` — `Card`           | 1..7             | 1 `Player` tiene 7 `Card`            | Cada jugador siempre tiene **7 cartas** en su mano durante el juego.                              |

- **Casos especiales**:
  - **`DeckManager` y los descartes**: Aunque el UML no lo muestra explícitamente, `DeckManager` gestiona una **lista de cartas de descarte** (cardinalidad `0..*`), ya que puede estar vacía o contener múltiples cartas.

---

#### **4. Separación de Paquetes: `app` vs `dominio`**
El UML **agrupa las clases en dos paquetes** con propósitos distintos:

- **Paquete `app`**:
  - **Contenido**: Clases de **control y coordinación** (`GameEngine`, `GameManager`, `GameLoop`, etc.).
  - **En el UML**: Aparecen como un **grupo lógico** con relaciones de composición/agregación entre sí.
  - **Objetivo**: Gestionar el **flujo del juego** (turnos, rondas, puntuaciones).

- **Paquete `dominio`**:
  - **Contenido**: Clases de **negocio y datos** (`Player`, `Card`, `Deck`, `HandAnalyzer`, etc.).
  - **En el UML**: Aparecen como un **grupo independiente**, con relaciones de herencia (ej: `Human` y `AI` heredan de `Player`) y dependencia (ej: `HandAnalyzer` depende de `Card`).
  - **Objetivo**: Representar las **reglas y elementos del juego** (cartas, jugadores, combinaciones).

- **Relación entre paquetes**:
  - `app` **depende** de `dominio` (flecha discontinua de `GameManager` a `Player`).
  - **Nunca al revés**: Las clases de `dominio` **no conocen** a las de `app`. Esto garantiza que:
    - El dominio sea **reutilizable** (ej: en otro juego de cartas).
    - El código sea más **fácil de testear** (el dominio no depende de la interfaz de usuario).

---
#### **5. Herencia en el UML**
El diagrama muestra **herencia** en el paquete `dominio`:
- **`Player` (clase abstracta)**:
  - **En el UML**: Aparece con el estereotipo `<<abstract>>` y métodos abstractos (ej: `+ playTurn(): void`).
  - **Subclases**: `Human` y `AI` **heredan** de `Player` (flecha con punta triangular).
  - **Ventaja**:
    - **Polimorfismo**: `GameManager` puede tratar a todos los jugadores como `Player`, sin importar su tipo.
    - **Extensibilidad**: Se pueden añadir nuevos tipos de jugadores (ej: `BotAvanzado`) sin modificar el código existente.

---
#### **6. Atributos y Métodos Clave en el UML**
El diagrama incluye **atributos y métodos** que definen el comportamiento de las clases:
 | **Clase**         | **Atributo/Método**               | **Significado en el UML**                                                                 |
 |-------------------|-----------------------------------|-----------------------------------------------------------------------------------------|
 | `GameEngine`      | `- instance: GameEngine`          | Atributo **estático** (Singleton).                                                       |
 |                   | `+ getInstance(): GameEngine`     | Método **estático** para acceder a la instancia única.                                  |
 | `PlayerFactory`   | `+ createPlayer(type: PlayerType): Player` | Método de **fábrica** que devuelve un `Player` según el tipo.                          |
 | `Deck`            | `- cards: List<Card>`             | **Composición**: `Deck` **contiene** cartas.                                            |
 |                   | `+ drawCard(): Card`              | Método para **robar una carta** del mazo.                                               |
 | `HandAnalyzer`    | `+ canClose(hand: List<Card>): boolean` | Método para **validar si una mano cumple las reglas de cierre**.                     |

---
#### **7. Decisiones de Diseño Reflejadas en el UML**
 | **Decisión**                     | **Cómo se Ve en el UML**                          | **Beneficio**                                                                             |
 |----------------------------------|--------------------------------------------------|-----------------------------------------------------------------------------------------|
 | **Singleton en `GameEngine`**    | Atributo estático + método `getInstance()`.       | Control centralizado del juego.                                                          |
 | **Factory Method**               | `PlayerFactory` con método `createPlayer()`.      | Desacoplamiento entre `GameManager` y las clases concretas de jugadores.               |
 | **Separación `app`/`dominio`**    | Dos paquetes distintos en el diagrama.           | Reutilización del dominio y facilidad de testing.                                       |
 | **Composición en `GameEngine`**  | Diamantes negros hacia `GameManager`, `GameLoop`, etc. | Garantiza que las dependencias existan durante toda la vida del juego.                 |
 | **Agregación en `GameManager`**   | Diamante blanco hacia `Player`.                   | Permite que los jugadores existan fuera del contexto de un juego.                      |
 | **Herencia en `Player`**         | Flecha triangular de `Human` y `AI` a `Player`.     | Polimorfismo y extensibilidad.                                                          |

---
#### **8. ¿Qué NO está en el UML? (y por qué)**
- **Métodos privados**: No se muestran en el UML para simplificar el diagrama (ej: `GameEngine` tiene métodos privados para inicializar componentes).
- **Atributos transitorios**: No se incluyen atributos temporales (ej: `hand` en `Player` podría ser un parámetro en métodos en lugar de un atributo).
- **Interfaces**: No se usan interfaces explícitas (ej: `IPlayer`), pero el diseño permite implementarlas en el futuro si es necesario.
- **Clases de utilidad**: `Colors` y `GameConstants` no aparecen en el UML principal porque son **clases estáticas** sin relaciones complejas.
