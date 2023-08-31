package org.openapitools.api;

import org.openapitools.api.factories.DoctorsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.Doctor;
import org.openapitools.model.ErrorObject;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/doctors")
@io.swagger.annotations.Api(description = "the doctors API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class DoctorsApi {
    private final DoctorsApiService delegate;

    public DoctorsApi(@Context ServletConfig servletContext) {
        DoctorsApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("DoctorsApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (DoctorsApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = DoctorsApiServiceFactory.getDoctorsApi();
        }

        this.delegate = delegate;
    }

    @javax.ws.rs.POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Doctor.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Doctors APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 201, message = "201 Created",
                    response = Doctor.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response createDoctor(@ApiParam(value = "") @Valid Doctor doctor,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.createDoctor(doctor, securityContext);
    }

    @javax.ws.rs.DELETE
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Void.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Doctors APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "204 No Content",
                    response = Void.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response deleteDoctor(
            @ApiParam(value = "", required = true) @QueryParam("email") @NotNull String email,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.deleteDoctor(email, securityContext);
    }

    @javax.ws.rs.GET
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Doctor.class,
            responseContainer = "List",
            tags = {"Doctors APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = Doctor.class, responseContainer = "List"),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response getDoctor(
            @ApiParam(value = "", required = true) @QueryParam("email") @NotNull String email,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.getDoctor(email, securityContext);
    }

    @javax.ws.rs.PUT
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Doctor.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Doctors APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = Doctor.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response updateDoctor(@ApiParam(value = "") @Valid Doctor doctor,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.updateDoctor(doctor, securityContext);
    }
}
