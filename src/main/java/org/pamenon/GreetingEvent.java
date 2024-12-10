package org.pamenon;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/welcome")
public class GreetingEvent {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(Event event) {
        return "Welcome to "+event.getName()+" at "+event.getLocation();
    }
}
