package org.openapitools.api.impl;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.openapitools.api.*;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.Medicine;
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
public class MedicinesApiServiceImpl extends MedicinesApiService {
    @Override
    public Response createMedicine(Medicine medicine, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(MedicinesApiServiceImpl.class);
        logClient.debug("received new request for `createMedicine`");
        if (!medicine.isValid()) {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("invalid request body")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            long matchingDocsLength = dbClient.getCollection("medicines")
                    .countDocuments(eq("medicine_id", medicine.getMedicineId()));
            if (matchingDocsLength > 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.CONFLICT.getStatusCode())
                        .description("medicine already exists!")
                        .moreInfo(Response.Status.CONFLICT.getReasonPhrase());
                return Response.status(Response.Status.CONFLICT.getStatusCode()).entity(err)
                        .build();
            }
            Document doc = medicine.toDocument();
            InsertOneResult insertResult = dbClient.getCollection("medicines").insertOne(doc);
            if (insertResult.getInsertedId() != null) {
                return Response.status(Response.Status.CREATED.getStatusCode()).entity(doc).build();
            }
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description("could not save medicine to the database")
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
    public Response deleteMedicine(@NotNull String medicineId, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(MedicinesApiServiceImpl.class);
        logClient.debug("received new request for `deleteMedicine`");
        if (medicineId == null || medicineId.equals("")) {
            logClient.error("`medicineId` query parameter is null or empty");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("'id' query parameter is required!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            DeleteResult deleteResult =
                    dbClient.getCollection("medicines").deleteOne(eq("medicine_id", medicineId));
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
    public Response getMedicine(@NotNull String medicineId, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(MedicinesApiServiceImpl.class);
        logClient.debug("received new request for `getMedicine`");
        if (medicineId == null || medicineId.equals("")) {
            logClient.error("`medicine_id` query parameter is null or empty");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("'medicine_id' query parameter is required!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            ArrayList<Document> doctorsList = new ArrayList<Document>();
            Bson projection = exclude("_id", "__v");
            if (medicineId.equals("*")) {
                logClient.debug("`medicine_id` query parameter is *, finding all medicines");
                FindIterable<Document> dbResp =
                        dbClient.getCollection("medicines").find().projection(projection);
                for (Document doc : dbResp) {
                    doctorsList.add(doc);
                }
            } else {
                logClient.debug("`medicine_id` query parameter is " + medicineId
                        + ", finding matching medicines");
                FindIterable<Document> dbResp = dbClient.getCollection("medicines")
                        .find(eq("medicineId", medicineId)).projection(projection);
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
    public Response updateMedicine(Medicine medicine, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(MedicinesApiServiceImpl.class);
        logClient.debug("received new request for `updateMedicine`");
        if (!medicine.isValid()) {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("invalid request body")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            Document doc = medicine.toDocument();
            UpdateResult updateResult = dbClient.getCollection("medicines")
                    .replaceOne(eq("medicine_id", medicine.getMedicineId().toString()), doc);
            if (updateResult.getModifiedCount() == 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("could not find medicine in the database!")
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
