package Laberinto;


public class Main {
    public static void main(String[] args) {

        BackTracking laberinto01 = new BackTracking(10,3);
        laberinto01.construirLaberinto("Tareas/T7-1_Opcional_Laberinto/Entradas_Tableros/entrada.lab");

        laberinto01.getLaberinto().imprimirTablero(); // Tablero construido sin resolver

        laberinto01.jugadorEnEntrada();
        System.out.println("\nJugador listo para arrancar\n");
        laberinto01.getLaberinto().imprimirTablero(); // Tablero con jugador posicionado en la entrada

        laberinto01.solucionarLaberinto();
        System.out.println("\n" + laberinto01.getCamino().peek());

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

        Posicion posicionEntrada = new Posicion(10,10);

        Nodo recorrido = new Nodo(posicionEntrada);
        Pila<Posicion> camino = new Pila<>(recorrido);

        camino.push("30");
        camino.push(19);
        System.out.println(camino.peek());

        camino.pop();
        camino.push("fin de la pila");
        System.out.println(camino.peek());

        camino.pop();
        camino.pop();

        System.out.println(camino.peek());
        System.out.println(camino.peek().obtenerDatos("X"));
        System.out.println(camino.getTamanio());
        */
    }

}