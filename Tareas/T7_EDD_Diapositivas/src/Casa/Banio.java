package Casa;

public class Banio {
    private int noLavabos;
    private boolean tina;
    private boolean regadera;
    private float m2Construidos;
    private String tipoBanio;
    private String modelo;

    public Banio(int noLavabos, boolean tina, boolean regadera, float m2Construidos, String tipoBanio, String modelo) {
        this.noLavabos = noLavabos;
        this.tina = tina;
        this.regadera = regadera;
        this.m2Construidos = m2Construidos;
        this.tipoBanio = tipoBanio;
        this.modelo = modelo;
    }

    public float getM2Construidos() { return m2Construidos; }

    @Override
    public String toString() {
        return "Banio{" + modelo + ", lavabos=" + noLavabos + ", m2=" + m2Construidos + "}";
    }
}