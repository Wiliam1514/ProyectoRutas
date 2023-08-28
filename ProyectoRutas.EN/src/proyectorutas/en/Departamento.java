package proyectorutas.en;

import java.util.ArrayList;

public class Departamento {
    private int id;
    private String nombreDepartamento;
     private int top_aux;
    private ArrayList<Ruta> rutas;

    public Departamento() {
    }

    public Departamento(int id, String nombreDepartamento, int top_aux,ArrayList<Ruta> rutas ) {
        this.id = id;
        this.nombreDepartamento = nombreDepartamento;
        this.top_aux = top_aux;
        this.rutas = rutas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }
    public ArrayList<Ruta> getRutas() {
        return rutas;
    }
    public void setRutas(ArrayList<Ruta> rutas) {
        this.rutas = rutas;
    }
}
