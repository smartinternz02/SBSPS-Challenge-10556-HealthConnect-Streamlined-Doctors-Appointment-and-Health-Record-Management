package org.openapitools.api.impl;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.openapitools.api.*;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.Report;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.openapitools.api.NotFoundException;
import org.openapitools.api.db.DBClient;
import org.openapitools.api.logging.LogClient;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import javax.validation.constraints.*;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class HealthReportsApiServiceImpl extends HealthReportsApiService {
    @Override
    public Response createReport(Report report, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(HealthReportsApiServiceImpl.class);
        logClient.debug("received new request for `createReport`");
        if (!report.isValid()) {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("invalid request body")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            long matchingDocsLength = dbClient.getCollection("reports")
                    .countDocuments(eq("report_id", report.getReportID().toString()));
            if (matchingDocsLength > 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.CONFLICT.getStatusCode())
                        .description("report already exists!")
                        .moreInfo(Response.Status.CONFLICT.getReasonPhrase());
                return Response.status(Response.Status.CONFLICT.getStatusCode()).entity(err)
                        .build();
            }
            Document doc = report.toDocument();
            InsertOneResult insertResult = dbClient.getCollection("reports").insertOne(doc);
            if (insertResult.getInsertedId() != null) {
                return Response.status(Response.Status.CREATED.getStatusCode()).entity(doc).build();
            }
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description("could not save report to the database")
                            .moreInfo(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(err).build();
        } catch (Exception e) {
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description(e.getMessage().toString())
                            .moreInfo(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(err).build();
        }
    }

    @Override
    public Response deleteReport(@NotNull String reportId, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(HealthReportsApiServiceImpl.class);
        logClient.debug("received new request for `deleteReport`");
        if (reportId == null || reportId.equals("")) {
            logClient.error("`report_id` query parameter is null or empty");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("'report_id' query parameter is required!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            DeleteResult deleteResult =
                    dbClient.getCollection("reports").deleteOne(eq("report_id", reportId));
            if (deleteResult.getDeletedCount() == 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("no records found!")
                        .moreInfo(Response.Status.NOT_FOUND.getReasonPhrase());
                return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(err)
                        .build();
            }
            return Response.status(Response.Status.NO_CONTENT.getStatusCode()).build();
        } catch (Exception e) {
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description(e.getMessage().toString())
                            .moreInfo(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(err).build();
        }
    }

    @Override
    public Response getReport(@NotNull String reportId, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(HealthReportsApiServiceImpl.class);
        logClient.debug("received new request for `getReport`");
        if (reportId == null || reportId.equals("")) {
            logClient.error("`report_id` query parameter is null or empty");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("'report_id' query parameter is required!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            ArrayList<Document> doctorsList = new ArrayList<Document>();
            Bson projection = exclude("_id", "__v");
            if (reportId.equals("*")) {
                logClient.debug("`report_id` query parameter is *, finding all reports");
                FindIterable<Document> dbResp =
                        dbClient.getCollection("reports").find().projection(projection);
                for (Document doc : dbResp) {
                    doctorsList.add(doc);
                }
            } else {
                logClient.debug(
                        "`report_id` query parameter is " + reportId + ", finding matching reports");
                FindIterable<Document> dbResp = dbClient.getCollection("reports")
                        .find(eq("report_id", reportId)).projection(projection);
                for (Document doc : dbResp) {
                    doctorsList.add(doc);
                }
            }
            if (doctorsList.size() == 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("no records found!")
                        .moreInfo(Response.Status.NOT_FOUND.getReasonPhrase());
                return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(err)
                        .build();
            }
            return Response.ok().entity(doctorsList).build();
        } catch (Exception e) {
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description(e.getMessage().toString())
                            .moreInfo(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(err).build();
        }
    }

    @Override
    public Response updateReport(Report report, SecurityContext securityContext)
            throws NotFoundException {
        // do some magic!
        LogClient logClient = new LogClient(HealthReportsApiServiceImpl.class);
        logClient.debug("received new request for `updateReport`");
        if (!report.isValid()) {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("invalid request body")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            Document doc = report.toDocument();
            UpdateResult updateResult = dbClient.getCollection("reports")
                    .replaceOne(eq("report_id", report.getReportID().toString()), doc);
            if (updateResult.getModifiedCount() == 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("could not find report in the database!")
                        .moreInfo(Response.Status.NOT_FOUND.getReasonPhrase());
                return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(err)
                        .build();
            }
            return Response.status(Response.Status.OK.getStatusCode()).entity(doc.toJson()).build();
        } catch (Exception e) {
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description(e.getMessage().toString())
                            .moreInfo(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(err).build();
        }
    }
}
