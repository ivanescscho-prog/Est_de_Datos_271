package Laberinto;


public class Main {
    public static void main(String[] args) {

        BackTracking laberinto01 = new BackTracking("Tareas/T7-1_Opcional_Laberinto/Entradas_Tableros/entrada.lab");
        laberinto01.construirLaberinto();

        System.out.println("\n\nTablero listo");
        laberinto01.getLaberinto().imprimirTablero(); // Tablero construido sin resolver

        // laberinto01.jugadorEnEntrada();
        laberinto01.solucionarLaberinto();

        /*laberinto02.jugadorEnEntrada();
        System.out.println("\nJugador listo para arrancar\n");
        laberinto02.getLaberinto().imprimirTablero(); // Tablero con jugador posicionado en la entrada

        laberinto02.solucionarLaberinto();
        System.out.println("\n" + laberinto02.getCamino().peek());

         */
    }

}