package edu.upc.dsa;

import java.util.ArrayList;

public class Titulo {
    //atributos
    private String id;
    private String nombre;
    private String artista;
    private ArrayList<PlayList> playlists;

    //constructores
    public Titulo(){
        this.playlists = new ArrayList<>();
    }

    public Titulo(String id, String nombre, String artista) {
        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public ArrayList<PlayList> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<PlayList> playlists) {
        this.playlists = playlists;
    }

    //metodos
    public void añadirPlayList (PlayList playlist){
        this.playlists.add(playlist);
    }
}
