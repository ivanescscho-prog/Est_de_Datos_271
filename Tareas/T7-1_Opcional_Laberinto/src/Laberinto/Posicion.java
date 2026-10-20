package Laberinto;

public class Posicion {
    private int fila;
    private int columna;

    public Posicion(){
        this.fila = -1;
        this.columna = -1;
    }

    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila(){
        return this.fila;
    }

    public int getColumna(){
        return this.columna;
    }

    private boolean validarDatos(){
        return (fila > -1 && columna > -1);
    }

    private String detectarDatoErroneo(){
        if (getFila() == -1){
            return "Fila invalida,asignar valor a fila";
        }
        if (getColumna() == -1) {
            return "Columna invalida, asignar valores a columna";
        }
        return "Al parecer todo esta bien, " + posicionActual();
    }

    private String posicionActual(){
        return "Posicion actual: " + fila + ", " + columna;
    }

    @Override
    public String toString(){
        return posicionActual();
    }

    public String obtenerDatos(String tipo){
        if (validarDatos()) {
            if (tipo.equals("x")) {
                return "Coordenada en X = " + fila;
            } else {
                return "Coordenada en Y = " + columna;

            }
        }
        return detectarDatoErroneo();
    }
}
