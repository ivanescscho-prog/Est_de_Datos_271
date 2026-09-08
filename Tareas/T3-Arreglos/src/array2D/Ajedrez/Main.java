package array2D.Ajedrez;

public class Main {
    public static void main(String[] args) {

        //Especificaciones del objeto
        Array2D<String> tablero = new Array2D<>(8, 8);

        // Variables de apoyo
        String[] piezasNegras = {"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"};
        String[] piezasBlancas = {"♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"};
        String peonNegro = "♟";
        String peonBlanco = "♙";
        String vacio = " "; // Casilla sin pieza

        // Lógica mapeo del tablero

        for (int f = 0; f < tablero.getFilas(); f++) {
            for (int c = 0; c < tablero.getColumnas(); c++) {
                if (f == 0) {
                    tablero.setElemento(f, c, piezasNegras[c]);
                } else if (f == 1) {
                    tablero.setElemento(f, c, peonNegro);
                } else if (f == 6) {
                    tablero.setElemento(f, c, peonBlanco);
                } else if (f == 7) {
                    tablero.setElemento(f, c, piezasBlancas[c]);
                } else {
                    tablero.setElemento(f, c, vacio);
                }
            }
        }

        // Impresión del tablero
        System.out.println("  a  b  c  d  e  f  g  h");

        for (int f = 0; f < tablero.getFilas(); f++) {
            System.out.print((8 - f) + " ");

            for (int c = 0; c < tablero.getColumnas(); c++) {
                System.out.print(tablero.getElemento(f, c) + "  ");
            }
            System.out.println();
        }
    }
}