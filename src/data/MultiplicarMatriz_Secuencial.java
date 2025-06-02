package data;

public class MultiplicarMatriz_Secuencial {
	
	
	// Dadas dos matrices compatibles para multiplicar, se calcula y retorna una matriz C con el resultado de la operación
	// Este algoritmo funciona de forma secuencial
	
	public static int[][] multiplicar(int a[][], int b[][]) {
        if (a[0].length != b.length) {
            throw new ArithmeticException("La cantidad de columnas de matriz A debe coincidir con la cantidad de filas de matriz B para que puedan multiplicarse.");
        }
        int result[][] = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int total = 0;
                for (int k = 0; k < b.length; k++) {
                    total += a[i][k] * b[k][j];
                }
                result[i][j] = total;
            }
        }
        return result;
	}
}
