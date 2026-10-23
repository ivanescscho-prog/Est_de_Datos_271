// Resolver un laberitno mediante el algoritmo de Backtracking usando las EDD de pila y Array2D

package Laberinto;

public class Main {
    public static void main(String[] args) {

        BackTracking laberinto01 = new BackTracking("Tareas/T7-1_Opcional_Laberinto/Entradas_Tableros/entrada7.lab");
        laberinto01.construirLaberinto();

        System.out.println("\n\nTablero listo");
        laberinto01.getLaberinto().imprimirTablero(); // Tablero construido sin resolver

        System.out.println("\n");
        laberinto01.solucionarLaberinto(); // Tablero resuelto
    }

}