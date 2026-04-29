package chinchon.app;

import java.util.Scanner;

/**
 * Encapsula la lectura segura de datos por consola y aplica validaciones básicas.
 */
public class ConsoleInput {
	private Scanner keyboard;

	public ConsoleInput(Scanner keyboard) {
		this.keyboard = keyboard;
	}

	private void cleanInput() {
		keyboard.nextLine();
	}

	public int readInt() {
		int resultado = 0;
		boolean hayError = true;
		do {
			try {
				resultado = keyboard.nextInt();
				cleanInput();
				hayError = false;
			} catch (Exception e) {
				System.err.println("Error: Introduce un número entero válido.");
				cleanInput();
			}
		} while (hayError);
		return resultado;
	}

	public int readIntLessThan(int upperBound) {
		int valor;
		System.out.printf("Introduce un entero menor que %d: ", upperBound);
		do {
			valor = readInt();
			if (valor >= upperBound) {
				System.err.printf("Error: %d no es menor que %d. Inténtalo de nuevo: ", valor, upperBound);
			}
		} while (valor >= upperBound);
		return valor;
	}

	public int readIntLessOrEqualThan(int upperBound) {
		int valor;
		System.out.printf("Introduce un entero menor o igual que %d: ", upperBound);
		do {
			valor = readInt();
			if (valor > upperBound) {
				System.err.printf("Error: %d no es menor o igual que %d. Inténtalo de nuevo: ", valor, upperBound);
			}
		} while (valor > upperBound);
		return valor;
	}

	public int readIntGreaterThan(int lowerBound) {
		int valor;
		System.out.printf("Introduce un número entero mayor que %d: ", lowerBound);
		do {
			valor = readInt();
			if (valor <= lowerBound) {
				System.err.printf("Error: %d no es mayor que %d. Inténtalo de nuevo: ", valor, lowerBound);
			}
		} while (valor <= lowerBound);
		return valor;
	}

	public int readIntGreaterOrEqualThan(int lowerBound) {
		int valor;
		System.out.printf("Introduce un número entero mayor o igual que %d: ", lowerBound);
		do {
			valor = readInt();
			if (valor < lowerBound) {
				System.err.printf("Error: %d no es mayor o igual que %d. Inténtalo de nuevo: ", valor, lowerBound);
			}
		} while (valor < lowerBound);
		return valor;
	}

	/**
	 * Lee un entero comprendido dentro de un rango cerrado.
	 * 
	 * @param lowerBound valor minimo
	 * @param upperBound valor máximo
	 * @return entero leído por consola y validado
	 */
	public int readIntInRange(int lowerBound, int upperBound) {
		int valor;
		System.out.printf("Introduce un entero entre %d y %d: ", lowerBound, upperBound);
		do {
			valor = readInt();
			if (valor < lowerBound || valor > upperBound) {
				System.err.printf("Error: %d no está entre %d y %d. Inténtalo de nuevo: ", valor, lowerBound,
						upperBound);
			}
		} while (valor < lowerBound || valor > upperBound);
		return valor;
	}

	public double readDouble() {
		double resultado = 0.0;
		boolean hayError = true;
		do {
			try {
				resultado = keyboard.nextDouble();
				hayError = false;
			} catch (Exception e) {
				System.err.println("Error: Introduce un número decimal válido.");
				cleanInput();
			}
		} while (hayError);
		return resultado;
	}

	public double readDoubleLessThan(double upperBound) {
		double valor;
		System.out.printf("Introduce un decimal menor que %f: ", upperBound);
		do {
			valor = readDouble();
			if (valor >= upperBound) {
				System.err.printf("Error: %f no es menor que %f. Inténtalo de nuevo: ", valor, upperBound);
			}
		} while (valor >= upperBound);
		return valor;
	}

	public double readDoubleLessOrEqualThan(double upperBound) {
		double valor;
		System.out.printf("Introduce un decimal menor o igual que %f: ", upperBound);
		do {
			valor = readDouble();
			if (valor > upperBound) {
				System.err.printf("Error: %f no es menor o igual que %f. Inténtalo de nuevo: ", valor, upperBound);
			}
		} while (valor > upperBound);
		return valor;
	}

	public double readDoubleGreaterThan(double lowerBound) {
		double valor;
		System.out.printf("Introduce un decimal mayor que %f: ", lowerBound);
		do {
			valor = readDouble();
			if (valor <= lowerBound) {
				System.err.printf("Error: %f no es mayor que %f. Inténtalo de nuevo: ", valor, lowerBound);
			}
		} while (valor <= lowerBound);
		return valor;
	}

	public double readDoubleGreaterOrEqualThan(double lowerBound) {
		double valor;
		System.out.printf("Introduce un decimal mayor o igual que %f: ", lowerBound);
		do {
			valor = readDouble();
			if (valor < lowerBound) {
				System.err.printf("Error: %f no es mayor o igual que %f. Inténtalo de nuevo: ", valor, lowerBound);
			}
		} while (valor < lowerBound);
		return valor;
	}

	public double readDoubleInRange(double lowerBound, double upperBound) {
		double valor;
		System.out.printf("Introduce un decimal entre %f y %f: ", lowerBound, upperBound);
		do {
			valor = readDouble();
			if (valor < lowerBound || valor > upperBound) {
				System.err.printf("Error: %f no está entre %f y %f. Inténtalo de nuevo: ", valor, lowerBound,
						upperBound);
			}
		} while (valor < lowerBound || valor > upperBound);
		return valor;
	}

	public char readChar() {
		String s;
		char c = ' ';
		boolean hayError = true;
		do {
			try {
				s = keyboard.next();
				if (s.length() != 1) {
					System.err.println("Error: Debes introducir exactamente un carácter.");
				} else {
					c = s.charAt(0);
					hayError = false;
				}
			} catch (Exception e) {
				System.err.println("Error al leer el carácter.");
				cleanInput();
			}
		} while (hayError);
		return c;
	}

	public String readString() {
		String resultado = "";

		while (resultado.isEmpty()) {
			resultado = keyboard.nextLine().trim();
		}
		return resultado;
	}

	/**
	 * Lee una cadena con una longitud máxima permitida.
	 * 
	 * @param maxLength longitud límite
	 * @return cadena leída por la consola
	 */
	public String readString(int maxLength) {
		String s;
		System.out.printf("Introduce una cadena (máximo %d caracteres): ", maxLength);
		do {
			s = readString();
			if (s.length() > maxLength) {
				System.err.printf("Error: La longitud es %d, supera el máximo de %d. Inténtalo de nuevo: ", s.length(),
						maxLength);
			}
		} while (s.length() > maxLength);
		return s;
	}

	public boolean readBooleanUsingChar(char affirmativeValue, char negativeValue) {
	/**
	 * Lee una respuesta binaria a partir de dos caracteres permitidos.
	 *
	 * @param affirmativeValue carácter que representa {@code true}
	 * @param negativeValue    carácter que representa {@code false}
	 * @param mensaje          mensaje que se muestra al usuario antes de leer
	 * @return {@code true} si se introduce el carácter afirmativo
	 */
		char c;
		char aff = Character.toLowerCase(affirmativeValue);
		char neg = Character.toLowerCase(negativeValue);

		System.out.printf("Introduce '%c' para Sí o '%c' para No: ", affirmativeValue, negativeValue);

		do {
			c = Character.toLowerCase(readChar());
			if (c != aff && c != neg) {
				System.err.printf("Opción no válida. Introduce '%c' o '%c': ", affirmativeValue, negativeValue);
			}
		} while (c != aff && c != neg);

		return c == aff;
	}

	/**
	 * Peticion de si o no con mensaje personalizado
	 * 
	 * @param affirmativeValue caracter para true
	 * @param negativeValue    caracter para false
	 * @param mensaje          para pedir al usuario
	 * @return true/false segun caracter introducido
	 */
	public boolean readBooleanUsingChar(char affirmativeValue, char negativeValue, String mensaje) {
		char c;
		char aff = Character.toLowerCase(affirmativeValue);
		char neg = Character.toLowerCase(negativeValue);

		System.out.println(mensaje);

		do {
			c = Character.toLowerCase(readChar());
			if (c != aff && c != neg) {
				System.err.printf("Opción no válida. Introduce '%c' o '%c': ", affirmativeValue, negativeValue);
			}
		} while (c != aff && c != neg);

		return c == aff;
	}

	/**
	 * Lee una opción de menú dentro de un intervalo válido.
	 *
	 * @param minOption opción mínima aceptada
	 * @param maxOption opción máxima aceptada
	 * @return opción elegida por el usuario
	 */
	public int readMenuOption(int minOption, int maxOption) {
		int opcion;
		System.out.printf("Seleccione una opción [%d - %d]: ", minOption, maxOption);
		do {
			opcion = readInt();
			if (opcion < minOption || opcion > maxOption) {
				System.err.println("Opción no válida. Por favor, elija una opción del menú.");
			}
		} while (opcion < minOption || opcion > maxOption);
		return opcion;
	}

	/**
	 * Lee una respuesta de sí o no usando los caracteres 's' y 'n'.
	 *
	 * @param message mensaje que se mostrará al usuario
	 * @return {@code true} si la respuesta es afirmativa
	 */
	public boolean readYesNo(String message) {
		System.out.println(message + " (s/n): ");
		char c;
		boolean respuesta = false;
		boolean entradaValida = false;

		System.out.printf("%s (s/n)", message);
		do {
			c = Character.toLowerCase(readChar());
			if (c == 's') {
				respuesta = true;
				entradaValida = true;
			} else if (c == 'n') {
				respuesta = false;
				entradaValida = true;
			} else {
				System.err.println("Por favor, introduce 's' para sí o 'n' para no.");
			}
		} while (!entradaValida);

		return respuesta;
	}
}
