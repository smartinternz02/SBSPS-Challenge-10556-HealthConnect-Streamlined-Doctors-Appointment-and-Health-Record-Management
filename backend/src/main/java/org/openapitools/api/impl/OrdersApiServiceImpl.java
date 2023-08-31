package org.openapitools.api.impl;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.openapitools.api.*;
import org.openapitools.api.db.DBClient;
import org.openapitools.api.logging.LogClient;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.OrderDetails;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;
import java.util.ArrayList;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2023-08-31T13:30:54.533812+05:30[Asia/Kolkata]")
public class OrdersApiServiceImpl extends OrdersApiService {
    @Override
    public Response createOrder(OrderDetails orderDetails, SecurityContext securityContext) throws NotFoundException {
        LogClient logClient = new LogClient(MedicinesApiServiceImpl.class);
        logClient.debug("received new request for `createOrder`");
        if (!orderDetails.isValid()) {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("invalid request body")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            Document doc = orderDetails.toDocument();
            InsertOneResult insertResult = dbClient.getCollection("orders").insertOne(doc);
            if (insertResult.getInsertedId() != null) {
                return Response.status(Response.Status.CREATED.getStatusCode()).entity(doc).build();
            }
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description("could not save order to the database")
                            .moreInfo(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(err).build();
        } catch (Exception e) {
            e.printStackTrace();
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description(e.getMessage().toString())
                            .moreInfo(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(err).build();
        }
    }
    @Override
    public Response deleteOrder( @NotNull String orderId, SecurityContext securityContext) throws NotFoundException {
        LogClient logClient = new LogClient(MedicinesApiServiceImpl.class);
        logClient.debug("received new request for `deleteOrder`");
        if (orderId == null || orderId.equals("")) {
            logClient.error("`order_id` query parameter is null or empty");
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("'order_id' query parameter is required!")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            DeleteResult deleteResult =
                    dbClient.getCollection("orders").deleteOne(eq("order_id", orderId));
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
    public Response getOrder( @NotNull String email, SecurityContext securityContext) throws NotFoundException {
        LogClient logClient = new LogClient(MedicinesApiServiceImpl.class);
        logClient.debug("received new request for `getOrder`");
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
            Bson projection = exclude("_id", "__v");
            if (email.equals("*")) {
                logClient.debug("`email` query parameter is *, finding all medicines");
                FindIterable<Document> dbResp =
                        dbClient.getCollection("orders").find().projection(projection);
                for (Document doc : dbResp) {
                    doctorsList.add(doc);
                }
            } else {
                logClient.debug("`email` query parameter is " + email
                        + ", finding matching medicines");
                FindIterable<Document> dbResp = dbClient.getCollection("orders")
                        .find(eq("user_email", email)).projection(projection);
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
    public Response updateOrder(OrderDetails orderDetails, SecurityContext securityContext) throws NotFoundException {
        LogClient logClient = new LogClient(MedicinesApiServiceImpl.class);
        logClient.debug("received new request for `updateMedicine`");
        if (!orderDetails.isValid()) {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("invalid request body")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            Document doc = orderDetails.toDocument();
            UpdateResult updateResult = dbClient.getCollection("orders")
                    .replaceOne(eq("order_id", orderDetails.getOrderId().toString()), doc);
            if (updateResult.getModifiedCount() == 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("could not find order in the database!")
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
