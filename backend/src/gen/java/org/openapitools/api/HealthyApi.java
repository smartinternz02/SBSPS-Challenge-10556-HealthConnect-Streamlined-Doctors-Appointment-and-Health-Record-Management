package org.openapitools.api;

import org.openapitools.api.factories.HealthyApiServiceFactory;

import org.openapitools.model.ProbeResponse;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/healthy")


@io.swagger.annotations.Api(description = "the healthy API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
      date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class HealthyApi {
   private final HealthyApiService delegate;

   public HealthyApi(@Context ServletConfig servletContext) {
      HealthyApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("HealthyApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (HealthyApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         }
      }

      if (delegate == null) {
         delegate = HealthyApiServiceFactory.getHealthyApi();
      }

      this.delegate = delegate;
   }

   @javax.ws.rs.GET


   @Produces({"application/json"})
   @io.swagger.annotations.ApiOperation(value = "", notes = "", response = ProbeResponse.class, tags = {})
   @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
         message = "200 OK", response = ProbeResponse.class)})
   public Response healthyGet(@Context SecurityContext securityContext) throws NotFoundException {
      return delegate.healthyGet(securityContext);
   }
}
