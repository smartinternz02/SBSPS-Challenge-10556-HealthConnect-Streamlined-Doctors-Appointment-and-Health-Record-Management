package org.openapitools.api.impl;

import org.openapitools.api.*;
import org.openapitools.api.db.DBClient;
import org.openapitools.api.logging.LogClient;
import org.openapitools.model.AppointmentDetails;
import org.openapitools.model.ErrorObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-31T13:30:54.533812+05:30[Asia/Kolkata]")
public class AppointmentsApiServiceImpl extends AppointmentsApiService {
    @Override
    public Response bookAppointment(AppointmentDetails appointmentDetails,
            SecurityContext securityContext) throws NotFoundException {
        LogClient logClient = new LogClient(HealthReportsApiServiceImpl.class);
        logClient.debug("received new request for `bookAppointment`");
        if (!appointmentDetails.isValid()) {
            logClient.error("supplied booking details are invalid!");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("supplied booking details are invalid!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            FindIterable<Document> matchingDoctors = dbClient.getCollection("doctors")
                    .find(eq("email", appointmentDetails.getDoctorEmail().toString()));
            if (matchingDoctors.first() == null) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("no matching doctor found!")
                        .moreInfo(Response.Status.NOT_FOUND.getReasonPhrase());
                return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(err)
                        .build();
            }
            Document doc = appointmentDetails.toDocument();
            InsertOneResult insertResult = dbClient.getCollection("booking").insertOne(doc);
            if (insertResult.getInsertedId() != null) {
                return Response.status(Response.Status.CREATED.getStatusCode()).entity(doc)
                        .build();
            }
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description("could not save booking to the database")
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
    public Response deleteAppointment(@NotNull String appointmentId, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(MedicinesApiServiceImpl.class);
        logClient.debug("received new request for `deleteAppointment`");
        if (appointmentId == null || appointmentId.equals("")) {
            logClient.error("`appointment_id` query parameter is null or empty");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("'appointment_id' query parameter is required!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            DeleteResult deleteResult =
                    dbClient.getCollection("booking").deleteOne(eq("appointment_id", appointmentId));
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
    public Response getAppointment(@NotNull String email, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(MedicinesApiServiceImpl.class);
        logClient.debug("received new request for `getAppointment`");
        if (email == null || email.equals("")) {
            logClient.error("`email` query parameter is null or empty");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("'email' query parameter is required!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            ArrayList<Document> appointmentList = new ArrayList<Document>();
            Bson projection = exclude("_id", "__v");
            if (email.equals("*")) {
                logClient.debug("`email` query parameter is *, finding all medicines");
                FindIterable<Document> dbResp =
                        dbClient.getCollection("booking").find().projection(projection);
                for (Document doc : dbResp) {
                    appointmentList.add(doc);
                }
            } else {
                logClient.debug("`email` query parameter is " + email
                        + ", finding matching appointments");
                FindIterable<Document> dbResp = dbClient.getCollection("booking")
                        .find(eq("user_email", email)).projection(projection);
                for (Document doc : dbResp) {
                    appointmentList.add(doc);
                }
            }
            if (appointmentList.size() == 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("no records found!")
                        .moreInfo(Response.Status.NOT_FOUND.getReasonPhrase());
                return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(err)
                        .build();
            }
            return Response.ok().entity(appointmentList).build();
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
    public Response updateAppointment(AppointmentDetails appointmentDetails,
            SecurityContext securityContext) throws NotFoundException {
        LogClient logClient = new LogClient(HealthReportsApiServiceImpl.class);
        logClient.debug("received new request for `updateAppointment`");
        if (!appointmentDetails.isValid()) {
            logClient.error("supplied booking details are invalid!");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("supplied booking details are invalid!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            FindIterable<Document> matchingDoctors = dbClient.getCollection("doctors")
                    .find(eq("email", appointmentDetails.getDoctorEmail().toString()));
            if (matchingDoctors.first() == null) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("no matching doctor found!")
                        .moreInfo(Response.Status.NOT_FOUND.getReasonPhrase());
                return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(err)
                        .build();
            }
            Document doc = appointmentDetails.toDocument();
            UpdateResult updateResult = dbClient.getCollection("booking").replaceOne(eq(doc), doc);
            if (updateResult.getMatchedCount() == 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("no matching appointment found!")
                        .moreInfo(Response.Status.NOT_FOUND.getReasonPhrase());
                return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(err)
                        .build();
            } else {
                return Response.status(Response.Status.OK.getStatusCode()).entity(doc)
                        .build();
            }
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
