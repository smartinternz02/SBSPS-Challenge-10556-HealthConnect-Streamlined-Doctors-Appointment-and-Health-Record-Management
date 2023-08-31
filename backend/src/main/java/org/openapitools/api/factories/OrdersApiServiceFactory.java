package org.openapitools.api.factories;

import org.openapitools.api.OrdersApiService;
import org.openapitools.api.impl.OrdersApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2023-08-31T13:44:34.470114+05:30[Asia/Kolkata]")
public class OrdersApiServiceFactory {
    private static final OrdersApiService service = new OrdersApiServiceImpl();

    public static OrdersApiService getOrdersApi() {
        return service;
    }
}
