package edu.upc.dsa;

import java.util.LinkedList;

public class PlayList {
    //atributos
    private String id;
    private String nombre;
    private LinkedList<Titulo> titulos;
    private Usuario usuario;

    //constructores
    public PlayList(String id, Usuario usuario, String nombre){
        this.titulos = new LinkedList<>();
    }

    public PlayList(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.titulos = titulos;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(LinkedList<Titulo> titulos) {
        this.titulos = titulos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //metodos
    public void añadirTitulo (String titulo){
        this.titulos.add(titulo);
    }
}
