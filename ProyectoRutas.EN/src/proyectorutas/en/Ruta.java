package proyectorutas.en;

public class Ruta {
    private int id;
     private int idDepartamento;
    private String nombreRuta;
    private String recorrido;
    private String puntoSalida;
    private String puntoLlegada;
    private String horaInicio;
    private String horaFin;
    private String codigoBus;
    private int top_aux;
     private Departamento departamento;
    
    /*private int idConductor;
    private int idAutobus;*/

    public Ruta() {
    }

    public Ruta(int id, int idDepartamento, String nombreRuta, String recorrido, String puntoSalida, String puntoLlegada, String horaInicio,
               String horaFin, String codigoBus,int top_aux, Departamento departamento) {
        this.id = id;
        this.idDepartamento = idDepartamento;
        this.nombreRuta = nombreRuta;
        this.recorrido = recorrido;
        this.puntoSalida = puntoSalida;
        this.puntoLlegada = puntoLlegada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.codigoBus = codigoBus;
        this.top_aux = top_aux;
        this.departamento = departamento;
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public String getPuntoSalida() {
        return puntoSalida;
    }

    public void setPuntoSalida(String puntoSalida) {
        this.puntoSalida = puntoSalida;
    }
    public String getPuntoLlegada() {
        return puntoLlegada;
    }
    public void setPuntoLlegada(String puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }
    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getHoraFin(){
        return horaFin;
    }
    public void setHoraFin (String horaFin){
        this.horaFin = horaFin;
    }
    public String getCodigoBus (){
        return codigoBus;
    }
    public void setCodigoBus (String codigoBus ){
        this.codigoBus = codigoBus;
    }
    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    
    public Departamento  getDepartamento() {
    return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
