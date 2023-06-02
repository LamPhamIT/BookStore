package com.shinn.api.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class BookApplication extends ResourceConfig {
    public BookApplication() {
        packages("com.shinn.resource.v1");
    }
}
