/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import daos.UsuarioDAO;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import modelo.Usuario;

/**
 *
 * @author flavio
 */
@Path("/usuarios")
public class UsuarioResource {

    @Inject
    private UsuarioDAO usuarioDao;

    @GET
    @Path("trampa")
    public Usuario crearUsuario(@Context UriInfo uriInfo) {
        Usuario u = usuarioDao.getUsuarioById(1);
        u.setFechaNacimiento(LocalDate.now());
        
        return u;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuariosNoAdministradores();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Usuario getUsuarios(Integer id) {
        return usuarioDao.getUsuarioById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Usuario u, @Context UriInfo uriInfo) {
        usuarioDao.guardarUsuario(u);
        u.setFechaNacimiento(LocalDate.now());
        
        return Response
                .created(uriInfo.getBaseUriBuilder()
                        .path(u.getId().toString())
                        .build())
                .entity(u)
                .build();
    }

}
