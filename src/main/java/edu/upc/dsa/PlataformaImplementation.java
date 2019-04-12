package edu.upc.dsa;

import org.apache.log4j.Logger;
import sun.awt.image.ImageWatched;


import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class PlataformaImplementation implements Plataforma{
    private final static Logger log = Logger.getLogger(PlataformaImplementation.class.getName());
    //Singleton
    private static PlataformaImplementation instance;
    private int numArtistas;
    private HashMap<String,Usuario> users;
    private LinkedList<Titulo> titulos;
    private LinkedList<Artista> artists;
    private ArrayList<PlayList> playLists;

    //constructor privado
    private PlataformaImplementation(){
        this.numArtistas = 0;
        this.artists = new LinkedList<>();
        this.playLists = new ArrayList<>();
        this.users = new HashMap<>();
        this.titulos = new LinkedList<>();
    }
    //metodo getInstance
    public static Plataforma getInstance(){
        if (instance == null) instance = new PlataformaImplementation();
        return instance;

    }

    @Override
    public void añadirArtista(String id, String nombre) {
        Artista a = new Artista(id,nombre);
        this.artists.add(a);
        this.numArtistas++;


    }

    @Override
    public List<Artista> ListadoDeArtistas() {
        List<Artista> artistas = new LinkedList<>();
        artistas.addAll(this.artists);
        return artistas;





    }



    @Override
    public void añadirTitulo(String titulo , String idPlaylist) throws PlayListNotFoundException {
        PlayList playlist = this.getPlayList(idPlaylist);
        playlist.añadirTitulo(titulo);

    }

    @Override
    public void crearPlayList(String id, String idUsuario, String nombre) throws UsuarioNotFoundException {
        Usuario usuario = this.users.get(idUsuario);
        PlayList playList = new PlayList(id,usuario,nombre);
        this.playLists.add(playList);


    }

    @Override
    public List<PlayList> ListadoDePlayLists(String Usuario) throws UsuarioNotFoundException {
        Usuario usuario = this.users.get(Usuario);

        if(usuario != null){
            ArrayList<PlayList> playLists = usuario.getPlaylists();
            log.info("Lista playlists del usuario " + Usuario +  ": " + playLists);
            return playLists;




        }else {
            log.info("Usuario no encontrado");
            throw new UsuarioNotFoundException();
        }


    }
    @Override
    public void añadirUsuario(String id, String nombre) {
        this.users.put(id, new Usuario (id,nombre));
        log.info(users.size());
        log.info("User added:" + this.users.get(id));


    }

    @Override
    public int numArtistas() {
        return 0;
    }

    @Override
    public int numPlaylists() {
        return 0;
    }

    public PlayList getPlayList (String idPlaylist) throws PlayListNotFoundException {
        for (int i = 0; i < this.numPlaylists(); i++) {
            if (idPlaylist.equals(this.playLists.get(i).getId())) return this.playLists.get(i);
        }
        log.info("Playlist no encontrada ");
        throw new PlayListNotFoundException();
    }
    private int getArtistById(String idArtist) throws ArtistaNotFoundException {
        for (int i = 0; i < this.numArtistas(); i++) {
            if (idArtist.equals(this.artists.get(i).getId())) return i;
        }
        log.info("Artist not found");
        throw new ArtistaNotFoundException();
    }
    @Override
    public void clear() {
        instance = null;
        this.playLists = null;
        this.titulos = null;
        this.artists = null;
        this.users = null;
        log.info("Data cleared");
    }

    @Override
    public int numUsers() {
        return 0;
    }


}
