package org.openapitools.api;

import org.openapitools.model.Report;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public abstract class HealthReportsApiService {
    public abstract Response createReport(Report report, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response deleteReport(@NotNull String report_id, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getReport(@NotNull String report_id, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response updateReport(Report report, SecurityContext securityContext)
            throws NotFoundException;
}
