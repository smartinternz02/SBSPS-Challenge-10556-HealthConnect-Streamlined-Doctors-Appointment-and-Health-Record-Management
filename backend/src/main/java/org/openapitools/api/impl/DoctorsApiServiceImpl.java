package org.openapitools.api.impl;

import org.openapitools.api.*;
import org.openapitools.model.Doctor;
import org.openapitools.model.ErrorObject;
import org.openapitools.api.db.DBClient;
import org.openapitools.api.logging.LogClient;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;

import java.util.ArrayList;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen",
        date = "2023-08-25T10:57:20.735818+05:30[Asia/Kolkata]")
public class DoctorsApiServiceImpl extends DoctorsApiService {
    @Override
    public Response createDoctor(Doctor doctor, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(DoctorsApiServiceImpl.class);
        logClient.debug("received new request for `createDoctor`");
        if (!doctor.isValid()) {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("invalid request body")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            long matchingDocsLength = dbClient.getCollection("doctors")
                    .countDocuments(eq("email", doctor.getEmail()));
            if (matchingDocsLength > 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.CONFLICT.getStatusCode())
                        .description("doctor already exists!")
                        .moreInfo(Response.Status.CONFLICT.getReasonPhrase());
                return Response.status(Response.Status.CONFLICT.getStatusCode()).entity(err)
                        .build();
            }
            Document doc = doctor.toDocument();
            InsertOneResult insertResult = dbClient.getCollection("doctors").insertOne(doc);
            if (insertResult.getInsertedId() != null) {
                doc.remove(Doctor.JSON_PROPERTY_PASSWORD);
                return Response.status(Response.Status.CREATED.getStatusCode()).entity(doc).build();
            }
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description("could not save doctor to the database")
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
    public Response deleteDoctor(@NotNull String email, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(DoctorsApiServiceImpl.class);
        logClient.debug("received new request for `deleteDoctor`");
        if (email == null || email.equals("")) {
            logClient.error("`email` query parameter is null or empty");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("'email' query parameter is required!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            DeleteResult deleteResult =
                    dbClient.getCollection("doctors").deleteOne(eq("email", email));
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
    public Response getDoctor(@NotNull String email, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(DoctorsApiServiceImpl.class);
        logClient.debug("received new request for `getDoctor`");
        if (email == null || email.equals("")) {
            logClient.error("`email` query parameter is null or empty");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("'email' query parameter is required!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            ArrayList<Document> doctorsList = new ArrayList<Document>();
            Bson projection = exclude("_id", "__v", "password");
            if (email.equals("*")) {
                logClient.debug("`email` query parameter is *, finding all doctors");
                FindIterable<Document> dbResp =
                        dbClient.getCollection("doctors").find().projection(projection);
                for (Document doc : dbResp) {
                    doctorsList.add(doc);
                }
            } else {
                logClient.debug(
                        "`email` query parameter is " + email + ", finding matching doctors");
                FindIterable<Document> dbResp = dbClient.getCollection("doctors")
                        .find(eq("email", email)).projection(projection);
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
    public Response updateDoctor(Doctor doctor, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(DoctorsApiServiceImpl.class);
        logClient.debug("received new request for `updateDoctor`");
        if (!doctor.isValid()) {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("invalid request body")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            Document doc = doctor.toDocument();
            UpdateResult updateResult = dbClient.getCollection("doctors")
                    .replaceOne(eq("email", doctor.getEmail().toString()), doc);
            if (updateResult.getModifiedCount() == 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("could not find doctor in the database!")
                        .moreInfo(Response.Status.NOT_FOUND.getReasonPhrase());
                return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(err)
                        .build();
            }
            doc.remove(Doctor.JSON_PROPERTY_PASSWORD);
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
