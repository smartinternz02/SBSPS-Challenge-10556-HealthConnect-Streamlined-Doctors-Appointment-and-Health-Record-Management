package org.openapitools.api.middleware;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class CORSHandler implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getMethod().equalsIgnoreCase("OPTIONS")) {
            Response response = Response.ok()
                    .header("Access-Control-Allow-Origin", "*") // Change * to the appropriate origin
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE")
                    .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                    .build();
            requestContext.abortWith(response);
        }
    }
}
