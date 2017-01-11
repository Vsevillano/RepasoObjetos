package matrices;
/**
 * @author Grupo 1
 * @version 1.0
 */
public class Matriz {
	int[][] matriz;

	/**
	 * Constructor que inicializa a 0
	 * 
	 * @param filas
	 * @param columnas
	 */
	public Matriz(int filas, int columnas) {

		if(filas<=0){ // Los dos if controlan que filas y columnas tengan valores válidos.
			filas=2;
		}
		if(columnas<=0){
			columnas=2;
		}

		matriz = new int[filas][columnas];
	}

	/**
	 * Constructor que inicializa aleatoriamente entre un max y un min
	 * 
	 * @param filas
	 * @param columnas
	 * @param min
	 * @param max
	 */
	public Matriz(int filas, int columnas, int min, int max) {
		
		if(filas<=0){ // Los dos if controlan que filas y columnas tengan valores válidos.
			filas=2;
		}
		if(columnas<=0){
			columnas=2;
		}
		if(max<min){ // Controla que el max nunca sea menor que el min
			max=min+1;
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
	 * @return
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
	 * @return
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
	 * @return
	 */
	public Matriz multiplicar(Matriz p2) {

		return null;
	}

	/**
	 * Comprueba si la dimension de dos matrices es la misma o no
	 * 
	 * @param m
	 * @return
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
	 * @return
	 */
	public int filas() {
		return matriz.length; // Longitud del vector
	}

	/**
	 * Devuelve el numero de columnas de una matriz
	 * 
	 * @return
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
