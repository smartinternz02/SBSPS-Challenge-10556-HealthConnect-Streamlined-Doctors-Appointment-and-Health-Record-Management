package org.openapitools.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public abstract class HealthyApiService {
    public abstract Response healthyGet(SecurityContext securityContext) throws NotFoundException;
}
