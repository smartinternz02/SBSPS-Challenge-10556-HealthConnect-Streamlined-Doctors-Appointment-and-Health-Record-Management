package org.openapitools.api;

import org.openapitools.api.factories.MedicinesApiServiceFactory;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.Medicine;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/medicines")


@io.swagger.annotations.Api(description = "the medicines API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class MedicinesApi {
    private final MedicinesApiService delegate;

    public MedicinesApi(@Context ServletConfig servletContext) {
        MedicinesApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("MedicinesApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (MedicinesApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = MedicinesApiServiceFactory.getMedicinesApi();
        }

        this.delegate = delegate;
    }

    @javax.ws.rs.POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Medicine.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Medicines APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = Medicine.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response createMedicine(@ApiParam(value = "") @Valid Medicine medicine,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.createMedicine(medicine, securityContext);
    }

    @javax.ws.rs.DELETE


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Void.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Medicines APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "204 No Content",
                    response = Void.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response deleteMedicine(
            @ApiParam(value = "", required = true) @QueryParam("medicine_id") @NotNull String medicineId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.deleteMedicine(medicineId, securityContext);
    }

    @javax.ws.rs.GET


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Medicine.class,
            responseContainer = "List",
            tags = {"Medicines APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = Medicine.class, responseContainer = "List"),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response getMedicine(
            @ApiParam(value = "", required = true) @QueryParam("medicine_id") @NotNull String medicineId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.getMedicine(medicineId, securityContext);
    }

    @javax.ws.rs.PUT

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Medicine.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Medicines APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = Medicine.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response updateMedicine(@ApiParam(value = "") @Valid Medicine medicine,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.updateMedicine(medicine, securityContext);
    }
}
