package org.openapitools.api.factories;

import org.openapitools.api.ReviewsApiService;
import org.openapitools.api.impl.ReviewsApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class ReviewsApiServiceFactory {
    private static final ReviewsApiService service = new ReviewsApiServiceImpl();

    public static ReviewsApiService getReviewsApi() {
        return service;
    }
}
