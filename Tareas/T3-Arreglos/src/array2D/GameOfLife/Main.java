package array2D.GameOfLife;

public class Main {
    public static void main(String[] args) {
        GameOfLife juego = new GameOfLife(10, 10, "poblacion.csv");

        System.out.println("Generación 0 (Configuración Inicial):");
        juego.imprimirTablero();

        for (int i = 1; i <= 10; i++) {
            juego.calcularSiguienteGeneracion();
            System.out.println("Generación " + i + ":");
            juego.imprimirTablero();
        }
    }
}
