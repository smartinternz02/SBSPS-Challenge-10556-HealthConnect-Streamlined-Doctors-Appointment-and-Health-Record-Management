package org.openapitools.api.factories;

import org.openapitools.api.MedicinesApiService;
import org.openapitools.api.impl.MedicinesApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class MedicinesApiServiceFactory {
    private static final MedicinesApiService service = new MedicinesApiServiceImpl();

    public static MedicinesApiService getMedicinesApi() {
        return service;
    }
}
