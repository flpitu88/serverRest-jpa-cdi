/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rutas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author flpitu88
 */
@Path("/mensaje")
public class MensajeBienvenidaResource {

    @GET
    @Path("/{mensaje}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response imprimirMensaje(@PathParam("mensaje") String mje) {
        String resultado = "Restful ejemplo: " + mje;
        return Response.ok(resultado, MediaType.APPLICATION_JSON).build();
    }
}
