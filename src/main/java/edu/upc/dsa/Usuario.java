package edu.upc.dsa;

import java.util.ArrayList;

public class Usuario {
    //atributos
    private String id;
    private String nombre;
    private ArrayList<PlayList> playlists;

    //constructores
    public Usuario(){
        this.playlists = new ArrayList<>();
    }

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.playlists = playlists;
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

    public ArrayList<PlayList> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<PlayList> playlists) {
        this.playlists = playlists;
    }

    //metodos
    public void añadirPlayList (PlayList playList){
        this.playlists.add(playList);
    }
}
