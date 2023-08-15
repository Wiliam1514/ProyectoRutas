package proyectorutas.en;

public class Ruta {
    private int id;
    private String nombreRuta;
    private String descripcion;
    private String horario;
    private int idDepartamento;
    private int idConductor;
    private int idAutobus;

    public Ruta() {
    }

    public Ruta(int id, String nombreRuta, String descripcion, String horario,
                int idDepartamento, int idConductor, int idAutobus) {
        this.id = id;
        this.nombreRuta = nombreRuta;
        this.descripcion = descripcion;
        this.horario = horario;
        this.idDepartamento = idDepartamento;
        this.idConductor = idConductor;
        this.idAutobus = idAutobus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public int getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(int idAutobus) {
        this.idAutobus = idAutobus;
    }
}
