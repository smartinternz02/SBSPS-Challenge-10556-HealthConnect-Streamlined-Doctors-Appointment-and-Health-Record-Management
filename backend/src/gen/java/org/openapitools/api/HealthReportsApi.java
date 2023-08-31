package org.openapitools.api;

import org.openapitools.api.factories.HealthReportsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.Report;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/health-reports")


@io.swagger.annotations.Api(description = "the health-reports API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class HealthReportsApi {
    private final HealthReportsApiService delegate;

    public HealthReportsApi(@Context ServletConfig servletContext) {
        HealthReportsApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("HealthReportsApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (HealthReportsApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = HealthReportsApiServiceFactory.getHealthReportsApi();
        }

        this.delegate = delegate;
    }

    @javax.ws.rs.POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Report.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"HealthReports APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 201, message = "201 Created",
                    response = Report.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response createReport(@ApiParam(value = "") @Valid Report report,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.createReport(report, securityContext);
    }

    @javax.ws.rs.DELETE


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Void.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"HealthReports APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "204 No Content",
                    response = Void.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response deleteReport(
            @ApiParam(value = "", required = true) @QueryParam("report_id") @NotNull String reportId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.deleteReport(reportId, securityContext);
    }

    @javax.ws.rs.GET


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Report.class,
            responseContainer = "List",
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"HealthReports APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = Report.class, responseContainer = "List"),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response getReport(
            @ApiParam(value = "", required = true) @QueryParam("report_id") @NotNull String reportId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.getReport(reportId, securityContext);
    }

    @javax.ws.rs.PUT

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Report.class,
            authorizations = {@io.swagger.annotations.Authorization(value = "bearerAuth")},
            tags = {"HealthReports APIs",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "200 OK",
                    response = Report.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "400 Bad Request",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "401 Unauthorized",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "404 Not Found",
                    response = ErrorObject.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "500 Internal Server Error",
                    response = ErrorObject.class)})
    public Response updateReport(@ApiParam(value = "") @Valid Report report,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.updateReport(report, securityContext);
    }
}
