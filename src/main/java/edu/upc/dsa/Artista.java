package edu.upc.dsa;

import java.util.LinkedList;

public class Artista {
    //atributos
    private String id;
    private String nombre;
    private LinkedList<Titulo> titulos;
    //constructores
    public Artista (){
        this.titulos = new LinkedList<>();
    }

    public Artista(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.titulos = titulos;
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

    //metodo
    public void añadirTitulo(Titulo titulo){
        this.titulos.add(titulo);
    }
}
