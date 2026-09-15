package conjuntos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main { // Creación de conjuto a partir de archivo csv obtenido de kaggle. Venta de productos dn amazon
    public static void main(String[] args) {

        String archivoCSV = "Tareas/T4_Conjuntos/Recursos/amazon.csv";
        String archivoTXT = "Tareas/T4_Conjuntos/Recursos/productos_unicos.txt";
        ConjuntoADT<String> conjuntoProductos = new ConjuntoADT<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) { // lectura
            String linea;
            boolean esCabecera = true;

            while ((linea = br.readLine()) != null) {
                if (esCabecera) {
                    esCabecera = false;
                    continue;
                }

                String[] columnas = linea.split(",");
                if (columnas.length > 0) {
                    String productId = columnas[0];
                    conjuntoProductos.agregarElemento(productId);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
            return;
        }

        System.out.println("Estos son los primeros 40 elementos del conjunto");
        int contador = 0;
            for (String id : conjuntoProductos.getElementos()) {
            System.out.println((contador + 1) + ". " + id);
            contador++;
            if (contador >= 40) {
                break;
            }
        }

        System.out.println("Total de elementos del conjunto: " + conjuntoProductos.longitud());

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoTXT))) {
            for (String id : conjuntoProductos.getElementos()) {
                pw.println(id);
            }
            System.out.println("\nSe ha exportado exitosamente el archivo: " + archivoTXT);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo TXT: " + e.getMessage());
        }
    }
}