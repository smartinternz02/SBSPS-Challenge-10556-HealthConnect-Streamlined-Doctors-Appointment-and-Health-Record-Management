package org.openapitools.api.factories;

import org.openapitools.api.AuthApiService;
import org.openapitools.api.impl.AuthApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class AuthApiServiceFactory {
    private static final AuthApiService service = new AuthApiServiceImpl();

    public static AuthApiService getAuthApi() {
        return service;
    }
}
