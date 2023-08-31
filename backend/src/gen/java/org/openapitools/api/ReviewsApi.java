package org.openapitools.api;

import org.openapitools.api.factories.ReviewsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.Rating;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/reviews")


@io.swagger.annotations.Api(description = "the reviews API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class ReviewsApi {
    private final ReviewsApiService delegate;

    public ReviewsApi(@Context ServletConfig servletContext) {
        ReviewsApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("ReviewsApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (ReviewsApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = ReviewsApiServiceFactory.getReviewsApi();
        }

        this.delegate = delegate;
    }

    @javax.ws.rs.POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Rating.class,
            tags = {"Ratings APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 201, message = "201 Created",
                    response = Rating.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response createReview(@ApiParam(value = "") @Valid Rating rating,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.createReview(rating, securityContext);
    }

    @javax.ws.rs.DELETE


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Void.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Ratings APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "204 No Content",
                    response = Void.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response deleteReview(
            @ApiParam(value = "", required = true) @QueryParam("rating_id") @NotNull String ratingId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.deleteReview(ratingId, securityContext);
    }

    @javax.ws.rs.GET


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Rating.class,
            responseContainer = "List",
            tags = {"Ratings APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = Rating.class, responseContainer = "List"),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response getReview(
            @ApiParam(value = "", required = true) @QueryParam("rating_id") @NotNull String ratingId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.getReview(ratingId, securityContext);
    }

    @javax.ws.rs.PUT

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Rating.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"Ratings APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = Rating.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response updateReview(@ApiParam(value = "") @Valid Rating rating,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.updateReview(rating, securityContext);
    }
}
