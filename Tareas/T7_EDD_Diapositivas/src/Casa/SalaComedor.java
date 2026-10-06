package Casa;

public class SalaComedor {
    private String modelo;
    private int capacidadPersonas;
    private float m2Construidos;
    private boolean terraza;

    public SalaComedor(String modelo, int capacidadPersonas, float m2Construidos, boolean terraza) {
        this.modelo = modelo;
        this.capacidadPersonas = capacidadPersonas;
        this.m2Construidos = m2Construidos;
        this.terraza = terraza;
    }

    public float getM2Construidos() { return m2Construidos; }

    @Override
    public String toString() {
        return "SalaComedor{" + modelo + ", capacidad=" + capacidadPersonas + ", m2=" + m2Construidos + "}";
    }
}