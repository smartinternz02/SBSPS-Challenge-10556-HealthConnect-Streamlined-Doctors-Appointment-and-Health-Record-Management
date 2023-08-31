package org.openapitools.api.impl;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.openapitools.api.*;
import org.openapitools.model.ErrorObject;
import org.openapitools.model.User;
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
public class UsersApiServiceImpl extends UsersApiService {
    @Override
    public Response createUser(User user, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(UsersApiServiceImpl.class);
        logClient.debug("received new request for `createUser`");
        if (!user.isValid()) {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("invalid request body")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            long matchingDocsLength =
                    dbClient.getCollection("users").countDocuments(eq("email", user.getEmail()));
            if (matchingDocsLength > 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.CONFLICT.getStatusCode())
                        .description("user already exists!")
                        .moreInfo(Response.Status.CONFLICT.getReasonPhrase());
                return Response.status(Response.Status.CONFLICT.getStatusCode()).entity(err)
                        .build();
            }
            Document doc = user.toDocument();
            InsertOneResult insertResult = dbClient.getCollection("users").insertOne(doc);
            if (insertResult.getInsertedId() != null) {
                doc.remove(User.JSON_PROPERTY_PASSWORD);
                return Response.status(Response.Status.CREATED.getStatusCode()).entity(doc).build();
            }
            ErrorObject err =
                    new ErrorObject().code(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .description("could not save user to the database")
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
    public Response deleteUser(@NotNull String email, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(UsersApiServiceImpl.class);
        logClient.debug("received new request for `deleteUser`");
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
                    dbClient.getCollection("users").deleteOne(eq("email", email));
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
    public Response getUser(@NotNull String email, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(UsersApiServiceImpl.class);
        logClient.debug("received new request for `getUser`");
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
                logClient.debug("`email` query parameter is *, finding all Users");
                FindIterable<Document> dbResp =
                        dbClient.getCollection("users").find().projection(projection);
                for (Document doc : dbResp) {
                    doctorsList.add(doc);
                }
            } else {
                logClient.debug("`email` query parameter is " + email + ", finding matching Users");
                FindIterable<Document> dbResp = dbClient.getCollection("users")
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
    public Response updateUser(@NotNull String email, User user, SecurityContext securityContext)
            throws NotFoundException {
        LogClient logClient = new LogClient(UsersApiServiceImpl.class);
        logClient.debug("received new request for `updateUser`");
        if (!user.isValid()) {
            ErrorObject err = new ErrorObject().code(Response.Status.BAD_REQUEST.getStatusCode())
                    .description("invalid request body")
                    .moreInfo(Response.Status.BAD_REQUEST.getReasonPhrase());
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(err).build();
        }
        try {
            MongoDatabase dbClient = DBClient.getDatabase();
            Document doc = user.toDocument();
            UpdateResult updateResult = dbClient.getCollection("users")
                    .replaceOne(eq("email", user.getEmail().toString()), doc);
            if (updateResult.getModifiedCount() == 0) {
                ErrorObject err = new ErrorObject().code(Response.Status.NOT_FOUND.getStatusCode())
                        .description("could not find user in the database!")
                        .moreInfo(Response.Status.NOT_FOUND.getReasonPhrase());
                return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(err)
                        .build();
            }
            doc.remove(User.JSON_PROPERTY_PASSWORD);
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
