package org.openapitools.api;

import org.openapitools.model.Medicine;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public abstract class MedicinesApiService {
    public abstract Response createMedicine(Medicine medicine, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response deleteMedicine(@NotNull String medicineId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getMedicine(@NotNull String medicineId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response updateMedicine(Medicine medicine, SecurityContext securityContext)
            throws NotFoundException;
}
