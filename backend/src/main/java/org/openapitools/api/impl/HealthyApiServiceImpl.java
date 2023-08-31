package org.openapitools.api.impl;

import org.openapitools.api.*;
import org.openapitools.model.ProbeResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class HealthyApiServiceImpl extends HealthyApiService {
    @Override
    public Response healthyGet(SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(new ProbeResponse().ok(true)).build();
    }
}
