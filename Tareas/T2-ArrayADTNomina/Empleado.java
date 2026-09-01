// package mx.unam.aragon.ico.edd.arreglos;

public class Empleado {
    private String nombre;
    private double sueldoBase;
    private int anioIngreso;
    private int horasExtras;

    public Empleado(String nombre, double sueldoBase, int anioIngreso, int horasExtras) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.anioIngreso = anioIngreso;
        this.horasExtras = horasExtras;
    }

    public int getAntiguedad(int anioActual) {
        return anioActual - this.anioIngreso;
    }

    public double calcularSueldoMensual(int anioActual) {
        double bono = this.sueldoBase * (this.getAntiguedad(anioActual) * 0.03);
        double extra = this.horasExtras * 276.5;
        return this.sueldoBase + bono + extra;
    }

    public String getNombre() {
        return nombre;
    }
}