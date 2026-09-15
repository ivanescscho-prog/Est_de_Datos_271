package conjuntos;

import java.util.ArrayList;

public class ConjuntoADT<T> {
    private ArrayList<T> elementos;

    public ConjuntoADT(){
        this.elementos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ConjuntoADT{" +
                "elementos=" + elementos +
                '}';
    }

    public ArrayList<T> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<T> nuevosElementos) {
        if (nuevosElementos != null) {
            this.elementos = new ArrayList<>();
            for (T item : nuevosElementos) {
                this.agregarElemento(item);
            }
        }
    }

    public int longitud(){
        return elementos.size();
    }

    public void agregarElemento(T elemento){
        if (!this.contieneElemento(elemento)){
            elementos.add(elemento);
        }
    }

    public boolean contieneElemento(T elemento){
        return elementos.contains(elemento);
    }
}
