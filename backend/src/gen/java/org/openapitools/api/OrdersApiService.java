package org.openapitools.api;

import org.openapitools.model.OrderDetails;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2023-08-31T13:44:34.470114+05:30[Asia/Kolkata]")
public abstract class OrdersApiService {
    public abstract Response createOrder(OrderDetails orderDetails,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteOrder( @NotNull String orderId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getOrder( @NotNull String email,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateOrder(OrderDetails orderDetails,SecurityContext securityContext) throws NotFoundException;
}
