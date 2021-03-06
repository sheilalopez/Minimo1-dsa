package edu.upc.dsa;

import java.util.List;

public interface Plataforma {
    //fachada
    public void añadirArtista(String id, String nombre);
    public List<Artista> ListadoDeArtistas ();
    public void añadirTitulo(String idUser, String idPlayList, String idTitulo, String nombre, String artista) throws PlayListNotFoundException, UsuarioNotFoundException,ArtistaNotFoundException;
    public void crearPlayList (String id,String idUsuario, String nombre) throws UsuarioNotFoundException;
    public List<PlayList> ListadoDePlayLists (String Usuario) throws UsuarioNotFoundException;
    public void añadirUsuario (String id, String nombre);

    int numArtistas ();
    int numPlaylists();
    int numTitulos();

    public void clear();


    int numUsers();
}
