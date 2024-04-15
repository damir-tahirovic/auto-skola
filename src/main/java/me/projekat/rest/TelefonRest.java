package me.projekat.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.projekat.model.Telefon;
import me.projekat.service.TelefonService;

@Path("/telefon")
public class TelefonRest {

    @Inject
    private TelefonService telefonService;

    @POST
    @Path("/createTelefon")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTelefon(Telefon telefon) {
        return Response.ok(telefonService.createTelefon(telefon)).build();
    }

    @PUT
    @Path("/updateTelefon")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTelefon(Telefon telefon) {
        return Response.ok(telefonService.updateTelefon(telefon)).build();
    }

    @DELETE
    @Path("/deleteTelefon/{telefonId}")
    public Response deleteTelefon(@PathParam("telefonId") Long telefonId) {
        telefonService.deleteTelefon(telefonId);
        return Response.ok().build();
    }

    @GET
    @Path("/getTelefon/{telefonId}")
    public Response getTelefonById(@PathParam("telefonId") Long telefonId) {
        Telefon telefon = telefonService.getTelefonById(telefonId);
        if (telefon != null) {
            return Response.ok(telefon).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Telefon not found").build();
        }
    }
}
