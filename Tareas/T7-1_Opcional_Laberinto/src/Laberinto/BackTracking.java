package Laberinto;

import EDD_Laberinto.Array2D;
import EDD_Laberinto.Pila;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BackTracking {
    private int posicionEntradaF;
    private int posicionEntradaC;
    private char jugador = '♛';
    private char rastroCamino = 'o';
    private char caimoIncorrecto = '×';
    private Posicion posicionEntrada;
    private Array2D<Character> laberinto = new Array2D<Character>();
    private Pila<Posicion> caminoCorrecto = new Pila<Posicion>();

    public BackTracking(){
        this.posicionEntradaF = -1;
        this.posicionEntradaC = -1;
    }

    public BackTracking(int posicionEntradaF, int posicionEntradaC) {
        this.posicionEntradaF = posicionEntradaF-1;
        this.posicionEntradaC = posicionEntradaC-1;
        this.posicionEntrada = new Posicion(posicionEntradaF-1, posicionEntradaC-1);
    }

    public int getPosicionEntradaF(){
        return posicionEntradaF;
    }

    public int getPosicionEntradaC(){
        return posicionEntradaC;
    }

    public Pila getCamino(){
        return caminoCorrecto;
    }

    public Posicion getPosicionEntrada(){
        return posicionEntrada;
    }

    public Array2D<Character> getLaberinto(){
        return laberinto;
    }

    public char getJugador(){
        return jugador;
    }

    private boolean validarposicionEntrada() {
        return getPosicionEntradaF() > -1 && getPosicionEntradaC() > -1;
    }

    public void avisoEntrada(Posicion dato){
        if (validarposicionEntrada() && dato == posicionEntrada){
            System.out.println("Entrada correcta, " + dato);
        } else {
            System.out.println("Entrada invalida, favor de corroborar coordenadas de la Entrada. " + dato.posicionActual());
        }
    }

    public void construirLaberinto(String rutaArchivo){
        this.laberinto = leerArchivo("Tareas/T7-1_Opcional_Laberinto/Entradas_Tableros/entrada.lab");
        if (laberinto != null) {
            System.out.println("Dimensiones del laberinto: " + laberinto.getNoFilas() + "x" + laberinto.getNoColumnas());
            System.out.println("Elemento en (0,0): " + laberinto.getElemento(0, 0));
        }
    }

    // Extraer Tablero de un archivo .lab
    private static Array2D<Character> leerArchivo(String rutaArchivo) {
        Array2D<Character> laberinto = null;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            int filas = Integer.parseInt(br.readLine().trim());
            int columnas = Integer.parseInt(br.readLine().trim());

            laberinto = new Array2D<>(filas, columnas);

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
        laberinto.setElemento(posicionEntradaF,posicionEntradaC, jugador);
    }

    public void solucionarLaberinto(){
        System.out.println();
        System.out.println("===========================================================");
        System.out.println("SOLUCION DEL LABERINTO MEDIANTE EL ALGORITMO DE BACKTRAKING");
        System.out.println("===========================================================");

        Posicion posicionActual = this.posicionEntrada;
        caminoCorrecto.push(this.posicionEntrada);

        for (int i = 0; i < 5; i++){
            posicionActual = avanzar(posicionActual);
            System.out.println("iteracion " + (i+1));
            laberinto.imprimirTablero();
            System.out.println("\n" + caminoCorrecto.peek());
            posicionActual = caminoCorrecto.peek();
        }
    }

    private Posicion avanzar(Posicion posicionActual){

        if (avanzarArriba(posicionActual) != posicionActual){
            avanzarArriba(posicionActual);
        }
        else {
            if (avanzarDerecha(posicionActual) != posicionActual){
                avanzarDerecha(posicionActual);
            }
            else {
                if (avanzarIzquierda(posicionActual) != posicionActual) {
                    avanzarArriba(posicionActual);
                }
            }
        }
        return retroceder(posicionActual);
    }

    private Posicion avanzarArriba(Posicion posicion){
        if (posicion.validarDatos()){
            int nuevaPosicionF = posicion.getFila() - 1;
            Posicion posicionN = new Posicion(nuevaPosicionF, posicion.getColumna());

            if (laberinto.getElemento(posicionN).equals(' ')) {
                laberinto.setElemento(posicion, rastroCamino);
                laberinto.setElemento(posicionN, jugador);
                caminoCorrecto.push(posicionN);
                return posicionN;
            }
            return posicion;
        }
        return posicion; // Invalido();
    }

    private Posicion avanzarDerecha(Posicion posicion){
        if (posicion.validarDatos()){
            int nuevaPosicionC = posicion.getColumna() - 1;
            Posicion posicionN = new Posicion(posicion.getFila(), nuevaPosicionC);

            if (laberinto.getElemento(posicionN).equals(' ')) {
            laberinto.setElemento(posicion, rastroCamino);
            laberinto.setElemento(posicionN, jugador);
            caminoCorrecto.push(posicionN);
            return posicionN;
            }
            return posicion;
        }
        return posicion; // Invalido();
    }

    private Posicion avanzarIzquierda(Posicion posicion){
        if (posicion.validarDatos()){
            int nuevaPosicionC = posicion.getColumna() + 1;
            Posicion posicionN = new Posicion(posicion.getFila(), nuevaPosicionC);

            if (laberinto.getElemento(posicionN).equals(' ')) {
                laberinto.setElemento(posicion, rastroCamino);
                laberinto.setElemento(posicionN, jugador);
                caminoCorrecto.push(posicionN);
                return posicionN;
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
}
