package me.projekat.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.projekat.model.Oblast;
import me.projekat.service.OblastService;

import java.util.List;

@Path("/oblast")
public class OblastRest {

    @Inject
    private OblastService oblastService;

    @POST
    @Path("/createOblast")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOblast(Oblast oblast) {
        return Response.ok(oblastService.createOblast(oblast)).build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Oblast> oblasti = oblastService.getAll();
        return Response.ok().entity(oblasti).build();
    }

    @PUT
    @Path("/updateOblast")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOblast(Oblast oblast) {
        return Response.ok(oblastService.updateOblast(oblast)).build();
    }

    @DELETE
    @Path("/deleteOblast/{oblastId}")
    public Response deleteOblast(@PathParam("oblastId") Long oblastId) {
        oblastService.deleteOblast(oblastId);
        return Response.ok().build();
    }

    @GET
    @Path("/getOblast/{oblastId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOblastById(@PathParam("oblastId") Long oblastId) {
        Oblast oblast = oblastService.getOblastById(oblastId);
        if (oblast != null) {
            return Response.ok(oblast).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Oblast not found").build();
        }
    }
}
