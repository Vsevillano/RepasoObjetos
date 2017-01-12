package matrices;

/**
 * Crea un objeto matriz que realice las operaciones basicas entre matrices... Sumar, restar, trasponer, multiplicar... y las muestre.
 * 
 * @author Grupo 1
 * @version 1.0
 */
public class Matriz {
	int[][] matriz;

	/**
	 * Constructor que inicializa a 0
	 * 
	 * @param filas
	 *            Numero de filas de la matriz
	 * @param columnas
	 *            Numero de columnas de la matriz
	 */
	public Matriz(int filas, int columnas) {

		if (filas <= 0) { // Los dos if controlan que filas y columnas tengan
							// valores válidos.
			filas = 2;
		}
		if (columnas <= 0) {
			columnas = 2;
		}

		matriz = new int[filas][columnas];
	}

	/**
	 * Constructor que inicializa aleatoriamente entre un max y un min
	 * 
	 * @param filas
	 *            de la matriz
	 * @param columnas
	 *            de la matriz
	 * @param min
	 *            aleatorio a generar
	 * @param max
	 *            aleatorio a generar
	 */
	public Matriz(int filas, int columnas, int min, int max) {

		if (filas <= 0) { // Los dos if controlan que filas y columnas tengan
							// valores válidos.
			filas = 2;
		}
		if (columnas <= 0) {
			columnas = 2;
		}
		if (max < min) { // Controla que el max nunca sea menor que el min
			max = min + 1;
		}
		matriz = new int[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				matriz[i][j] = (int) ((Math.random() * (max - min + 1)) + min);
			}
		}
	}

	/**
	 * Suma dos matrices
	 * 
	 * @param s2
	 *            Matriz sumando
	 * @return Una martriz con el resultado de la suma
	 */
	public Matriz sumar(Matriz s2) {

		if (!mismasDimensiones(s2)) {
			System.out.println("\n No puedo sumar las matrices porque no son de las mismas dimensiones");
			return null;
		}

		int filas = filas();
		int columnas = columnas();

		Matriz suma = new Matriz(filas, columnas);

		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				suma.matriz[i][j] = matriz[i][j] + s2.matriz[i][j];

		return suma;

	}

	/**
	 * Resta dos matrices
	 * 
	 * @param sustraendo
	 *            Matriz sustraendo
	 * @return Una matriz con el resultado de la operacion
	 */
	public Matriz restar(Matriz sustraendo) {
		if (!mismasDimensiones(sustraendo)) {
			System.out.println("\n No puedo restar las matrices porque no son de las mismas dimensiones");
			return null;
		}
		int filas = filas();
		int columnas = columnas();
		Matriz resta = new Matriz(filas, columnas);
		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				resta.matriz[i][j] = matriz[i][j] - sustraendo.matriz[i][j];
		return resta;

	}

	/**
	 * Traspone una matriz
	 */
	public void trasponer() {
		int filas = filas();
		int columnas = columnas();

		int[][] resultado = new int[columnas][filas];
		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				resultado[j][i] = matriz[i][j];

		matriz = resultado;

	}

	/**
	 * Multiplica dos matrices
	 * 
	 * @param p2
	 *            Matriz producto
	 * @return Una matriz con el producto de matriz y p2
	 */
	public Matriz multiplicar(Matriz p2) {
		Matriz resultado = new Matriz(matriz.length, p2.matriz[0].length);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < p2.matriz[0].length; j++) {
				for (int k = 0; k < matriz[0].length; k++) {
					resultado.matriz[i][j] += matriz[i][k] * p2.matriz[k][j];
				}
			}
		}
		return resultado;
	}

	/**
	 * Comprueba si la dimension de dos matrices es la misma o no
	 * 
	 * @param m
	 *            Matriz a comparar
	 * @return True si es la misma dimension y false en caso contrario
	 */
	public boolean mismasDimensiones(Matriz m) {
		if (m.matriz.length == matriz.length && m.matriz[0].length == matriz[0].length) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Devuelve el numero de filas de una matriz
	 * 
	 * @return Entero con el numero de filas
	 */
	public int filas() {
		return matriz.length; // Longitud del vector
	}

	/**
	 * Devuelve el numero de columnas de una matriz
	 * 
	 * @return entero con el numero de columnas
	 */
	public int columnas() {
		return matriz[0].length; // Longitud de los elementos de la primera fila
	}

	/**
	 * Non-Javadoc
	 */
	@Override
	public String toString() {

		String cadena = "";
		for (int i = 0; i < matriz.length; i++) {
			cadena += "\n";
			for (int j = 0; j < matriz[0].length; j++) {
				cadena += "\t" + matriz[i][j];
			}

		}
		return cadena;
	}

}
