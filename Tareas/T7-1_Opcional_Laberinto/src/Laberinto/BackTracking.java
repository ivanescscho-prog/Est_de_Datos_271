// Algoritmo BackTracking. Construcción del laberinto y asignación de simbolo para el juego

package Laberinto;

import EDD_Laberinto.Array2D;
import EDD_Laberinto.Pila;
import com.sun.source.tree.WhileLoopTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BackTracking {
    private int tamanioF;
    private int tamanioC;
    private char jugador = '♛';
    private char rastroCamino = 'o';
    private char caimoIncorrecto = '×';
    private String rutaArchivo;
    private Posicion posicionEntrada;
    private Posicion posicionSalida;
    private Array2D<Character> laberinto = new Array2D<Character>();
    private Pila<Posicion> caminoCorrecto = new Pila<Posicion>();

    public BackTracking(){
        this.posicionEntrada = new Posicion(-1, -1);
    }

    public BackTracking(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public BackTracking(int posicionEntradaF, int posicionEntradaC) {
        this.posicionEntrada = new Posicion(posicionEntradaF-1, posicionEntradaC-1);
    }

    public Pila getCamino(){
        return caminoCorrecto;
    }

    public Posicion getPosicionEntrada(){
        return posicionEntrada;
    }

    public Posicion getPosicionSalida(){
        return posicionEntrada;
    }

    public Array2D<Character> getLaberinto(){
        return laberinto;
    }

    public char getJugador(){
        return jugador;
    }

    private boolean validarposicionEntrada() {
        return posicionEntrada.getFila() > -1 && posicionEntrada.getColumna() > -1;
    }

    private boolean validarposicionSalida() {
        return posicionSalida.getFila() > -1 && posicionSalida.getColumna() > -1;
    }

    public void avisoEntrada(Posicion dato){
        if (validarposicionEntrada() && dato == posicionEntrada){
            System.out.println("Entrada correcta, " + dato);
        } else {
            System.out.println("Entrada invalida, favor de corroborar coordenadas de la Entrada. " + dato.posicionActual());
        }
    }

    public void construirLaberinto(){

        if (this.rutaArchivo != null) {
            String rutaArchivo = this.rutaArchivo;
            this.laberinto = leerArchivo(rutaArchivo);

            if (laberinto != null) {
                System.out.println("Dimensiones del laberinto: " + laberinto.getNoFilas() + " x " + laberinto.getNoColumnas());
                System.out.println("Elemento en (0,0): " + laberinto.getElemento(0, 0));

                this.tamanioF = laberinto.getNoFilas();
                this.tamanioC = laberinto.getNoColumnas();

                System.out.println("Iniciarndo busqueda de la entrada...");
                this.posicionEntrada = buscarEntrada();
                System.out.println("Iniciarndo busqueda de la salida...");
                this.posicionSalida = buscarSalida();

                System.out.println("La entrada esta en las coordenadas: " + (posicionEntrada.getFila()+1) + ", " + (posicionEntrada.getColumna()+1));
                System.out.println("La salida esta en las coordenadas: " + (posicionSalida.getFila()+1) + ", " + (posicionSalida.getColumna()+1));

            }

        } else {
            System.out.println("Imposible leer el archivo cargado, confirma que la ruta sea correcta");
        }
    }

    // Extraer Tablero de un archivo .lab
    private static Array2D<Character> leerArchivo(String rutaArchivo) {

        Array2D<Character> laberinto = null;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            int filas = Integer.parseInt(br.readLine().trim());
            int columnas = Integer.parseInt(br.readLine().trim());

            laberinto = new Array2D<Character>(filas, columnas);

            String linea;
            int filaActual = 0;

            while ((linea = br.readLine()) != null && filaActual < filas) {

                String[] valores = linea.split(",");

                for (int colActual = 0; colActual < valores.length && colActual < columnas; colActual++) {
                    char simboloOriginal = valores[colActual].trim().charAt(0);


                    char simboloMapeado = mapearLaberinto(simboloOriginal);


                    laberinto.setElemento(filaActual, colActual, simboloMapeado);
                }
                filaActual++;
            }
            System.out.println("¡Laberinto cargado exitosamente desde el archivo!");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de las dimensiones del archivo: " + e.getMessage());
        }

        return laberinto;
    }

    // Caracteres personalizados para el tablero
    private static char mapearLaberinto(char entrada) {
        switch (entrada) {
            case '1':
                return '■'; // Muro
            case '0':
                return ' '; // Camino
            case 'E':
                return 'E'; // Entrada
            case 'S':
                return 'S'; // Salida
            default:
                return entrada;
        }
    }

    // Establecer al jugador en la posición de entrada
    public void jugadorEnEntrada(){
        laberinto.setElemento(posicionEntrada.getFila(),posicionEntrada.getColumna(), jugador);
    }

    public void solucionarLaberinto(){
        System.out.println();
        System.out.println("===========================================================");
        System.out.println("SOLUCION DEL LABERINTO MEDIANTE EL ALGORITMO DE BACKTRAKING");
        System.out.println("===========================================================");

        Posicion posicionActual = posicionEntrada;
        caminoCorrecto.push(posicionEntrada);


        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 1000; j++){
                posicionActual = avanzar(posicionActual);

                // laberinto.imprimirTablero();
                // System.out.println("\n" + caminoCorrecto.peek());
                // System.out.println("iteracion " + (j+1));
                posicionActual = caminoCorrecto.peek();

                if (posicionActual.getFila() == posicionSalida.getFila() && posicionActual.getColumna() == posicionSalida.getColumna()){

                    laberinto.imprimirTablero();
                    System.out.println("\n" + caminoCorrecto.peek());
                    System.out.println("iteracion " + (j+1));

                    System.out.println();
                    System.out.println("===========================================================");
                    System.out.println("             ¡¡¡ LABERINTO RESUELTO !!!                    ");
                    System.out.println("===========================================================");

                    return;
                }
            }
        }
    }

    private Posicion avanzar(Posicion posicionActual){

        if (avanzarArriba(posicionActual) != posicionActual){
            return avanzarArriba(posicionActual);
        }
        else {
            if (avanzarDerecha(posicionActual) != posicionActual){
                return avanzarDerecha(posicionActual);
            }
            else {
                if (avanzarIzquierda(posicionActual) != posicionActual) {
                    return avanzarArriba(posicionActual);
                } if (avanzarAbajo(posicionActual) != posicionActual) {
                    return avanzarAbajo(posicionActual);
                }
            }
        }
        return retroceder(posicionActual);
    }

    private Posicion avanzarArriba(Posicion posicion){
        if (posicion.validarDatos()){
            int nuevaPosicionF = posicion.getFila() - 1;
            Posicion posicionN = new Posicion(nuevaPosicionF, posicion.getColumna());

            if (posicionN.validarDatos()){
                if (laberinto.getElemento(posicionN).equals(' ')) {
                    laberinto.setElemento(posicion, rastroCamino);
                    laberinto.setElemento(posicionN, jugador);
                    caminoCorrecto.push(posicionN);
                    return posicionN;
                }
                if (laberinto.getElemento(posicionN).equals('S')) {
                    laberinto.setElemento(posicion, rastroCamino);
                    laberinto.setElemento(posicionN, jugador);
                    caminoCorrecto.push(posicionN);
                    return posicionN;
                }
            }
            return posicion;
        }
        return posicion; // Invalido();
    }

    private Posicion avanzarDerecha(Posicion posicion){
        if (posicion.validarDatos()){
            int nuevaPosicionC = posicion.getColumna() - 1;
            Posicion posicionN = new Posicion(posicion.getFila(), nuevaPosicionC);

            if (posicionN.validarDatos()){
                if (laberinto.getElemento(posicionN).equals(' ')) {
                    laberinto.setElemento(posicion, rastroCamino);
                    laberinto.setElemento(posicionN, jugador);
                    caminoCorrecto.push(posicionN);
                    return posicionN;
                }
                if (laberinto.getElemento(posicionN).equals('S')) {
                    laberinto.setElemento(posicion, rastroCamino);
                    laberinto.setElemento(posicionN, jugador);
                    caminoCorrecto.push(posicionN);
                    return posicionN;
                }
            }
            return posicion;
        }
        return posicion; // Invalido();
    }

    private Posicion avanzarIzquierda(Posicion posicion){
        if (posicion.validarDatos()){
            int nuevaPosicionC = posicion.getColumna() + 1;
            Posicion posicionN = new Posicion(posicion.getFila(), nuevaPosicionC);

            if (posicionN.validarDatos()){
                if (laberinto.getElemento(posicionN).equals(' ')) {
                    laberinto.setElemento(posicion, rastroCamino);
                    laberinto.setElemento(posicionN, jugador);
                    caminoCorrecto.push(posicionN);
                    return posicionN;
                }
                if (laberinto.getElemento(posicionN).equals('S')) {
                    laberinto.setElemento(posicion, rastroCamino);
                    laberinto.setElemento(posicionN, jugador);
                    caminoCorrecto.push(posicionN);
                    return posicionN;
                }
            }
            return posicion;
        }
        return posicion; // Invalido();

    }

    private Posicion avanzarAbajo(Posicion posicion){
        if (posicion.validarDatos()){
            int nuevaPosicionF = posicion.getFila() + 1;
            Posicion posicionN = new Posicion(nuevaPosicionF, posicion.getColumna());

            if (posicionN.validarDatos()){
                if (laberinto.getElemento(posicionN).equals(' ')) {
                    laberinto.setElemento(posicion, rastroCamino);
                    laberinto.setElemento(posicionN, jugador);
                    caminoCorrecto.push(posicionN);
                    return posicionN;
                }
                if (laberinto.getElemento(posicionN).equals('S')) {
                    laberinto.setElemento(posicion, rastroCamino);
                    laberinto.setElemento(posicionN, jugador);
                    caminoCorrecto.push(posicionN);
                    return posicionN;
                }
            }
            return posicion;
        }
        return posicion; // Invalido();

    }

    private Posicion retroceder(Posicion posicion){
        laberinto.setElemento(posicion, caimoIncorrecto);
        caminoCorrecto.pop();
        laberinto.setElemento(caminoCorrecto.peek(), jugador);
        return caminoCorrecto.peek();
    }

    private Posicion buscarEntrada() {
        Character elementoABuscar = 'E';

        for (int i = 0; i < tamanioF; i++) {
            for (int j = 0; j < tamanioC; j++) {
                Posicion actual = new Posicion(i, j);

                Character elementoActual = (Character) laberinto.getElemento(actual);
                // System.out.println("Coordenadas del elemento: " + laberinto.getNoFilas() + ", " + laberinto.getNoColumnas());
                // System.out.println("Revisando las coordenadas. Elemento en la celda: " + elementoActual);

                if (elementoActual != null && elementoActual.equals(elementoABuscar)) {
                    return actual;
                }
            }
        }

        System.out.println("No hay una entrada definida según los parámetros.");
        System.out.println("Verifica que la entrada esté señalizada con el carácter E");
        return null;
    }

    private Posicion buscarSalida() {
        Character elementoABuscar = 'S';

        for (int i = 0; i < tamanioF; i++) {
            for (int j = 0; j < tamanioC; j++) {
                Posicion actual = new Posicion(i, j);

                Character elementoActual = (Character) laberinto.getElemento(actual);
                // System.out.println("Coordenadas del elemento: " + laberinto.getNoFilas() + ", " + laberinto.getNoColumnas());
                // System.out.println("Revisando las coordenadas. Elemento en la celda: " + elementoActual);

                if (elementoActual != null && elementoActual.equals(elementoABuscar)) {
                    return actual;
                }
            }
        }

        System.out.println("No hay una entrada definida según los parámetros.");
        System.out.println("Verifica que la entrada esté señalizada con el carácter S");
        return null;
    }
}
