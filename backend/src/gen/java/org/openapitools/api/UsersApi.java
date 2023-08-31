package org.openapitools.api;

import org.openapitools.api.factories.UsersApiServiceFactory;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.User;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/users")


@io.swagger.annotations.Api(description = "the users API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class UsersApi {
    private final UsersApiService delegate;

    public UsersApi(@Context ServletConfig servletContext) {
        UsersApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("UsersApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (UsersApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = UsersApiServiceFactory.getUsersApi();
        }

        this.delegate = delegate;
    }

    @javax.ws.rs.POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = User.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Users APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 201, message = "200 OK",
                    response = User.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response createUser(@ApiParam(value = "") @Valid User user,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.createUser(user, securityContext);
    }

    @javax.ws.rs.DELETE


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Void.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Users APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "204 No Content",
                    response = Void.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response deleteUser(
            @ApiParam(value = "", required = true) @QueryParam("email") @NotNull String email,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.deleteUser(email, securityContext);
    }

    @javax.ws.rs.GET


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = User.class,
            responseContainer = "List",
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Users APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = User.class, responseContainer = "List"),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response getUser(
            @ApiParam(value = "", required = true) @QueryParam("email") @NotNull String email,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.getUser(email, securityContext);
    }

    @javax.ws.rs.PUT

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = User.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Users APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = User.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response updateUser(
            @ApiParam(value = "", required = true) @QueryParam("email") @NotNull String email,
            @ApiParam(value = "") @Valid User user, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateUser(email, user, securityContext);
    }
}
