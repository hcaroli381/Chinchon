# 📝 ConsoleInput

> **Responsabilidad**: Gestionar la entrada de datos del usuario a través de la consola con validación robusta de errores.

**Paquete**: `chinchon.app`

**Descripción**: Proporciona métodos seguros para leer enteros y valores booleanos desde la consola, con manejo completo de excepciones y validación de límites.

---

## Métodos

### 1️⃣ `ConsoleInput(Scanner keyboard)`

**Tipo**: Constructor

**Descripción**: Inicializa la clase con un Scanner para entrada del usuario.

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `keyboard` | Scanner | Scanner para leer entrada |

---

### 2️⃣ `readInt()`

**Tipo**: Método público

**Retorna**: `int` - Entero válido leído del usuario

**Descripción**: Lee un entero válido del usuario con validación de errores.

**Lógica**:
- Bucle de validación hasta recibir un entero válido
- Si hay excepción, muestra mensaje de error y limpia buffer
- Retorna el número entero leído

---

### 3️⃣ `readIntLessThan(int upperBound)`

**Tipo**: Método público

**Retorna**: `int` - Entero menor que `upperBound`

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `upperBound` | int | Límite superior (exclusivo) |

**Descripción**: Lee un entero que sea estrictamente menor que un valor específico.

**Lógica**:
- Pide entrada al usuario
- Valida que sea menor que el límite
- Muestra error si no es válido
- Retorna el entero válido

---

### 4️⃣ `readIntLessOrEqualThan(int upperBound)`

**Tipo**: Método público

**Retorna**: `int` - Entero menor o igual que `upperBound`

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `upperBound` | int | Límite superior (inclusivo) |

**Descripción**: Lee un entero que sea menor o igual a un valor específico.

---

### 5️⃣ `readBooleanUsingChar(char charTrue, char charFalse, String prompt)`

**Tipo**: Método público

**Retorna**: `boolean` - true si introduce `charTrue`, false si introduce `charFalse`

| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `charTrue` | char | Carácter para verdadero |
| `charFalse` | char | Carácter para falso |
| `prompt` | String | Mensaje a mostrar al usuario |

**Descripción**: Lee un valor booleano basado en caracteres específicos del usuario.

**Lógica**:
- Muestra el prompt al usuario
- Lee enteros hasta que introduzca el carácter correcto
- Retorna true/false según corresponda

---

### 6️⃣ `cleanInput()` (privado)

**Tipo**: Método privado

**Descripción**: Limpia el buffer de entrada del Scanner.

**Lógica**:
- Consume la línea restante con `nextLine()`
- Se utiliza después de cada lectura para evitar desincronización
