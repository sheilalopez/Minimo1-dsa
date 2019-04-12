package edu.upc.dsa.services;

import edu.upc.dsa.*;;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/music", description = "Plataform Services")
@Path("/music")
public class PlataformaServices {

    private Plataforma Plataforma;

    public PlataformaServices() {

        this.Plataforma = PlataformaImplementation.getInstance();

        if (this.Plataforma.numUsers() == 0) {

            this.Plataforma.añadirUsuario("User1", "Sheila");
            this.Plataforma.añadirUsuario("User2", "Jana");

            this.Plataforma.añadirArtista("Artist1", "ArianaGrande");
            this.Plataforma.añadirArtista("Artist2", "EdSheeran");
            this.Plataforma.añadirArtista("Artist3", "losdelrio");

        }
    }

    @POST
    @ApiOperation(value = "añadir un artista")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
    })
    @Path("/{idArtist}/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response añadirArtista(@PathParam("idArtista") String idArtista, @PathParam("nombre") String nombre) {
        this.Plataforma.añadirArtista(idArtista, nombre);
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "obtener la lista de artistass")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Artista.class, responseContainer = "List")
    })
    @Path("/artists")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArtistas() {
        List<Artista> artists = this.Plataforma.ListadoDeArtistas();
        GenericEntity<List<Artista>> entity = new GenericEntity<List<Artista>>(artists) {
        };
        return Response.status(200).entity(entity).build();
    }

    @POST
    @ApiOperation(value = "añadir playlist")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "ArtistNotFoundException"),
            @ApiResponse(code = 405, message = "UserNotFoundException")
    })
    @Path("/playlist/{idArtist}/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response añadirPlaylist(PlayList playlist, @PathParam("idArtist") String idArtista, @PathParam("idUser") String idUsuario, @PathParam("nombre") String nombre) {
        try {
            this.Plataforma.crearPlayList(playlist.getId(),playlist.getUsuario(), playlist.getNombre());
            return Response.status(201).build();

        } catch (UsuarioNotFoundException e) {
            e.printStackTrace();
            return Response.status(405).build();
        }
    }
    @GET
    @ApiOperation(value = "obtener la playlist de un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = PlayList.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "UserNotFoundException")
    })
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPlayListDeUnusuario(@PathParam("idUsuario") String idUsuario) {
        try {
            List<PlayList> playlists = this.Plataforma.ListadoDePlayLists(idUsuario);
            GenericEntity<List<PlayList>> entity = new GenericEntity<List<PlayList>>(playlists) {};
            return Response.status(200).entity(entity).build();
        } catch (UsuarioNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }
    /*@POST
    @ApiOperation(value = "añadir un titulo a una playlist")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Titulo.class),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 405, message = "Playlist not found"),
            @ApiResponse(code = 406, message = "Artista not found")
    })
    @Path("/titol/{idUser}/{idPlayList}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTitol(Titulo titulo ,@PathParam("idUser") String idUser,@PathParam("idPlayList") String idPlayList) {
        try{
            this.Plataforma.añadirTitulo(idUser,idPlayList,titulo.getPlaylists(),titulo.getId(),titulo.getNombre(),titulo.getArtista());
            return Response.status(201).entity(titulo).build();
        } catch(UsuarioNotFoundException e1){
            return Response.status(404).build();
        } catch(PlayListNotFoundException e2){
            return Response.status(405).build();
        } catch(ArtistaNotFoundException e3){
            return Response.status(406).build();
        }
    }*/
}
