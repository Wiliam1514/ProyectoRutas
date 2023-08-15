package proyectorutas.en;

public class Autobus {
    private int id;
    private String numeroAutobus;
    private int capacidad;
    private String modelo;
    private int anioFabricacion;

    public Autobus() {
    }

    public Autobus(int id, String numeroAutobus, int capacidad, String modelo, int anioFabricacion) {
        this.id = id;
        this.numeroAutobus = numeroAutobus;
        this.capacidad = capacidad;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroAutobus() {
        return numeroAutobus;
    }

    public void setNumeroAutobus(String numeroAutobus) {
        this.numeroAutobus = numeroAutobus;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
}
