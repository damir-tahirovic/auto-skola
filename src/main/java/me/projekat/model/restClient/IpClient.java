package me.projekat.model.restClient;

import java.util.List;

import me.projekat.rest.server.IpLog;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.projekat.model.restClient.IpClient;

@Path("/data")
@RegisterRestClient(configKey = "ip-client")
public interface IpClient {

    @GET
    @Path("/client-ip")
    IpLog getIpLog();

}