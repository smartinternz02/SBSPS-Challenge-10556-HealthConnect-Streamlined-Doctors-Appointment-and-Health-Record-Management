package org.openapitools.api;

import org.openapitools.model.LoginCreds;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public abstract class AuthApiService {
    public abstract Response login(LoginCreds loginCreds, SecurityContext securityContext)
            throws NotFoundException;
}
