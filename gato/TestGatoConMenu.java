package gato;

import utiles.Menu;
import utiles.Teclado;

/**
 * Crea una clase TestGatoConMenu que muestre un menú para que juegue con el gato.
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class TestGatoConMenu {
	/**
	 * Creo el gato estático para que sea accesible desde otros metodos
	 */
	private static Gato gato;

	public static void main(String[] args) {
		Menu menuGeneral = new Menu("** ¿Que desea hacer? **",
				new String[] { "Comer", "Jugar", "Hablar", "Dormir", "Despertar" , "Salir"});
		
		gato = new Gato(Teclado.leerCadena("Nombre del gato"), Teclado.leerCadena("Raza del gato:"), pedirPesoValido());
		int opcion;

		do {
			opcion = menuGeneral.gestionar();
			gestionarOpciones(opcion);
		} while (opcion!=menuGeneral.SALIR);
		
	}
	
	/**
	 * Pide un peso valido (mayor que cero y menor que 8)
	 * @return Un entero con el peso valido
	 */
	private static double pedirPesoValido() {
		double peso;
		do {
			peso = Teclado.leerDecimal("Introduzca un peso valido (2 por defecto)");
		} while (peso < 0 || peso > 8);
		return peso;
	}

	/**
	 * Gestiona las opciones del gato
	 * 
	 * @param opcion
	 *            del menu
	 */
	private static void gestionarOpciones(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println(gato.comer());
			break;
		case 2:
			System.out.println(gato.jugar());
			break;
		case 3:
			System.out.println(gato);
			break;
		case 4:
			System.out.println(gato.dormir());
			break;
		case 5:
			System.out.println(gato.despertar());
			break;
		}
	}
}
