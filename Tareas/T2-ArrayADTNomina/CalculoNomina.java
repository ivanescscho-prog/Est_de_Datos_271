String rutaArchivo = "/home/ivan-desktop/Documents/Proyectos_SF/Proyectos_ICO_SF/SF2026/SF2608/Est_de_Datos_271/Tareas/T2-ArrayADTNomina/datos/junio.dat";

    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
String linea;
// Iterar mientras existan líneas de texto en el archivo
        while ((linea = br.readLine()) != null) {

// Separar los datos asumiendo que están divididos por comas
String[] datos = linea.split(",");

// Asegurar que la línea leída contiene los 4 datos exactos esperados
            if (datos.length == 4) {
// Limpiar espacios en blanco con trim() y convertir al tipo de dato correcto
String nombre = datos[0].trim();
double sueldoBase = Double.parseDouble(datos[1].trim());
int anioIngreso = Integer.parseInt(datos[2].trim());
int horasExtras = Integer.parseInt(datos[3].trim());

// Crear el objeto Empleado con los datos extraídos
Empleado emp = new Empleado(nombre, sueldoBase, anioIngreso, horasExtras);

// Insertarlo en el Tipo de Dato Abstracto
                nomina.insertarElemento(contadorEmpleados, emp);
contadorEmpleados++;
        }
        }
        } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
        }

int anioActual = 2026;
int maxAntiguedad = -1;
int minAntiguedad = 9999;

Empleado empMasAntiguo = null;
Empleado empMenosAntiguo = null;

        System.out.println("--- REPORTE DE EMPLEADOS ---");

        for (int i = 0; i < nomina.longitud(); i++) {
Empleado actual = nomina.obtenerElemento(i);

// 1. Desplegar datos y sueldo de todos
int antiguedadActual = actual.getAntiguedad(anioActual);
double sueldoFinal = actual.calcularSueldoMensual(anioActual);
            System.out.println("Nombre: " + actual.getNombre() + " | Antigüedad: " + antiguedadActual + " años | Sueldo a pagar: $" + sueldoFinal);

        // 2. Lógica para encontrar al de MAYOR antigüedad
        if (antiguedadActual > maxAntiguedad) {
maxAntiguedad = antiguedadActual;
empMasAntiguo = actual;
            }

                    // 3. Lógica para encontrar al de MENOR antigüedad
                    if (antiguedadActual < minAntiguedad) {
minAntiguedad = antiguedadActual;
empMenosAntiguo = actual;
            }
                    }

                    System.out.println("\--- RESULTADOS DE ANTIGÜEDAD ---");
        System.out.println("Trabajador con MAYOR antigüedad: " + empMasAntiguo.getNombre() + " (" + maxAntiguedad + " años)");
        System.out.println("Trabajador con MENOR antigüedad: " + empMenosAntiguo.getNombre() + " (" + minAntiguedad + " años)");
