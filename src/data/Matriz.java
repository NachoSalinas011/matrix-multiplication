package data;

import java.util.Random;

public class Matriz {
	
	
	public static int[][] crear_Random(int cantFilas, int cantColumnas) {
		Random random = new Random();
	    int[][] matriz = new int[cantFilas][cantColumnas];

	    // Se llena la matriz con valores aleatorios del 0 al 100
	    for (int i = 0; i < cantFilas; i++) {
	        for (int j = 0; j < cantColumnas; j++) {
	            matriz[i][j] = random.nextInt(100);
	        }
	    }
	    return matriz;
	}
	
	// Por cada elemento de la matriz se imprime en consola su valor
	public static void imprimir(int[][] matriz) {
	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[i].length; j++) {
	            System.out.print(matriz[i][j] + "\t");
	        }
	        System.out.println();
	    }
	}
	
	
	//Retorna TRUE si dos matrices son multiplicables
	public static boolean SePuedenMultiplicar(int[][] matrizA, int[][] matrizB) {
	    return matrizA[0].length == matrizB.length;
	}
}
