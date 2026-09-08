package array2D.Ajedrez;

public class Array2D <T> {
    // Atributos
    private int filas;
    private int columnas;
    private Object[][] datos;

    // Constructor
    public Array2D(int f, int c) {
        this.filas = f;
        this.columnas = c;
        this.datos = new Object[filas][columnas];
    }

    // Métodos
    public void setElemento(int f, int c, T elemento) {
        if (f >= 0 && f < filas && c >= 0 && c < columnas) {
            datos[f][c] = elemento;
        } else {
            System.out.println("Índice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T getElemento(int f, int c) {
        return (T) datos[f][c];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}