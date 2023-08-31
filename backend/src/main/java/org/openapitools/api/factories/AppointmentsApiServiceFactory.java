package org.openapitools.api.factories;

import org.openapitools.api.AppointmentsApiService;
import org.openapitools.api.impl.AppointmentsApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2023-08-31T13:43:00.087129+05:30[Asia/Kolkata]")
public class AppointmentsApiServiceFactory {
    private static final AppointmentsApiService service = new AppointmentsApiServiceImpl();

    public static AppointmentsApiService getAppointmentsApi() {
        return service;
    }
}
