package edu.upc.dsa;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlataformaTest {
        private Plataforma pt;
@Before
public void setUp() throws UsuarioNotFoundException, PlayListNotFoundException{
    this.pt = PlataformaImplementation.getInstance();
    //añado Usuarios
    this.pt.añadirUsuario("usuario1","Sheila");
    this.pt.añadirUsuario("usuario2","Jana");
    //añado playlists
    this.pt.crearPlayList("playlist1","Sheila","country");
    this.pt.crearPlayList("playlist2","Sheila","pop");
    this.pt.crearPlayList("playlist3","Jana","divertidas");



    //añadir artista
    this.pt.añadirArtista("artista1","losdelrio");
    this.pt.añadirArtista("artista2","arianagrande");
    Assert.assertEquals(2,this.pt.numArtistas());
    Assert.assertEquals(3,this.pt.numPlaylists());
    //añado titulos
    this.pt.añadirTitulo("goodisawoman","playlist2");
    this.pt.añadirTitulo("macarena","playlist3");


    @After
    public void tearDown(){
        this.mb.clear();
    }


    @Test
    public void testañadirPlayList() throws UsuarioNotFoundException {

        Assert.assertEquals(1, this.pt.numPlaylists());

        this.pt.crearPlayList("playlist6","usuario2","cancionestristes");

        Assert.assertEquals(2, this.pt.numPlaylists());
    }




}


}
