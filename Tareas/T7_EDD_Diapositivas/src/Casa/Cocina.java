package Casa;

public class Cocina {
    private float m2Construidos;
    private String modelo;

    public Cocina(float m2Construidos, String modelo) {
        this.m2Construidos = m2Construidos;
        this.modelo = modelo;
    }

    public float getM2Construidos() { return m2Construidos; }

    @Override
    public String toString() {
        return "Cocina{" + modelo + ", m2=" + m2Construidos + "}";
    }
}