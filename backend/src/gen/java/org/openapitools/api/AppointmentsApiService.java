package org.openapitools.api;

import org.openapitools.model.AppointmentDetails;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2023-08-31T13:30:54.533812+05:30[Asia/Kolkata]")
public abstract class AppointmentsApiService {
    public abstract Response bookAppointment(AppointmentDetails appointmentDetails,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteAppointment( @NotNull String refId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAppointment( @NotNull String email,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateAppointment(AppointmentDetails appointmentDetails,SecurityContext securityContext) throws NotFoundException;
}
