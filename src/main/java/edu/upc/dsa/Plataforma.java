package edu.upc.dsa;

public interface Plataforma {
    //fachada
    public void añadirArtista(String id, String nombre);
    public List<Artista> ListadoDeArtistas () throws ArtistaNotFoundException;
    public void añadirTitulo (String id, String nombre, Artista artista);
    public void crearPlayList (String id) throws UsuarioNotFoundException;
    public List<PlayList> ListadoDePlayLists (String Usuario) throws UsuarioNotFoundException;


}
