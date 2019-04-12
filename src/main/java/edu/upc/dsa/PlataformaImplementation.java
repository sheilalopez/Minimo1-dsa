package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PlataformaImplementation implements Plataforma{
    private final static Logger log = Logger.getLogger(PlataformaImplementation.class.getName());
    //Singleton
    private static PlataformaImplementation instance;
    private int numArtistas;
    private HashMap<String,Usuario> usuarios;
    private LinkedList<Titulo> titulos;
    private LinkedList<Artista> artistas;
    private ArrayList<PlayList> playLists;

    //constructor privado
    private PlataformaImplementation(){
        this.numArtistas = 0;
        this.artistas = new LinkedList<>();
        this.playLists = new ArrayList<>();
        this.usuarios = new HashMap<>();
        this.titulos = new LinkedList<>();
    }
    //metodo getInstance
    public static Plataforma getInstance(){
        if (instance == null) instance = new PlataformaImplementation();
        return instance;

    }

    @Override
    public void añadirArtista(String id, String nombre) {

    }

    @Override
    public List<Artista> ListadoDeArtistas() throws ArtistaNotFoundException {
        return null;
    }

    @Override
    public void añadirTitulo(String id, String nombre, Artista artista) {

    }

    @Override
    public void crearPlayList(String id) throws UsuarioNotFoundException {

    }

    @Override
    public List<PlayList> ListadoDePlayLists(String Usuario) throws UsuarioNotFoundException {
        return null;
    }




}
