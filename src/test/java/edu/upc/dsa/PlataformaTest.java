package edu.upc.dsa;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlataformaTest {
    private Plataforma pt;

    @Before
    public void setUp() throws UsuarioNotFoundException, PlayListNotFoundException, ArtistaNotFoundException {
        this.pt = PlataformaImplementation.getInstance();
        //añado Usuarios
        this.pt.añadirUsuario("usuario1", "Sheila");
        this.pt.añadirUsuario("usuario2", "Jana");
        //añado playlists
        this.pt.crearPlayList("playlist1", "Sheila", "country");
        this.pt.crearPlayList("playlist2", "Sheila", "pop");
        this.pt.crearPlayList("playlist3", "Jana", "divertidas");


        //añadir artista
        this.pt.añadirArtista("artista1", "losdelrio");
        this.pt.añadirArtista("artista2", "arianagrande");
        Assert.assertEquals(2, this.pt.numArtistas());
        Assert.assertEquals(3, this.pt.numPlaylists());
        //añado titulos
        this.pt.añadirTitulo("usuario1", "playlist2", "titulo1", "goodisawoman", "arianagrande");
        this.pt.añadirTitulo("usuario1", "playlist2", "titulo2", "breakfree", "arianagrande");
        this.pt.añadirTitulo("usuario2", "playlist3", "titulo1", "macarena", "losdelrio");


        @After
        public void tearDown () {
            this.pt.clear();
        }
        @Test
        public void testAñadirUsuario () {
            this.pt.añadirUsuario("usuario2", "Sergi");
            Assert.assertEquals(3, this.pt.numUsers());
        }
        @Test
        public void testAñadirArtista () {
            this.pt.añadirArtista("artista3", "EdSheeran");
            Assert.assertEquals(3, this.pt.numArtistas());
        }

        @Test
        public void testañadirPlayList ()throws UsuarioNotFoundException {
            this.pt.crearPlayList("playlist3", "usuario1", "rock");
            Assert.assertEquals(4, this.pt.numPlaylists());
        }
        @Test
        public void testAñadirTitulo () throws
        UsuarioNotFoundException, PlayListNotFoundException, ArtistaNotFoundException
        {
            this.pt.añadirArtista("artista6", "Estopa");
            this.pt.añadirArtista("artista7", "JulioIglesias");

            Assert.assertEquals(5, this.pt.numArtistas());

            this.pt.añadirTitulo("usuario1", "playlist2", "titulo5", "barcelona", "EdSheeran");
            this.pt.añadirTitulo("usuario1", "playlist2", "titulo6", "perfect", "EdSheeran");
            Assert.assertEquals(4, this.pt.numTitulos());

        }
    }
}











