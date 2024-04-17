package me.projekat.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.projekat.model.RadnikPoznajeOblast;
import me.projekat.service.RadnikPoznajeOblastService;

import java.util.List;

@Path("/radnikPoznajeOblast")
public class RadnikPoznajeOblastRest {

    @Inject
    private RadnikPoznajeOblastService radnikPoznajeOblastService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRadnikPoznajeOblast(RadnikPoznajeOblast veza) {
        return Response.ok(radnikPoznajeOblastService.createRadnikPoznajeOblast(veza)).build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<RadnikPoznajeOblast> veze = radnikPoznajeOblastService.getAll();
        return Response.ok().entity(veze).build();
    }

    @DELETE
    @Path("/delete/{vezaId}")
    public Response deleteRadnikPoznajeOblast(@PathParam("vezaId") Long vezaId) {
        radnikPoznajeOblastService.deleteRadnikPoznajeOblast(vezaId);
        return Response.ok().build();
    }

    @GET
    @Path("/get/{vezaId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRadnikPoznajeOblastById(@PathParam("vezaId") Long vezaId) {
        RadnikPoznajeOblast veza = radnikPoznajeOblastService.getRadnikPoznajeOblastById(vezaId);
        if (veza != null) {
            return Response.ok(veza).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Veza not found").build();
        }
    }
}
