## Value

Enum que representa los valores de las cartas de la baraja española utilizada en el juego Chinchón.

### Valores

1. **UNO** (1)

   Carta de valor 1.

2. **DOS** (2)

   Carta de valor 2.

3. **TRES** (3)

   Carta de valor 3.

4. **CUATRO** (4)

   Carta de valor 4.

5. **CINCO** (5)

   Carta de valor 5.

6. **SEIS** (6)

   Carta de valor 6.

7. **SIETE** (7)

   Carta de valor 7.

8. **SOTA** (10)

   Carta de la figura Sota con valor 10.

9. **CABALLO** (11)

   Carta de la figura Caballo con valor 11.

10. **REY** (12)

    Carta de la figura Rey con valor 12.

### Funciones

1. **Value(int number)**

   Constructor del enum que asigna un valor numérico a cada carta.

   - Asigna el valor que tendrá la carta para cálculos de puntuación

2. **getNumber()**

   Responsabilidad: Obtener el valor numérico de la carta.

   - Retorna el número asociado al valor de la carta
   - Se utiliza para calcular la puntuación y ordenar cartas

### Propósito

Este enum define todos los valores válidos en la baraja española del juego Chinchón, asegurando que solo se utilicen valores correctos y facilitando el cálculo de puntuaciones.
