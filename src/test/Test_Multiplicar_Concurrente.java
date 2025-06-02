package test;

import data.Matriz;
import data.MultiplicarMatriz_Concurrente;

public class Test_Multiplicar_Concurrente {

	public static void main(String[] args) {

		// Crear matrices a multiplicar y validar que sean multiplicables
		int[][] matriz_uno = Matriz.crear_Random(2, 3);
		int[][] matriz_dos = Matriz.crear_Random(3, 5);

		try {
			if (!Matriz.SePuedenMultiplicar(matriz_uno, matriz_dos)) {
				throw new Exception("Las matrices no se pueden multiplicar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Crear matriz resultante con las dimensiones correspondientes
		int[][] matriz_resultado = new int[matriz_uno.length][matriz_dos[0].length];

		// Hilos a utilizar
		int cantidadHilos = 5;

		// Variables para calcular el tiempo de ejecución
		double tiempoInicial, tiempoFinal;

		tiempoInicial = System.nanoTime();
		
        MultiplicarMatriz_Concurrente.setMatrices(matriz_uno, matriz_dos);

		// Clase con la lógica de multiplicación por hilos
		MultiplicarMatriz_Concurrente[] hilos = new MultiplicarMatriz_Concurrente[cantidadHilos];

		
		// Calcular los parametros 'filaDesde' y 'filaHasta' para cada hilo
		int filas = matriz_uno.length;
		int filasPorHilo = filas / cantidadHilos;
		int resto = filas % cantidadHilos;
		int filaInicio = 0;

		for (int i = 0; i < cantidadHilos; i++) {
			int filasAsignadas = filasPorHilo + (i < resto ? 1 : 0);
			int filaFin = filaInicio + filasAsignadas;

			//Inicializar cada hilo
			hilos[i] = new MultiplicarMatriz_Concurrente(filaInicio, filaFin);

			filaInicio = filaFin;
		}
		

		// Ejecutar hilos
		for (int i = 0; i < cantidadHilos; i++) {
			hilos[i].start();
		}

		
		// Esperar hilos
		for (int i = 0; i < cantidadHilos; i++) {

			try {
				hilos[i].join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
        matriz_resultado = MultiplicarMatriz_Concurrente.getResultado();

		tiempoFinal = System.nanoTime() - tiempoInicial;
		
		//Validaciones
		System.out.println("Hilos: " + cantidadHilos + "\nTiempo de ejecución (nanosegundos): " + tiempoFinal);
		System.out.println("\nMatriz A\n");
		Matriz.imprimir(matriz_uno);
		
		System.out.println("\n----------------------------------");
		System.out.println("\nMatriz B\n");
		Matriz.imprimir(matriz_dos);

		System.out.println("\n----------------------------------");
		System.out.println("\nResultado\n");
		Matriz.imprimir(matriz_resultado);
	}

}
