## ConsoleInput

Clase encargada de gestionar la entrada de datos del usuario a través de la consola. Proporciona métodos robustos para leer enteros y valores booleanos con validación de errores.

### Funciones

1. **ConsoleInput(Scanner keyboard)**

   Constructor que inicializa la clase con un Scanner.

   - Recibe un objeto Scanner como parámetro
   - Lo almacena como variable de instancia

2. **readInt()**

   Responsabilidad: Leer un entero válido del usuario con manejo de errores.

   - Bucle de validación que continúa hasta recibir un entero válido
   - Si hay excepción, muestra mensaje de error y limpia el buffer
   - Retorna el número entero leído

3. **readIntLessThan(int upperBound)**

   Responsabilidad: Leer un entero que sea menor que un valor específico.

   - Pide al usuario que introduzca un entero menor que upperBound
   - Valida que el valor sea menor que el límite
   - Si no es válido, muestra error y pide nuevamente
   - Retorna el entero válido

4. **readIntLessOrEqualThan(int upperBound)**

   Responsabilidad: Leer un entero que sea menor o igual que un valor específico.

   - Similar a readIntLessThan pero permite igualdad
   - Pide al usuario que introduzca un entero menor o igual que upperBound
   - Valida que el valor sea menor o igual al límite
   - Retorna el entero válido

5. **readBooleanUsingChar(char charTrue, char charFalse, String prompt)**

   Responsabilidad: Leer un valor booleano basado en caracteres específicos.

   - Muestra el mensaje del prompt
   - Lee enteros hasta que el usuario introduzca el carácter correcto
   - Retorna true si introduce charTrue, false si introduce charFalse

6. **cleanInput()**

   Responsabilidad: Limpiar el buffer de entrada del Scanner.

   - Consume la línea restante del Scanner
   - Se usa después de cada lectura para evitar problemas de sincronización
