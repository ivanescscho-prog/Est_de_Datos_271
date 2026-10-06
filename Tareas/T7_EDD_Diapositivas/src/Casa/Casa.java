package Casa;

public class Casa {
    private float m2Construidos;
    private float precio;
    private String modelo;
    private int noRecamaras;
    private int noBanio;
    private float m2OtrasAreas;
    private String descripcion;
    private float precioPorM2;

    // Relaciones de composición
    private Recamara[] arregloRecamaras;
    private Banio[] arregloBanios;
    private Cocina cocina;
    private SalaComedor salaComedor;

    // Contadores para controlar los arreglos
    private int indiceRecamara = 0;
    private int indiceBanio = 0;

    public Casa(String modelo, float precio, int noRecamaras, int noBanio, float m2OtrasAreas) {
        this.modelo = modelo;
        this.precio = precio;
        this.noRecamaras = noRecamaras;
        this.noBanio = noBanio;
        this.m2OtrasAreas = m2OtrasAreas;

        // Se inicializan los espacios según el tamaño indicado
        this.arregloRecamaras = new Recamara[noRecamaras];
        this.arregloBanios = new Banio[noBanio];

        calcularM2Construidos(); // Cálculo inicial
    }

    public void agregarRecamara(Recamara r) {
        if (indiceRecamara < noRecamaras) {
            arregloRecamaras[indiceRecamara] = r;
            indiceRecamara++;
            calcularM2Construidos();
        }
    }

    public void agregarBanio(Banio b) {
        if (indiceBanio < noBanio) {
            arregloBanios[indiceBanio] = b;
            indiceBanio++;
            calcularM2Construidos();
        }
    }

    public void agregarCocina(Cocina c) {
        this.cocina = c;
        calcularM2Construidos();
    }

    public void agregarSalaComedor(SalaComedor sc) {
        this.salaComedor = sc;
        calcularM2Construidos();
    }

    public void agregarDescripcion(String desc) {
        this.descripcion = desc;
    }

    public float precio() {
        return this.precio;
    }

    private void calcularM2Construidos() {
        float sumaM2 = this.m2OtrasAreas;

        for (int i = 0; i < indiceRecamara; i++) {
            sumaM2 += arregloRecamaras[i].getM2Construidos();
        }
        for (int i = 0; i < indiceBanio; i++) {
            sumaM2 += arregloBanios[i].getM2Construidos();
        }
        if (this.cocina != null) {
            sumaM2 += this.cocina.getM2Construidos();
        }
        if (this.salaComedor != null) {
            sumaM2 += this.salaComedor.getM2Construidos();
        }

        this.m2Construidos = sumaM2;
        calcularPrecioPorM2();
    }

    private void calcularPrecioPorM2() {
        if (this.m2Construidos > 0) {
            this.precioPorM2 = this.precio / this.m2Construidos;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Casa otraCasa = (Casa) obj;
        if (this.modelo != null) {
            return this.modelo.equals(otraCasa.modelo);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Casa{" + modelo + ", Precio=$" + precio + ", M2 Totales=" + m2Construidos +
                ", Precio/M2=$" + precioPorM2 + "}";
    }
}
