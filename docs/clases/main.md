## Main

Clase principal del programa que actúa como punto de entrada para la aplicación. Se encarga de inicializar todos los componentes necesarios y lanzar el juego.

### Funciones

1. **main(String[] args)**

   Responsabilidad: Punto de entrada de la aplicación.

   - Crea un Scanner para leer entrada del usuario
   - Inicializa ConsoleInput con el Scanner
   - Crea un HandAnalyzer para análisis de manos
   - Crea un DeckManager para gestión de baraja
   - Crea la instancia única de GameEngine (patrón Singleton)
   - Obtiene la instancia de GameEngine
   - Inicia el juego llamando a engine.startGame()
   - Captura excepciones en caso de que la instancia no se haya inicializado correctamente
