package Laberinto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import EDD_Laberinto.Array2D;
import EDD_Laberinto.Nodo;
import EDD_Laberinto.Pila;

public class Main {
    public static void main(String[] args) {
        /*
        Array2D<Character> laberintoP01 = leerArchivo("Tareas/T7-1_Opcional_Laberinto/Entradas_Tableros/entrada.lab");

        if (laberintoP01 != null) {
            System.out.println("Dimensiones del laberinto: " + laberintoP01.getNoFilas() + "x" + laberintoP01.getNoColumnas());
            System.out.println("Elemento en (0,0): " + laberintoP01.getElemento(0, 0));
        }

        Array2D<Character> laberintoP02 = leerArchivo("Tareas/T7-1_Opcional_Laberinto/Entradas_Tableros/entrada2.lab");

        if (laberintoP01 != null) {
            System.out.println("Dimensiones del laberinto: " + laberintoP01.getNoFilas() + "x" + laberintoP01.getNoColumnas());
            System.out.println("Elemento en (0,0): " + laberintoP01.getElemento(0, 0));
        }

        Array2D<Character> laberintoP03 = leerArchivo("Tareas/T7-1_Opcional_Laberinto/Entradas_Tableros/entrada3.lab");

        if (laberintoP01 != null) {
            System.out.println("Dimensiones del laberinto: " + laberintoP01.getNoFilas() + "x" + laberintoP01.getNoColumnas());
            System.out.println("Elemento en (0,0): " + laberintoP01.getElemento(0, 0));
        }

        Array2D<Character> laberintoP04 = leerArchivo("Tareas/T7-1_Opcional_Laberinto/Entradas_Tableros/entrada4.lab");

        if (laberintoP01 != null) {
            System.out.println("Dimensiones del laberinto: " + laberintoP01.getNoFilas() + "x" + laberintoP01.getNoColumnas());
            System.out.println("Elemento en (0,0): " + laberintoP01.getElemento(0, 0));
        }

        Array2D<Character> laberintoP05 = leerArchivo("Tareas/T7-1_Opcional_Laberinto/Entradas_Tableros/entrada5.lab");

        if (laberintoP01 != null) {
            System.out.println("Dimensiones del laberinto: " + laberintoP01.getNoFilas() + "x" + laberintoP01.getNoColumnas());
            System.out.println("Elemento en (0,0): " + laberintoP01.getElemento(0, 0));
        }

        Array2D<Character> laberintoP06 = leerArchivo("Tareas/T7-1_Opcional_Laberinto/Entradas_Tableros/entrada7.lab");

        if (laberintoP01 != null) {
            System.out.println("Dimensiones del laberinto: " + laberintoP01.getNoFilas() + "x" + laberintoP01.getNoColumnas());
            System.out.println("Elemento en (0,0): " + laberintoP01.getElemento(0, 0));
        }

        laberintoP01.imprimirTablero();
        System.out.println();
        laberintoP02.imprimirTablero();
        System.out.println();
        laberintoP03.imprimirTablero();
        System.out.println();
        laberintoP04.imprimirTablero();
        System.out.println();
        laberintoP05.imprimirTablero();
        System.out.println();
        laberintoP06.imprimirTablero();
*/
        Posicion posicionEntrada = new Posicion(10,10);

        Nodo recorrido = new Nodo(posicionEntrada);
        Pila<Posicion> caminoCorrecto = new Pila<>(recorrido);

        /*
        caminoCorrecto.push("30");
        caminoCorrecto.push(19);
        System.out.println(caminoCorrecto.peek());

        caminoCorrecto.pop();
        caminoCorrecto.push("fin de la pila");
        System.out.println(caminoCorrecto.peek());

        caminoCorrecto.pop();
        caminoCorrecto.pop();
        */

        System.out.println(caminoCorrecto.peek());
        System.out.println(caminoCorrecto.peek().obtenerDatos("x"));
        System.out.println(caminoCorrecto.getTamanio());
    }

    // Extraer Tablero de un archivo .lab
    public static Array2D<Character> leerArchivo(String rutaArchivo) {
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


                    char simboloMapeado = mapearSimbolo(simboloOriginal);


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
    private static char mapearSimbolo(char entrada) {
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
}