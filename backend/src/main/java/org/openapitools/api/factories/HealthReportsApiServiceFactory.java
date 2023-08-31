package org.openapitools.api.factories;

import org.openapitools.api.HealthReportsApiService;
import org.openapitools.api.impl.HealthReportsApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class HealthReportsApiServiceFactory {
    private static final HealthReportsApiService service = new HealthReportsApiServiceImpl();

    public static HealthReportsApiService getHealthReportsApi() {
        return service;
    }
}
