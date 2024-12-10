package org.pamenon;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/thanks")
public class ThankYouSponsor {

    @ConfigProperty(name = "app.sponsor")
    String sponsor;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String thankSponsor() {
        return "Thank you to our amazing organiser: " + sponsor + "!";
    }

}
