package EDD_Laberinto;

public class Pila<T> {
    private Nodo<T> tope;
    private int tamanio;

    // Constructor
    public Pila() {
        this.tope = null;
        this.tamanio = 0;
    }

    public Pila(Nodo<T> dato) {
        this.tope = dato;
        this.tamanio = 1;
    }


    public boolean estaVacia() {
        return tope == null;
    }


    public void push(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
        tamanio++;
    }


    public T pop() {
        if (estaVacia()) {
            throw new IllegalStateException("Error: La pila está vacía (Underflow).");
        }
        T datoAux = tope.getDato();
        tope = tope.getSiguiente();
        tamanio--;
        return datoAux;
    }


    public T peek() {
        if (estaVacia()) {
            throw new IllegalStateException("Error: La pila está vacía.");
        }
        return tope.getDato();
    }

    // Obtener el tamaño actual
    public int getTamanio() {
        return tamanio;
    }
}