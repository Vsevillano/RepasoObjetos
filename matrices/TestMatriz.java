package matrices;

public class TestMatriz {

	public static void main(String[] args) {
//		Matriz matriz = new Matriz(1, 2);
//		Matriz m = new Matriz(1, 3);
//		System.out.println(matriz.filas());
//		System.out.println(matriz.columnas());
//		System.out.println(matriz.mismasDimensiones(m));
		
		Matriz s1= new Matriz(2,3, 1, 5);
		Matriz s2= new Matriz(2, 3, 1, 5);
		System.out.println("matriz 1: "+s1);
		System.out.println("matriz 2: "+s2);
		
		
		Matriz resultado= s1.sumar(s2);
		System.out.println("suma: "+resultado);
		
		resultado= s1.restar(s2);
		System.out.println("resta: "+resultado);
		
		s1.trasponer();
		System.out.println("Traspuesta "+s1);
		
		
	}

}
