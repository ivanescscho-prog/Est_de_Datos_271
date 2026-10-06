package Casa;

import Casa.ListaLigadaADT;

public class Main {
    public static void main(String[] args) {
        ListaLigadaADT<Casa> catalogoCasas = new ListaLigadaADT<Casa>();

        // 1. Instanciar los componentes
        Recamara recamaraPrincipal = new Recamara(1, true, "Lujo", 16.5f, "Recamara Principal Plus");
        Banio banioVisitas = new Banio(1, false, false, 4.0f, "Medio Baño", "Basico");
        Cocina cocinaIntegral = new Cocina(12.0f, "Cocina en L");
        SalaComedor sala = new SalaComedor("Abierto", 6, 25.0f, true);

        // 2. Construir el objeto Casa y agregarle sus componentes
        Casa modeloA = new Casa("Prototipo A", 1250000.0f, 1, 1, 10.0f);
        modeloA.agregarDescripcion("Casa ideal para parejas");
        modeloA.agregarRecamara(recamaraPrincipal);
        modeloA.agregarBanio(banioVisitas);
        modeloA.agregarCocina(cocinaIntegral);
        modeloA.agregarSalaComedor(sala);

        Casa modeloB = new Casa("Prototipo B", 2500000.0f, 2, 2, 15.0f);

        // 3. Probar los métodos ADT con los objetos complejos
        System.out.println("--- Agregando e imprimiendo ---");
        catalogoCasas.agregar(modeloA);
        catalogoCasas.agregarAlInicio(modeloB);
        catalogoCasas.transversal();

        System.out.println("\n\n--- Buscando un elemento ---");
        int index = catalogoCasas.buscar(modeloA);
        System.out.println("El Prototipo A está en el nodo con índice: " + index);

        System.out.println("\n--- Eliminando el primer elemento (Prototipo B) ---");
        catalogoCasas.eliminarElPrimero();
        catalogoCasas.transversal();
    }
}
