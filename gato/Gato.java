package gato;

import java.sql.PseudoColumnUsage;

/**
 * Crea la clase “Gato” que responda al siguiente comportamiento:
 * a. Un gato puede comer. 
 * En este caso incrementa su peso y dice “Rico rico…”
 * 
 * b. Un gato puede jugar.
 * En este caso decrementa su peso y dice “Qué diver…”
 * 
 * c. Un gato puede dormir (su estado natural).
 * En este caso dice “Ronroneo. Zzz…”
 * 
 * Nuestros gatos son habladores. Nos pueden decir por ejemplo:
 * “Hola, soy Gardfield de raza Persa. Peso 4.597 kilos”
 * 
 * Modifica la clase Gato para que si engorda demasiado o adelgaza en extremo,
 * advierta a su amo (“Tengo hambre!!!” o “Voy a reventar!!!”). 
 * En caso de llegar a un peso máximo o mínimo, el gato morirá (se saldrá del programa)
 * 
 * @author Victoriano Sevillano Vega
 * @version 1.0
 */
public class Gato {
	private String nombre;
	private String raza;
	private double peso;
	private boolean dormido = false;
	private static final double MAX_PESO = 8;
	private static final double MIN_PESO = 0.5;
	

	/**
	 * Constructor que inicializa el gato con nombre, raza y peso
	 * 
	 * @param nombre
	 *            del gato
	 * @param raza
	 *            del gato
	 * @param peso
	 *            del gato
	 */
	public Gato(String nombre, String raza, double peso) {
		setNombre(nombre);
		setRaza(raza);
		if (peso < 2) {
			setPeso(2);
		} else {
			setPeso(peso);
		}
		setDormido(true); // Su estado natural
	}

	// Getters y setters de los campos
	/**
	 * Obtiene el nombre del gato
	 * 
	 * @return Una cadena con el nombre del gato
	 */
	private String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del gato
	 * 
	 * @param nombre
	 *            del gato
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la raza del gato
	 * 
	 * @return Cadena con la raza del gato
	 */
	private String getRaza() {
		return raza;
	}

	/**
	 * Modifica la raza del gato
	 * 
	 * @param raza del gato
	 */
	private void setRaza(String raza) {
		this.raza = raza;
	}

	/**
	 * Obtiene el peso del gato
	 * 
	 * @return Double con el peso del gato
	 */
	private double getPeso() {
		return peso;
	}

	/**
	 * Modifica el peso del gato
	 * 
	 * @param peso
	 *            del gato
	 */
	private void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Obtiene el estado de dormido
	 * 
	 * @return El estado de dormido
	 */
	private boolean isDormido() {
		return dormido;
	}

	/**
	 * Modifica el estado del gato
	 * 
	 * @param dormido 
	 */
	private void setDormido(boolean dormido) {
		this.dormido = dormido;
	}

	/**
	 * Devuelve el valor de muerto
	 * 
	 * @return True o false
	 */
	private boolean pesoValido() {
		boolean valido;
		if (getPeso() > MAX_PESO || getPeso() < MIN_PESO) {
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}

	/**
	 * Incrementa el peso del gato y dice "Rico rico..."
	 * 
	 * @return Cadena con un mensaje
	 */
	String comer() {
		if(!pesoValido())return "Estoy muerto";
		if (isDormido()) {
			return "Ronroneo. Zzz";
		} else if (!pesoValido()) {
			return "He muerto";
		} else if (getPeso() >= (MAX_PESO - 0.5)) {
				setPeso(getPeso() + 0.5);
				return "Voy a reventar!!!";
			} else {
				setPeso(getPeso() + 0.5);
				return "Rico rico...";
			}
		}
	

	/**
	 * Decrementa su peso y dice "Que diver..."
	 * 
	 * @return Cadena con mensaje
	 */
	String jugar() {
		if(!pesoValido())return "Estoy muerto";
		if (isDormido()) {
			return "Ronroneo. Zzz";
		} else if (getPeso() <= MIN_PESO) {
			setPeso(getPeso() - 0.5);
			return "He muerto";
		} else if (getPeso() <= (MIN_PESO + 0.5)) {
				setPeso(getPeso() - 0.5);
				return "Tengo hambre!!!";
			} else {
				setPeso(getPeso() - 0.5);
				return "Que diver...";
			}

	}

	/**
	 * Duerme al gato
	 * 
	 * @return Cadena con mensaje
	 */
	String dormir() {
		if(!pesoValido())return "Estoy muerto";
		setDormido(true);
		return "Ronroneo. Zzz...";
	}
	
	/**
	 * Despierta al gato
	 * 
	 * @return Cadena con mensaje
	 */
	String despertar() {
		if(!pesoValido())return "Estoy muerto";
		setDormido(false);
		return "Miau.. Buenos dias!";
	}
//
//	/**
//	 * Incrementa el peso del gato
//	 */
//	private void inPeso() {
//		setPeso(getPeso() + 0.5);
//	}
//
//	/**
//	 * Decrementa el peso del gato
//	 */
//	private void decPeso() {
//		setPeso(getPeso() - 0.5);
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (isDormido())
			return "Ronroneo. Zzz";
		else 
			return "Hola, soy " + getNombre() + " de raza " + getRaza() + ". Peso " + getPeso() + " kilos.";
	}
}
