package org.openapitools.api.factories;

import org.openapitools.api.ReadyApiService;
import org.openapitools.api.impl.ReadyApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class ReadyApiServiceFactory {
    private static final ReadyApiService service = new ReadyApiServiceImpl();

    public static ReadyApiService getReadyApi() {
        return service;
    }
}
