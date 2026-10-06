package Nodos;

public class Main {
    public static void main(String[] args) {

        Nodo head = new Nodo<>("AL", new Nodo<>("B", new Nodo<>("C",new Nodo<>("De",new Nodo<>("Mc",new Nodo<>("Zi"))))));

        System.out.println(head.getSiguiente());

        /* 1. Construye manualmente la lista inicial según la imagen anexa
        Nodo<String> nodoAl = new Nodo<>("Al");
        Nodo<String> nodoB  = new Nodo<>("B");
        Nodo<String> nodoC  = new Nodo<>("C");
        Nodo<String> nodoDe = new Nodo<>("De");
        Nodo<String> nodoMc = new Nodo<>("Mc");
        Nodo<String> nodoZi = new Nodo<>("Zi");

        // Enlazamos los nodos mediante referencias físicas en memoria
        nodoAl.setSiguiente(nodoB);
        nodoB.setSiguiente(nodoC);
        nodoC.setSiguiente(nodoDe);
        nodoDe.setSiguiente(nodoMc);
        nodoMc.setSiguiente(nodoZi);*/

        // Definimos la 'head' apuntando al primer nodo de la estructura
        // Nodo<String> head = nodoAl;

        /* 2. Imprime el estado inicial completo
        System.out.println("--- Estado Inicial ---");
        imprimirLista(head);

        // 3. Imprime únicamente el dato del primer nodo de la lista
        System.out.println("\n--- Dato del primer nodo ---");
        System.out.println(head.getDato());

        // 4. Imprime el estado completo del último nodo
        System.out.println("\n--- Estado del último nodo ---");
        // Sabemos que 'nodoZi' es el último en este punto
        System.out.println("Nodo: " + nodoZi.toString() + " | Apunta a: " + nodoZi.getSiguiente());

        // 5. Inserta un nuevo nodo "Fe" entre "De" y "Mc"
        Nodo<String> nodoFe = new Nodo<>("Fe");
        // Primero, "Fe" debe apuntar a lo que actualmente apunta "De" (que es "Mc")
        nodoFe.setSiguiente(nodoDe.getSiguiente());
        // Luego, "De" rompe su enlace con "Mc" y ahora apunta a "Fe"
        nodoDe.setSiguiente(nodoFe);

        // 6. Imprime el nuevo estado de la lista
        System.out.println("\n--- Lista tras insertar 'Fe' ---");
        imprimirLista(head);

        // 7. Inserta un nuevo nodo "Zz" al final de la lista
        Nodo<String> nodoZz = new Nodo<>("Zz");
        // Como sabemos que 'nodoZi' era el último, simplemente hacemos que apunte a "Zz"
        nodoZi.setSiguiente(nodoZz);

        // 8. Imprime el nuevo estado de la lista
        System.out.println("\n--- Lista tras insertar 'Zz' al final ---");
        imprimirLista(head);

        // 9. Inserta un nuevo nodo "Aa" al inicio de la lista
        Nodo<String> nodoAa = new Nodo<>("Aa");
        // "Aa" debe apuntar a la antigua cabeza ("Al")
        nodoAa.setSiguiente(head);
        // Actualizamos nuestro puntero principal 'head' para que reconozca a "Aa" como el nuevo inicio
        head = nodoAa;

        // 10. Imprime el estado final de la lista
        System.out.println("\n--- Estado Final de la Lista ---");
        imprimirLista(head);
    }

    // Método auxiliar para recorrer la lista de inicio a fin e imprimirla
    public static void imprimirLista(Nodo<String> inicio) {
        Nodo<String> temporal = inicio;
        while (temporal != null) {
            System.out.print(temporal.toString());
            if (temporal.getSiguiente() != null) {
                System.out.print(" -> ");
            }
            // Avanzamos al siguiente nodo
            temporal = temporal.getSiguiente();
        }
        System.out.println();*/
    }
}