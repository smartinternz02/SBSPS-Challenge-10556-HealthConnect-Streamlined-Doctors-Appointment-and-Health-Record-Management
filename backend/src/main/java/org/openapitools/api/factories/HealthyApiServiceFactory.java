package org.openapitools.api.factories;

import org.openapitools.api.HealthyApiService;
import org.openapitools.api.impl.HealthyApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class HealthyApiServiceFactory {
    private static final HealthyApiService service = new HealthyApiServiceImpl();

    public static HealthyApiService getHealthyApi() {
        return service;
    }
}
