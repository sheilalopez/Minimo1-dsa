package edu.upc.dsa;

import java.util.List;

public interface Plataforma {
    //fachada
    public void añadirArtista(String id, String nombre);
    public List<Artista> ListadoDeArtistas ();
    public void añadirTitulo(String titulo , String idPlaylist) throws PlayListNotFoundException;
    public void crearPlayList (String id,String idUsuario, String nombre) throws UsuarioNotFoundException;
    public List<PlayList> ListadoDePlayLists (String Usuario) throws UsuarioNotFoundException;
    public void añadirUsuario (String id, String nombre);

    int numArtistas ();
    int numPlaylists();

    public void clear();


    int numUsers();
}
