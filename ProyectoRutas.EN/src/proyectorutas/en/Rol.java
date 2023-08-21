package proyectorutas.en;

import java.util.ArrayList;

public class Rol {
    private int id;
    private String nombreRol;
    private int top_aux;
    private ArrayList<Usuario> usuarios;
    public Rol() {
    }

    public Rol(int id, String nombreRol, int top_aux, ArrayList<Usuario> usuarios ) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.top_aux = top_aux;
        this.usuarios = usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
