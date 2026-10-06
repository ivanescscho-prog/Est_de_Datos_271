package Casa;

public class Recamara {
    private int noCamas;
    private boolean banio;
    private String modBanio;
    private float m2Construidos;
    private String modelo;

    public Recamara(int noCamas, boolean banio, String modBanio, float m2Construidos, String modelo) {
        this.noCamas = noCamas;
        this.banio = banio;
        this.modBanio = modBanio;
        this.m2Construidos = m2Construidos;
        this.modelo = modelo;
    }

    public float getM2Construidos() { return m2Construidos; }

    @Override
    public String toString() {
        return "Recamara{" + modelo + ", camas=" + noCamas + ", m2=" + m2Construidos + "}";
    }
}
