package gato;
/**
 * Crea una clase TestGato que cree una instancia de Gato, 
 * le dé de comer ,juegue con él mucho (7 veces), 
 * lo haga dormir y finalmente nos hable.
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class TestGato {

	public static void main(String[] args) {
		// Creamos el gato con un nombre, raza y peso por defecto
		Gato gato = new Gato("Gardfield", "Persa", 4.597f);

		// Le damos de comer (su peso incrementa en 0.5)
		System.out.println(gato.comer());

		// Lo hacemos jugar mucho, 7 veces
		for (int i = 0; i < 7; i++) {
			System.out.println(gato.jugar());
		}

		// Dormimos al gato
		System.out.println(gato.dormir());

		// Finalmente nos habla
		System.out.println(gato);
	}

}
