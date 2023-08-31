package org.openapitools.api;

import org.openapitools.model.User;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public abstract class UsersApiService {
    public abstract Response createUser(User user, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response deleteUser(@NotNull String email, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getUser(@NotNull String email, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response updateUser(@NotNull String email, User user,
            SecurityContext securityContext) throws NotFoundException;
}
