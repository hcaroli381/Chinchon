## Card

Clase que representa una carta individual de la baraja española. Contiene el palo y valor de la carta, además de un estado que indica si está combinada o no.

### Funciones

1. **Card(Suit suit, Value value)**

   Constructor que inicializa una carta.

   - Asigna el palo (suit) de la carta
   - Asigna el valor (value) de la carta
   - Inicializa la bandera combined como false (sin combinar)

2. **toString()**

   Responsabilidad: Representar la carta como texto con colores.

   - Si la carta está combinada: la muestra con color verde (Colors.GREEN)
   - Si no está combinada: la muestra en color normal
   - Formato: "número de palo" o "número de palo" según sea combinada

3. **getSuit()**

   Responsabilidad: Obtener el palo de la carta.

   - Retorna el enum Suit de la carta

4. **getValue()**

   Responsabilidad: Obtener el valor de la carta.

   - Retorna el enum Value de la carta

5. **setCombined(boolean combined)**

   Responsabilidad: Establecer el estado de combinación de la carta.

   - Actualiza la bandera que indica si la carta está combinada en una escalera o grupo

6. **compareTo(Card other)**

   Responsabilidad: Comparar esta carta con otra (implementa Comparable<Card>).

   - Primero compara por palo (suit)
   - Si los palos son iguales, compara por valor numérico
   - Retorna un valor negativo si esta carta es menor, 0 si son iguales, positivo si es mayor
