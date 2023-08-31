package org.openapitools.api;

import org.openapitools.model.Doctor;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public abstract class DoctorsApiService {
    public abstract Response createDoctor(Doctor doctor, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response deleteDoctor(@NotNull String email, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getDoctor(@NotNull String email, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response updateDoctor(Doctor doctor, SecurityContext securityContext)
            throws NotFoundException;
}
