package me.projekat.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.projekat.model.Kandidat;
import me.projekat.service.KandidatService;

import java.util.List;

@Path("/kandidat/")
public class KandidatRest {

    @Inject
    private KandidatService kandidatService;

    @POST
    @Path("/createKandidat")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createKandidat(Kandidat kandidat) {
        return Response.ok(kandidatService.createKandidat(kandidat)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public Response getAll() {
        List<Kandidat> kandidati = kandidatService.getAll();
        return Response.ok().entity(kandidati).build();
    }

    @PUT
    @Path("/updateKandidat")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateKandidat(Kandidat kandidat) {
        return Response.ok(kandidatService.updateKandidat(kandidat)).build();
    }

    @DELETE
    @Path("/deleteKandidat/{kandidatId}")
    public Response deleteKandidat(@PathParam("kandidatId") Long kandidatId) {
        kandidatService.deleteKandidat(kandidatId);
        return Response.ok().build();
    }

    @GET
    @Path("/getKandidat/{kandidatId}")
    public Response getKandidatById(@PathParam("kandidatId") Long kandidatId) {
        Kandidat kandidat = kandidatService.getKandidatById(kandidatId);
        if (kandidat != null) {
            return Response.ok(kandidat).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Kandidat not found").build();
        }
    }



}
