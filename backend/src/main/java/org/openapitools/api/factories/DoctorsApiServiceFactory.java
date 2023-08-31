package org.openapitools.api.factories;

import org.openapitools.api.DoctorsApiService;
import org.openapitools.api.impl.DoctorsApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class DoctorsApiServiceFactory {
    private static final DoctorsApiService service = new DoctorsApiServiceImpl();

    public static DoctorsApiService getDoctorsApi() {
        return service;
    }
}
