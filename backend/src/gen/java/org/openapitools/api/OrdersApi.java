package org.openapitools.api;

import org.openapitools.api.factories.OrdersApiServiceFactory;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.OrderDetails;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/orders")


@io.swagger.annotations.Api(description = "the orders API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2023-08-31T13:44:34.470114+05:30[Asia/Kolkata]")
public class OrdersApi  {
   private final OrdersApiService delegate;

   public OrdersApi(@Context ServletConfig servletContext) {
      OrdersApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("OrdersApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (OrdersApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         }
      }

      if (delegate == null) {
         delegate = OrdersApiServiceFactory.getOrdersApi();
      }

      this.delegate = delegate;
   }

    @javax.ws.rs.POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = OrderDetails.class, tags={ "Orders APIs", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK", response = OrderDetails.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request", response = ErrorObject.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized", response = ErrorObject.class),
        @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error", response = ErrorObject.class)
    })
    public Response createOrder(@ApiParam(value = "") @Valid  OrderDetails orderDetails,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createOrder(orderDetails, securityContext);
    }
    @javax.ws.rs.DELETE
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Void.class, tags={ "Orders APIs", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "204 No Content", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized", response = ErrorObject.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found", response = ErrorObject.class),
        @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error", response = ErrorObject.class)
    })
    public Response deleteOrder(@ApiParam(value = "", required = true) @QueryParam("order_id") @NotNull  String orderId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteOrder(orderId, securityContext);
    }
    @javax.ws.rs.GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = OrderDetails.class, responseContainer = "List", tags={ "Orders APIs", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK", response = OrderDetails.class, responseContainer = "List"),
        @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request", response = ErrorObject.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized", response = ErrorObject.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found", response = ErrorObject.class),
        @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error", response = ErrorObject.class)
    })
    public Response getOrder(@ApiParam(value = "", required = true) @QueryParam("email") @NotNull  String email,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getOrder(email, securityContext);
    }
    @javax.ws.rs.PUT
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = OrderDetails.class, tags={ "Orders APIs", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK", response = OrderDetails.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request", response = ErrorObject.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized", response = ErrorObject.class),
        @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error", response = ErrorObject.class)
    })
    public Response updateOrder(@ApiParam(value = "") @Valid  OrderDetails orderDetails,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateOrder(orderDetails, securityContext);
    }
}
