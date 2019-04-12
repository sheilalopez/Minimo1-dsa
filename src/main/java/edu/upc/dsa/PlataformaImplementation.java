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


    }

    @Override
    public List<Artista> ListadoDeArtistas() throws ArtistaNotFoundException {
        List<Artista> artistas = new LinkedList<>();
        artistas.addAll(this.artists);
        return artistas;





    }


    @Override
    public void añadirTitulo(String id, String nombre, Artista artista, String idPlayList) throws PlayListNotFoundException {
       Titulo titulo = new Titulo(id,nombre,artista);
       PlayList playList = this.playLists.get(idPlayList);
       if (playList != null){
           log.info("La playList existe");
           playList.añadirTitulo(titulo);
       }else {
           throw new PlayListNotFoundException();
       }







    }

    @Override
    public void crearPlayList(String id, Usuario usuario, String nombre) throws UsuarioNotFoundException {
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




}
