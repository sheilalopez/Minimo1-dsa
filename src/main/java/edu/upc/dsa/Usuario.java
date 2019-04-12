package edu.upc.dsa;

import java.util.ArrayList;
import java.util.LinkedList;

public class Usuario {
    //atributos
    private String id;
    private String nombre;
    private ArrayList<PlayList> playlists;
    private LinkedList<Artista> artistas;

    //constructores
    public Usuario(){
        this.playlists = new ArrayList<>();
        this.artistas = new LinkedList<>();
    }

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.playlists = playlists;
        this.artistas = artistas;

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

    public LinkedList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(LinkedList<Artista> artistas) {
        this.artistas = artistas;
    }

    //metodos
    public void añadirPlayList (PlayList playList){
        this.playlists.add(playList);
    }
    public void añadirArtista (Artista artista){
        this.artistas.add(artista);
    }
}
