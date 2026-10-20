package Laberinto;

// Tablero del laberinto

public class Array2D <T> {
    private int noFilas;
    private int noColumnas;
    private Object[][] matriz;

    public Array2D (){

    }

    public Array2D(int noFilas, int noColumnas){
        this.noFilas = noFilas;
        this.noColumnas = noColumnas;
        this.matriz = new Object[noColumnas][noFilas];
        this.tableroSolido();
    }

    public int getNoFilas() {
        return noColumnas;
    }

    public int getNoColumnas(){
        return noFilas;
    }

    public Object getElemento(int fila, int columna){
        if (validarRango(fila, columna)){
            return  matriz [fila][columna];
        } else {
            avisoFueraDeRango(fila, columna);
            return null;
        }
    }

    public void setElemento(int fila, int columna, T elemento) {
        if (validarRango(fila, columna)) {
            matriz[fila][columna] = elemento;
        } else {
            avisoFueraDeRango(fila, columna);
        }
    }

    public void imprimirTablero (){
        for (int i = 0; i < noFilas; i++){
            System.out.println();
            for (int  j = 0; j < noColumnas; j++){
                System.out.print(matriz[i][j] + " ");
            }
        }
    }

    // Extras

    private void tableroSolido(){
        for (int i = 0; i < noColumnas; i++) {
            for (int j = 0; j < noFilas; j++) {
                matriz [i][j] = "■";
            }
        }
    }

    private boolean validarRango(int fila, int columna){
        return fila >= 0 && fila < noFilas && columna >= 0 && columna < noColumnas;
    }

    private void avisoFueraDeRango(int fila, int columna){
        System.out.println("Coordenadas fuera del rango");
        if ((columna < 0 || columna > noColumnas) && (fila < 0 || fila > noFilas)){
            System.out.println("Número de columna y fila no valido, favor de confirmar");
        } else {
            if (columna < 0 || columna > noColumnas){
                System.out.println("Número de columna no valido, favor de confirmar");
            } else {
                System.out.println("Número de fila no valido, favor de confirmar");
            }
        }
        throw new IndexOutOfBoundsException("Posición (" + fila + ", " + columna + ") fuera de los límites del laberinto.");
    }
}