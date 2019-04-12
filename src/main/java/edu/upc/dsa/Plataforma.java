package edu.upc.dsa;

import java.util.List;

public interface Plataforma {
    //fachada
    public void añadirArtista(String id, String nombre);
    public List<Artista> ListadoDeArtistas () throws ArtistaNotFoundException;
    public void añadirTitulo (String id, String nombre, Artista artista, String idPlayList) throws PlayListNotFoundException;
    public void crearPlayList (String id,Usuario usuario, String nombre) throws UsuarioNotFoundException;
    public List<PlayList> ListadoDePlayLists (String Usuario) throws UsuarioNotFoundException;


}
