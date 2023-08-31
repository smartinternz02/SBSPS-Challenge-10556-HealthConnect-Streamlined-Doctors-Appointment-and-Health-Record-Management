package org.openapitools.api;

import org.openapitools.api.factories.AuthApiServiceFactory;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.LoggedInUserDetails;
import org.openapitools.model.LoginCreds;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.Valid;

@Path("/auth/login")


@io.swagger.annotations.Api(description = "the auth API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
      date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class AuthApi {
   private final AuthApiService delegate;

   public AuthApi(@Context ServletConfig servletContext) {
      AuthApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("AuthApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (AuthApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         }
      }

      if (delegate == null) {
         delegate = AuthApiServiceFactory.getAuthApi();
      }

      this.delegate = delegate;
   }

   @javax.ws.rs.POST

   @Consumes({"application/json"})
   @Produces({"application/json"})
   @io.swagger.annotations.ApiOperation(value = "", notes = "",
         response = LoggedInUserDetails.class,
         tags = {"Auth APIs",})
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
               response = LoggedInUserDetails.class),
         @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
               response = ErrorObject.class),
         @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
               response = ErrorObject.class),
         @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
               response = ErrorObject.class)})
   public Response login(@ApiParam(value = "") @Valid LoginCreds loginCreds,
         @Context SecurityContext securityContext) throws NotFoundException {
      return delegate.login(loginCreds, securityContext);
   }
}
