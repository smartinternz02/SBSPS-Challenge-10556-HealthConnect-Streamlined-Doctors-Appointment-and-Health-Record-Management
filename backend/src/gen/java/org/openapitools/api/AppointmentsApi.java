package org.openapitools.api;

import org.openapitools.api.factories.AppointmentsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.AppointmentDetails;
import org.openapitools.model.ErrorObject;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/appointments")


@io.swagger.annotations.Api(description = "the appointments API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-31T13:30:54.533812+05:30[Asia/Kolkata]")
public class AppointmentsApi {
    private final AppointmentsApiService delegate;

    public AppointmentsApi(@Context ServletConfig servletContext) {
        AppointmentsApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("AppointmentsApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (AppointmentsApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = AppointmentsApiServiceFactory.getAppointmentsApi();
        }

        this.delegate = delegate;
    }

    @javax.ws.rs.POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "",
            response = AppointmentDetails.class, tags = {"Appointments APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = AppointmentDetails.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response bookAppointment(
            @ApiParam(value = "") @Valid AppointmentDetails appointmentDetails,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.bookAppointment(appointmentDetails, securityContext);
    }

    @javax.ws.rs.DELETE


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Void.class,
            tags = {"Appointments APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "204 No Content",
                    response = Void.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response deleteAppointment(
            @ApiParam(value = "", required = true) @QueryParam("appointment_id") @NotNull String appointmentId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.deleteAppointment(appointmentId, securityContext);
    }

    @javax.ws.rs.GET


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "",
            response = AppointmentDetails.class, responseContainer = "List",
            tags = {"Appointments APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = AppointmentDetails.class, responseContainer = "List"),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response getAppointment(
            @ApiParam(value = "", required = true) @QueryParam("email") @NotNull String email,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.getAppointment(email, securityContext);
    }

    @javax.ws.rs.PUT

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "",
            response = AppointmentDetails.class, tags = {"Appointments APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = AppointmentDetails.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response updateAppointment(
            @ApiParam(value = "") @Valid AppointmentDetails appointmentDetails,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.updateAppointment(appointmentDetails, securityContext);
    }
}
