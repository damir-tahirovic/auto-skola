package me.projekat.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.projekat.model.Radnik;
import me.projekat.service.RadnikService;

import java.util.List;

@Path("/radnik")
public class RadnikRest {

    @Inject
    private RadnikService radnikService;

    @POST
    @Path("/createRadnik")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRadnik(Radnik radnik) {
        return Response.ok(radnikService.createRadnik(radnik)).build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Radnik> radnici = radnikService.getAll();
        return Response.ok().entity(radnici).build();
    }

    @PUT
    @Path("/updateRadnik")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRadnik(Radnik radnik) {
        return Response.ok(radnikService.updateRadnik(radnik)).build();
    }

    @DELETE
    @Path("/deleteRadnik/{radnikId}")
    public Response deleteRadnik(@PathParam("radnikId") Long radnikId) {
        radnikService.deleteRadnik(radnikId);
        return Response.ok().build();
    }

    @GET
    @Path("/getRadnik/{radnikId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRadnikById(@PathParam("radnikId") Long radnikId) {
        Radnik radnik = radnikService.getRadnikById(radnikId);
        if (radnik != null) {
            return Response.ok(radnik).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Radnik not found").build();
        }
    }
}
