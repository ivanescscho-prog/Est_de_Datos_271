package Laberinto;

// Tablero del laberinto

public class Array2D {
    private int noFilas;
    private int noColumnas;
    private Object[][] matriz;

    public Array2D (){

    }

    public Array2D(int noFilas, int noColumnas){
        this.noFilas = noFilas;
        this.noFilas2 = noFilas;
        this.noColumnas = noColumnas;
        this.noColumnas2 = noColumnas;
        this.matriz = new Object[noColumnas][noFilas];
    }

    public int getNoColumnas() {
        return noColumnas;
    }

    public int getNoFilas(){
        return noFilas;
    }

    public Object getElemento(int fila, int columna){
        if (fila >= 0 && fila <= noFilas && columna >= 0 && columna <= noColumnas){
            return  matriz [fila][columna];
        } else {
            return Array2D.avisoFueraDeRango(columna, fila);
        }
    }

    public void setElemento(int columna, int fila, int elemento) {
        if (fila >= 0 && fila <= noFilas && columna >= 0 && columna <= noColumnas) {
            matriz[fila][columna] = elemento;
        } else {
            Array2D.avisoFueraDeRango(columna, fila);
        }
    }

    // Extras

    private static int noColumnas2;
    private static int noFilas2;

    private static Object avisoFueraDeRango(int columna, int fila){
        System.out.println("Coordenadas fuera del rango");
        if ((columna < 0 || columna > noColumnas2) && (fila < 0 || fila > noFilas2)){
            System.out.println("Número de columna y fila no valido, favor de confirmar");
        } else {
            if (columna < 0 || columna > noColumnas2){
                System.out.println("Número de columna no valido, favor de confirmar");
            } else {
                System.out.println("Número de fila no valido, favor de confirmar");
            }
        }
        return null;
    }

}