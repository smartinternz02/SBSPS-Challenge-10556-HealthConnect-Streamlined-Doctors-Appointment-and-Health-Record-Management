package org.openapitools.api;

import org.openapitools.model.Rating;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public abstract class ReviewsApiService {
    public abstract Response createReview(Rating rating, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response deleteReview(@NotNull String ratingId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getReview(@NotNull String ratingId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response updateReview(Rating rating, SecurityContext securityContext)
            throws NotFoundException;
}
