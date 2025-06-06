package test.Secuencial;

import data.Matriz;
import data.MultiplicarMatriz_Secuencial;

public class Test_Multiplicar_Secuencial_Grande {

	public static void main(String[] args) {
		//Matrices a utilizar
		int[][] matriz_uno = Matriz.crear_Random(1000, 1000);
		int[][] matriz_dos = Matriz.crear_Random(1000, 1000);
		
		try {
			if (!Matriz.SePuedenMultiplicar(matriz_uno, matriz_dos)) {
				throw new Exception("Las matrices no se pueden multiplicar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Variables para calcular el tiempo de ejecución
		long tiempoInicial, tiempoFinal;
		
		tiempoInicial = System.nanoTime();
		//Multiplicar matrices
		int[][] result = MultiplicarMatriz_Secuencial.multiplicar(matriz_uno, matriz_dos);
		
		tiempoFinal = System.nanoTime() - tiempoInicial;
		
		
		//Validaciones
		System.out.println("Tiempo de ejecución (nanosegundos): " + tiempoFinal);
//		System.out.println("\nMatriz A\n");		
//		Matriz.imprimir(matriz_uno);
//		
//		System.out.println("\n----------------------------------");
//		System.out.println("\nMatriz B\n");
//		
//		Matriz.imprimir(matriz_dos);
//		
//		System.out.println("\n----------------------------------");
//		System.out.println("\nResultado\n");
//		Matriz.imprimir(result);
	}

}
