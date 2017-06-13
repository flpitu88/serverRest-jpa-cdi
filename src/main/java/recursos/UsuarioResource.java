/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import daos.UsuarioDAO;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author flavio
 */
@Path("/usuarios")
public class UsuarioResource {

    @Inject
    private UsuarioDAO usuarioDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodosLosUsuarios() {
        return Response.ok(usuarioDao.getUsuariosNoAdministradores(),
                MediaType.APPLICATION_JSON)
                .build();
    }
}
