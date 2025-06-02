package data;

public class MultiplicarMatriz_Concurrente extends Thread {
	
	// Esta clase realiza la multiplicación de dos matrices
	// indicando el rango de elementos a calcular de la matriz resultado
	
	private int filaDesde;
	private int filaHasta;
	private static int[][] matrizA;
	private static int[][] matrizB;
	private static int[][] matrizResultado;
	
	
	public MultiplicarMatriz_Concurrente(int filaDesde, int filaHasta) {
		this.filaDesde = filaDesde;
		this.filaHasta = filaHasta;
	}
	
	public static void setMatrices(int matriz_a[][], int matriz_b[][]) {
		matrizA = matriz_a;
		matrizB = matriz_b;
	    matrizResultado = new int[matrizA.length][matrizB[0].length];

	}
	
    public static int[][] getResultado() {
        return matrizResultado;
    }
	
	@Override
	public void run() {
		for(int i = filaDesde; i < filaHasta; i++) {
			for(int j = 0; j < matrizB[0].length; j++) {
				int suma = 0;
				
				for(int k = 0; k < matrizB.length; k++) {
					suma += matrizA[i][k] * matrizB[k][j];
				}
				
				matrizResultado[i][j] = suma;
			}
		}
	}
}
