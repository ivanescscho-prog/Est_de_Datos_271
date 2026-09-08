package array2D.GameOfLife;
import array2D.Ajedrez.Array2D;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameOfLife {
    private Array2D tableroActual;
    private int filasTotales;
    private int columnasTotales;

    public GameOfLife(int filas, int columnas, String rutaCSV) {
        this.filasTotales = filas;
        this.columnasTotales = columnas;
        this.tableroActual = new Array2D<>(filas, columnas);

        try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV))) {
            String linea;
            int f = 0;
            while ((linea = br.readLine()) != null && f < filasTotales) {
                String[] valores = linea.split(",");
                for (int c = 0; c < columnasTotales && c < valores.length; c++) {
                    int estadoCelula = Integer.parseInt(valores[c].trim());
                    tableroActual.setElemento(f, c, estadoCelula);
                }
                f++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV.");
        }
    }

    private int contarVecinosVivos(int fila, int columna) {
        int vecinosVivos = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int filaVecina = fila + i;
                int colVecina = columna + j;

                if (filaVecina >= 0 && filaVecina < filasTotales && colVecina >= 0 && colVecina < columnasTotales) {
                    if ((Integer) tableroActual.getElemento(filaVecina, colVecina) == 1) {
                        vecinosVivos++;
                    }
                }
            }
        }
        return vecinosVivos;
    }

    public void calcularSiguienteGeneracion() {
        Array2D<Integer> tableroSiguiente = new Array2D<>(filasTotales, columnasTotales);

        for (int f = 0; f < filasTotales; f++) {
            for (int c = 0; c < columnasTotales; c++) {
                int estadoActual = (Integer) tableroActual.getElemento(f, c);
                int vecinos = contarVecinosVivos(f, c);

                if (estadoActual == 1) {
                    if (vecinos == 2 || vecinos == 3) {
                        tableroSiguiente.setElemento(f, c, 1);
                    } else {
                        tableroSiguiente.setElemento(f, c, 0);
                    }
                } else {
                    if (vecinos == 3) {
                        tableroSiguiente.setElemento(f, c, 1);
                    } else {
                        tableroSiguiente.setElemento(f, c, 0);
                    }
                }
            }
        }
        this.tableroActual = tableroSiguiente;
    }

    public void imprimirTablero() {
        for (int f = 0; f < filasTotales; f++) {
            for (int c = 0; c < columnasTotales; c++) {
                if ( (Integer) tableroActual.getElemento(f, c) == 1) {
                    System.out.print("■ ");
                } else {
                    System.out.print("□ ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
}
